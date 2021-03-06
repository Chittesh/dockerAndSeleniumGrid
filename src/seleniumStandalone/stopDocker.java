package seleniumStandalone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;

public class stopDocker {
	public void stop() throws IOException, InterruptedException {
		// This Class will help us to execute any bat file on our windows machine
		Runtime objRuntime = Runtime.getRuntime();
		objRuntime.exec("cmd /c start dockerDown.bat");
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
				if (currentLine.contains("Shutdown complete")) {
					System.out.println("Shutdown complete");
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
	}

}
