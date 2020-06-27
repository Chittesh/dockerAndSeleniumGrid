package seleniumStandalone;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Standalone {

	public static void main(String[] args) throws MalformedURLException {
		//When we want to run scripts in remote like cloud, browserstack, docker 
		//we need to use Remotewebdriver.
		//this take 2 arguments , which port we need to run and the other is desired capablites
		
		//URL of port where docker contaier is present
		URL objURL=new URL("http://localhost:4444/wd/hub");
		//Which browser we need to run
		//DesiredCapabilities objDesiredCapabilities = DesiredCapabilities.chrome();
		DesiredCapabilities objDesiredCapabilities = DesiredCapabilities.chrome();
		RemoteWebDriver objRemoteWebDriver = new RemoteWebDriver(objURL,objDesiredCapabilities);
		
		objRemoteWebDriver.get("https://www.google.com");
		System.out.println(objRemoteWebDriver.getTitle());

	}

}
