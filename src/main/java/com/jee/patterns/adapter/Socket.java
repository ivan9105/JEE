package com.jee.patterns.adapter;

/**
 * Created by Иван on 13.03.2017.
 */
public class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}
