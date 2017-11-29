package com.owl;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

public class MinaKeepAliveFactory implements KeepAliveMessageFactory {

    @Override
    public boolean isRequest(IoSession arg0, Object arg1) {
        String str = arg1.toString();
        if (str.length() > 1) {
            return false;
        } else {
            return MinaConstantConfig.MSG_TYPE_HEART_BEAT_REQUEST == Integer.parseInt(str);
        }
    }

    @Override
    public boolean isResponse(IoSession arg0, Object arg1) {
        String str = arg1.toString();
        if (str.length() > 1) {
            return false;
        } else {
            return MinaConstantConfig.MSG_TYPE_HEART_BEAT_RESPONSE == Integer.parseInt(str);
        }
    }

    @Override
    public Object getRequest(IoSession arg0) {
        return null;
    }

    @Override
    public Object getResponse(IoSession arg0, Object arg1) {
        return MinaConstantConfig.MSG_TYPE_HEART_BEAT_RESPONSE;
    }
}
