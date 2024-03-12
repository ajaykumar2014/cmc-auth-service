package com.lbg.cmc.utils;

@FunctionalInterface
public interface ExceptionBearingAction<T> {

    T doAction() throws Exception;
}
