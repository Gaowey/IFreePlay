package com.ifreeplay.ifreeplaylogin.logininterface;

/**
 * Created by asus on 2016/1/16.
 */
public interface HttpCallBackListener {

    void onFinish(String response);

    void onError(Exception e);

}
