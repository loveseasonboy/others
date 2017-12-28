package com.netty;

import java.io.Serializable;

public class Command implements Serializable{
    private String actionName;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
