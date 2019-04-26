package usingaggregateoperationsthatacceptlambdaasparam;

import java.util.List;

import com.tm.model.Person;

/**
 * 
 * @author tarif-5329
 * Use Aggregate Operations That Accept Lambda Expressions as Parameters
 * 
 * roster.stream() returns an stream of objects
 * 
 * streamedCollection.filter(Predicate<T> predicate) takes a lambda expression implementing
 * public boolean test(T t); and returns an stream of object that matches the predicate condition
 *  Stream<T> filter(Predicate<? super T> predicate)
 *  
 *  Generic Hierarcy Predicate<? super T> Explanation
 *  "? super T" describes the Argument type of test in declaration NOT IN CALLING
 *  that is  boolean test(? super T);
 * 
 * 
 * streamedCollection.map(Function<T,R> mapper) takes a lambda expression implementing
 * public R apply(T t); and returns an stream of object after applying the apply function
 * <R> Stream<R> map(Function<? super T,? extends R> mapper)
 * 
 * streamedCollection.forEach(Consumer<T> consumer)takes a lambda expression implementing
 * public void accept(T t) and returns nothing
 * void forEachOrdered(Consumer<? super T> action)
 */
public class UsingAGGtOPRTnWithLambdas {
	public static void main(String[] args) {
		List<Person> roster = Person.createRoster();
		roster
		.stream()
		.filter(p->p.getGender() == Person.Sex.MALE
		         &&p.getAge() >=18
		         &&p.getAge()<=25)
		.map(p->p.getEmailAddress())
		.forEach(email->System.out.println(email));
	}
	
}
