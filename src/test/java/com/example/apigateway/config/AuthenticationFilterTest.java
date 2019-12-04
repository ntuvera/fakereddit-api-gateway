package com.example.apigateway.config;

import com.example.apigateway.bean.UserBean;
import com.example.apigateway.repository.UserRepository;
import com.netflix.zuul.context.RequestContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class AuthenticationFilterTest {
    private UserBean tempUser;
    @InjectMocks
    AuthenticationFilter authenticationFilter;

    @Mock
    SecurityContext ctx;
    @Mock
    Authentication authentication;

    @InjectMocks
    UserBean user;

    @Before
    public void init() {
        tempUser = new UserBean();
        tempUser.setUsername("user");
        tempUser.setPassword("password");
        tempUser.setId(1);
        SecurityContextHolder.setContext(ctx);
    }

    @Test
    public void authenticationFilterTest_Success() {
        assertEquals(authenticationFilter.filterType(), "pre");
        assertEquals(authenticationFilter.filterOrder(), 1);
        assertEquals(authenticationFilter.shouldFilter(), true);
    }

    @Test
    public void filter_Success() {
        when(ctx.getAuthentication()).thenReturn(authentication);
        when(authentication.getName()).thenReturn("user");
        boolean value = authenticationFilter.shouldFilter();
        assertEquals(true, value);
    }
    @Test
    public void run_Success() {
        when(ctx.getAuthentication()).thenReturn(authentication);
        when(authentication.getName()).thenReturn("user");
        when(RequestContext.getCurrentContext()).thenReturn((RequestContext) ctx);
//        when(((RequestContext) ctx).getRequest().getHeader(anyString())).thenReturn(true);
        authenticationFilter.run();
    }
}
