package com.sherwin.rapid.base.framework.app;


import com.sherwin.rapid.base.framework.util.LogUtil;
import com.sherwin.rapid.base.framework.util.SPTool;
import com.sherwin.rapid.base.framework.util.StringUtil;

import java.net.URL;

/**
 * @author Wander.Zeng
 * @data 2015-11-26 下午2:52:30
 * @desc GlobalConfig.java
 */
public class GlobalConfig {

    private static final String TAG = "GlobalConfig";

    public static final String UMENG_CHANNEL_KEY = "UMENG_CHANNEL";

    public static final String DB_NAME = "ants.housekeeper";

    public final static int TIMEOUT_CON_DEFAULT = 15000;
    public final static int TIMEOUT_CON_DEBUG = 15000;
    /**
     * 线上接口地址
     * https://120.55.32.138:8082/v1
     */
    public static final String URL_DEFAULT = "https://www.inewell.com:8082/v1";
    /**
     * 测试接口地址
     * http://106.14.173.39:8082/v1
     */
    public static final String URL_DEBUG = "http://test.stonekac.club:8082/v1";

    // 默认线上数据
    private static String protocolURL = URL_DEFAULT;
    private static int protocolTimeoutCon = TIMEOUT_CON_DEFAULT;
    private static int protocolTimeoutSo = TIMEOUT_CON_DEFAULT;
    private static int logLevel = LogUtil.LEVEL_DEFAULT;
    private static boolean isDebug = false;

    /**
     * 配置初始化
     * @param isDebug 是否是debug
     */
    public static void init(boolean isDebug) {
        GlobalConfig.isDebug = isDebug;
        initConfOfProtocol();
        initConfOfLog();
        LogUtil.d(TAG, "protocolURL:" + protocolURL);
        LogUtil.d(TAG, "protocolTimeoutCon:" + protocolTimeoutCon);
        LogUtil.d(TAG, "protocolTimeoutSo:" + protocolTimeoutSo);
        LogUtil.d(TAG, "logLevel:" + logLevel);
        LogUtil.d(TAG, "isDebug:" + isDebug);
    }

    // 配置用的
    public static final String KEY_PROTOCOL_URL = "KEY_PROTOCOL_URL";
    // 配置用的 是否采用https
    public static final String KEY_PROTOCOL_IS_HTTPS = "KEY_PROTOCOL_IS_HTTPS";
    /**
     * 初始化协议相关配置
     */
    private static void initConfOfProtocol() {
        String protocolURLTmp = isDebug ? URL_DEBUG : URL_DEFAULT;
        if (StringUtil.isNotBlank(protocolURLTmp)) {
            try {
                new URL(protocolURLTmp);
                protocolURL = protocolURLTmp;
            } catch (Exception e) {
                LogUtil.d(TAG, "protocolURL config error : " + e);
            }
        }
        if (isDebug()){
            String purl = SPTool.getParamToString(GlobalApplication.getInstance(),KEY_PROTOCOL_URL,null);
            boolean useHttps = SPTool.getParamToBoolean(GlobalApplication.getInstance(),KEY_PROTOCOL_IS_HTTPS,true);
            if (StringUtil.isNotBlank(purl)){
                setProtocolURL(purl,useHttps);
            }
        }
        protocolTimeoutSo = protocolTimeoutCon = isDebug ? TIMEOUT_CON_DEBUG : TIMEOUT_CON_DEFAULT;
    }

    /**
     * 初始化日志等级
     */
    private static void initConfOfLog() {
        if (isDebug) {
            logLevel = LogUtil.DEBUG;
        } else {
            logLevel = LogUtil.LEVEL_DEFAULT;
        }
    }


    /**
     * 只允许测试和开发版本使用
     *
     * @param protocolURL
     */
    public static void setProtocolURL(String protocolURL,boolean useHttps) {
        if (isDebug) {
            if (StringUtil.isBlank(protocolURL)){
                GlobalConfig.protocolURL = isDebug ? URL_DEBUG : URL_DEFAULT;
            } else {
                if(useHttps){
                    GlobalConfig.protocolURL = "https://" + protocolURL + "/v1";
                } else{
                    GlobalConfig.protocolURL = "http://" + protocolURL + "/v1";
                }
            }
        }
    }

    public static String getProtocolURL() {
        return protocolURL;
    }

    public static int getProtocolTimeoutCon() {
        return protocolTimeoutCon;
    }

    public static int getProtocolTimeoutSo() {
        return protocolTimeoutSo;
    }

    public static int getLogLevel() {
        return logLevel;
    }

    public static boolean isDebug() {
        return isDebug;
    }
}
