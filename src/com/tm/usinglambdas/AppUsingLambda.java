package com.tm.usinglambdas;

import java.util.List;

import com.tm.model.Person;
import com.tm.model.Person.Sex;
import com.tm.utility.CheckPerson;

public class AppUsingLambda {
	public static void main(String[] args) {
		//one approach
		printPersons(Person.createRoster(),
				(Person p) -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
		
		System.out.println("*************");
		
		//another approach
		CheckPerson tester = (Person p) -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
		printPersons(Person.createRoster(), tester);
	}

	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
}
