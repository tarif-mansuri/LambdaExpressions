package com.tm.usinglocalclass;

/***
 * this driver class creates a list of persons
 * and 
 * creates an object of CheckPersonEligibleForSelectiveService
 * (that implements CheckPerson interface and provides a way for testing)
 * and
 * passes them to local method printPerson that uses tester's test method on person
 * object to get selected person
 * 
 * then we can perform any operation of selected person
 */

import java.util.List;

import com.tm.model.Person;
import com.tm.utility.CheckPerson;
import com.tm.utility.CheckPersonEligibleForSelectiveService;

public class AppUsinLocalClass {
	public static void main(String[] args) {
		printPersons(Person.createRoster(), new CheckPersonEligibleForSelectiveService());
	}
	public static void printPersons(
		    List<Person> roster, CheckPerson tester) {
		    for (Person p : roster) {
		        if (tester.test(p)) {
		            p.printPerson();
		        }
		    }
		}
}
