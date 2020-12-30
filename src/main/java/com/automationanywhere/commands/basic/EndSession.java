package com.automationanywhere.commands.basic;


import com.automationanywhere.commands.misc.BackendServer;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.util.Map;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;
//import java.net.http.HttpResponse;

/**
 * @author Brendan Sapience
 */


@BotCommand
@CommandPkg(label = "End session", name = "EndSession", description = "End session", icon =
        "", node_label = "End session {{sessionName}}")
public class EndSession {
    @Sessions
    private Map<String, Object> sessions;
    @Execute
    public void end(
            @Idx(index = "1", type = TEXT) @Pkg(label = "Session name", default_value_type = STRING, default_value = "Default") @NotEmpty String sessionName
    ) {
        sessions.remove(sessionName);
    }
    public void setSessions(Map<String, Object> sessions) {
        this.sessions = sessions;
    }
}