package com.tm.usegenericsmoreextensivly;

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
//Notice that the collection roster, which is a collection of type List, is also an object of type Iterable.
	public static <X,Y> void processPersonsWithFunInterfaces(Iterable<X> source, Predicate<X> tester,
			Function<X, Y> mapper, Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
}

