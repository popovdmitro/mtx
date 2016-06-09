package com.miratech.security.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;

public class UserPermissionResolver implements PermissionResolver {

    @Override
    public Permission resolvePermission(String permissionString) {
        return new UserPermission(permissionString);
    }

}
