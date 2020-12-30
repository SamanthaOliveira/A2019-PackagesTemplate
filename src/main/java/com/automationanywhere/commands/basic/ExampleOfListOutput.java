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

import com.automationanywhere.botcommand.data.impl.BooleanValue;
import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bren Sapience
 *
 */
@BotCommand
@CommandPkg(label="Test List Output Type", name="Output Types - List", description="Demoing List output types", icon="pkg.svg",
		node_label="Node Label",
		return_type= DataType.LIST, return_label="Assign the output to variable", return_required=true)

public class ExampleOfListOutput {

	private static final Messages MESSAGES = MessagesFactory.getMessages("com.automationanywhere.botcommand.demo.messages");

	@Execute
	public ListValue action(
			@Idx(index = "1", type = AttributeType.TEXT) @Pkg(label = "Some Text", default_value_type = DataType.STRING) @NotEmpty String SomeString
		) {

		List<NumberValue> AllVariants = new ArrayList();
		for(int j=0;j<10;j++){
			NumberValue val = new NumberValue();
			Double d= (double) j;
			val.set(d);
			AllVariants.add(val);
		}

		ListValue myListValue = new ListValue();
		myListValue.set(AllVariants);
		return myListValue;
	}

}
