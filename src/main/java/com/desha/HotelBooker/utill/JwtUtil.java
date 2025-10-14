package com.desha.HotelBooker.utill;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.text.DecimalFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtUtil {

    private String generateToken(Map<String, Object> extraDetails, UserDetails userDetails) {
        return Jwts.builder().setClaims(extraDetails).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 3600 * 24))
                .signWith(getSigningInKey(), SignatureAlgorithm.HS256).compact();
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }


    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningInKey()).build().parseClaimsJws(token)
                .getBody();
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims  = extractAllClaims(token);
        return  claimsResolver.apply(claims);
    }


    public String extractUserName(String token){
        return extractClaims(token, Claims::getSubject);
    }

    private Date extractExpiration(String token){
        return extractClaims(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }




    private Key getSigningInKey() {
        byte[] keyBytes = Decoders.BASE64.decode("4135F4428472B48625065536856605970337333676397924422645294840406351");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
