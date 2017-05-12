package a.all;

import static org.junit.Assert.fail;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import c.hlp.CompanyResponse;
import core.beans.Company;

public class UnMarHelpers {
	
	
	public static CompanyResponse unmarshallCompany(String token) throws JAXBException{
		
		
		CompanyResponse copanyResponse = new CompanyResponse();
		
		
		JAXBContext jaxbContext;
		
			jaxbContext = JAXBContext.newInstance(CompanyResponse.class);
			StringReader reader = new StringReader(AllTests.token);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			copanyResponse = (CompanyResponse) jaxbUnmarshaller.unmarshal(reader);
			System.out.println(copanyResponse);
		
		
		
		
		return copanyResponse;
		
	}

}
