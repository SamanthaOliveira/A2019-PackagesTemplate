package com.automationanywhere.commands.basic;


import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

//BotCommand makes a class eligible for being considered as an action.
@BotCommand

//CommandPks adds required information to be displayable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "my 6th action", label = "my 6th action",
        node_label = "my 6th action", description = "my 6th action", icon = "newicon_w.svg",
        comment = true , text_color = "#94005f" , background_color =  "#94005f",
        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "returns something", return_type = DataType.STRING, return_required = true)

public class SimpleAction6Icon {

    //Messages read from full qualified property file name and provide i18n capability.
    private static final Messages MESSAGES = MessagesFactory.getMessages("com.automationanywhere.botcommand.demo.messages");

    //Identify the entry point for the action. Returns a Value<String> because the return type is String.
    @Execute
    public StringValue action(

            @Idx(index = "1", type = AttributeType.TEXT)
            @Pkg(label = "URL")
            @NotEmpty String MyURL

            ) {

        //Internal validation, to disallow empty strings. No null check needed as we have NotEmpty on firstString.
        if ("".equals(MyURL.trim())) {
            throw new BotCommandException(MESSAGES.getString("emptyInputString", "YourName"));
        }

        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get(MyURL).asString();
            return new StringValue(response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        //Return StringValue.
        return new StringValue("");
    }

}
