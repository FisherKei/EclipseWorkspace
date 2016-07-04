package f2k.pic_hc06_ds1307;

import android.annotation.SuppressLint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Arman.Pagilagan on 15/05/14.
 */
@SuppressLint("SimpleDateFormat") public class DateTime {

    public static final String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";
    private Date mDate;
    private Calendar mCalendar;

 
    public DateTime() {

        this(new Date());

    }

    public DateTime(Date date) {

        mDate = date;
        mCalendar = Calendar.getInstance();
        mCalendar.setTime(mDate);

    }

    public DateTime(String dateFormat, String dateString) {

        mCalendar = Calendar.getInstance();
        SimpleDateFormat mFormat = new SimpleDateFormat(dateFormat);

        try {
            mDate = mFormat.parse(dateString);
            mCalendar.setTime(mDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public DateTime(String dateString) {
        this(DATE_FORMAT, dateString);
    }

    public DateTime(int year, int monthOfYear, int dayOfMonth,
                    int hourOfDay, int minuteOfHour, int secondOfMinute) {

        mCalendar = Calendar.getInstance();
        mCalendar.set(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute);
        mDate = mCalendar.getTime();

    }

	public DateTime(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour) {
		
		this(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, 0);
	}

    public DateTime(int year, int monthOfYear, int dayOfMonth) {

        this(year, monthOfYear, dayOfMonth, 0,0,0);
    }

    public Date getDate() {
        return mDate;
    }

    public Calendar getCalendar() {
        return mCalendar;
    }

    @SuppressLint("SimpleDateFormat") 
    public String getDateString(String dateFormat) {
        SimpleDateFormat mFormat = new SimpleDateFormat(dateFormat);
        return mFormat.format(mDate);
    }

    public String getDateString() {

        return getDateString(DATE_FORMAT);
    }

    public int getYear() {

        return mCalendar.get(Calendar.YEAR);
    }

    public int getMonthOfYear() {

        return mCalendar.get(Calendar.MONTH);
    }

    public int getDayOfMonth() {

        return mCalendar.get(Calendar.DAY_OF_MONTH);
    }
    
    public int getDayOfWeek() {
    	return mCalendar.get(Calendar.DAY_OF_WEEK);
    }

    public int getHourOfDay() {

        return mCalendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinuteOfHour() {

        return mCalendar.get(Calendar.MINUTE);
    }

    public int getSecondOfMinute() {

        return mCalendar.get(Calendar.SECOND);
    }

}
