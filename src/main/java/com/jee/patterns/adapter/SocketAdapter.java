package com.jee.patterns.adapter;

/**
 * Created by Иван on 13.03.2017.
 */
public interface SocketAdapter {
    public Volt get120Volt();

    public Volt get12Volt();

    public Volt get3Volt();
}
