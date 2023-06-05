package com.tutorialsninja.qa.testcases;



import java.util.Date;

import org.testng.annotations.Test;

public class DemoTest {

	//public static void main (String[] args) {
		//System.getProperties().list(System.out);
		//System.out.println(System.getProperty("os.name"));
		//System.out.println(System.getProperty("user.name"));
		//System.out.println(System.getProperty("java.version"));
		
	//}
	
	@Test
	
		public void generatetimestamp() 
		{
			Date date=new Date();
			System.out.println(date.toString().replace(":", "_").replace(" ", "_")); 
		}	
}
