/*
 * Copyright (c) 2019 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */
/**
 *
 */
package com.automationanywhere.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.BooleanValue;
import com.automationanywhere.botcommand.data.impl.DictionaryValue;
import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Bren Sapience
 *
 */
@BotCommand
@CommandPkg(label="Test Dict Output Type", name="Output Types - Dict", description="Demoing Dict output types", icon="pkg.svg",
		node_label="node label",

		return_type= DataType.DICTIONARY, return_label="Assign the output to variable", return_required=true)

public class ExampleOfDictionaryOutput {

	private static final Messages MESSAGES = MessagesFactory.getMessages("com.automationanywhere.botcommand.demo.messages");

	@Execute
	public DictionaryValue action(
			@Idx(index = "1", type = AttributeType.TEXT) @Pkg(label = "Some Text", default_value_type = DataType.STRING) @NotEmpty String SomeString
			)
	{

		// Dictionary of key-values
		Map<String,Value> ResMap = new LinkedHashMap();
		ResMap.put("login",new StringValue("brendan"));
		ResMap.put("password",new StringValue("wowlookatthatlongpassword!"));
		ResMap.put("score",new NumberValue("1"));

		return new DictionaryValue(ResMap);

	}

}
