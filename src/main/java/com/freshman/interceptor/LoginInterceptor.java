package com.freshman.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.freshman.jwt.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // 实现用户登录验证
        String token = request.getHeader("Authorization");
        if (token == null) {
            PrintWriter pw = response.getWriter();
            pw.write("{\"code\":-1, \"msg\":\"not login\", \"data\":null}");
            pw.flush();
            return false;
        }
        Map<String, Claim> user = JwtUtil.verifyToken(token);
        if (user == null) {
            PrintWriter pw = response.getWriter();
            pw.write("{\"code\":-1, \"message\":\"invalid token\", \"data\":null}");
            pw.flush();
            return false;
        }
        return true;
    }
}
