package com.weborder;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Order {

	
	 
	 private static int getRandomInteger(int min, int max){
		 
		 return ThreadLocalRandom.current().nextInt(min, max+1);
	 }
	
	 public static String randomCard(int num) {
			
			Random rn = new Random();
			String card=""; 
			for (int i = 0; i < num-1; i++) {
				int random = rn.nextInt(10); 
			    card=card+random;  
				
			}
			
			return card; 
			
		
			
		}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cakici\\Documents\\Selenium dependencies\\drivers\\chromedriver.exe");
		
//		1.Open browser
//		2.Go to url http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx (Links to an external site.)Links to an external site.
//		3.Login using username Tester and password test
//		4.Click on Order link
//		5.Enter a random quantity between 1 and 100
//		6.Enter Customer Name: John <middle_name> Smith. Instead of <middle_name> your code should enter a random string every time.
//		Enter street: 123 Any st
//		Enter City: Anytown
//		Enter State: Virginia
//		Enter a random 5 digit number to the zip code field
//		Select any card type. Every time your code should select a different type.
//		Enter any card number. If you selected Visa, card number should start with 4.
//				If you selected Master, card number should start with 5. 
//				If you selected American Express, card number should start with 3. 
//				New card number should be auto generated every time you run the test. 
//				Card numbers should be 16 digits for Visa and Master, 
//				15 for American Express.
//		Enter any valid expiration date 
//		Click on Process
//		Verify than the page contains text New order has been successfully added.
	
		WebDriver driver = new ChromeDriver();
		 driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
		 driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("tester");
		 driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		 driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		 driver.findElement(By.linkText("Order")).click();
		 driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")).click();
		 driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),Random_num());
		 driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John");
		 driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"John "+randomIdentifier()+" Smith");
		 driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		 driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Houston");
		 driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Texas");
		 driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(Random_num(5));
		 driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
		 
		
		
		 
		 
		 final int cardType= getRandomInteger(1,3); 
			driver.findElement(By.xpath("(//input[@name='ctl00$MainContent$fmwOrder$cardList'])["+cardType+"]")).click();
		 
		 switch(cardType) {
			case 1: driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("4"+randomCard(16) ); break; 
			case 2: driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("5"+randomCard(16)  ); break;
			case 3: driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("3"+randomCard(15)  ); break;
			}
		 driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("10/22");
		 Thread.sleep(3000);
		 
			driver.findElement(By.linkText("Process")).click();
			
			 if( driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder > tbody > tr > td > div > strong")).isDisplayed()){
			System.out.println("Verified");
	}else{
			System.out.println("unVerified");
	}
  
    
}
		 
		 
	
	
	public static String Random_num() {
		Random rn = new Random();
		int random = rn.nextInt(100);
		String run_num = Integer.toString(random);
		return run_num;
	}
	public static String randomIdentifier() {
	
	final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	Random rn = new Random();
	int random1 = rn.nextInt(24);
	
    
    return lexicon.charAt(random1)+"";
}
		 
	public static String Random_num(int num) {
		Random rn = new Random();
		int random = 0;
		if (num >=5) random = (1 + rn.nextInt(2)) * 10000 + rn.nextInt(10000);
		else random = rn.nextInt(100);
		String run_num = Integer.toString(random);
		return run_num;
	}

	public static String Random_number() {
		Random rn = new Random();
		int random = rn.nextInt(3);
		String run_num = Integer.toString(random);
		return run_num;
	}  
	
	
	
	
	
	
	
	
//	Enter any card number. If you selected Visa, card number should start with 4.
//	If you selected Master, card number should start with 5. 
//	If you selected American Express, card number should start with 3. 
//	New card number should be auto generated every time you run the test. 
//	Card numbers should be 16 digits for Visa and Master, 
//	15 for American Express.	 
		 
		
		
	
		 
		 
}
	