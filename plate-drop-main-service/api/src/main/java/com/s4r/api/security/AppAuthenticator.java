package com.s4r.api.security;

import com.s4r.domain.user.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

public class AppAuthenticator implements Authentication {

    private final UserInfo userDetails;
    private boolean isAuthenticated;
    private HashSet<GrantedAuthority> grantedAuthorities;


    public AppAuthenticator(UserInfo userDetails, boolean isAuthenticated) {
        this.userDetails = userDetails;
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (grantedAuthorities == null) {

            grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(userDetails.getRole().name()));
        }
        return grantedAuthorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return userDetails.getName();
    }
}
