package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by user on 21.05.2017.
 */
public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
