package com.owl;

public class MinaConstantConfig {

    public static final String DEFAULT_CHARSET = "UTF-8";

    public static final String MSG_TYPE = "msg_type";
    public static final String MSG_ID = "msg_id";
    public static final String MSG_READ = "msg_isRead";
    public static final String MSG_URL = "msg_url";
    public static final String MSG_ICON = "msg_icon";
    public static final String MSG_TITLE = "msg_title";
    public static final String MSG_BRIEF = "msg_brief";
    public static final String MSG_DATE = "msg_date";

    public static final int MSG_TYPE_DEVICE = 1;
    public static final int MSG_TYPE_HEART_BEAT_REQUEST = 2;
    public static final int MSG_TYPE_HEART_BEAT_RESPONSE = 3;
    public static final int MSG_TYPE_MESSAGE = 4;

    public static final int PORT = 9123;

    public static final int READ_BUFFER_SIZE = 2 * 1024;

    public static final int KEEP_ALIVE_INTERVAL = 60;

    public static final int KEEP_ALIVE_TIMEOUT = 30;

    public static final int IDLE_TIME = KEEP_ALIVE_INTERVAL * 2;

}
