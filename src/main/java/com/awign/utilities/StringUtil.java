package com.awign.utilities;

import java.util.Locale;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;

/** 
* @author  Partheeban.moorthy@awign.com
* @version 1.0 
*/


public class StringUtil {
    Faker faker = new Faker(new Locale("en-US"));	
	public Company getRandomString() {
		return faker.company();	
	}
	
	public String getRandommusic() {
		return faker.music().toString();	
	}

	
}
