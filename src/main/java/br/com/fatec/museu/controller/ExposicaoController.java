package br.com.fatec.museu.controller;

import br.com.fatec.museu.dao.AcervoDAO;
import br.com.fatec.museu.model.Acervo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExposicaoController {

    @Autowired
    private AcervoDAO dao;


    @GetMapping("/exposicao")
    public String paginaExposicao(Model model) {
        model.addAttribute("acervo", new Acervo());
        model.addAttribute("obras", dao.findAll());
        return "exposicao";
    }

}
