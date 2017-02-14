package com.jee.bean.util;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Иван on 13.02.2017.
 */
@Singleton(name = "ComponentRegistry")
@Lock(LockType.READ)
public class ComponentRegistry {
    private final Map<Class, Object> components = new HashMap<>();

    public <T> T getComponent(final Class<T> type) {
        return (T) components.get(type);
    }

    public Collection<?> getComponents() {
        return new ArrayList(components.values());
    }

    @Lock(LockType.WRITE)
    public <T> T setComponent(final Class<T> type, final T value) {
        return (T) components.put(type, value);
    }

    @Lock(LockType.WRITE)
    public <T> T removeComponent(final Class<T> type) {
        return (T) components.remove(type);
    }
}
