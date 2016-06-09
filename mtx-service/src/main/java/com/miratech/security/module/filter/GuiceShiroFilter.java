package com.miratech.security.module.filter;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;

import javax.inject.Singleton;

@Singleton
public class GuiceShiroFilter extends AbstractShiroFilter {

    private Injector injector;

    @Override
    public void init() throws Exception {
        super.init();
        injector = (Injector) getServletContext().getAttribute(Injector.class.getName());
        this.setSecurityManager(injector.getInstance(WebSecurityManager.class));
        this.setFilterChainResolver(injector.getInstance(FilterChainResolver.class));
    }

    @Inject
    public GuiceShiroFilter(WebSecurityManager mWebSecurityManager, FilterChainResolver mFilterChainResolver) {
        this.setSecurityManager(mWebSecurityManager);
        this.setFilterChainResolver(mFilterChainResolver);
    }

}
