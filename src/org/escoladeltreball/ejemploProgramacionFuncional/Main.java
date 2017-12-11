/**
 * 
 */
package org.escoladeltreball.ejemploProgramacionFuncional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.escoladeltreball.ejemploProgramacionFuncional.RosterTest.CheckPerson;

/**
 * @author iaw39397876
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> roster = Person.createRoster();
		System.out.println("Todas las personas: ");
		RosterTest.printAllPersons(roster);
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		System.out.println("Persona older than 20: ");
		RosterTest.printPersonOlderThan(roster, 20);
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		System.out.println("Persona younger than 30: ");
		RosterTest.printPersonYoungerThan(roster, 30);
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		System.out.println("Persona between 20 and 26: ");
		RosterTest.printPersonWithinAgeRange(roster, 20, 26);
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		System.out.println("Women between 20 and 30: ");
		RosterTest.printWomenWithAgeBetween(roster, 20, 30);
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		System.out.println("Persons who are eligible for Selective Service: ");
		
		class checkPersonEligibleForSelectiveService implements CheckPerson {
			@Override
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE && p.getAge() >= 20 && p.getAge() <= 30;
			}
		}
		RosterTest.printPersons(roster, new checkPersonEligibleForSelectiveService());
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		//APROXIMACIÓN 4
		System.out.println("Persons who are eligible for Selective Service " + "(annonymous class):");
		RosterTest.printPersons(roster, new CheckPerson() {
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE && p.getAge() >= 20 && p.getAge() <= 30;
			}
		});
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		//APROXIMACIÓN 5
		System.out.println("Persons who are eligible for Selective Service " + "(lambda expression):");
		RosterTest.printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 20 && p.getAge() <= 30);
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		System.out.println("Persons who are eligible for Selective Service " + "(with Predicate parameter):");
		RosterTest.printPersonsWithPredicate(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 20 && p.getAge() <= 30);
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		System.out.println("Persons who are eligible for Selective Service " + "(with Predicate and Consumer parameters):");
		RosterTest.processPersons(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 20 && p.getAge() <= 30, p -> p.printPerson());
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		System.out.println("Persons who are eligible for Selective Service " + "(with Predicate, Function, and Consumer parameters):");
		RosterTest.processPersonsWithFunction(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 20 && p.getAge() <= 30, p -> p.getEmailAddress(), email -> System.out.println(email));
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		System.out.println("Persons who are eligible for Selective Service " + "(generic version):");
		RosterTest.processElements(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 20 && p.getAge() <= 30, p -> p.getEmailAddress(), email -> System.out.println(email));
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		//APROXIMACIÓN 9
		System.out.println("Persons who are eligible for Selective Service " + "(with bulk data operation):");
		roster.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 10 && p.getAge() <= 40).map(p -> p.getEmailAddress()).forEach(email -> System.out.println(email));
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------------------------
		System.out.println("-----------");
		
		Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
		class PersonAgeComparator implements Comparator<Person> {
			public int compare(Person a, Person b) {
				return a.getBirthday().compareTo(b.getBirthday());
			}
		}
		Arrays.sort(rosterAsArray, new PersonAgeComparator());
		Arrays.sort(rosterAsArray, (Person a, Person b) -> {
			return a.getBirthday().compareTo(b.getBirthday());
		});
		Arrays.sort(rosterAsArray, (a, b) -> Person.compareByAge(a, b));
		Arrays.sort(rosterAsArray, Person::compareByAge);
		System.out.println("-----------");
		//-------------------------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------------------------
		double average = roster.stream().filter(p -> p.getGender() == Person.Sex.MALE).mapToInt(Person::getAge).average().getAsDouble();
		System.out.println(average);
		System.out.println("-----------");
		roster.stream().forEach(p -> p.setName(p.getName().toUpperCase()));
		roster.stream().forEach(p -> System.out.println(p.getName()));
		
	}
}
