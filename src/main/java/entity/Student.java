package entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student extends Person {
	
	
	private String studentNumber;
	@ManyToMany
	@JoinTable(
			name="student_courses",
			joinColumns=@JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="course_id")
			)	
	private List<Course> courses;

	public Student() {

	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
