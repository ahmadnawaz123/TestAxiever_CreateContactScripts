package textAxiever.GenericUtility;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;

public class JavaUtility {

	public void selectOption(List<WebElement> alldropDownOptions, String optionToBeSelected) {
		boolean isFound = false;
		for (WebElement option : alldropDownOptions) {
			if (option.getText().equals(optionToBeSelected)) {
				option.click();
				isFound = true;
				break;
			}
 
		}
		if (!isFound)
			System.out.println("No matching option found.");
		
	}

	/**
	 * This method will generate a random number
	 * @return
	 */
	public int getRandomNumber() {
		{
			Random r = new Random();
			int ran =r.nextInt(1000);
			return ran;
		}
		
	}
	
}
