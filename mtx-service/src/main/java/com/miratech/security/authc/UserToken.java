package com.miratech.security.authc;

import com.miratech.security.subject.UserPrincipal;
import org.apache.shiro.authc.AuthenticationToken;

public class UserToken implements AuthenticationToken {

    private String credentials;

    public UserToken() {
    }

    public UserToken(String credentials) {
        this.credentials = credentials;
    }

    @Override
    public UserPrincipal getPrincipal() {
        return new UserPrincipal(credentials);
    }

    @Override
    public String getCredentials() {
        return credentials;
    }

}
