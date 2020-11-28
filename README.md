# apiautomation
apiautomation
\# apiautomation
Service automation

Main purpose of the Automation is to automate all the api in from end to end service.
in initial phase we are focusing on api backend automation.

The automation is build using maven and serenity bdd framework 
note:[the automation in not in bdd framework.]
1. Client registration.
2. Creation of EP, BP
3. Creation of listing
4. Handle applications.
5. Configure Projects:
6. Apply for a job. 
7. Accept the offer letter.
8. PO: Create lead and assign to WF.
9. Workforce: Submitted the lead.
10. Workforce: Add pan card.
11. Workforce: Request for a payout.


Command to execute: mvn clean verify -Dtags="regression" serenity:aggregate

Add new service Json file :
Step 1 : Add a entry in below file
 /apiautomation-master/src/main/java/com/awign/dataprovider/DataConstants.java
Step 2 : Add the new servies in the method in getServiceFilebyName 
 /apiautomation-master/src/main/java/com/awign/utilities/JsonUtil.java
 
 Add a new api to an service:
 
 Step 1: Add an api in the respective services .json file.
 /apiautomation-master/src/main/java/com/awign/services/AuthPlatform.json
 step 2 : Add a test method in the respective servies test file. 
 /apiautomation-master/src/test/java
 Step 3 : add the method to test class. & and appropriate tags.

#For example if you are adding an new api in auth related service.
Step 1 :Add an api in 
/apiautomation-master/src/main/java/com/awign/services/AuthPlatform.json
Step 2 : Add a test method in 
/apiautomation-master/src/test/java/com/awign/tests/authplatform/authPlatformTest.java
Step 3: Add to regression suite or test methods.
/apiautomation-master/src/test/java/com/awign/tests/EndToEndRegression.java

#Utility class are present in: 
/apiautomation-master/src/main/java/com/awign/utilities/ApiHeader.java
/apiautomation-master/src/main/java/com/awign/utilities/ApiMethod.java
/apiautomation-master/src/main/java/com/awign/utilities/JsonUtil.java
/apiautomation-master/src/main/java/com/awign/utilities/TestDataGenerator.java
/apiautomation-master/src/main/java/com/awign/utilities/StringUtil.java
/apiautomation-master/src/main/java/com/awign/utilities/ReusableSpecifications.java

Validation in Response: Data extract from Response:

/apiautomation-master/src/test/java/steps/VerificationSteps.java

Automation level serenity attributes: 
/apiautomation-master/src/test/java/src/test/resources/configs/attribute.properties


#Future Enhancement: 
1.Validate Api response schema.
2.Test API with different http methods. 
3.Service level automation
4.Performance & Security checks. 
5.Android app automation for user flows.

Note: Recomended to execute only in stage/Dev/QA environment- Do not execute in production environment or use production Api URLs. 


Initial contribution:
Partheeban Moorthy

