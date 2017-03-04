package com.jee.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Иван on 02.03.2017.
 */
public class DateFormatHolder {
    private static final ThreadLocal<DateFormat> THREAD_CACHE = new ThreadLocal<>();

    private static DateFormat getFormat(String pattern) {
        DateFormat format = THREAD_CACHE.get();
        if (format == null) {
            format = new SimpleDateFormat(pattern);
            THREAD_CACHE.set(format);
        }
        return format;
    }
}
