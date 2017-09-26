package com.bjss.traffic.stepdefs;


import org.junit.runner.RunWith; 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 

@RunWith(Cucumber.class) 
@CucumberOptions(
		plugin = {"pretty", "html:target/trafficreport2"} 
		) 

public class Test { }
	