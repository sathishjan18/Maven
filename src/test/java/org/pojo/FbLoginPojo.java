package org.pojo;

import java.util.ArrayList;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPojo extends BaseClass{

	public FbLoginPojo()  {

		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindAll({
		@FindBy(xpath="//input[@class='inputtext _55r1 _6luy']"),
		@FindBy(xpath="//input[@name='email']"),
		@FindBy(xpath="//input[@id='email']"),
		@FindBy(xpath="//input[@data-testid='royal_email']"),
		@FindBy(xpath="//input[@placeholder='Email address or phone number']")
	})
	private WebElement email;
	
	@CacheLookup
	@FindAll({
		@FindBy(xpath="//input[@type='password']"),
		@FindBy(xpath="//input[@class='inputtext _55r1 _6luy _9npi']"),
		@FindBy(xpath="//input[@id='pass']"),
		@FindBy(xpath="//input[@data-testid='royal_pass']"),
		@FindBy(xpath="//input[@placeholder='Password']"),
		@FindBy(xpath="//input[@aria-label='Password']")
	})
	private WebElement passWord;

	@CacheLookup
	@FindAll({
		@FindBy(xpath="//button[@value='1']"),
		@FindBy(xpath="//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']"),
		@FindBy(xpath="//button[@name='login']"),
		@FindBy(xpath="//button[@id='u_0_d_O/']"),
		@FindBy(xpath="//button[@type='submit']")
	})
	private WebElement login;
  
	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLogin() {
		return login;
	}
	
}  		
