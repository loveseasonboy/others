package com.json;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 共用csf的返回结果集
 */
//@ApiModel(value = "共用的结果属性", description = "返回的结果集")
public class CommonCsfResult implements Serializable {
    private static final long serialVersionUID = 4507240745429139546L;
    private String rtnCode;//服务返回编码
    private String rtnMsg;//服务返回提示信息
    private ArrayList bean;//基本上空值
    private Object[] beans;//类型数组--基本上是空值
    private Object object;//内容包含result

    //@ApiModelProperty(value = "服务返回编码。0：成功 -9999：失败", required = true)
    public String getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    //@ApiModelProperty(value = "服务调用提示信息。retCode=0提示成功，其他提示错误", required = true)
    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }

    public ArrayList getBean() {
        return bean;
    }

    public void setBean(ArrayList bean) {
        this.bean = bean;
    }

    public Object[] getBeans() {
        return beans;
    }

    public void setBeans(Object[] beans) {
        this.beans = beans;
    }

    //@ApiModelProperty(value = "服务返回的结果集内容", required = true)
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
