package com.ifreeplay.ifreeplaylogin.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class SPUtil {
    private static SharedPreferences sp;
    private static SharedPreferences guideSp;
    private static String XML_NAME;
    public static String myInformationId = "1";
    public static String mytoken = "";
    public static String myBrName = "myBrName";
    public static String myBrHomeName = "myBrHomeName";
    public static String ATTENTIONUP = "ATTENTIONUP";
    public static String ATTENTIONDOWN = "ATTENTIONDOWN";
    public static String REFRESHDATA = "REFRESHDATA";
    public static String REFRESHMESSAGEDATA = "REFRESHMESSAGEDATA";

    public static String VOUDATA = "VOUDATA";

    public static String PRAISEUP = "PRAISEUP";
    public static String PRAISEDOWN = "PRAISEDOWN";
    public static String CRASHPATH = "/sdcard/calftrader/";

    public static String Guide = "";


    public static void setMyToken(String mytokens) {
        mytoken = mytokens;
    }

    public static void init(Context context) {
        XML_NAME =  "xiaoniu";
        Guide =  "guide";
    }

    public static void setBoolean(Context ctx, String key, boolean value) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context ctx, String key, boolean defValue) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    public static void setString(Context ctx, String key, String value) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context ctx, String key, String defValue) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    public static void setInt(Context ctx, String key, int value) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(Context ctx, String key, int defValue) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);
    }

    public static void setFloat(Context ctx, String key, float value) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putFloat(key, value).commit();
    }

    public static Float getFloat(Context ctx, String key, float defValue) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        return sp.getFloat(key, defValue);
    }

    public static void setLong(Context ctx, String key, long value) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putLong(key, value).commit();
    }

    public static Long getLong(Context ctx, String key, long defValue) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        return sp.getLong(key, defValue);
    }

    public static void setList(Context ctx, String key, Set<String> value) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putStringSet(key, value).commit();
    }

    public static Set<String> getList(Context ctx, String key, Set<String> defValue) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        return sp.getStringSet(key, defValue);
    }


    public static void remove(Context ctx, String key) {
        if (sp == null) {
            sp = ctx.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().remove(key).commit();
    }

    public static void setGuideBoolean(Context ctx, String key, boolean value) {
        if (guideSp == null) {
            guideSp = ctx.getSharedPreferences(Guide, Context.MODE_PRIVATE);
        }
        guideSp.edit().putBoolean(key, value).commit();
    }

    public static boolean getGuideBoolean(Context ctx, String key, boolean defValue) {
        if (guideSp == null) {
            guideSp = ctx.getSharedPreferences(Guide, Context.MODE_PRIVATE);
        }
        return guideSp.getBoolean(key, defValue);
    }

    public static void setGuideString(Context ctx, String key, String value) {
        if (guideSp == null) {
            guideSp = ctx.getSharedPreferences(Guide, Context.MODE_PRIVATE);
        }
        guideSp.edit().putString(key, value).commit();
    }

    public static String getGuideString(Context ctx, String key, String defValue) {
        if (guideSp == null) {
            guideSp = ctx.getSharedPreferences(Guide, Context.MODE_PRIVATE);
        }
        return guideSp.getString(key, defValue);
    }
    public static void setGuideInt(Context ctx, String key, int value) {
        if (guideSp == null) {
            guideSp = ctx.getSharedPreferences(Guide, Context.MODE_PRIVATE);
        }
        guideSp.edit().putInt(key, value).commit();
    }

    public static int getGuideInt(Context ctx, String key, int defValue) {
        if (guideSp == null) {
            guideSp = ctx.getSharedPreferences(Guide, Context.MODE_PRIVATE);
        }
        return guideSp.getInt(key, defValue);
    }

    /**
     * 清空Sp中保存的信息
     *
     * @param context Context
     */
    public static void clear(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences(XML_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().clear().apply();
    }
}

