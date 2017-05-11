/**
 * 
 */
package a.admin;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.ArrayList;

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
import a.all.UnMarHelpers;
import c.hlp.CompanyResponce;
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

		
		AllTests.token = AllTests.service.path("Admin").path("createCompanyService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Email", "comp1").queryParam("name", "comp1")
				.queryParam("CompanyPw", "comp1").accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		CompanyResponce companyResponce = new CompanyResponce();
		try {
			companyResponce = UnMarHelpers.unmarshallCompany(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		System.out.println(companyResponce.getMessage());
		assertEquals("success", companyResponce.getMessage());

	}

	@Test
	public void test020createCompanyWithSameName() {

		
		AllTests.token = AllTests.service.path("Admin").path("createCompanyService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Email", "comp1").queryParam("name", "comp1")
				.queryParam("CompanyPw", "comp1").accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		
		
		CompanyResponce companyResponce = new CompanyResponce();
		try {
			companyResponce = UnMarHelpers.unmarshallCompany(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		System.out.println(companyResponce.getMessage());
		assertEquals("error: Name exists", companyResponce.getMessage());

	}

	@Test
	public void test030updateCompanyService() {

		
		AllTests.token = AllTests.service.path("Admin").path("updateCompanyService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Email", "comp1").queryParam("name", "comp1")
				.queryParam("CompanyPw", "comp1").accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		CompanyResponce companyResponce = new CompanyResponce();
		try {
			companyResponce = UnMarHelpers.unmarshallCompany(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		System.out.println(companyResponce.getMessage());
		assertEquals("success", companyResponce.getMessage());

	}

	// getcomp
	@Test
	public void test040getCompanyService() {

		
		AllTests.token = AllTests.service.path("Admin").path("getCompanyService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Email", "comp1").accept(MediaType.APPLICATION_XML)
				.get(String.class);
		System.out.println("Token: " + AllTests.token);
		
		
		CompanyResponce companyResponce = new CompanyResponce();
		try {
			companyResponce = UnMarHelpers.unmarshallCompany(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		
		ArrayList<Company> companies = companyResponce.getCompanies();
		Company company = companies.get(0);
		
		System.out.println(company);
		assertEquals(company.getName(), "comp1");
		assertEquals("success", companyResponce.getMessage());
		

	}

	@Test
	public void test050removeCompanyService() {

		
		AllTests.token = AllTests.service.path("Admin").path("removeCompanyService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Email", "comp1").accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		
		
		
		CompanyResponce companyResponce = new CompanyResponce();
		try {
			companyResponce = UnMarHelpers.unmarshallCompany(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		System.out.println(companyResponce.getMessage());
		assertEquals("success", companyResponce.getMessage());

	}

}
