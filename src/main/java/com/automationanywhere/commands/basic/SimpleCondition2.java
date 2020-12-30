package com.automationanywhere.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.BotCommand.CommandType;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

/**
 * @author Bren Sapience
 *
 */

@BotCommand(commandType = CommandType.Condition)
@CommandPkg(label = "web server is available", name = "webserveravailable",
        description = "check if a web application is available",
        node_label = "check web app", icon = "")
public class SimpleCondition2 {

    @ConditionTest
    public boolean test(@Idx(index = "1", type = AttributeType.TEXT)  @Pkg(label = "Endpoint" , default_value_type = STRING) @NotEmpty String MyURL)

    {
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get(MyURL).asString();
            if(response.getCode() == 200){
                return true;
            }else{
                return false;
            }
        } catch (UnirestException e) {
            return false;
        }

    }
}

