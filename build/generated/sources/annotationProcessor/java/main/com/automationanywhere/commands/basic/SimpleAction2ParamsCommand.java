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

public final class SimpleAction2ParamsCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(SimpleAction2ParamsCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    SimpleAction2Params command = new SimpleAction2Params();
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

    try {
      Optional<Value> result =  Optional.ofNullable(command.action((String)convertedParameters.get("YourName"),(Boolean)convertedParameters.get("SomeTrueOrFalseValue")));
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
