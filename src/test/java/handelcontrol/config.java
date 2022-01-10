package handelcontrol;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class config {
	Properties prop;
	public config() throws IOException
	{
		FileInputStream fi=new FileInputStream(".\\Irctc\\irctc.properties");
		 prop=new Properties();
		prop.load(fi);
	}
	public String username()
	{
		return prop.getProperty("url");
		
	}
	{
		
	}
	
	
}
