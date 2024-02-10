package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.Course;
import entity.Student;
import entity.Stuff;
import entity.Teacher;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            // StandardServiceRegistry sınıfı, Hibernate'in çeşitli hizmetlerini
			// yapılandırmak ve yönetmek için kullanılır.
			
			// Hizmet Kaynaklarını Yönetme: Hibernate, bir dizi hizmet kullanır. Örneğin,
			// bağlantı sağlama, sorgu yürütme, transaksiyon yönetimi gibi hizmetler.
			// StandardServiceRegistry sınıfı, bu hizmetleri yapılandırma ve yönetme
			// görevini üstlenir.
			
			//Yapılandırma Ayarlarını Tutma: Hibernate'in yapılandırma ayarları, özellikle 
			//veritabanı bağlantı bilgileri, dialect (veritabanı türüne özgü SQL dil desteği), 
			//cache ayarları gibi birçok özelliği içerir. Bu ayarları yönetmek ve sınıflar arasında 
			//iletmek için StandardServiceRegistry kullanılır.
			
			//SessionFactory Oluşturma: Hibernate'in temel nesnesi olan SessionFactory'yi oluşturmak 
			//için kullanılır. SessionFactory, Hibernate'in nesne tabanlı modelleme ve veritabanı 
			//arasındaki köprüdür.
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                    .applySettings(getHibernateConfig())
                    .build();
//Metadata, Hibernate tarafından yönetilen nesne modelini ve bu nesne modelini veritabanı 
			//şemasına nasıl eşleyeceğini tanımlar. Bu, Java sınıflarının ve veritabanı tablolarının 
			//arasındaki ilişkiyi belirlemek ve Hibernate'in bu iki dünya arasında etkileşimi sağlamak 
			//için kullanılır.
			
            Metadata meta = new MetadataSources(ssr)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Teacher.class)
                    .addAnnotatedClass(Stuff.class)
                    .getMetadataBuilder()
                    .build();

            SESSION_FACTORY = meta.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Properties getHibernateConfig() {
        Properties prop = new Properties();
        prop.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/student_system");
        prop.put("hibernate.connection.username", "root");
        prop.put("hibernate.connection.password", "1234");
        prop.put("hibernate.hbm2ddl.auto", "update"); 
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        prop.put("hibernate.show_sql", "true");
        return prop;
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        if (SESSION_FACTORY != null) {
            SESSION_FACTORY.close();
        }
    }
}
