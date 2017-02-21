package com.jee.mdb;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 21.02.2017.
 */
@Singleton(name = "MessageCache")
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class MessageCache {
    private List<String> messages = new ArrayList<>();

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
