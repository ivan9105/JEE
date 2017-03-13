package com.jee.patterns.builder;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Иван on 13.03.2017.
 */
public class Element {
    @NotNull
    private String name;
    @NotNull
    private Date startTime;
    @NotNull
    private Date finishTime;
    private String description;
    private UUID roomId;
    private UUID dayId;
    private UUID scheduleId;
    private UUID lessonId;

    public Element(String name, Date startTime, Date finishTime) {
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public UUID getDayId() {
        return dayId;
    }

    public void setDayId(UUID dayId) {
        this.dayId = dayId;
    }

    public UUID getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(UUID scheduleId) {
        this.scheduleId = scheduleId;
    }

    public UUID getLessonId() {
        return lessonId;
    }

    public void setLessonId(UUID lessonId) {
        this.lessonId = lessonId;
    }

    public static class ElementBuilder {
        private Element element;

        public ElementBuilder create(String name, Date startTime, Date finishTime) {
            this.element = new Element(name, startTime, finishTime);
            return this;
        }

        public ElementBuilder setDescription(String description) {
            this.element.setDescription(description);
            return this;
        }

        public ElementBuilder setRoomId(UUID roomId) {
            this.element.setRoomId(roomId);
            return this;
        }

        public ElementBuilder setDayId(UUID dayId) {
            this.element.setDayId(dayId);
            return this;
        }

        public ElementBuilder setScheduleId(UUID scheduleId) {
            this.element.setScheduleId(scheduleId);
            return this;
        }

        public ElementBuilder setLessonId(UUID lessonId) {
            this.element.setLessonId(lessonId);
            return this;
        }

        public Element build() {
            return element;
        }
    }
}
