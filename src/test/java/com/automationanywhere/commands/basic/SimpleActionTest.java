package com.automationanywhere.commands.basic;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.DictionaryValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commands.basic.ExamplesOfInputTypes;
import com.automationanywhere.commands.basic.SimpleAction;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Map;

import static org.testng.Assert.assertEquals;


@Test(enabled=true)
public class SimpleActionTest {

    SimpleAction command = new SimpleAction();

        @DataProvider(name = "data")
        public Object[][] dataTobeTested(){

            return new Object[][]{
                    {"bren", "Oh hi there, bren"},
                    {"dart", "Oh hi there, dart"},
                    {"linus", "Oh hi there, linus"}
            };
        }

        @Test(dataProvider = "data")
        public void myTest(String SomeInputString, String ExpectedResults){
            StringValue d = command.action(SomeInputString);
            assertEquals(ExpectedResults,d.toString());
        }
}
