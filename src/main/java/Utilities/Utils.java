package Utilities;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils {

    public static void selectValue(List<WebElement> elements, String value){

        for(int i=0;i<elements.size();i++){
            if(elements.get(i).getText().equalsIgnoreCase(value)){
                elements.get(i).click();

            }

        }



    }

}
