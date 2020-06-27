package seleniumStandalone;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenGoogle {
	
	@Test()
	public void openGoogleOnChromeInstances() throws MalformedURLException {
		URL objURL=new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities objDesiredCapabilities = DesiredCapabilities.chrome();
		RemoteWebDriver objRemoteWebDriver = new RemoteWebDriver(objURL,objDesiredCapabilities);
		objRemoteWebDriver.get("https://www.google.com");
		System.out.println(objRemoteWebDriver.getTitle());
	}
	
	@Test()
	public void openGoogleOnFirefoxChromeInstances() throws MalformedURLException {
		URL objURL=new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities objDesiredCapabilities = DesiredCapabilities.firefox();
		RemoteWebDriver objRemoteWebDriver = new RemoteWebDriver(objURL,objDesiredCapabilities);
		objRemoteWebDriver.get("https://www.google.com");
		System.out.println(objRemoteWebDriver.getTitle());
	}
	
	@BeforeTest()
	public void startDocker() throws IOException, InterruptedException{
		startDocker objstartDocker = new startDocker();
		objstartDocker.start();
		
	}
	
	@AfterTest()
	public void stopDocker() throws IOException, InterruptedException{
		stopDocker objstoptDocker = new stopDocker();
		objstoptDocker.stop();
		

		File myObj = new File("DockerServerLogs.txt");
		if (myObj.delete()) {
			System.out.println("Deleted the file: " + myObj.getName());
		} else {
			System.out.println("Failed to delete the file.");
		}
	
		
	}
	

}
