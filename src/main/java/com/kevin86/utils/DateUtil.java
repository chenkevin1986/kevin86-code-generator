package com.kevin86.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final long MILLISECOND = 1L;
	public static final long SECONDETIME = 1000L;
	public static final long MINUTETIME = 60000L;
	public static final long HOURTIME = 3600000L;
	public static final long DAYTIME = 86400000L;

	/**
	 *
	 * @param date
	 * @return 转换成 yyyy-MM-dd HH:mm:ss 日期格式
     */
	public static String getStringDate(Date date) {
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return _sdf.format(date);
	}

	/**当前时间 转换成秒*/
	public static int getCurrSencondTime(){
		return (int)Math.ceil(((double)System.currentTimeMillis()/1000d));
	}

	/**
	 * @return 获取现在时间的 yyyy-MM-dd HH:mm:ss 日期格式
     */
	public static String getNowStringDate() {
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return _sdf.format(new Date());
	}

	/**
	 * @param date
	 * @return 转换成 yyyyMMdd 日期格式
     */
	public static String getNumStringDate(Date date){
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyyMMdd");
		return _sdf.format(date);
	}

	public static Date addDate(Date date, int d){
		long new_time = date.getTime() + d * DAYTIME;
		return new Date(new_time);
	}
	/**
	 * @return  除星期天为0 其他对应星期几
	 */
	public static int getCurWeekDay(){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		return (c1.get(Calendar.DAY_OF_WEEK)-1);
	}

	/**
	 * @param day  除星期天为0 其他对应星期几就可以!
	 * @return  指定本周某一星期几 对应的时间
     */
	public static Date getCurWeekDate(int day){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		int dVal = day - (c1.get(Calendar.DAY_OF_WEEK)-1);
		return addDate(new Date(),dVal);
	}

	/**
	 *
	 * @param day
	 * @return 指定下周某一星期几 对应的时间
	 */
	public static Date getNextWeekDate(int day){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		int add = (7 - (c1.get(Calendar.DAY_OF_WEEK)-1))+day;
		return addDate(new Date(),add);
	}

	public static void main(String[] args) {
		//这周五0点 到 下周四24点
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		System.out.println(c1.get(Calendar.DAY_OF_WEEK)-1);


	}




	/**
	 *
	 * @param date
	 * @return
     */
	public static Date getDateByString(String date) {
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return _sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getDateByStringOnlyDay(String days) {
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return _sdf.parse(days);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getDateByLongOnlyDay(Date date) {
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return _sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getDateByStringOnlyTimes(String times) {
		SimpleDateFormat _sdf = new SimpleDateFormat("HH:mm:ss");
		try {
			return _sdf.parse(times);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getDateForLongToString(long times) {
		SimpleDateFormat _sdf = new SimpleDateFormat("HH:mm:ss");
		try {
			return _sdf.format(Long.valueOf(times));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getStringForDate(Date times) {
		SimpleDateFormat _sdf = new SimpleDateFormat("yyyy��MM��dd��");
		try {
			return _sdf.format(times);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getStringByLong(long times) {
		SimpleDateFormat _sdf = new SimpleDateFormat("mm��ss��");
		try {
			return _sdf.format(Long.valueOf(times));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *获取现在时间Date
	 * @return
     */
	public static Date getCurrentDate() {
		try {
			return new Date(System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * @param time
	 * @return  传入的时间 是否就是今天
     */
	public static boolean isToday(long time) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c2.setTimeInMillis(time);
		if (c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR)) {
			return false;
		}
		int day1 = c1.get(Calendar.DAY_OF_YEAR);
		int day2 = c2.get(Calendar.DAY_OF_YEAR);
		return day1 == day2;
	}

	/**
	 * @param d1
	 * @param d2
     * @return 是否为同一天
     */
	public static boolean isTheSameDay(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
				&&(c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
				&& (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 *
	 * @param time
	 * @return 是否为相同月份
     */
	public static boolean isThatSameMonth(long time) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c2.setTimeInMillis(time);
		if (c1.get(1) != c2.get(1)) {
			return false;
		}
		int month1 = c1.get(2);
		int month2 = c2.get(2);
		return month1 == month2;
	}

	/**
	 *
	 * @param time
	 * @return 是否在同一周
     */
	public static boolean isThatSameWeek(long time) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c2.setTimeInMillis(time);

		c2.setFirstDayOfWeek(2);
		c1.setFirstDayOfWeek(2);

		if (c1.get(1) != c2.get(1)) {
			return false;
		}
		int week1 = c1.get(3);
		int week2 = c2.get(3);

		return week1 == week2;
	}

	/**
	 *
	 * @param time
	 * @return 传入的时间 与 当前时间 相差多少天
     */
	public static int differOfDay(long time) {
		int dayNum = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(new Date());

		c2.setTimeInMillis(time);
		int day1 = c1.get(6);
		int day2 = c2.get(6);
		int year1 = c1.get(1);
		int year2 = c2.get(1);
		if (year1 != year2) {
			int day2Max = c2.getMaximum(6);
			dayNum = day2Max - day2 + day1;
		} else {
			dayNum = day1 - day2;
		}
		return dayNum;
	}

	public static long nowCut24(long time) {
		Calendar c2 = Calendar.getInstance();
		c2.setTimeInMillis(time);
		c2.set(5, c2.getActualMaximum(5));
		c2.set(11, c2.getActualMaximum(11));
		c2.set(12, c2.getActualMaximum(12));
		c2.set(13, c2.getActualMaximum(13));
		long longTime24 = c2.getTimeInMillis();
		longTime24 -= time;
		return longTime24;
	}

	public static long nowCut0(long time) {
		Calendar c2 = Calendar.getInstance();
		c2.setTimeInMillis(time);
		c2.set(5, c2.getActualMinimum(5));
		c2.set(11, c2.getActualMinimum(11));
		c2.set(12, c2.getActualMinimum(12));
		c2.set(13, c2.getActualMinimum(13));
		long longTime0 = c2.getTimeInMillis();
		longTime0 = time - longTime0;

		return longTime0;
	}

	public static int someDayOnThisMonth(long time) {
		Calendar c1 = Calendar.getInstance();
		c1.setTimeInMillis(time);
		return c1.get(5);
	}

	public static int hasSomeHours(long time) {
		int i = (int) time / 60 / 60 / 1000;
		return i;
	}

	public static long hasSomeMillisecond(long time) {
		long i = time % 3600000L;
		return i;
	}

	public static boolean hourIsBetweenAAndB(int x, int y) {
		Calendar c1 = Calendar.getInstance();
		c1.setTimeInMillis(System.currentTimeMillis());
		int hour = c1.get(11);
		if ((hour >= x) && (hour < y)) {
			return true;
		}
		return false;
	}

	public static int getNowHour(long time) {
		Calendar c1 = Calendar.getInstance();
		c1.setTimeInMillis(time);
		return c1.get(11);
	}

	/**
	 * 每周五开始 用于提交的文件目录以下周五的日期为文件名
	 * @return 日期的格式为全数字 例如“20160105”
	 */
	public static String dateNumfileName(){
		int curWeekDay = DateUtil.getCurWeekDay();
		if (curWeekDay >= 5 ){ //每周五开始 用于提交的文件目录以下周五的日期为文件名
			Date nextWeekDate = DateUtil.getNextWeekDate(5);
			return DateUtil.getNumStringDate(nextWeekDate);
		}else{
			Date curWeekDate = DateUtil.getCurWeekDate(5);
			return DateUtil.getNumStringDate(curWeekDate);
		}
	}

	/**
	 * 获取过期时间
     */
	public static Date getOverdueDate(Date startDate, int hours){
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		long date1 = cal.getTimeInMillis();
		long date2 = 0;
		long hoursL = hours;
		if(0 < hours){
			date2 = date1 + hoursL * 3600 * 1000;
		}
		else{
			String str = "2215-07-02";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try{
				sdf.setLenient(false);
				date2 = sdf.parse(str).getTime();
			}catch (ParseException e){
				e.printStackTrace();
			}
		}
		Date overdueDate = new Date(date2);
		return overdueDate;
	}
}
