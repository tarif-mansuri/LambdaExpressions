package com.tm.usinstandardfunctionalinterfacewithlambda;

import java.util.List;
import java.util.function.Predicate;

import com.tm.model.Person;
import com.tm.model.Person.Sex;

public class AppUsingSTDFunctionalInterfaceWithLambda {
	public static void main(String[] args) {
		printPersonsWithPredicate(Person.createRoster(), (Person p)-> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
		
	}

	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
}
