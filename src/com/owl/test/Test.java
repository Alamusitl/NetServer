package com.owl.test;

import com.owl.Message;

import java.util.Date;

/**
 * Created by Imagine Owl on 2017/7/25.
 */

public class Test {

    private static int id = 1;

    public static Message getSingleMessage() {
        String title = "I'm Title";
        String brief = "I'm Brief";
        Message message = new Message();
        message.setMessageId(id);
        message.setRead(false);
        message.setMessageUrl("http://www.baidu.com");
        message.setIconUrl("http://192.168.112.74:8000/kog/app/images/cart@2x.png");
        message.setTitle(title);
        message.setBrief(brief);
        message.setDate(new Date());
        id++;
        return message;
    }
}
