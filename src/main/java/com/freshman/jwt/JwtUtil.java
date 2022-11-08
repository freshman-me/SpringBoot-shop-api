package com.freshman.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.freshman.pojo.User;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    // 密钥
    public static final String SECRET = "secret";

    /** token 过期时间: 10天 */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 10;

    /**
     *  创建token
     * @param user 用户的信息
     * @return  token
     */
   public static String createToken(User user) throws Exception{
       // 现在时间
       Date iatDate = new Date();

       // 过期时间
       Calendar nowTime = Calendar.getInstance();
       nowTime.add(calendarField, calendarInterval);
       Date expiresDate = nowTime.getTime();

       // header Map
       Map<String, Object> map = new HashMap<>();
       map.put("alg", "HS256");
       map.put("typ", "JWT");

       String token = JWT.create().withHeader(map) // header
               .withClaim("id",user.getId().toString())
               .withClaim("username",user.getUsername())
               .withClaim("isAdmin",user.getIsAdmin().toString())  // payload
               .withIssuedAt(iatDate)  // sign date
               .withExpiresAt(expiresDate) // expire date
               .sign(Algorithm.HMAC256(SECRET));  // signature

        return token;
   }

   public static Map<String, Claim> verifyToken(String token){
       DecodedJWT jwt = null;
       try {
           JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
           jwt = jwtVerifier.verify(token);

       }catch (Exception exception){
           exception.printStackTrace();
       }
       return jwt.getClaims();
   }
}
