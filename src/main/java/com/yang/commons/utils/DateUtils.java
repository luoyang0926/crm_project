package com.yang.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class DateUtils {

    public static String formateDateTime(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }

}
