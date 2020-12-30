package com.automationanywhere.commands.basic;

import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commands.misc.BackendServer;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

import java.util.Map;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;
//import java.net.http.HttpResponse;

/**
 * @author Brendan Sapience
 */

@BotCommand
@CommandPkg(label = "Start session", name = "StartSession", description = "Start new session",
        icon = "", node_label = "start session {{sessionName}}|")
public class StartSession {

    //private static final Logger logger = LogManager.getLogger(StartSession.class);

    private static final Messages MESSAGES = MessagesFactory.getMessages("com.automationanywhere.botcommand.demo.messages");

    // The session annotation indicates that a session object is being used
    @Sessions
    private Map<String, Object> sessions;

    @com.automationanywhere.commandsdk.annotations.GlobalSessionContext
    private com.automationanywhere.bot.service.GlobalSessionContext globalSessionContext;

    public void setGlobalSessionContext(com.automationanywhere.bot.service.GlobalSessionContext globalSessionContext) {
        this.globalSessionContext = globalSessionContext;
    }

    @Execute
    public void start(@Idx(index = "1", type = TEXT) @Pkg(label = "Session name",  default_value_type = STRING, default_value = "Default") @NotEmpty String sessionName,
                      @Idx(index = "2", type = TEXT) @Pkg(label = "Some Backend URL",  default_value_type = STRING, default_value = "Default") @NotEmpty String BackendURL
    ) throws Exception {

        // Check for existing session
        if (sessions.containsKey(sessionName))
            throw new BotCommandException(MESSAGES.getString("Session name in use ")) ;

        BackendServer myBackendServ = new BackendServer(BackendURL);
        this.sessions.put(sessionName, myBackendServ);

    }

    public void setSessions(Map<String, Object> sessions) {
        this.sessions = sessions;
    }

}
