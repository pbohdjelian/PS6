package base;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel per;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		per = new PersonDomainModel();
		per.setFirstName("Peter");
		per.setLastName("Bohdjelian");
		per.setCity("Fort Washington");
		per.setPostalCode(19034);
		per.setStreet("1224 Hazelwood Drive");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDomainModel person;
		PersonDAL.deletePerson(per.getPersonID());
		per = PersonDAL.getPerson(per.getPersonID());
		assertNull("The Person shouldn't be in the database", per);

	}

	@Test
	public void addPersonTest() {
		PersonDomainModel person;
		person = PersonDAL.getPerson(per.getPersonID());
		assertNull("The Person shouldn't be in the database", person);
		PersonDAL.addPerson(per);

		per = PersonDAL.getPerson(per.getPersonID());
		System.out.println(per.getPersonID());
		assertNotNull("The Person should  be added to the database", per);
	}

	@Test
	public void updatePersonTest() {
		PersonDomainModel person;
		final String C_LASTNAME = "Smith";

		person = PersonDAL.getPerson(per.getPersonID());
		assertNull("The Person shouldn't be in the database", person);
		PersonDAL.addPerson(per);

		per.setLastName(C_LASTNAME);
		PersonDAL.updatePerson(per);

		person = PersonDAL.getPerson(per.getPersonID());

		assertTrue("Name Didn't Change", per.getLastName() == C_LASTNAME);
	}

	@Test
	public void deletePersonTest() {
		PersonDomainModel person;
		person = PersonDAL.getPerson(per.getPersonID());
		assertNull("The Person shouldn't have been in the database", person);

		PersonDAL.addPerson(per);
		person = PersonDAL.getPerson(per.getPersonID());
		System.out.println(per.getPersonID());
		assertNotNull("The Person should have been added to the database", person);

		PersonDAL.deletePerson(per.getPersonID());
		person = PersonDAL.getPerson(per.getPersonID());
		assertNull("The Person shouldn't have been in the database", person);

	}

	@Test
	public void getPersonTest() {
		PersonDomainModel person;
		person = PersonDAL.getPerson(per.getPersonID());
		assertNull("The Person shouldn't be in the database", person);

	}

	@Test
	public void test() {
		assertTrue(1 == 1);
	}

}
