package cn.tanyu.security.rbac.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2020/10/29 11:25 上午
 */
@Component
public class JwtUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String createJWT(Boolean rememberMe, Long id, String subject, List<String> roles, Collection<? extends SimpleGrantedAuthority> authorities) {
        Date now = new Date();
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id.toString())
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, "tanyu")
                .claim("roles", roles)
                .claim("authorities", authorities);

        String jwt = jwtBuilder.compact();
        stringRedisTemplate.opsForValue().set("security:jwt:" + subject, jwt);
        return jwt;
    }


}
