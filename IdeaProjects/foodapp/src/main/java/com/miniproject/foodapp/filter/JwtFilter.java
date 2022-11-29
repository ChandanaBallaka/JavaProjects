package com.miniproject.foodapp.filter;


import com.miniproject.foodapp.service.RestaurantService;
import com.miniproject.foodapp.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter
{
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private RestaurantService restaurantService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        String authorization = httpServletRequest.getHeader("Authorization");
        String token = null;
        String userName = null;
        if(null != authorization && authorization.startsWith("Bearer "))
        {
            token = authorization.substring(7);
            userName = jwtUtility.getUsernameFromToken(token);
        }
        if(null != userName && SecurityContextHolder.getContext().getAuthentication() == null)
        {
            UserDetails userDetails = restaurantService.loadUserByUsername(userName);
            if(jwtUtility.validateToken(token,userDetails))
            {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
                );

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
