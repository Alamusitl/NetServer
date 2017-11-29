package com.owl;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;

public class MinaKeepAliveHandler implements KeepAliveRequestTimeoutHandler {

    @Override
    public void keepAliveRequestTimedOut(KeepAliveFilter arg0, IoSession arg1) throws Exception {
        System.out.println("heart beat timeout");
    }

}
