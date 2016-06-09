package com.miratech.security.module;

import com.google.inject.binder.AnnotatedBindingBuilder;
import com.miratech.security.realm.UserRealm;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletContext;

public class BootstrapShiroModule extends ShiroWebModule {

    public BootstrapShiroModule(ServletContext servletContext) {
        super(servletContext);
    }

    @Override
    protected void configureShiroWeb() {
        expose(WebSecurityManager.class);
        expose(FilterChainResolver.class);
        bindRealm().to(UserRealm.class);
    }

    @Override
    protected void bindSessionManager(AnnotatedBindingBuilder<SessionManager> bind) {
        bind.to(DefaultWebSessionManager.class);
    }

}
