package com.partidoback18.partidos.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class Autorizacion implements Filter {
    // Llave de cifrado y descifrado
    public static final String KEY = "bjhhjgffgdvkjbkjbkjbjhvhjgd";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
       
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Headers", "Authorization");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST");

        String url = req.getRequestURI();
        // http://localhost:8080 ------->url

        if (url.contains("/api/usuarios") || url.contains("/api/usuarios/login")) {
            chain.doFilter(request, response);
        }else{
            String hash=req.getHeader("Authorization");
            if(hash==null || hash.trim().equals("")){
                response.setContentType("application/json");
                String body="{\"autorizacion\":\"NO\"}";
                response.getWriter().write(body);
            }try{
                //Lectura de carga util del JWT
                Jws<Claims> claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(hash);
                if((url.contains("/api/partidos") || url.contains("/api/equipos"))&& (!claims.getBody().get("username").equals(""))){
                    chain.doFilter(request, response);
                }

            }catch(MalformedJwtException e){
                response.setContentType("application/json");
                String body="{\"autorizacion\":\"TOKEN NO VALIDO\"}";
                response.getWriter().write(body);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }



                
        }
    }

}
