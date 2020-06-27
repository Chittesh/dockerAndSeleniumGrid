package seleniumStandalone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class startDocker {

	public void start() throws IOException, InterruptedException {
		// This Class will help us to execute any bat file on our windows machine
		Runtime objRuntime = Runtime.getRuntime();
		objRuntime.exec("cmd /c start dockerUp.bat");
		String ServerLog = "DockerServerLogs.txt";

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 30);
		long millisecond = cal.getTimeInMillis();

		boolean serverStatus = false;
		// Checking for 30 seconds
		while (System.currentTimeMillis() < millisecond) {
			// Converting to file format
			Thread.sleep(1500);
			FileReader fs = new FileReader(ServerLog);
			// To Read the contents
			BufferedReader bs = new BufferedReader(fs);
			// bs.readLine() - Reads the first line then goes on
			String currentLine = bs.readLine();
			while (currentLine != null) {
				if (currentLine.contains("The node is registered to the hub and ready to use")) {
					System.out.println("The node is registered to the hub and ready to use");
					serverStatus = true;
					break;
				} else {
					currentLine = bs.readLine();
				}
			}
			bs.close();
			// To break the Main while Loop
			if (serverStatus) {
				break;
			}
		}

		Assert.assertTrue(serverStatus);
		objRuntime.exec("cmd /c start scaleUpChrome.bat");
		Thread.sleep(30000);
	}

}
