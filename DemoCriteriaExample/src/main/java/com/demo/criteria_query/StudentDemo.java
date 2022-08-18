package com.demo.criteria_query;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Immutable;

@Entity
public  class  StudentDemo  {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private   int rollno;
		@Column
		private  String name;
		@Column
		private  int marks;
		
		@OneToOne(cascade = CascadeType.ALL)
		private  Laptop laptop;

		public StudentDemo() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "StudentDemo [rollno=" + rollno + ", name=" + name + ", marks=" + marks + ", laptop=" + laptop + "]";
		}

		public StudentDemo(int rollno, String name, int marks, Laptop laptop) {
			super();
			this.rollno = rollno;
			this.name = name;
			this.marks = marks;
			this.laptop = laptop;
		}

		public int getRollno() {
			return rollno;
		}

		public void setRollno(int rollno) {
			this.rollno = rollno;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getMarks() {
			return marks;
		}

		public void setMarks(int marks) {
			this.marks = marks;
		}
		
		

		public Laptop getLaptop() {
			return laptop;
		}

		public void setLaptop(Laptop laptop) {
			this.laptop = laptop;
		}

		
			
}
