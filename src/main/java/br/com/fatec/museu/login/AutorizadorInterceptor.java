package br.com.fatec.museu.login;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object controller) throws Exception {
        System.out.println("o usuario esta logado, "+ request.getSession().getAttribute("usuarioLogado"));
        if(request.getSession().getAttribute("usuarioLogado") == null){
            if(request.getRequestURI().contains("admin")){
                response.sendRedirect("/");
                return false;
            }

            return true;
        }
        return (Boolean)request.getSession().getAttribute("usuarioLogado");
    }
}