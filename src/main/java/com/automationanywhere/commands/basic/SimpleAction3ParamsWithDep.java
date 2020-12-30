package com.automationanywhere.commands.basic;


import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

//BotCommand makes a class eligible for being considered as an action.
@BotCommand

//CommandPks adds required information to be displayable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "my third action", label = "my third action",
        node_label = "my third action", description = "my third action", icon = "pkg.svg",

        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "returns something", return_type = com.automationanywhere.commandsdk.model.DataType.STRING, return_required = true)

public class SimpleAction3ParamsWithDep {

    //Messages read from full qualified property file name and provide i18n capability.
    private static final Messages MESSAGES = MessagesFactory.getMessages("com.automationanywhere.botcommand.demo.messages");

    //Identify the entry point for the action. Returns a Value<String> because the return type is String.
    @Execute
    public Value<String> action(
            @Idx(index = "1", type = AttributeType.TEXT)
            @Pkg(label = "your name")
            @NotEmpty String YourName,

            @Idx(index = "2", type = AttributeType.BOOLEAN)
            @Pkg(label = "take more PTO")
            @NotEmpty Boolean SomeTrueOrFalseValue,

            @Idx(index = "3", type = AttributeType.SELECT, options = {
                    @Idx.Option(index = "3.1", pkg = @Pkg(label = "Option 1", value = "1")),
                    @Idx.Option(index = "3.2", pkg = @Pkg(label = "Option 2", value = "2")),
            })
            @Pkg(label = "Pick an Option", default_value = "1", default_value_type = DataType.STRING) @NotEmpty String MySelectOption,

            @Idx(index = "4",  type = AttributeType.RADIO, options = {
                    @Idx.Option(index = "4.1", pkg = @Pkg(label = "Option 3", value = "3")),
                    @Idx.Option(index = "4.2", pkg = @Pkg(label = "Option 4", value = "4")),
            }) @Pkg(label = "Pick an Option", default_value = "1", default_value_type = DataType.STRING) @NotEmpty String MyRadioOption

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
