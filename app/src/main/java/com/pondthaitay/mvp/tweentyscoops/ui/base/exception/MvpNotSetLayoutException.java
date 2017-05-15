package com.pondthaitay.mvp.tweentyscoops.ui.base.exception;

public class MvpNotSetLayoutException extends RuntimeException {
    public MvpNotSetLayoutException() {
        super("getLayoutView() not return 0");
    }
}

