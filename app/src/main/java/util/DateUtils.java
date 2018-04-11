package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

/**
 * 日期工具类 主要负责处理时间java.util.Date与String类型的转换
 * 
 * @author coffee
 */
public class DateUtils {
	private static Logger log = Logger.getLogger(DateUtils.class.toString());
	/**
	 * 默认的格式化格式为 yyyy-MM-dd HH:mm:ss
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdfCountDate = new SimpleDateFormat("HH时mm分ss秒");
	private static SimpleDateFormat sdfCountDate2 = new SimpleDateFormat("dd天HH时mm分");

	/**
	 * 格式化日期类型 ，返回字符串
	 * 
	 * @param : 传入参数
	 * @return 返回一个字符串
	 */
	public static String format(Object value) {
		try {
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			return sdf.format(value);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 格式化日期类型 ，返回字符串
	 * 
	 * @param : 传入参数
	 * @return 返回一个字符串-仅日期
	 */
	public static String formatDate(Object value) {
		try {
			sdfDate.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			return sdfDate.format(value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 解析字符串,返回日期
	 * 
	 * @param
	 * @return 返回日期
	 */
	public static Date parse(String value) {
		try {
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			return sdf.parse(value);
		} catch (Exception e) {
			try {
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
				return sdf.parse(value.toString());
			} catch (Exception ex) {
				try {
					sdf = new SimpleDateFormat("HH:mm:ss");
					sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
					return sdf.parse(value.toString());
				} catch (Exception exc) {
					// exc.printStackTrace();
					log.warning("不能格式化指定的值: " + value);
				}
			}
			return null;
		}
	}

	// 获取当前日期-时间
	public String getCurDateTime(String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			return sdf.format(new Date(System.currentTimeMillis()));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将两个时间的差值转换成 相差多少时间
	 * 
	 * @param mss
	 * @return
	 */
	public static String formatDuring(long mss) {
		String dateStr = "";
		String day = formatDuringDay(mss);
		if (!day.equals("00")) {
			dateStr = day + "天";
		}
		dateStr = dateStr + formatDuringHour(mss) + "时";
		dateStr = dateStr + formatDuringMinute(mss) + "分";
		dateStr = dateStr + formatDuringSecond(mss) + "秒";
		return dateStr;
	}

	public static String formatDuringForPromotion(long mss) {
		String dateStr = "";
		String day = formatDuringDay(mss);
		if (!day.equals("00")) {
			dateStr = day + "天";
		}
		dateStr = dateStr + formatDuringHour(mss) + "时";
		dateStr = dateStr + formatDuringMinute(mss) + "分";
		return dateStr;
	}

	/**
	 * 列表的倒计时差值,转换成 10小时02分30秒类似形式
	 * 
	 * @param date
	 * @return
	 */
	public static String CountDate(long date) {
		String dateStr = "";
		String day = formatDuringDay(date);
		if (!day.equals("00")) {
			dateStr = day + "天";
		}
		dateStr = dateStr + formatDuringHour(date) + "时";
		dateStr = dateStr + formatDuringMinute(date) + "分";
		dateStr = dateStr + formatDuringSecond(date) + "秒";
		return dateStr;

	}

	/**
	 * 返回时间差值的天数
	 * 
	 * @param mss
	 * @return
	 */
	public static String formatDuringDay(long mss) {
		long days = mss / (1000 * 60 * 60 * 24);
		return days == 0 ? "00" : days + "";
	}

	/**
	 * 返回时间差值的小时
	 * 
	 * @param mss
	 * @return
	 */
	public static String formatDuringHour(long mss) {
		long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		if ((hours <= 9 ? ("0" + hours) : "" + hours).equals("")) {
			return "00";
		}
		return hours <= 9 ? ("0" + hours) : "" + hours;
	}

	/**
	 * 返回时间差值的分钟
	 * 
	 * @param mss
	 * @return
	 */
	public static String formatDuringMinute(long mss) {
		long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
		
		if ((minutes <= 9 ? ("0" + minutes) : "" + minutes).equals("")) {
			return "00";
		}
		
		return minutes <= 9 ? ("0" + minutes) : "" + minutes;
	}

	/**
	 * 返回时间差值的秒
	 * 
	 * @param mss
	 * @return
	 */
	public static String formatDuringSecond(long mss) {
		long seconds = (mss % (1000 * 60)) / 1000;
		return seconds <= 9 ? ("0" + seconds) : "" + seconds;
	}

	/**
	 * 时间 显示 时分秒
	 */
	public static String formatCountDown(long mss) {
		long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (mss % (1000 * 60)) / 1000;
		// long seconds = (mss % (1000 * 60)) / 1000;
		String date = "";
		date = date + (hours <= 9 ? ("0" + hours) : hours) + ":";
		date = date + (minutes <= 9 ? ("0" + minutes) : minutes) + ":";
		date = date + (seconds <= 9 ? ("0" + seconds) : seconds);
		return date;
	}
}
