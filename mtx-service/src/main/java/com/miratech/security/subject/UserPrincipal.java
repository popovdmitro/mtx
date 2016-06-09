package com.miratech.security.subject;

import java.util.Collection;

public class UserPrincipal {

    private String credentials;
    private String role;

    private Collection<String> permissions;

    public UserPrincipal(String credentials) {
        this.credentials = credentials;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<String> permissions) {
        this.permissions = permissions;
    }

}
