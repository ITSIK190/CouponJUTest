package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import c.hlp.CouponResponse;
import core.beans.Coupon;
import core.beans.CouponType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyListTC {

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
	public void test010getCouponService() {

		AllTests.token = AllTests.service.path("Company").path("getCouponService").queryParam("User", "comp1")
				.queryParam("PW", "comp1").queryParam("Title", "coup1")
				.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String startDate =  "2016-01-01";
		String endDate =  "2019-12-31";
		
		Date utilStartDate = null;
		Date utilEndDate = null;
		try {
			utilStartDate = df.parse(startDate);
			utilEndDate = df.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		Coupon couponTest = new Coupon("coup1", utilStartDate, utilEndDate, 9, CouponType.RESTAURANTS, "coup1", 12.34, "coup1");
		
		
		
		CouponResponse couponResponse = new CouponResponse();
		try {
			couponResponse = UnMarHelpers.unmarshallCoupon(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		
		assertEquals("success", couponResponse.getMessage());
		ArrayList<Coupon> coupons = couponResponse.getCoupons();
		
		
		Coupon couponXML = coupons.get(0);
		
		System.out.println(couponXML);
		assertEquals(couponXML.toString(), couponTest.toString());

	}
	
	
	
	
	@Test
	public void test020getAllMyCompanysCouponsService() {

		AllTests.token = AllTests.service.path("Company").path("getAllMyCompanysCouponsService").queryParam("User", "comp1")
				.queryParam("PW", "comp1").accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String startDate =  "2016-01-01";
		String endDate =  "2019-12-31";
		
		Date utilStartDate = null;
		Date utilEndDate = null;
		try {
			utilStartDate = df.parse(startDate);
			utilEndDate = df.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		Coupon couponTest = new Coupon("coup1", utilStartDate, utilEndDate, 9, CouponType.RESTAURANTS, "coup1", 12.34, "coup1");
		
		
		
		CouponResponse couponResponse = new CouponResponse();
		try {
			couponResponse = UnMarHelpers.unmarshallCoupon(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		
		assertEquals("success", couponResponse.getMessage());
		ArrayList<Coupon> coupons = couponResponse.getCoupons();
		
		
		Coupon couponXML = coupons.get(0);
		
		System.out.println(couponXML);
		assertEquals(couponXML.toString(), couponTest.toString());

	}
	
	
	
	@Test
	public void test030getCouponsByTypeService() {

		AllTests.token = AllTests.service.path("Company").path("getCouponsByTypeService").queryParam("User", "comp1")
				.queryParam("PW", "comp1").queryParam("Type", "RESTAURANTS")
				.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String startDate =  "2016-01-01";
		String endDate =  "2019-12-31";
		
		Date utilStartDate = null;
		Date utilEndDate = null;
		try {
			utilStartDate = df.parse(startDate);
			utilEndDate = df.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		Coupon couponTest = new Coupon("coup1", utilStartDate, utilEndDate, 9, CouponType.RESTAURANTS, "coup1", 12.34, "coup1");
		
		
		
		CouponResponse couponResponse = new CouponResponse();
		try {
			couponResponse = UnMarHelpers.unmarshallCoupon(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		
		assertEquals("success", couponResponse.getMessage());
		ArrayList<Coupon> coupons = couponResponse.getCoupons();
		
		
		Coupon couponXML = coupons.get(0);
		
		System.out.println(couponXML);
		assertEquals(couponXML.toString(), couponTest.toString());

	}
	
	
	@Test
	public void test040getCouponsByPriceService() {

		AllTests.token = AllTests.service.path("Company").path("getCouponsByPriceService").queryParam("User", "comp1")
				.queryParam("PW", "comp1").queryParam("Price", "12.35")
				.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String startDate =  "2016-01-01";
		String endDate =  "2019-12-31";
		
		Date utilStartDate = null;
		Date utilEndDate = null;
		try {
			utilStartDate = df.parse(startDate);
			utilEndDate = df.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		Coupon couponTest = new Coupon("coup1", utilStartDate, utilEndDate, 9, CouponType.RESTAURANTS, "coup1", 12.34, "coup1");
		
		
		
		CouponResponse couponResponse = new CouponResponse();
		try {
			couponResponse = UnMarHelpers.unmarshallCoupon(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		
		assertEquals("success", couponResponse.getMessage());
		ArrayList<Coupon> coupons = couponResponse.getCoupons();
		
		
		Coupon couponXML = coupons.get(0);
		
		System.out.println(couponXML);
		assertEquals(couponXML.toString(), couponTest.toString());

	}
	
	
	@Test
	public void test050getCouponsByDateService() {

		AllTests.token = AllTests.service.path("Company").path("getCouponsByDateService").queryParam("User", "comp1")
				.queryParam("PW", "comp1").queryParam("Date", "2016-01-01")
				.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String startDate =  "2016-01-01";
		String endDate =  "2019-12-31";
		
		Date utilStartDate = null;
		Date utilEndDate = null;
		try {
			utilStartDate = df.parse(startDate);
			utilEndDate = df.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		Coupon couponTest = new Coupon("coup1", utilStartDate, utilEndDate, 9, CouponType.RESTAURANTS, "coup1", 12.34, "coup1");
		
		
		
		CouponResponse couponResponse = new CouponResponse();
		try {
			couponResponse = UnMarHelpers.unmarshallCoupon(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		
		assertEquals("success", couponResponse.getMessage());
		ArrayList<Coupon> coupons = couponResponse.getCoupons();
		
		
		Coupon couponXML = coupons.get(0);
		
		System.out.println(couponXML);
		assertEquals(couponXML.toString(), couponTest.toString());

	}
	
	
	
	
}
