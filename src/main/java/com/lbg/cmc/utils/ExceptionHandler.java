package com.lbg.cmc.utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.MessageFormat;
import java.util.function.Consumer;

public class ExceptionHandler {

    private ExceptionHandler() {
    }

    public static void voidUnchecked(final VoidBearingAction template, Consumer<Exception> exceptionConsumer) {
        try {
            template.doAction();
        } catch (Exception ex) {
            exceptionConsumer.accept(ex);
        }
    }

    public static <T> T unchecked(final ExceptionBearingAction<T> template, Consumer<Exception> exceptionConsumer) {
        T results = null;
        try {
            results = template.doAction();
        } catch (Exception ex) {
            exceptionConsumer.accept(ex);
        }
        return results;
    }

    public static void throwException(Exception ex) {
        String errorMessage = "";
        if (ex instanceof JsonProcessingException) {
            JsonProcessingException jsonProcessingException = ((JsonProcessingException) ex);
            errorMessage  = format("JSON Parsing Error at Location [{0}] and messages - {1} ", jsonProcessingException.getLocation(), jsonProcessingException.getMessage());
        }
        throw new RuntimeException(errorMessage,ex);
    }
    
    private static String format(String s, Object... args) {
        return new MessageFormat(s).format(args);
    }

}