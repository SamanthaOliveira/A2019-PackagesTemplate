package com.automationanywhere.commands.basic;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.core.security.SecureString;
import java.lang.Boolean;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Number;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ExamplesOfInputTypesCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(ExamplesOfInputTypesCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    ExamplesOfInputTypes command = new ExamplesOfInputTypes();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("InputFile") && parameters.get("InputFile") != null && parameters.get("InputFile").get() != null) {
      convertedParameters.put("InputFile", parameters.get("InputFile").get());
      if(!(convertedParameters.get("InputFile") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","InputFile", "String", parameters.get("InputFile").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("InputFile") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","InputFile"));
    }

    if(parameters.containsKey("Checkbox1") && parameters.get("Checkbox1") != null && parameters.get("Checkbox1").get() != null) {
      convertedParameters.put("Checkbox1", parameters.get("Checkbox1").get());
      if(!(convertedParameters.get("Checkbox1") instanceof Boolean)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","Checkbox1", "Boolean", parameters.get("Checkbox1").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("Checkbox1") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","Checkbox1"));
    }

    if(parameters.containsKey("MySelectOption") && parameters.get("MySelectOption") != null && parameters.get("MySelectOption").get() != null) {
      convertedParameters.put("MySelectOption", parameters.get("MySelectOption").get());
      if(!(convertedParameters.get("MySelectOption") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","MySelectOption", "String", parameters.get("MySelectOption").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("MySelectOption") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","MySelectOption"));
    }
    if(convertedParameters.get("MySelectOption") != null) {
      switch((String)convertedParameters.get("MySelectOption")) {
        case "1" : {

        } break;
        case "2" : {

        } break;
        default : throw new BotCommandException(MESSAGES_GENERIC.getString("generic.InvalidOption","MySelectOption"));
      }
    }

    if(parameters.containsKey("SomeText") && parameters.get("SomeText") != null && parameters.get("SomeText").get() != null) {
      convertedParameters.put("SomeText", parameters.get("SomeText").get());
      if(!(convertedParameters.get("SomeText") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","SomeText", "String", parameters.get("SomeText").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("SomeText") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","SomeText"));
    }

    if(parameters.containsKey("aNumber") && parameters.get("aNumber") != null && parameters.get("aNumber").get() != null) {
      convertedParameters.put("aNumber", parameters.get("aNumber").get());
      if(!(convertedParameters.get("aNumber") instanceof Number)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","aNumber", "Number", parameters.get("aNumber").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("aNumber") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","aNumber"));
    }

    if(parameters.containsKey("aDictionary") && parameters.get("aDictionary") != null && parameters.get("aDictionary").get() != null) {
      convertedParameters.put("aDictionary", parameters.get("aDictionary").get());
      if(!(convertedParameters.get("aDictionary") instanceof LinkedHashMap)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","aDictionary", "LinkedHashMap", parameters.get("aDictionary").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("aDictionary") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","aDictionary"));
    }

    if(parameters.containsKey("aList") && parameters.get("aList") != null && parameters.get("aList").get() != null) {
      convertedParameters.put("aList", parameters.get("aList").get());
      if(!(convertedParameters.get("aList") instanceof ArrayList)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","aList", "ArrayList", parameters.get("aList").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("aList") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","aList"));
    }

    if(parameters.containsKey("aCred") && parameters.get("aCred") != null && parameters.get("aCred").get() != null) {
      convertedParameters.put("aCred", parameters.get("aCred").get());
      if(!(convertedParameters.get("aCred") instanceof SecureString)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","aCred", "SecureString", parameters.get("aCred").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("aCred") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","aCred"));
    }

    if(parameters.containsKey("MyRadioOption") && parameters.get("MyRadioOption") != null && parameters.get("MyRadioOption").get() != null) {
      convertedParameters.put("MyRadioOption", parameters.get("MyRadioOption").get());
      if(!(convertedParameters.get("MyRadioOption") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","MyRadioOption", "String", parameters.get("MyRadioOption").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("MyRadioOption") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","MyRadioOption"));
    }
    if(convertedParameters.get("MyRadioOption") != null) {
      switch((String)convertedParameters.get("MyRadioOption")) {
        case "3" : {

        } break;
        case "4" : {

        } break;
        default : throw new BotCommandException(MESSAGES_GENERIC.getString("generic.InvalidOption","MyRadioOption"));
      }
    }

    if(parameters.containsKey("aCode") && parameters.get("aCode") != null && parameters.get("aCode").get() != null) {
      convertedParameters.put("aCode", parameters.get("aCode").get());
      if(!(convertedParameters.get("aCode") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","aCode", "String", parameters.get("aCode").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("aCode") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","aCode"));
    }

    if(parameters.containsKey("bool") && parameters.get("bool") != null && parameters.get("bool").get() != null) {
      convertedParameters.put("bool", parameters.get("bool").get());
      if(!(convertedParameters.get("bool") instanceof Boolean)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","bool", "Boolean", parameters.get("bool").get().getClass().getSimpleName()));
      }
    }
    if(parameters.containsKey("boolChild1") && parameters.get("boolChild1") != null && parameters.get("boolChild1").get() != null) {
      convertedParameters.put("boolChild1", parameters.get("boolChild1").get());
      if(!(convertedParameters.get("boolChild1") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","boolChild1", "String", parameters.get("boolChild1").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("boolChild1") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","boolChild1"));
    }


    try {
      Optional<Value> result =  Optional.ofNullable(command.action((String)convertedParameters.get("InputFile"),(Boolean)convertedParameters.get("Checkbox1"),(String)convertedParameters.get("MySelectOption"),(String)convertedParameters.get("SomeText"),(Number)convertedParameters.get("aNumber"),(LinkedHashMap<String, Value>)convertedParameters.get("aDictionary"),(ArrayList<Value>)convertedParameters.get("aList"),(SecureString)convertedParameters.get("aCred"),(String)convertedParameters.get("MyRadioOption"),(String)convertedParameters.get("aCode"),(Boolean)convertedParameters.get("bool"),(String)convertedParameters.get("boolChild1")));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","action"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
