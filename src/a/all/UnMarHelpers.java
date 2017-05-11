package a.all;

import static org.junit.Assert.fail;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import c.hlp.CompanyResponce;
import core.beans.Company;

public class UnMarHelpers {
	
	
	public static CompanyResponce unmarshallCompany(String token) throws JAXBException{
		
		
		CompanyResponce copanyResponce = new CompanyResponce();
		
		
		JAXBContext jaxbContext;
		
			jaxbContext = JAXBContext.newInstance(CompanyResponce.class);
			StringReader reader = new StringReader(AllTests.token);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			copanyResponce = (CompanyResponce) jaxbUnmarshaller.unmarshal(reader);
			System.out.println(copanyResponce);
		
		
		
		
		return copanyResponce;
		
	}

}
