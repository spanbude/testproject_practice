package utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class config {
	Properties prop;

    public config() throws Exception {

        FileInputStream fis = new FileInputStream(".\\TestData\\nopcommerce.properties");

        prop = new Properties();

        prop.load(fis);

    }

    public String getAppURL() {

        return prop.getProperty("url");

    }

    public String getAdminUser() {

        return prop.getProperty("user");

    }
    
    public String getAdminPass() {

        return prop.getProperty("pswd");

    }
    public String getemailField() {

        return prop.getProperty("email");

    }
    public String getFirstName() {

        return prop.getProperty("firstname");

    }
    public String getLastName() {

        return prop.getProperty("lastnamae");

    }

}
