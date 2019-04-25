package com.tm.utility;

import com.tm.model.Person;
import com.tm.model.Person.Sex;

public class CheckPersonEligibleForSelectiveService implements CheckPerson {
	@Override
	public boolean test(Person p) {
		return p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
	}

}



