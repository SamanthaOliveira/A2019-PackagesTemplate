package com.automationanywhere.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test(enabled=true)
public class SimpleAction5Test {

    SimpleAction5 command = new SimpleAction5();

        @DataProvider(name = "data")
        public Object[][] dataTobeTested(){

            return new Object[][]{
                    {"bren", ""}
            };
        }

        @Test(dataProvider = "data")
        public void myTest(String SomeInputString, String ExpectedResults){
            StringValue d = command.action(SomeInputString);
            System.out.println(d.toString());
            //assertEquals(ExpectedResults,d.toString());
        }


}
