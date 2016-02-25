package cn.aft.weather.utils;

import cn.aft.weather.event.Event;
import cn.aft.weather.event.EventType;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class EventPredictor {

    public static boolean isUsefulEvent(Event event) {
        return event.getEventType() == EventType.USEFUL;
    }

    public static boolean isUselessEvent(Event event) {
        return !isUsefulEvent(event);
    }
}
