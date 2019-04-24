package com.tm.usinglocalclass;

import com.tm.person.Person;
import com.tm.person.Person.Sex;

public class CheckPersonEligibleForSelectiveService implements CheckPerson{

	@Override
	public boolean test(Person p) {
		return p.getGender() == Sex.MALE &&
				p.getAge() >= 18 &&
				p.getAge() <= 25;
	}
	
}
