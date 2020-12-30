package com.automationanywhere.commands.basic;


import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.commandsdk.model.AttributeType;

//BotCommand makes a class eligible for being considered as an action.
@BotCommand

//CommandPks adds required information to be displayable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "my second action", label = "my second action",
        node_label = "my second action", description = "my second action", icon = "pkg.svg",

        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "returns something", return_type = com.automationanywhere.commandsdk.model.DataType.STRING, return_required = true)

public class SimpleAction2Params {

    //Messages read from full qualified property file name and provide i18n capability.
    private static final Messages MESSAGES = MessagesFactory.getMessages("com.automationanywhere.botcommand.demo.messages");

    //Identify the entry point for the action. Returns a Value<String> because the return type is String.
    @Execute
    public Value<String> action(
            @Idx(index = "1", type = AttributeType.TEXT)
            @Pkg(label = "[[action2.label]]")
            @NotEmpty String YourName,

            @Idx(index = "2", type = AttributeType.BOOLEAN)
            @Pkg(label = "take more PTO")
            @NotEmpty Boolean SomeTrueOrFalseValue
    ) {

        //Internal validation, to disallow empty strings. No null check needed as we have NotEmpty on firstString.
        if ("".equals(YourName.trim())) {
            throw new BotCommandException(MESSAGES.getString("emptyInputString", "YourName"));
        }

        String result = "";
        //Business logic
        if(SomeTrueOrFalseValue){
            result = "Oh hi there, "+YourName+" - I think you need to take more PTO";
        }else{
            result = "Oh hi there, "+YourName;
        }

        //Return StringValue.
        return new StringValue(result);
    }

}
