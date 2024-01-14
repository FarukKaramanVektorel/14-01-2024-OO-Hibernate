package entity;

import jakarta.persistence.Entity;

@Entity
public class Stuff extends Person{
	private String gorev;
	
	public Stuff() {
		// TODO Auto-generated constructor stub
	}
	public String getGorev() {
		return gorev;
	}
	public void setGorev(String gorev) {
		this.gorev = gorev;
	}

}
