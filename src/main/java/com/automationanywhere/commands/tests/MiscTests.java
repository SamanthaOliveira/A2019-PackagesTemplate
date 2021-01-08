package com.automationanywhere.commands.tests;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commands.basic.SimpleAction;
import com.automationanywhere.commands.basic.SimpleAction4Rest;
import com.automationanywhere.commands.basic.SimpleAction4Rest2;

import static org.testng.Assert.assertEquals;

public class MiscTests {

    public static void main(String[] args){
        //test 1
        SimpleAction command = new SimpleAction();
        StringValue d = command.action("Samantha");
        assertEquals("Oh hi there, Samantha",d.toString());

        // test 2
        SimpleAction4Rest command4 = new SimpleAction4Rest();
        StringValue d4 = command4.action("https://viacep.com.br/ws/09725160/json/");
        System.out.println(d4.toString());

        //test 3
        SimpleAction4Rest2 command5 = new SimpleAction4Rest2();
        StringValue d5 = command5.action("https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/sp");
        System.out.println(d5.toString());
    }
}
