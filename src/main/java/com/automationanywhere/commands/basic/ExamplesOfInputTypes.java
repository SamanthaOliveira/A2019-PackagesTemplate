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
import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.CredentialOnly;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import com.automationanywhere.core.security.SecureString;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.automationanywhere.commandsdk.model.AttributeType.BOOLEAN;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

/**
 * @author Bren Sapience
 *
 */
@BotCommand
@CommandPkg(label="Test Input Types", name="Input Types - Tests", description="demoing multiple types of input parameters", icon="pkg.svg",
		node_label="Node Test",

		return_type= STRING, return_label="Assign the output to variable", return_required=true)

public class ExamplesOfInputTypes {

	private static final Messages MESSAGES = MessagesFactory.getMessages("com.automationanywhere.botcommand.demo.messages");

	@Execute
	public StringValue action(
			@Idx(index = "1", type = AttributeType.FILE)
			@Pkg(label = "Input File", default_value_type = DataType.FILE)
			@NotEmpty String InputFile,

			@Idx(index = "2", type = AttributeType.CHECKBOX)
			@Pkg(label = "Some Checkbox Option", default_value_type = DataType.BOOLEAN)
			@NotEmpty Boolean Checkbox1,

			@Idx(index = "3", type = AttributeType.SELECT, options = {
				@Idx.Option(index = "3.1", pkg = @Pkg(label = "Option 1", value = "1")),
				@Idx.Option(index = "3.2", pkg = @Pkg(label = "Option 2", value = "2")),
			})
			@Pkg(label = "Pick an Option", default_value = "1", default_value_type = DataType.STRING) @NotEmpty String MySelectOption,

			@Idx(index = "4", type = AttributeType.TEXT)
			@Pkg(label = "Some Text", default_value_type = STRING)
			@NotEmpty String SomeText,

			@Idx(index = "5", type = AttributeType.NUMBER)
			@Pkg(label = "Some Number", default_value_type = DataType.NUMBER)
			@NotEmpty Number aNumber,

			@Idx(index = "6", type = AttributeType.DICTIONARY)
			@Pkg(label = "Some Dictionary", default_value_type = DataType.DICTIONARY)
			@NotEmpty LinkedHashMap<String,Value> aDictionary,

			@Idx(index = "7", type = AttributeType.LIST)
			@Pkg(label = "Some List", default_value_type = DataType.LIST)
			@NotEmpty ArrayList<Value> aList,

			@Idx(index = "8", type = AttributeType.CREDENTIAL)
			@Pkg(label = "Some Credentials", default_value_type = DataType.RECORD)
			@NotEmpty SecureString aCred,

		@Idx(index = "9",  type = AttributeType.RADIO, options = {
				@Idx.Option(index = "9.1", pkg = @Pkg(label = "Option 3", value = "3")),
				@Idx.Option(index = "9.2", pkg = @Pkg(label = "Option 4", value = "4")),
		}) @Pkg(label = "Pick an Option", default_value = "1", default_value_type = DataType.STRING) @NotEmpty String MyRadioOption,


			@Idx(index = "10", type = AttributeType.CODE)
			@Pkg(label = "Some Code", default_value_type = DataType.STRING)
			@NotEmpty String aCode,

			@Idx(index = "11", type = BOOLEAN)
			@Pkg(label = "Boolean type", description = "A check box also supports children.")
					Boolean bool,

			@Idx(index = "11.1", type = TEXT)
			@Pkg(label = "Text type", description = "Child of boolean, this gets evaluated only when the checkbox is true")
			@NotEmpty String boolChild1

	) {

		if ("".equals(SomeText.trim()))
			throw new BotCommandException(MESSAGES.getString("emptyInputString", "InputFilePath"));

		String OUTPUT = "";

		// FILE
		OUTPUT = OUTPUT + "File:[" + InputFile+"]";

		// CHEKBOX
		OUTPUT = OUTPUT + "Checkbox:[" + Checkbox1+"]";

		// SELECT
		OUTPUT = OUTPUT + "Select:[" + MySelectOption+"]";

		// SELECT
		OUTPUT = OUTPUT + "Text:[" + SomeText+"]";

		// NUMBER
		OUTPUT = OUTPUT + "Number:[" + aNumber+"]";

		// DICTIONARY
		for (Map.Entry<String, Value> entry : aDictionary.entrySet()) {
			String myKey = entry.getKey();
			Value myValue = entry.getValue();
			OUTPUT = OUTPUT + "|" + "MapKey:[" + myKey + "] - MapValue:[" + myValue.toString()+"]";
			//System.out.println("Key = " + myKey + ", Value = " + myValue.toString());
		}

		// LIST
		for(Value v : aList){
			//System.out.println("Value = " + v.toString());
			OUTPUT = OUTPUT + "|" + "ListValue:[" + v.toString()+"]";
		}

		// CREDENTIAL
		OUTPUT = OUTPUT + "Cred:[" + aCred.getInsecureString()+"]";

		// RADIO
		OUTPUT = OUTPUT + "Radio:[" + MyRadioOption+"]";

		// CODE
		OUTPUT = OUTPUT + "Code:[" + aCode+"]";

		return new StringValue(OUTPUT);

	}

}
