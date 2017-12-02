package Assignment;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Tours {

	
	
		WebDriver driver = new FirefoxDriver();
		
		@BeforeTest
		
	
		public void load() {
			
			
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("REGISTER")).click();
		}

		  @DataProvider(name = "Data")
		  
		  public static Object[][] credentials() {
		 
		        return new Object[][] { { "Opesydra", "Uteh", "1234567890", "aslkdl", "Esasgwat@tco.com",
		        	"XYN", "BDF", "123"}};
		 
		  }
		
		@Test(dataProvider = "Data")
		
		//@Parameters(value = { "sfirstname", "slastname" })
		public void data(String sfirstname,String slastname,String sphone, String suserName, String saddress1, 
				String scity, 
				String sstate, String spostalCode)
		{
		driver.findElement(By.name("firstName")).sendKeys(sfirstname);
		driver.findElement(By.name("lastName")).sendKeys(slastname);
		driver.findElement(By.name("phone")).sendKeys(sphone);
		driver.findElement(By.name("userName")).sendKeys(suserName);
		driver.findElement(By.name("address1")).sendKeys(saddress1);
		driver.findElement(By.name("city")).sendKeys(scity);
		driver.findElement(By.name("state")).sendKeys(sstate);
		driver.findElement(By.name("postalCode")).sendKeys(spostalCode);
		
		WebElement ele = driver.findElement(By.name("country"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("INDIA");
		
		driver.findElement(By.id("email")).sendKeys("mno@kl.com");
		driver.findElement(By.name("password")).sendKeys("P$$w0rd");
		driver.findElement(By.name("confirmPassword")).sendKeys("P$$w0rd");
		driver.findElement(By.name("register")).click();
		
		driver.findElement(By.linkText("SIGN-OFF")).click();
		driver.close();
		driver.quit();
		
		}
	}


