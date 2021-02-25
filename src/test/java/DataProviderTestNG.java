import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderTestNG {

    @DataProvider
    public Object[][] getDataForSingleUser(Method method) {
        if (method.getName().equals("selectTitle"))
            return new String[][]{{"MR"}};

        if (method.getName().equals("EnterFirstName"))
            return new String[][]{{"sachin"}};

        else if (method.getName().equals("EnterLastName"))
            return new String[][]{{"Tendulkar"}};

        else if (method.getName().equals("ValidPhoneNumberTest"))
            return new String[][]{{"8700896891"}};

        else if (method.getName().equals("EnterPassword"))
            return new String[][]{{"sachin@12345"}};

        else if (method.getName().equals("EnterConfirmPassword"))
            return new String[][]{{"sachin@12345"}};

        else if (method.getName().equals("enterEmail"))
            return new String[][]{{"Email@domain.com"}};

        else if(method.getName().equals("selectYear"))
            return new String[][]{{"1998"}};

        else if(method.getName().equals("selectMonth"))
            return new String[][]{{"Feb"}};

        else if(method.getName().equals("selectDate"))
            return new String[][]{{"21"}};

        else
            return new String[][]{};


    }


}
