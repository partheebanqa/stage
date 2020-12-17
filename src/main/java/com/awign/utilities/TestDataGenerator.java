package com.awign.utilities;
import java.util.Random;
import java.util.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;

/** 
* @author  Partheeban.moorthy@awign.com
* @version 1.0 
*/


public class TestDataGenerator {

    public Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public String generateRandomMobileNumber() {
        Random rand = new Random();
        long mob = 9355600000l;
        int rand1 = rand.nextInt(1000);
        mob = mob + rand1;
        String mobileNumber = Long.toString(mob);
        return mobileNumber;
    }


    public String generateRandomName() {
        String random = RandomStringUtils.randomAlphabetic(8);
        return "testh" + random;
    }
    
    public String generateRandomEmail() {
    	String email="";
        String random = RandomStringUtils.randomAlphabetic(8);
        random = random.concat("@");
        String compemail = RandomStringUtils.randomAlphabetic(3);
        email = email.concat(random).concat(compemail).concat(".com");
        return "testh"+email;
    }
    
    public String generateRandomDomainName() {
        String random = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        return "tdh"+random;
    }
}
