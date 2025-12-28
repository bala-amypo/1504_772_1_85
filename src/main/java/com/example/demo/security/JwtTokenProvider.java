package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // 🔐 MUST be at least 32 chars (HS256 requirement)
    private static final String SECRET =
            "THIS_IS_A_TEST_SECRET_KEY_FOR_REAL_ESTATE_RATING_ENGINE";

    /**
     * Generate JWT token
     * Used in AuthController + Testcases
     */
    public String generateToken(Authentication authentication, User user) {

        return Jwts.builder()
                .setSubject(user.getEmail())          // email
                .claim("userId", user.getId())        // required by testcase
                .claim("role", user.getRole())        // ADMIN / ANALYST
                .setIssuedAt(new Date())
                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes(StandardCharsets.UTF_8)
                        )
                )
                .compact();
    }

    /**
     * Extract userId from JWT
     * REQUIRED by testcase:
     * jwtTokenProvider.getUserIdFromToken(token)
     */
    public Long getUserIdFromToken(String token) {

        Object id = Jwts.parserBuilder()
                .setSigningKey(
                        SECRET.getBytes(StandardCharsets.UTF_8)
                )
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("userId");

        return ((Number) id).longValue();
    }

    /**
     * Extract email (subject) from JWT
     * Used by JwtAuthenticationFilter
     */
    public String getEmailFromToken(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(
                        SECRET.getBytes(StandardCharsets.UTF_8)
                )
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
