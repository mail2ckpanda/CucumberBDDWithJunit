package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;
	/**
	 * This method is to initialize the property file and return the 
	 * @return
	 */
	public Properties init_Prop() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/Config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
