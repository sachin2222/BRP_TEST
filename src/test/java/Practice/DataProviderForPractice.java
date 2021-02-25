package Practice;


import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DataProviderForPractice {


    @DataProvider
    public Object[][] getDataForPractice(Method method, ITestContext testContext) {
        String[][] username = {{"sachin"},{"kapil"}};
        String[][] password = {{"password1"},{"password2"}};

        if (method.getName().equals("test1"))
            return username;


        else if (method.getName().equals("test2"))
            return password;


        else
            return new String[][]{{}};

    }
}
