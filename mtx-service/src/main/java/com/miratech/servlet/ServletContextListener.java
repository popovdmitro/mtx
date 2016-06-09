package com.miratech.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.miratech.service.module.RestModule;

import javax.servlet.ServletContextEvent;

public class ServletContextListener extends GuiceServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        //SLF4JBridgeHandler.install();
    }

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
                new RestModule()
        );
    }

}
