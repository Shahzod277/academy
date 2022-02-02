package uz.jurayev.academy.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import uz.jurayev.academy.service.impl.UserDetailsImpl;
import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

    public String generateToken(Authentication authentication) {

        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(principal.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstant.TUTOR_EXPIRE_AT))
                .signWith(Keys.hmacShaKeyFor(SecurityConstant.SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SecurityConstant.SECRET_KEY.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(SecurityConstant.SECRET_KEY.getBytes()))
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        }
        catch (SignatureException e) {
            LOG.error("Invalid JWT signature: {}", e.getMessage());
        }
        catch (MalformedJwtException e) {
            LOG.error("Invalid JWT token: {}", e.getMessage());
        }
        catch (ExpiredJwtException e) {
            LOG.error("JWT token is expired: {}", e.getMessage());
        }
        catch (UnsupportedJwtException e) {
            LOG.error("JWT token is unsupported: {}", e.getMessage());
        }
        catch (IllegalArgumentException e) {
            LOG.error("JWT claims is empty: {}", e.getMessage());
        }
        return false;
    }
}
