package com.owl.util;

import com.owl.MinaConstantConfig;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Imagine Owl on 2017/7/25.
 */

public class Util {

    public static int getMessageType(Object object) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assert jsonObject != null;
        return jsonObject.optInt(MinaConstantConfig.MSG_TYPE);
    }
}
