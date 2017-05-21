package test;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import a.all.AllTests;
import a.all.UnMarHelpers;
import c.hlp.CustomerResponse;

public class CompanyRemoveTC {

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

	
	
	@Test
	public void test020removeCouponService() {

		
		AllTests.token = AllTests.service.path("Company").path("removeCouponService").queryParam("User", "comp1")
				.queryParam("PW", "comp1").queryParam("Title", "coup1").accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		
		
		
		CustomerResponse customerResponse = new CustomerResponse();
		try {
			customerResponse = UnMarHelpers.unmarshallCustomer(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		System.out.println(customerResponse.getMessage());
		assertEquals("success", customerResponse.getMessage());

	}
	
	

}
