package br.com.fatec.museu.controller;

import br.com.fatec.museu.dao.AcervoDAO;
import br.com.fatec.museu.model.Acervo;
import br.com.fatec.museu.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private AcervoDAO dao;

    @GetMapping("/")
    public String listarTodos(Model model) {
        final List<Acervo> todasAsObras = dao.findAll();
        if(todasAsObras.size() < 3){
            model.addAttribute("obras", todasAsObras);
        }else{
            model.addAttribute("obras", todasAsObras.subList(0, 3));
        }
        return "template";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Usuario usuario, HttpSession session) {
        if("admin".equals(usuario.getUsuario()) && "umanoitenomuseu".equals(usuario.getSenha())){
            session.setAttribute("usuarioLogado",true);
            return "redirect:/admin/obra";
        }
        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}
