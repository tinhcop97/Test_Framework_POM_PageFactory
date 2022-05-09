package day1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ex3 {

    @Test(dataProvider = "data")
    public  void display(String color,String value){
        System.out.println(color +" "+ value);
    }

    @DataProvider(name = "data")
    public static Object[][] colors(){
        return new Object[][] {{"red", "#f00"}, {"green", "#0f0"}, {"blue", "#00f"}, {"cyan", "#0ff"}, {"magenta", "#f0f"}, {"yellow", "#ff0"}, {"black", "#000"}};
    }
}



