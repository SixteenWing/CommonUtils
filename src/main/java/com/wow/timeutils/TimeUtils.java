package com.wow.timeutils;

/**
 * ToolClass for Dealing with Time or Calender
 *
 * Created by kisrosen on 17/1/12.
 */
public class TimeUtils {

    /**
     * Get passed time from startTimeMills
     * @param startTimeMillis
     * @return
     */
    public static Long getPassedTimeMillis(Long startTimeMillis)
    {
        Long currentTimeMillis = System.currentTimeMillis();

        return currentTimeMillis - startTimeMillis;
    }
}
