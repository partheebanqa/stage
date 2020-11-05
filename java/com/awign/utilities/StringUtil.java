package com.awign.utilities;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class StringUtil {
    Faker usFaker = new Faker(new Locale("en-US"));	
	public Name getRandomString() {
		return usFaker.name();		
	}
	
}
