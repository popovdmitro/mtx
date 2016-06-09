package com.miratech.service.module.container;

import com.google.inject.Injector;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RestContainer extends GuiceContainer {

    @Inject
    public RestContainer(Injector injector) {
        super(injector);
    }

}
