package model;

import java.io.Serializable;

/**
 * 签到信息
 * 
 * @author coffee<br>
 *         2014年5月20日上午9:49:19
 */
public class CheckInBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2226879064099658666L;
	private int ret;
	private String combodays;// 连续签到次数

	private String checkInCount;// 总签到次数
	private String isCheckIn; // 本日是否签到 0:未签到；1：已签到
	private String todayCheckInValue;// 用户今日签到获得的名望值
	private String userCheckInValue;// 用户签到获得的总名望值
	private String fameValue;// 每次签到获得的名望值数量
	private String continueDaysStr;// 连续签到获得奖励的天数（规则）
	private String continueSignValueStr;// 连续签到获得奖励的名望值数量
	private String failedReason;// 签到失败原因
	private String appSignRules;//小提示
	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getCombodays() {
		return combodays;
	}

	public void setCombodays(String combodays) {
		this.combodays = combodays;
	}

	public String getCheckInCount() {
		return checkInCount;
	}

	public void setCheckInCount(String checkInCount) {
		this.checkInCount = checkInCount;
	}

	public String getIsCheckIn() {
		return isCheckIn;
	}

	public void setIsCheckIn(String isCheckIn) {
		this.isCheckIn = isCheckIn;
	}

	public String getTodayCheckInValue() {
		return todayCheckInValue;
	}

	public void setTodayCheckInValue(String todayCheckInValue) {
		this.todayCheckInValue = todayCheckInValue;
	}

	public String getUserCheckInValue() {
		return userCheckInValue;
	}

	public void setUserCheckInValue(String userCheckInValue) {
		this.userCheckInValue = userCheckInValue;
	}

	public String getFameValue() {
		return fameValue;
	}

	public void setFameValue(String fameValue) {
		this.fameValue = fameValue;
	}

	public String getContinueDaysStr() {
		return continueDaysStr;
	}

	public void setContinueDaysStr(String continueDaysStr) {
		this.continueDaysStr = continueDaysStr;
	}

	public String getContinueSignValueStr() {
		return continueSignValueStr;
	}

	public void setContinueSignValueStr(String continueSignValueStr) {
		this.continueSignValueStr = continueSignValueStr;
	}

	public String getFailedReason() {
		return failedReason;
	}

	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}

	public String getAppSignRules() {
		return appSignRules;
	}

	public void setAppSignRules(String appSignRules) {
		this.appSignRules = appSignRules;
	}
}
