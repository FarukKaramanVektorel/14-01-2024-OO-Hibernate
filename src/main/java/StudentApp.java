import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Course;
import entity.Student;
import entity.Stuff;
import entity.Teacher;
import util.HibernateUtil;

public class StudentApp {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		try {
			Session session=sf.openSession();
			Transaction transaction=session.beginTransaction();
			//Teacher Save
//			Teacher t=new Teacher();
//			t.setBranch("Matematik");
//			t.setFirstName("Mahmut");
//			t.setLastName("Can");
//			session.persist(t);
			
			//Course Save
//			Teacher t=session.get(Teacher.class, 3);
//			Course c=new Course();
//			c.setName("Geometri");
//			c.setTeacher(t);
//			session.persist(c);
			
			
			
			//Student Save
//			Course c=session.byId(Course.class).load(1);
//			Course c2=session.byId(Course.class).load(2);
//			List<Course> courses=new ArrayList<>();
//			courses.add(c2);
//			courses.add(c);
//			Student s=new Student();
//			s.setFirstName("Arda");
//			s.setLastName("Turan");
//			s.setStudentNumber("S001");
//			s.setCourses(courses);
//			session.persist(s);
			
			//Student update
//			Student s=session.get(Student.class, 1);
//			Course c=session.get(Course.class, 4);			
//			List<Course> curses=s.getCourses();
//			curses.add(c);			
//			s.setCourses(curses);
//			session.persist(s);
			
//			//Student getirme
//			Student s=session.get(Student.class, 1);
//			System.out.println(s.getFirstName()+" "+s.getLastName()+" "+s.getStudentNumber());
//			List<Course> sCourses=s.getCourses();
//			for(Course c:sCourses) {
//				System.out.println(c.getName()+" : "+c.getTeacher().getFirstName()+" "+c.getTeacher().getLastName());
//			}
//			
			
			//Stuff save
//			Stuff s=new Stuff();
//			s.setFirstName("Veysel");
//			s.setLastName("Efendi");
//			s.setGorev("Kapı");
//			session.persist(s);
			
			//stuff silme
			Stuff s=session.get(Stuff.class, 1);
			session.remove(s);
			
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
