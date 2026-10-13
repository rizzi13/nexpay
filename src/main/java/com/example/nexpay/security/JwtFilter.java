package com.example.nexpay.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // 1. Grab Authorization header
        final String authHeader = request.getHeader("Authorization");

        // 2. If no Bearer token, let it pass (public endpoints will handle it)
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. Extract the token after "Bearer "
        final String jwt = authHeader.substring(7);
        final String userEmail;

        try {
            userEmail = jwtService.extractEmail(jwt);
        } catch (Exception e) {
            // Bad/expired token -> continue without authenticating
            filterChain.doFilter(request, response);
            return;
        }

        // 4. If email is valid and user is not yet marked authenticated on this thread
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            if (jwtService.isTokenValid(jwt, userEmail)) {

                // Build a minimal UserDetails object representing the authenticated user
                UserDetails userDetails = User.builder()
                        .username(userEmail)
                        .password("")
                        .authorities(Collections.emptyList())
                        .build();

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // 5. Stamp the request: Store authentication in ThreadLocal memory!
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // 6. Pass the request to the next stop
        filterChain.doFilter(request, response);
    }
}