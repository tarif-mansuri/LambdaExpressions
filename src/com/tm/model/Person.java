package com.tm.model;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class Person {
	public enum Sex {
		MALE, FEMALE
	}

	String name;
	LocalDate birthDay;
	Sex gender;
	String emailAddress;

	Person(String name, LocalDate birthDay, Sex gender, String emailAddress) {
		this.name = name;
		this.birthDay = birthDay;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public Sex getGender() {
		return gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	public int getAge() {
		return birthDay.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}
	public void printPerson() {
	      System.out.println(name + ", " + this.getAge());
	    }
	public static int compareByAge(Person a, Person b) {
		return a.birthDay.compareTo(b.birthDay);
	}
	public static List<Person> createRoster(){
		List<Person> roster = new ArrayList<>();
		roster.add(new Person("Prasanna",IsoChronology.INSTANCE.date(1995,11,26),Person.Sex.MALE,"prasanna@exmaple.com"));
		roster.add(new Person("VasanthK",IsoChronology.INSTANCE.date(1995,9,04),Person.Sex.MALE,"vasanth.s@exmaple.com"));
		roster.add(new Person("Karthika",IsoChronology.INSTANCE.date(1995,7,25),Person.Sex.FEMALE,"karthika.r@exmaple.com"));
		roster.add(new Person("PoojaShree",IsoChronology.INSTANCE.date(1995,7,12),Person.Sex.FEMALE,"poojashree@exmaple.com"));
		roster.add(new Person("Sophie",IsoChronology.INSTANCE.date(2002,10,01),Person.Sex.FEMALE,"pv209304@exmaple.com"));
		return roster;
	}
}
