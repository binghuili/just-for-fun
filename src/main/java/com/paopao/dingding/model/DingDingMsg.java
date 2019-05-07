package com.paopao.dingding.model;

/**
 * @author libinghui
 * @date 2018/4/8 13:13
 */
public class DingDingMsg {

    private String msgtype;
    private At at;
    private Text text;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public At getAt() {
        return at;
    }

    public void setAt(At at) {
        this.at = at;
    }
}

