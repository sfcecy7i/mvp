package com.cmos.framework.mvp;

public interface P<T extends V> {
    void register();

    void unregister();
}