package com.miratech.service.module;

import com.google.inject.servlet.ServletModule;
import com.miratech.interfaces.UserService;
import com.miratech.security.module.BootstrapShiroModule;
import com.miratech.security.module.ShiroAnnotationsModule;
import com.miratech.security.module.filter.GuiceShiroFilter;
import com.miratech.service.impl.UserServiceImpl;
import com.miratech.service.module.container.RestContainer;
import com.sun.jersey.api.json.JSONConfiguration;

import java.util.HashMap;
import java.util.Map;

public class RestModule extends ServletModule {

    public static final String SERVICE_ROOT = "/rest/*";

    @Override
    protected void configureServlets() {
        super.configureServlets();

        bind(UserService.class).to(UserServiceImpl.class);

        Map<String, String> params = new HashMap<>();
        params.put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE.toString());

        serve(SERVICE_ROOT).with(RestContainer.class, params);

        filter(SERVICE_ROOT).through(GuiceShiroFilter.class);

        install(new BootstrapShiroModule(getServletContext()));
        install(new ShiroAnnotationsModule());
    }

}
