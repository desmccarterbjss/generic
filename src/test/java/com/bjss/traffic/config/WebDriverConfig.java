package com.bjss.traffic.config;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import com.bjss.traffic.tests.properties.Property;

import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.common.device.DeviceTargetPlatform;

public class WebDriverConfig {

	private WebDriver driver;
	private WebDriver driver2;

	protected final String globalPropertiesLocation="royalmail.properties";
	
	public WebDriver setUpSelendroid() { 
		
		/**
		 * Get environment ...
		 */
		String appId = Property.get(globalPropertiesLocation, "app.id");
	
		 //SelendroidConfiguration config = new SelendroidConfiguration();	
		 //config.addSupportedApp(appSrc);
		// SelendroidLauncher selendroidServer = new SelendroidLauncher(config);
		 //selendroidServer.lauchSelendroid();
		 
		io.selendroid.common.SelendroidCapabilities capa = new 
				io.selendroid.common.SelendroidCapabilities(appId);
	
		 //capa.setAut("com.bjss.precomsample:2.0.2");//com.bjss.precomsample:1.7.1
		 //capa.setPlatform(Platform.ANDROID);
		 //capa.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
		 //capa.setVersion("19");
		 //capa.setEmulator(true);
		 //capa.setModel("Nexus 5");
		 //capa.wait(10000000);
		 
		 //Create instance of Selendroid Driver
		 try{
			 System.out.println("[INFO] Connecting to Selendroid Standalone Server ....");
			 driver = new SelendroidDriver(capa);
			 System.out.println("[INFO] Done.");
		 }catch(Exception e){
			 System.out.println("[ERR] Connecting to Selendroid Standalone Server .... :"+e.getMessage());
		 }
		 
		 return driver;
		 
		}

	public WebDriver setUpSelendroid2() { 

		 String appId = System.getProperty("appId");
		 String appSrc= System.getProperty("appSrc");
		 //SelendroidConfiguration config = new SelendroidConfiguration();	
		 //config.addSupportedApp(appSrc);
		// SelendroidLauncher selendroidServer = new SelendroidLauncher(config);
		 //selendroidServer.lauchSelendroid();
		 
		 SelendroidCapabilities capa = new SelendroidCapabilities(appId);
		 //capa.setAut("com.bjss.precomsample:2.0.2");//com.bjss.precomsample:1.7.1
		 //capa.setPlatform(Platform.ANDROID);
		 //capa.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
		 //capa.setVersion("19");
		 //capa.setEmulator(true);
		 //capa.setModel("Nexus 5");
		 //capa.wait(10000000);
		 
		 //Create instance of Selendroid Driver
		 try{
		 driver2 = new SelendroidDriver(capa);	      
		 }catch(Exception e){}
		 
		 return driver2;
		 
		}
}
