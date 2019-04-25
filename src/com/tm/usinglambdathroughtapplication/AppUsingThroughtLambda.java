package com.tm.usinglambdathroughtapplication;

/**
 * Predicate interface is generic functional interface containing only one function test
 * that takes one argument and returns boolean
 * 
 * interface Predicate<T> {public boolean test(T t);}
 * 
 * Function interface is generic functional interface containing only one function apply
 * that takes one argument and returns one argument
 * 
 * public interface Function<T,R> {public R apply(T t);}
 * 
 * 
 * Consumer interface is generic functional interface containing only one function accept
 * That takes one argument and returns void
 * 
 * public interface Consumer<T> {public void accept(T t);}
 */
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.tm.model.Person;
import com.tm.model.Person.Sex;

public class AppUsingThroughtLambda {
	public static void main(String[] args) {
		processPersonsWithFunInterfaces(Person.createRoster(),
				(Person p) -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				(Person p) -> p.getEmailAddress(), (String email) -> System.out.println(email));

	}

	public static void processPersonsWithFunInterfaces(List<Person> roster, Predicate<Person> tester,
			Function<Person, String> mapper, Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
}
