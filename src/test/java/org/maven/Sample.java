package org.maven;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pojo.FbLoginPojo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample extends BaseClass {
	@Test

public void tc6(){

		
		launchBrowser();
		windowMaximize();
		launchUrl("https://en-gb.facebook.com/");
		currentPageTitle();
		currentPageUrl();
		FbLoginPojo f = new FbLoginPojo();
		passtext("sathishsat607@gmail.com", f.getEmail()); 
		passtext("hgjkdjnc", f.getPassWord());
		getAttributeValue(f.getPassWord());
		login(f.getLogin());
		
				
		
	}
}
 