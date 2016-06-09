package com.miratech.security.realm;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.miratech.security.authc.UserToken;
import com.miratech.security.permission.UserPermissionResolver;
import com.miratech.security.subject.UserPrincipal;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.security.spec.InvalidKeySpecException;
import java.util.Collection;
import java.util.HashSet;

@Singleton
public class UserRealm extends AuthorizingRealm {

    private String userName;
    private String passowrd;

    @Inject
    public UserRealm() {
    }

    @Inject
    private void initialize() {
        setAuthenticationTokenClass(UserToken.class);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserPrincipal principal = (UserPrincipal) principals.getPrimaryPrincipal();

        principal.setRole("admin");

        Collection<String> permissions = new HashSet<>();
        permissions.add("ALL_ACCESS");

        principal.setPermissions(permissions);

        authorizationInfo.addRole(principal.getRole());
        authorizationInfo.addStringPermissions(principal.getPermissions());

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        final UserToken upToken = (UserToken) token;
        final String decodeCredentials = Base64.decodeToString(upToken.getCredentials());
        final String[] credentials = decodeCredentials.split(":");
        userName = credentials[0];
        passowrd = credentials[1];
        try {
            SecurityUtils.getSubject().getSession().setTimeout(5400000L);
            // check user
            if (!userName.equalsIgnoreCase("admin") || !passowrd.equals("admin")) {
                throw new InvalidKeySpecException("Invalid user name or password");
            }
            return new SimpleAuthenticationInfo(upToken.getPrincipal(), upToken.getCredentials(), userName);
        } catch (InvalidKeySpecException | SecurityException e) {
            throw new UnauthenticatedException(e);
        }
    }

    @Override
    public PermissionResolver getPermissionResolver() {
        super.setPermissionResolver(new UserPermissionResolver());
        return super.getPermissionResolver();
    }

    public String getUserName() {
        return userName;
    }

}
