package com.owl;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Imagine Owl on 2017/7/25.
 */

public class Message {

    private int messageId;
    private boolean isRead;
    private String messageUrl;
    private String iconUrl;
    private String title;
    private String brief;
    private Date date;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(MinaConstantConfig.MSG_TYPE, MinaConstantConfig.MSG_TYPE_MESSAGE);
            jsonObject.put(MinaConstantConfig.MSG_ID, messageId);
            jsonObject.put(MinaConstantConfig.MSG_READ, isRead);
            jsonObject.put(MinaConstantConfig.MSG_URL, messageUrl);
            jsonObject.put(MinaConstantConfig.MSG_ICON, iconUrl);
            jsonObject.put(MinaConstantConfig.MSG_TITLE, title);
            jsonObject.put(MinaConstantConfig.MSG_BRIEF, brief);
            jsonObject.put(MinaConstantConfig.MSG_DATE, date.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
