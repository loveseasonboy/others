package com.netty;

import java.io.Serializable;
/*测试*/
public class Command implements Serializable{
    private String  actionName;

    public String getActionName() {
        return actionName;
    }

    /**
     * 测试
     * @param actionName
     */
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
