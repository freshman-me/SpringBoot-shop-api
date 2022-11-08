package com.freshman.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.freshman.jwt.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 实现admin用户登录验证
        String token = request.getHeader("Authorization");
        Map<String, Claim> map = JwtUtil.verifyToken(token);
        Integer isAdmin = map.get("isAdmin").asInt();
        if (isAdmin == 1){
            return true;
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("{\"code\":-1, \"msg\":\"permission denied\", \"data\":null}");
            writer.flush();
            return false;
        }
    }
}
