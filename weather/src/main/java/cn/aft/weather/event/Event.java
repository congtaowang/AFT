package cn.aft.weather.event;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class Event {

    private EventType eventType;

    public Event(EventType eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
