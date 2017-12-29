package com.ifreeplay.ifreeplaylogin.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.ifreeplay.ifreeplaylogin.bean.User;
import com.ifreeplay.ifreeplaylogin.logininterface.LogInStateListener;
import com.ifreeplay.ifreeplaylogin.logininterface.LogOutStateListener;
import com.linecorp.linesdk.api.LineApiClient;
import com.linecorp.linesdk.api.LineApiClientBuilder;
import com.linecorp.linesdk.auth.LineLoginApi;
import com.linecorp.linesdk.auth.LineLoginResult;

/**
 * Created by gaowe on 2017/7/19.
 */

public class LineLoginUtil {

    private static LineLoginUtil mLineLoginUtil;
    private View loginClickView;
    private View logOutView;
    private LogInStateListener mLineLoginStateChanged;
    private LogOutStateListener mLineLogOutStateListener;
    private Activity loginActivity;
    private String mChannelId1;
    private boolean isLogOut=false;
    private Context mLineLogOutContext;
    private LineApiClient lineApiClient;

    public static LineLoginUtil getInstance(Context context) {
        if(mLineLoginUtil ==null){
            mLineLoginUtil =new LineLoginUtil();
        }
        return mLineLoginUtil;
    }

    public  void SetLineLoginActivity(Activity activity){
        if(activity==null){
            throw new  NullPointerException("login activity is null");
        }else{
            loginActivity =activity;
        }
    }

    public  void SetLineLoginButton(View view){
        loginClickView =view;
    }

    public void SetLineLogOutButton(View view){
        logOutView =view;
    }
    public void setLineLogOutContext(Context lineLogOutContext) {
        this.mLineLogOutContext = lineLogOutContext;
    }

    public  void SetOnLineLoginStateListener(LogInStateListener LoginStateChanged){
        if(LoginStateChanged==null){
            throw new NullPointerException("LoginStateListener is null");
        }else{
            mLineLoginStateChanged =LoginStateChanged;
        }
    }

    public void SetOnLineLogOutListener(LogOutStateListener logoutListener){
        mLineLogOutStateListener =logoutListener;
    }

    public void SetLineLoginChinnalId(String channelId) {
        mChannelId1 = channelId;
    }

    public void open() {
        if (loginClickView!=null){
            loginClickView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        Intent loginIntent = LineLoginApi.getLoginIntent(v.getContext(), mChannelId1);
                        loginActivity.startActivityForResult(loginIntent, LoginManager.LineRequestCode);
                    }
                    catch(Exception e) {
                        Log.e("ERROR", e.toString());
                    }
                }
            });
        }

        if(logOutView!=null){
            logOutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //初始化lineApiClient
                    LineApiClientBuilder apiClientBuilder = new LineApiClientBuilder(mLineLogOutContext, mChannelId1);
                    lineApiClient = apiClientBuilder.build();
                    lineApiClient.logout();
                    isLogOut=true;
                    mLineLogOutStateListener.OnLogOutListener(isLogOut,"line");
                }
            });
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        LineLoginResult result = LineLoginApi.getLoginResultFromIntent(data);
        switch (result.getResponseCode()) {
            case SUCCESS:
                fetchUserInfo(result);
                break;

            case CANCEL:
                // Login canceled by user
                mLineLoginStateChanged.OnLoginError("user cancle login facebook!");
                break;

            default:
                // Login canceled due to other error
                mLineLoginStateChanged.OnLoginError(result.getErrorData().toString());
        }
    }

    private void fetchUserInfo(LineLoginResult result) {
        User user = new User();
        try {
            if (result.getLineProfile()!=null){
            user.setLineProfile(result.getLineProfile().toString());
        }
            if (result.getLineProfile().getDisplayName()!=null){
                user.setUserName(result.getLineProfile().getDisplayName());
            }
            if (result.getLineProfile().getUserId()!=null){
                user.setUserId(result.getLineProfile().getUserId());
            }
            if (result.getLineCredential().getAccessToken().getAccessToken()!=null){
                user.setAccessToken(result.getLineCredential().getAccessToken().getAccessToken());
            }
            mLineLoginStateChanged.OnLoginSuccess(user, "line");
        }catch (Exception e){
            mLineLoginStateChanged.OnLoginError(e.getMessage());
        }

    }


}
