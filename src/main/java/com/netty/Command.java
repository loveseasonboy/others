package com.netty;

import java.io.Serializable;
/*测试QQ*/
public class Command implements Serializable{
    private String actionName;
    /*测试QQ*/
    public String getActionName() {
        return actionName;
    }
    /*测试4*/
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
