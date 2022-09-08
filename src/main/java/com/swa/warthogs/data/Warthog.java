package com.swa.warthogs.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Warthog {

	private @Id @GeneratedValue Long id;

	private String firstName;

	private String lastName;

	private Warthog() {
		
	}

	public Warthog(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warthog other = (Warthog) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Warthog [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
