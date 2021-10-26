package org.junit;

import java.util.Date;

import org.baseclass.BaseClass;
import org.pojo.FbLoginPojo;

public class SampleJunit extends BaseClass{
	
	 @BeforeClass
	 public static void LaunchBrowser() {
		 launchBrowser();
		 windowMaximize();

	}

	
	 @AfterClass
	public static void CloseTheBrowser(){
		 closeBrowser();
	}
	 
	 @Test 
	 
	 public void tc3() {
		
		 System.out.println("Test Case 3");
		 launchUrl("https://www.flipkart.com/");

	}
	 @Test
	 public  void tc5() {
		System.out.println("Test Case 5");
		launchUrl("https://en-gb.facebook.com/");
		FbLoginPojo f = new FbLoginPojo();
		passtext("sjdvn@gmail.com", f.getEmail()); 
		passtext("hjfvhb", f.getPassWord());
		getAttributeValue(f.getPassWord());

	}
	 @Before
	 public void startDate() {

		 Date d = new Date();
		 System.out.println(d);
		 
		 
	}
	 @Ignore
	 @Test
	 public void tc2() {
		 System.out.println("Test Case 2");
		launchUrl("https://www.amazon.in/");

	}
	
	 
	 @After
	 public void endDate() { 
		 Date d = new Date();
		 System.out.println(d);
		 
		
	}
	 @Test
	 public  void tc1() {
		 System.out.println("Test Case 1");
			launchUrl("https://en-gb.facebook.com/");
			FbLoginPojo f = new FbLoginPojo();
			passtext("sathishsat607@gmail.com", f.getEmail()); 
			passtext("hgjkdjnc", f.getPassWord());
			getAttributeValue(f.getPassWord());

	}
	 @Ignore
	 @Test
	 public void tc4() {
		 
		 System.out.println("Test Case 4");
		 launchUrl("https://www.youtube.com/");
	 }

}