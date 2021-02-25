package Practice;

import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Practice{


    @Test(dataProvider = "getDataForPractice",dataProviderClass = DataProviderForPractice.class,priority = 1)
    public void test1(String value, ITestContext testContext){
        int currentCount = testContext.getAllTestMethods()[0].getCurrentInvocationCount();
        if(currentCount==0){
            System.out.println(value);
        }
        if(currentCount==1){



        }

    }
    @Test(dataProvider = "getDataForPractice",dataProviderClass = DataProviderForPractice.class,priority = 2)
    public void test2(String value){

       // System.out.println(value);


    }


}
