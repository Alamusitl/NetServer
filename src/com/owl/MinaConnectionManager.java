package com.owl;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class MinaConnectionManager {

    private static MinaConnectionManager sInstance = null;

    private IoAcceptor mAcceptor;

    private MinaConnectionManager() {
        mAcceptor = new NioSocketAcceptor();
        mAcceptor.getFilterChain().addLast("logging", new LoggingFilter());
        mAcceptor.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        setKeepAliveFilter();
        mAcceptor.setHandler(new MinaConnectionHandler());
        mAcceptor.getSessionConfig().setReadBufferSize(MinaConstantConfig.READ_BUFFER_SIZE);
        mAcceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, MinaConstantConfig.IDLE_TIME);
    }

    public static MinaConnectionManager getInstance() {
        if (sInstance == null) {
            synchronized (MinaConnectionManager.class) {
                if (sInstance == null) {
                    sInstance = new MinaConnectionManager();
                }
            }
        }
        return sInstance;
    }

    private void setKeepAliveFilter() {
        KeepAliveFilter filter = new KeepAliveFilter(new MinaKeepAliveFactory(), IdleStatus.BOTH_IDLE,
                new MinaKeepAliveHandler(), MinaConstantConfig.KEEP_ALIVE_INTERVAL, MinaConstantConfig.KEEP_ALIVE_TIMEOUT);
        filter.setForwardEvent(true);
        mAcceptor.getFilterChain().addLast("keepAlive", filter);
    }

    public void start() {
        try {
            mAcceptor.bind(new InetSocketAddress(MinaConstantConfig.PORT));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
