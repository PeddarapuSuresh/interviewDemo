package StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.Currencyformate;

public class pageObjects {

	WebDriver driver;

	// This is my assumption that i am taking this tag as parent of the all the labels as table
	// label list/tables
	WebElement Labellist = driver.findElement(By.xpath("//*[@id='lblval']/table[1]/tbody"));

	By Label1 = By.id("lbl_val_1");
	By Label2 = By.id("lbl_val_1");
	By Label3 = By.id("lbl_val_1");
	By Label4 = By.id("lbl_val_1");
	By Label5 = By.id("lbl_val_1");

	// This is my assumption that i am taking this tag as parent of all the value as table
	// prices
	WebElement pricelist = driver.findElement(By.xpath("//*[@id='value']/table[1]/tbody"));

	By price_label1 = By.id("txt_val_1");
	By price_label2 = By.id("txt_val_2");
	By price_label3 = By.id("txt_val_3");
	By price_label4 = By.id("txt_val_4");
	By price_label5 = By.id("txt_val_5");

	By totalLabels = By.id("lbl_ttl_val");
	By totallabels_prices = By.id("txt_ttl_val");

	public void Countlabels() {
		// Assuming My lables are under the list or table
		// So that i will use list to get the count

		List<WebElement> getcount = Labellist.findElements(By.tagName("tr"));

		int Count = getcount.size();

		System.out.println("My Labels avaliable in the application are  :" + Count);
	}

	public void PrintvaluesGreaterThenZero() throws Exception {

		List<WebElement> pricevalue = pricelist.findElements(By.tagName("tr"));
		for (int i = 0; i <= pricevalue.size(); i++) {

			WebElement p_val = driver
					.findElement(By.xpath("//*[@id='value']/table[1]/tbody/tr/td" + "[" + i + "]/text_val"));
			String price = Currencyformate.convertCurrencyToNbr(p_val.getText());
			double price_value = Double.parseDouble(price);
			if (price_value > 0) {

				WebElement vallabel = driver
						.findElement(By.xpath("//*[@id='lblval']/table[1]/tbody/tr/td" + "[" + i + "]/lbl_val"));
				System.out.println("values on the screen are greater than 0 " + vallabel.getAttribute("value"));
			}

		}

	}
	
	public void Verifytotalbalance() throws Exception {
		
		double totalrecords=0;
		
		
		List<WebElement> pricevalue = pricelist.findElements(By.tagName("tr"));
		for (int i = 0; i <= pricevalue.size(); i++) {

			WebElement p_val = driver
					.findElement(By.xpath("//*[@id='value']/table[1]/tbody/tr/td" + "[" + i + "]/text_val"));
			String price = Currencyformate.convertCurrencyToNbr(p_val.getText());
			double price_value = Double.parseDouble(price);
			
			totalrecords = totalrecords+price_value;
			
			System.out.println("total prices of all values are : "+totalrecords);
			
		}
		
		String actualprice = driver.findElement(totallabels_prices).getText();
		double actuals = Double.parseDouble(actualprice);
		Assert.assertEquals(totalrecords, actuals);
	
		
	}

	public void currencyvalidator() throws Exception {
		
		List<WebElement> pricevalue = pricelist.findElements(By.tagName("tr"));
		for (int i = 0; i <= pricevalue.size(); i++) {

			WebElement p_val = driver
					.findElement(By.xpath("//*[@id='value']/table[1]/tbody/tr/td" + "[" + i + "]/text_val"));
			String price = Currencyformate.convertCurrencyToNbr(p_val.getText());
			
			
			double price_value = Double.parseDouble(price);
			double formate = Currencyformate.currencytype(price_value);
			Assert.assertEquals(price_value, formate);
		}
		  
	}
	//Created constructor for Page objects 
	public pageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	
}
