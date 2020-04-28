package org.Adactin;



import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class ZExecuteAll {
	
@Test
public void Zresult() {
	Result rs = JUnitCore.runClasses(Login.class);
	
	int runCount =rs.getRunCount();
	System.out.println("Testcases Count : "+runCount);

	long runTime =rs.getRunTime();
	System.out.println("Total Time Taken : "+runTime);

	int ignoreCount =rs.getIgnoreCount();
	System.out.println("Ignore Testcases Count : "+ignoreCount);
	
	int failureCount =rs.getFailureCount();
	System.out.println("Failure Testcases Count : "+failureCount);
	
	List<Failure> failurereason= rs.getFailures();
	for (Failure f1 : failurereason) {
		System.out.println("Failure Reasons : " +f1.getMessage());
	}
	
}

}
