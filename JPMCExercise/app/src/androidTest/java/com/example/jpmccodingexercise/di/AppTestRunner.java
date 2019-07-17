package com.example.jpmccodingexercise.di;


import android.app.Application;
import android.content.Context;

import io.appflate.restmock.android.RESTMockTestRunner;

public class AppTestRunner extends RESTMockTestRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return super.newApplication(cl, TestApp.class.getCanonicalName(), context);
    }
}
