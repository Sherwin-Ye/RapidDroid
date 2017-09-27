package com.sherwin.radroid.base.framework.app;

/**
 * @author Sherwin.Ye
 * @data 2016年9月14日 15:29:51
 * @desc PkgInfo.java
 */
public class PkgInfo {

	private Integer versionCode;// 版本号
	private String versionName;// 版本名称
	private String packageName;// 包名
	private String channelCode;// 渠道号

	public Integer getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

}
