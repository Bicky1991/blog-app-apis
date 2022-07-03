package com.codewithpreet.blog.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenHelper {

    public static final long JWT_TOKEN_VALIDITY = 5*60*60;

    private String secret = "jwtTokenKey";

    //Private UserName From JWT Token
    public String getUsernameFromToken(String token){
        return getClaimFromToken(token,Claims::getSubject);
    }
    //Retrive Expiration Date From Token
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token,Claims::getExpiration);
    }
    public <T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    //For Retriving Any Information From Token We Will Need The Secret Key
    private Claims getAllClaimsFromToken(String token){
        return  Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    //Check If The Token Has Expired
    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    //Generate Token For User
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return  doGenerateToken(claims,userDetails.getUsername());
    }
    //While Creating The Token
    //1.Define claims Of The Token,like Issuer,Expiration,Subject, and the ID
    //2.Sign the Jwt using the HSS12 Algorithm and Secret Key.
    //3.According to JWS Compact Serialization(http://tools.ietf.org/html/draft-ietf-jose-json)
    //Compaction Of The JWT To a URL-Safe String
    private String doGenerateToken(Map<String,Object> claims,String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*100))
                .signWith(SignatureAlgorithm.HS512,secret).compact();
    }
    //Validate Token
    public Boolean validateToken(String token,UserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
