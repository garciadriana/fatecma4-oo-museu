package br.com.fatec.museu.controller;

import br.com.fatec.museu.dao.AcervoDAO;
import br.com.fatec.museu.model.Acervo;
import br.com.fatec.museu.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ObraController {

    @Autowired
    private AcervoDAO dao;

    @GetMapping("/obras")
    public String listarTodasAsObras(Model model) {
        model.addAttribute("obras", dao.findAll());
        return "obra";
    }


    @GetMapping("/admin/obra")
    public String paginaAcervo(Model model) {
        model.addAttribute("acervo", new Acervo());
        model.addAttribute("obras", dao.findAll());
        return "inserirObra";
    }

    @GetMapping("/admin/obra/alterar/{id}")
    public String paginaAcervo(@PathVariable int id, Model model) {
        model.addAttribute("acervo", dao.findOne(id));
        model.addAttribute("obras", dao.findAll());
        return "inserirObra";
    }

    @PostMapping("/admin/obra")
    public String inserirAcervo(@ModelAttribute Acervo acervo, Model model) {
        dao.save(acervo);
        model.addAttribute("acervo", new Acervo());
        model.addAttribute("obras", dao.findAll());
        return "inserirObra";
    }

    @PostMapping("/admin/obra/deletar/{id}")
    public String deletarAcervo(@PathVariable int id, Model model) {
        dao.delete(id);
        model.addAttribute("acervo", new Acervo());
        model.addAttribute("obras", dao.findAll());
        return "redirect:/admin/obra/";
    }
}
