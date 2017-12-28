package com.netty;

import java.io.Serializable;
/*测试*/
public class Command implements Serializable{
    private String actionName;
    /*测试*/
    public String getActionName() {
        return actionName;
    }
    /*测试3*/
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
