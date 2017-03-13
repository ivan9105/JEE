package com.jee.integration;

import com.jee.patterns.builder.Element;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Иван on 13.03.2017.
 */
public class BuilderTest {
    @Test
    public void doWork() {
        Element.ElementBuilder builder = new Element.ElementBuilder();
        Element element = builder.create("New element", new Date(), new Date())
                .setLessonId(UUID.randomUUID())
                .setScheduleId(UUID.randomUUID())
                .setDayId(UUID.randomUUID())
                .setDescription("Description")
                .build();
        Assert.assertTrue(element != null);
    }
}
