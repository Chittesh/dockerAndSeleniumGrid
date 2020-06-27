package seleniumStandalone;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class parallelExectuionOnGrid {

	@Test()
	public void fireFox () throws MalformedURLException {
		URL objURL=new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities objDesiredCapabilities = DesiredCapabilities.firefox();
		RemoteWebDriver objRemoteWebDriver = new RemoteWebDriver(objURL,objDesiredCapabilities);
		objRemoteWebDriver.get("https://www.google.com");
		System.out.println(objRemoteWebDriver.getTitle());
	}
	
	@Test()
	public void chrome () throws MalformedURLException {
		URL objURL=new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities objDesiredCapabilities = DesiredCapabilities.chrome();
		RemoteWebDriver objRemoteWebDriver = new RemoteWebDriver(objURL,objDesiredCapabilities);
		objRemoteWebDriver.get("https://www.google.com");
		System.out.println(objRemoteWebDriver.getTitle());
	}
	
}
