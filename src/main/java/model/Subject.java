package model;

import java.io.Serializable;
import jakarta.persistence.*;



@Entity
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idsubject;

	private String credits;

	private String subject;

	public Subject() {
		super();
	}

	public int getIdsubject() {
		return idsubject;
	}
	

	public void setIdsubject(int idsubject) {
		this.idsubject = idsubject;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}