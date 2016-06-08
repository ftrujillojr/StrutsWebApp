package org.yourorg.yourapp.support;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.yourorg.yourapp.exceptions.DateUtilsException;

public final class DateUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS zzz";
    private static final String DATE_FORMAT2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat(DATE_FORMAT2);

    // This is SET in nve.pesoft.ServletContext.java for the entire application.
    // TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
    // This is for Gson serialization/deserialization and adapters.
    // Change this in one place 
    public static String getProjectDateFormatString() {
        return DateUtils.DATE_FORMAT2;
    }

    public static String getProjectDateString(Date date) {
        if (date == null) {
            return null;
        }
        return DateUtils.getDateStringIso8601(date);
    }

    public static boolean areDatesEqualToMillisecond(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            String str1 = sdf2.format(date1);
            String str2 = sdf2.format(date2);
            result = str1.equals(str2);
        }

        return result;
    }

    public static Timestamp getTimestamp(Date date) {
        Timestamp resultTimestamp = new Timestamp(date.getTime());
        return resultTimestamp;
    }

    public static String getDateString(Date date) {
        return sdf.format(date);
    }

    public static String getDateStringIso8601(Date date) {
        return sdf2.format(date);
    }

    public static Date parse(String calString) throws ParseException, DateUtilsException {
        Date date;

        String tmpCalString = calString.trim();
        //System.out.println("CALSTRING " + calString);

        if (tmpCalString.matches("^[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}\\s+[0-9]{2}:[0-9]{2}:[0-9]{2}\\.[0-9]{3}\\s+[A-Z]+$")) {
            date = sdf.parse(tmpCalString);
        } else if (tmpCalString.matches("^[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}\\.[0-9]{3}Z$")) {
            date = sdf2.parse(tmpCalString);
        } else {
            String msg = "ERROR: Unable to parse Date input. => " + calString + "\n=>" + tmpCalString + "<=";
            throw new DateUtilsException(msg);
        }

        return (date);
    }
}
