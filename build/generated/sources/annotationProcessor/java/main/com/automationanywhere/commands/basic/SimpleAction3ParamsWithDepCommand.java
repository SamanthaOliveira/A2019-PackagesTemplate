package com.automationanywhere.commands.basic;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.Boolean;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class SimpleAction3ParamsWithDepCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(SimpleAction3ParamsWithDepCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    SimpleAction3ParamsWithDep command = new SimpleAction3ParamsWithDep();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("YourName") && parameters.get("YourName") != null && parameters.get("YourName").get() != null) {
      convertedParameters.put("YourName", parameters.get("YourName").get());
      if(!(convertedParameters.get("YourName") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","YourName", "String", parameters.get("YourName").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("YourName") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","YourName"));
    }

    if(parameters.containsKey("SomeTrueOrFalseValue") && parameters.get("SomeTrueOrFalseValue") != null && parameters.get("SomeTrueOrFalseValue").get() != null) {
      convertedParameters.put("SomeTrueOrFalseValue", parameters.get("SomeTrueOrFalseValue").get());
      if(!(convertedParameters.get("SomeTrueOrFalseValue") instanceof Boolean)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","SomeTrueOrFalseValue", "Boolean", parameters.get("SomeTrueOrFalseValue").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("SomeTrueOrFalseValue") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","SomeTrueOrFalseValue"));
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

    try {
      Optional<Value> result =  Optional.ofNullable(command.action((String)convertedParameters.get("YourName"),(Boolean)convertedParameters.get("SomeTrueOrFalseValue"),(String)convertedParameters.get("MySelectOption"),(String)convertedParameters.get("MyRadioOption")));
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
