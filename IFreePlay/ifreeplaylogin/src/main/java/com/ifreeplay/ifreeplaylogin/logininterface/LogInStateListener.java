package com.ifreeplay.ifreeplaylogin.logininterface;


import com.ifreeplay.ifreeplaylogin.bean.User;

/**
 * Created by gaowe on 2017/7/6.
 */

public interface LogInStateListener {
    public  void OnLoginSuccess(User user, String logType);
    public  void OnLoginError(String error);
}
