package com.ifreeplay.ifreeplaylogin.bean;

import java.io.Serializable;

/**
 * Created by gaowe on 2017/7/6.
 */

public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private  String status;
    private String error_message;
    private String email;
    private String token;
    private String firstname;
    private String lastname;
    private String userId;
    private String tibbrUserId;
    private String userName;
    private String middleName;
    private String link;
    private String birthday;
    private String ProfilePictureUri;
    private String gender;
    private String locale;
    private String timezone;
    private String lineProfile;
    private String lineCredential;
    private String displayName;
    private String statusMessage;
    private String accessToken;
    private String wxOpenId;
    private String wxUnionId;

    public String getWxOpenId(){return wxOpenId;}
    public void setWxOpenId(String wxOpenId){this.wxOpenId=wxOpenId;}
    public String getWxUnionId(){return wxUnionId;}
    public void setWxUnionId(String wxUnionId){this.wxUnionId=wxUnionId;}
    public String getLineProfile(){return lineProfile;}
    public void setLineProfile(String lineProfile){this.lineProfile=lineProfile;}
    public String getLineCredential(){return lineCredential;}
    public void setLineCredential(String lineCredential){this.lineCredential=lineCredential;}
    public String getDisplayName(){return displayName;}
    public void setDisplayName(String displayName){this.displayName=displayName;}
    public String getStatusMessage(){return statusMessage;}
    public void setStatusMessage(String statusMessage){this.statusMessage=statusMessage;}
    public String getAccessToken(){return accessToken;}
    public void setAccessToken(String accessToken){this.accessToken=accessToken;}
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getError_message() {
        return error_message;
    }
    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTibbrUserId() {
        return tibbrUserId;
    }
    public void setTibbrUserId(String tibbrUserId) {
        this.tibbrUserId = tibbrUserId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getProfilePictureUri() {
        return ProfilePictureUri;
    }
    public void setProfilePictureUri(String profilePictureUri) {
        ProfilePictureUri = profilePictureUri;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getLocale() {
        return locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }
    public String getTimezone() {
        return timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
