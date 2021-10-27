package org.maven;

import org.baseclass.BaseClass;
import org.junit.Test;
import org.pojo.FbLoginPojo;

public class Sample extends BaseClass {

	@Test
	public void tc6() {

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
