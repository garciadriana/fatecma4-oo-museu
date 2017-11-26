package br.com.fatec.museu.controller;

import br.com.fatec.museu.dao.AcervoDAO;
import br.com.fatec.museu.dao.ExposicaoDAO;
import br.com.fatec.museu.model.Acervo;
import br.com.fatec.museu.model.Exposicao;
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
    private ExposicaoDAO dao;


    @GetMapping("/exposicao")
    public String paginaExposicao(Model model) {
        model.addAttribute("acervo", new Exposicao());
        model.addAttribute("exposicaos", dao.findAll());
        return "exposicao";
    }



    @GetMapping("/admin/exposicao")
    public String paginaAcervo(Model model) {
        model.addAttribute("exposicao", new Exposicao());
        model.addAttribute("exposicaos", dao.findAll());
        return "inserirExposicao";
    }

    @GetMapping("/admin/exposicao/alterar/{id}")
    public String paginaAcervo(@PathVariable int id, Model model) {
        model.addAttribute("exposicao", dao.findOne(id));
        model.addAttribute("exposicaos", dao.findAll());
        return "inserirExposicao";
    }

    @PostMapping("/admin/exposicao")
    public String inserirAcervo(@ModelAttribute Exposicao acervo, Model model) {
        dao.save(acervo);
        model.addAttribute("exposicao", new Exposicao());
        model.addAttribute("exposicaos", dao.findAll());
        return "inserirExposicao";
    }

    @PostMapping("/admin/exposicao/deletar/{id}")
    public String deletarAcervo(@PathVariable int id, Model model) {
        dao.delete(id);
        model.addAttribute("exposicao", new Exposicao());
        model.addAttribute("exposicaos", dao.findAll());
        return "redirect:/admin/exposicao/";
    }
}
