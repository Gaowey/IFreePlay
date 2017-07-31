package com.ifreeplay.ifreeplaylogin.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ifreeplay.ifreeplaylogin.logininterface.LogInStateListener;
import com.ifreeplay.ifreeplaylogin.logininterface.LogOutStateListener;


/**
 * Created by gaowe on 2017/7/6.
 */

public  class LoginManager {
    private static FaceBookLoginUtil fbUtil=null;
    private static LineLoginUtil lineUtil=null;
    private static WeChatLoginUtil wechatUtil=null;
    public static final  int LineRequestCode=101;
    public static final  int FaceBookRequestCode=64206;

    /**
     * 登陆工具类，
     *
     */
    public static void initialize(Context context){
        fbUtil=FaceBookLoginUtil.getInstance(context);
        lineUtil = LineLoginUtil.getInstance(context);
        wechatUtil = WeChatLoginUtil.getInstance(context);
    }

    /**
     * 注销微信注册的广播
     */
    public static void unRegister(){
        wechatUtil.unRegister();
    }

    /**
     * 如果要使用facebook登录需要调用这个方法
     * @param activity
     * @param loginButton
     * @param arrarPermission
     * @param loginstateListener
     */
    public  static void setFaceBookLoginParams(Activity activity, View loginButton, String arrarPermission, LogInStateListener loginstateListener){
        fbUtil.SetFaceBookLoginActivity(activity);
        fbUtil.SetFaceBookLoginButton(loginButton);
        fbUtil.SetFaceBookReadPermission(arrarPermission);
        fbUtil.SetOnFaceBookLoginStateListener(loginstateListener);
        fbUtil.open();
    }

    /**
     * 如果要使用Line登录时需调用这个方法
     * @param activity
     * @param loginButton
     * @param loginstateListener
     */
    public static void setLineLoginParams(Activity activity, View loginButton,String channelId,LogInStateListener loginstateListener){
        lineUtil.SetLineLoginActivity(activity);
        lineUtil.SetLineLoginButton(loginButton);
        lineUtil.SetOnLineLoginStateListener(loginstateListener);
        lineUtil.SetLineLoginChinnalId(channelId);
        lineUtil.open();
    }

    /**
     * 如果要使用Wechat登录时需调用这个方法
     * @param activity
     * @param loginButton
     * @param loginstateListener
     */
    public static void setWeChatLoginParams(Activity activity, View loginButton,String appId,String appSecret,String packageName,LogInStateListener loginstateListener){
        wechatUtil.SetWeChatLoginActivity(activity);
        wechatUtil.SetWeChatLoginButton(loginButton);
        wechatUtil.SetWeChatLoginAppId(appId,appSecret,packageName);
        wechatUtil.register();
        wechatUtil.SetOnWeChatLoginStateListener(loginstateListener);
        wechatUtil.open();
    }
    /**
     * 退出Facebook登录时调用
     * @param logoutButton
     * @param logOutStateListener
     */
    public static void setFaceBookLogOutParams(View logoutButton,LogOutStateListener logOutStateListener){
        fbUtil.SetFaceBookLogOutButton(logoutButton);
        fbUtil.SetOnFaceBookLogOutListener(logOutStateListener );
        fbUtil.open();
    };

    /**
     * 退出line登录时调用
     * @param logoutButton
     * @param logOutStateListener
     */
    public static void setLineLogOutParams(View logoutButton, LogOutStateListener logOutStateListener, Context LogOutContext){
        lineUtil.SetLineLogOutButton(logoutButton);
        lineUtil.SetOnLineLogOutListener(logOutStateListener);
        lineUtil.setLineLogOutContext(LogOutContext);
        lineUtil.open();
    }
    public static void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==64206&&fbUtil!=null){
            fbUtil.onActivityResult(requestCode, resultCode, data);
        }else if (requestCode==101&&lineUtil!=null){
            //lineUtil.onActivityResult(requestCode, resultCode, data);
        }
    }
}
