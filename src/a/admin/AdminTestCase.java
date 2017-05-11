/**
 * 
 */
package a.admin;

import static org.junit.Assert.*;

import java.io.StringReader;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.runners.MethodSorters;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import a.all.AllTests;
import core.beans.Company;
import core.beans.Customer;

/**
 * @author Itsik
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminTestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test010createCompanyService() {

		System.out.println(AllTests.service);
		AllTests.token = AllTests.service.path("Admin").path("createCompanyService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Email", "comp1").queryParam("name", "comp1")
				.queryParam("CompanyPw", "comp1").accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		assertEquals("success", AllTests.token);

	}

	@Test
	public void test020createCompanyWithSameName() {

		System.out.println(AllTests.service);
		AllTests.token = AllTests.service.path("Admin").path("createCompanyService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Email", "comp1").queryParam("name", "comp1")
				.queryParam("CompanyPw", "comp1").accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		assertEquals("error: Name exists", AllTests.token);

	}

	@Test
	public void test030updateCompanyService() {

		System.out.println(AllTests.service);
		AllTests.token = AllTests.service.path("Admin").path("updateCompanyService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Email", "comp1").queryParam("name", "comp1")
				.queryParam("CompanyPw", "comp1").accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		assertEquals("success", AllTests.token);

	}

	// getcomp
	@Test
	public void test040getCompanyService() {

		System.out.println(AllTests.service);
		AllTests.token = AllTests.service.path("Admin").path("getCompanyService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Email", "comp2").accept(MediaType.APPLICATION_XML)
				.get(String.class);
		System.out.println("Token: " + AllTests.token);
		Company company = new Company();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Company.class);
			StringReader reader = new StringReader(AllTests.token);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			company = (Company) jaxbUnmarshaller.unmarshal(reader);
			System.out.println(company);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		assertEquals(company.getName(), "comp1");
		assertThat(AllTests.token,
				CoreMatchers.containsString("<name>comp1</name><password>comp1</password></company>"));

	}

	@Test
	public void test050removeCompanyService() {

		System.out.println(AllTests.service);
		AllTests.token = AllTests.service.path("Admin").path("removeCompanyService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Email", "comp1").accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		assertEquals("success", AllTests.token);

	}

}
