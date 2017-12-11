/**
 * 
 */
package org.escoladeltreball.ejemploProgramacionFuncional;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author iaw39397876
 *
 */
public class RosterTest {
	
	public interface CheckPerson {
		boolean test(Person p);
	}
	
	public interface Predicate<Person> {
		boolean test (Person t);
	}

	public static void printAllPersons(List<Person> roster) {
		for (Person p : roster) {
				p.printPerson();
		}
	}
	
	//APROXIMACIÓN 1
	public static void printPersonOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}
	
	public static void printPersonYoungerThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() <= age) {
				p.printPerson();
			}
		}
	}
	
	//APROXIMACIÓN 2
	public static void printPersonWithinAgeRange(List<Person> roster, int age1, int age2) {
		for (Person p : roster) {
			if (p.getAge() >= age1 && p.getAge() <= age2) {
				p.printPerson();
			}
		}
	}
	
	public static void printWomenWithAgeBetween(List<Person> roster, int age1, int age2) {
		for (Person p : roster) {
			if(p.getGender().equals(Person.Sex.FEMALE)) {
				if (p.getAge() >= age1 && p.getAge() <= age2) {
					p.printPerson();
				}
			}
		}
	}
	
	//APROXIMACIÓN 3
	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
	
	//APROXIMACIÓN 6
	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
	
	//APROXIMACIÓN 7
	public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
		for (Person p: roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}
	
	public static void processPersonsWithFunction (List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
	
	//APROXIMACIÓN 8
	public static <X, Y> void processElements (Iterable<X> source, Predicate<X> tester, Function<X,Y> mapper, Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
	
}
