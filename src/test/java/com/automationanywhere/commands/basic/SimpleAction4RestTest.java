package com.automationanywhere.commands.basic;
import com.automationanywhere.botcommand.data.impl.StringValue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Test(enabled=true)
public class SimpleAction4RestTest {

    SimpleAction4Rest command = new SimpleAction4Rest();

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
