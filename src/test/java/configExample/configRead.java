package configExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configRead {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fi=new FileInputStream(".\\data\\config.properties");
		Properties prop=new Properties();
		prop.load(fi);
		System.out.println("application url:"+prop.getProperty("url"));
		System.out.println("application user:"+prop.getProperty("user"));
		System.out.println("application pswd:"+prop.getProperty("pswd"));
	}

}
