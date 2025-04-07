package com;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tname;

	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
				name = "sub_tea",
				joinColumns = @JoinColumn(name="tid"),
				inverseJoinColumns = @JoinColumn(name="sid")
			
			
			)
	List<Subject> subjects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void addSubject(Subject subject)
	{
		if(subjects==null)
		{
			subjects = new ArrayList<>();
		}
		subjects.add(subject);
	}
	
}
