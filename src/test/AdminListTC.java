package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import a.all.AllTests;
import a.all.UnMarHelpers;
import c.hlp.CompanyResponse;
import core.beans.Company;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminListTC {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// getcomp
		@Test
		public void test040getCompanyService() {

			
			AllTests.token = AllTests.service.path("Admin").path("getCompanyService").queryParam("User", "Admin")
					.queryParam("PW", "Admin").queryParam("Email", "comp1").accept(MediaType.APPLICATION_XML)
					.get(String.class);
			System.out.println("Token: " + AllTests.token);
			
			
			CompanyResponse companyResponse = new CompanyResponse();
			try {
				companyResponse = UnMarHelpers.unmarshallCompany(AllTests.token);
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				fail(e1.getMessage());
			}
			
			ArrayList<Company> companies = companyResponse.getCompanies();
			Company company = companies.get(0);
			
			System.out.println(company);
			assertEquals(company.getName(), "comp1");
			assertEquals("success", companyResponse.getMessage());
			

		}

}
