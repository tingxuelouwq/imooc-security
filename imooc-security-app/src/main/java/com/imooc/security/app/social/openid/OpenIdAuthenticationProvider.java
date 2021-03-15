package com.imooc.security.app.social.openid;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * kevin<br/>
 * 2021/3/15 15:16<br/>
 */
public class OpenIdAuthenticationProvider implements AuthenticationProvider {

    private UsersConnectionRepository usersConnectionRepository;

    private SocialUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.isInstanceOf(OpenIdAuthenticationToken.class, authentication, "unsupported authentication type");
        Assert.isTrue(!authentication.isAuthenticated(), "already authenticated");
        OpenIdAuthenticationToken authToken = (OpenIdAuthenticationToken) authentication;

        String providerId = authToken.getProviderId();
        Set<String> providerUserIds = new HashSet<>();
        providerUserIds.add((String) authToken.getPrincipal());

        String userId = toUserId(providerId, providerUserIds);
        if (userId == null) {
            throw new BadCredentialsException("Unknown access token");
        }

        UserDetails userDetails = userDetailsService.loadUserByUserId(userId);
        if (userDetails == null) {
            throw new UsernameNotFoundException("Unknown connected account id");
        }

        OpenIdAuthenticationToken authenticationToken = new OpenIdAuthenticationToken(userDetails, userDetails.getAuthorities());
        authenticationToken.setDetails(authenticationToken.getDetails());
        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OpenIdAuthenticationToken.class.isAssignableFrom(authentication);
    }

    protected String toUserId(String providerId, Set<String> providerUserIds) {
        Set<String> userIds = usersConnectionRepository.findUserIdsConnectedTo(providerId, providerUserIds);
        // only if a single userId is connected to this providerUserId
        return (userIds.size() == 1) ? userIds.iterator().next() : null;
    }

    public void setUsersConnectionRepository(UsersConnectionRepository usersConnectionRepository) {
        this.usersConnectionRepository = usersConnectionRepository;
    }

    public void setUserDetailsService(SocialUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
