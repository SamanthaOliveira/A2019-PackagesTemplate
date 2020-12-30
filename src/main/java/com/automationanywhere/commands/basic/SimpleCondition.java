package com.automationanywhere.commands.basic;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.AttributeType.VARIABLE;
import static com.automationanywhere.commandsdk.model.AttributeType.CHECKBOX;

import static com.automationanywhere.commandsdk.model.DataType.RECORD;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import java.util.Iterator;
import java.util.List;
import static com.automationanywhere.commandsdk.model.DataType.BOOLEAN;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.model.Schema;
import com.automationanywhere.botcommand.data.model.record.Record;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;

import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import com.automationanywhere.commandsdk.annotations.ConditionTest;
import com.automationanywhere.commandsdk.annotations.BotCommand.CommandType;

/**
 * @author Bren Sapience
 *
 */

@BotCommand(commandType = CommandType.Condition)
@CommandPkg(label = "string is in list", name = "iteminlist",
        description = "check if string is in list",
        node_label = "List {{list1}} contains {{item}}", icon = "")
public class SimpleCondition  {

    @ConditionTest
    public boolean test(@Idx(index = "1", type = AttributeType.LIST)  @Pkg(label = "List" , default_value_type = DataType.LIST) @NotEmpty List<Value> list1,
                        @Idx(index = "2", type = TEXT)  @Pkg(label = "String"  , default_value_type = STRING) @NotEmpty String item)
    {

        for(Value listItem : list1){
            if(listItem.toString().equalsIgnoreCase(item)){
                return true;
            }
        }

        return false;

    }
}

