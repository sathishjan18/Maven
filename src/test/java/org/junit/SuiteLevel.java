package org.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.maven.Sample;

public class SuiteLevel {
	
	@RunWith(Suite.class)
	@SuiteClasses({SampleJunit.class,Sample.class})
	
	public class RunnerClass {
		

	}

}
