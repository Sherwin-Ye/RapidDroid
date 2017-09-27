package com.sherwin.radroid.base.framework.app;

import com.google.gson.Gson;
import com.sherwin.radroid.base.framework.util.LogUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sherwin.Ye on 2016/11/24.10:04
 * 内存缓存全局类，带有效期
 */
public class GlobalMemoryCache {
    private final static String TAG = "GlobalMemoryCache";

    private static Map<String, Object> mCacheMap;
    private static Map<String, Long> mCacheTimeOutMap;

    /**
     * 初始化
     */
    public static void init() {
        mCacheMap = new HashMap<>();
        mCacheTimeOutMap = new HashMap<>();
    }

    /**
     * 保存到内存的缓存，通过克隆的方式
     *
     * @param key
     * @param value
     */
    public static <T> void putByClone(String key, T value) {
        if (value != null) {
            Gson gson = new Gson();
            String json = gson.toJson(value);
            T valueClone = (T) gson.fromJson(json, value.getClass());
            put(key, valueClone, -1);
        }
    }

    /**
     * 保存到内存的缓存,外部修改对象会对齐造成影响
     *
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {
        put(key, value, -1);
    }

    /**
     * 保存到内存的缓存,外部修改对象会对齐造成影响
     * 并设置有效期
     *
     * @param key
     * @param value
     * @param interval 有效时间长度
     */
    public static void put(String key, Object value, long interval) {
        mCacheMap.put(key, value);
        if (interval < 0) {
            mCacheTimeOutMap.remove(key);
        } else {
            mCacheTimeOutMap.put(key, System.currentTimeMillis() + interval);
        }
    }

    /**
     * 获取key 对应的缓存
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T get(String key) {
        try {
            Long endTime = mCacheTimeOutMap.get(key);
            if (endTime == null || endTime >= System.currentTimeMillis()) {

                Object value = mCacheMap.get(key);
                if (value != null) {
                    return (T) value;
                }
            }
        } catch (Exception e) {
            LogUtil.e(e.getMessage());
            return null;
        }
        return null;
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public static void remove(String key) {
        try {
            mCacheTimeOutMap.remove(key);
        } catch (Exception e) {
            LogUtil.e(e.getMessage());
        }
    }

    /**
     * 获取key对应的时效时间
     *
     * @param key
     * @return <0 表示不存在，Long.MAX_VALUE 表示不限时间
     */
    public static long getEndTime(String key) {
        Object value = mCacheMap.get(key);
        if (value == null) {
            return -1;
        }
        Long endTime = mCacheTimeOutMap.get(key);
        return endTime == null ? Long.MAX_VALUE : endTime;
    }
}
