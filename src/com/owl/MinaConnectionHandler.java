package com.owl;

import com.owl.util.Util;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class MinaConnectionHandler extends IoHandlerAdapter {

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("session created");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("session opened");
        MinaSessionManager.getInstance().setSession(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("session closed");
        MinaSessionManager.getInstance().closeSession();
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println(status.toString());
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("message received: " + message.toString());
        int type = Util.getMessageType(message);
        if (MinaConstantConfig.MSG_TYPE_DEVICE == type) {
            System.out.println("message received: received device info");
        }
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("message send: " + message.toString());
    }
}
