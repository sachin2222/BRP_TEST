package Practice;

import org.testng.annotations.Test;

public class LogsPractice {

    @Test
    public void test1(){
     System.Logger logs=System.getLogger("LogsPractice");
        System.out.println(logs.getName());
        logs.log(System.Logger.Level.ERROR,"this is Logs");


    }
}
