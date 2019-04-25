package com.tm.usinganonymousclass;
/**
 * Passing anonymous implementation of CheckPerson interface
 */

import java.util.List;

import com.tm.model.Person;
import com.tm.utility.CheckPerson;

public class AppUsingAnonymousClass {
	public static void main(String[] args) {
		printPersons(Person.createRoster(), new CheckPerson() {
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
			}
		});
	}

	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
}
