package configExample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReaderExample {
	Properties prop;
	public configReaderExample() throws IOException
	{
		FileInputStream fi=new FileInputStream(".\\data\\config.properties");
		 prop=new Properties();
		prop.load(fi);
	}
	
	

	public String username()
	{
		return prop.getProperty("user");
		
	}
	public String Ps()
	{
		return prop.getProperty("pswd");
		
	}

	public String ul() {
		
		 return prop.getProperty("url");
	}

	
	}

