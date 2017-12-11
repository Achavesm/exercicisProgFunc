/**
 * 
 */
package org.escoladeltreball.ejemploProgramacionFuncional;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * @author iaw39397876
 *
 */
public class Person {

	public enum Sex {
		MALE, FEMALE
	}
	
	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;
	
	Person(String nameArg, LocalDate birthdayArg, Sex genderArg, String emailArg) {
		this.name = nameArg;
		this.birthday = birthdayArg;
		this.gender = genderArg;
		this.emailAddress = emailArg;
	}
	
	public int getAge() {
		return this.birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}
	
	public void printPerson() {
		System.out.println(name + ", " + this.getAge());
	}
	
	public Sex getGender() {
		return this.gender;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	public LocalDate getBirthday() {
		return this.birthday;
	}
	
	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public static List<Person> createRoster() {
		List<Person> roster = new ArrayList<>();
		roster.add(
				new Person(
				"Fred",
				IsoChronology.INSTANCE.date(1980, 6, 20),
				Person.Sex.MALE,
				"fred@example.com"));
		roster.add(
				new Person(
				"Jane",
				IsoChronology.INSTANCE.date(1990, 7, 15),
				Person.Sex.FEMALE,
				"jane@example.com"));
		roster.add(
				new Person(
				"George",
				IsoChronology.INSTANCE.date(1991, 8, 13),
				Person.Sex.MALE,
				"george@example.com"));
		roster.add(
				new Person(
				"Bob",
				IsoChronology.INSTANCE.date(2000, 9, 12),
				Person.Sex.MALE,
				"bob@example.com"));
		return roster;
	}
}
