package com.miratech.security.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;

public class UserPermission extends WildcardPermission {

    public UserPermission(String wildcardString) {
        super(wildcardString);
    }

    @Override
    public boolean implies(Permission p) {
        if (!(p instanceof UserPermission)) {
            return false;
        }
        return true;
    }

}
