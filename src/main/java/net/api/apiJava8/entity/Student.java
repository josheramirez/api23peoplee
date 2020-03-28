package net.api.apiJava8.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import net.api.apiJava8.validator.Rut;

@Entity
@Table(name="students")
public class Student {
	

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;

		@NotNull
		@Rut
		private String rut;
		
		@NotNull
		private String name;
		
		@NotNull
		private String lastName;
		
		@NotNull
		@Min(18)
		private Integer age;
		
		@NotNull
		private String course;
		
		
		@Override
		public String toString() {
			return "Student [id=" + id + ", rut=" + rut + ", name=" + name + ", lastName=" + lastName + ", age=" + age
					+ ", course=" + course + "]";
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getRut() {
			return rut;
		}

		public void setRut(String rut) {
			this.rut = rut;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getCourse() {
			return course;
		}

		public void setCourse(String course) {
			this.course = course;
		}

		
}
