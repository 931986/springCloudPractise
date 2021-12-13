package com.SpringCloud.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

/**
 * @author 乐心湖
 * @since 2020/08/05
 */
public class JwtUtils {

   public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";


  public static  final String APP_Id= UUID.randomUUID().toString();

    /**
     * 根据token获取会员id
//     * @param request
     * @return
     */
    public static String getJwtToken(JwtInfo jwtInfo, int expire){

        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("lakeCollege-user")//主题
                .setIssuedAt(new Date())//颁发时间
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())//过期时间
                .claim("id", jwtInfo.getId())//用户id
                .claim("nickname", jwtInfo.getNickname())//用户昵称
                .claim("avatar", jwtInfo.getAvatar())//用户头像
                .signWith(SignatureAlgorithm.HS256, getKeyInstance())
                .compact();

        return JwtToken;
    }
    private static Key getKeyInstance(){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] bytes = DatatypeConverter.parseBase64Binary(APP_SECRET);
        return new SecretKeySpec(bytes,signatureAlgorithm.getJcaName());
    }
    public static JwtInfo getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if(StringUtils.isEmpty(jwtToken)) {
            return null;
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        JwtInfo jwtInfo = new JwtInfo(claims.get("id").toString(), claims.get("nickname").toString(), claims.get("avatar").toString());
        return jwtInfo;
    }
    public  static  Boolean checkToken(String token){
        try{
            Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
       return true;

    }
}
