package br.com.fatec.museu.controller;

import br.com.fatec.museu.dao.ExposicaoDAO;
import br.com.fatec.museu.dao.RestauracaoDAO;
import br.com.fatec.museu.model.Exposicao;
import br.com.fatec.museu.model.Restauracao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestauracaoController {

    @Autowired
    private RestauracaoDAO dao;


    @GetMapping("/restauracao")
    public String paginaExposicao(Model model) {
        model.addAttribute("restauracao", new Restauracao());
        model.addAttribute("restauracaos", dao.findAll());
        return "restauracao";
    }



    @GetMapping("/admin/restauracao")
    public String paginaAcervo(Model model) {
        model.addAttribute("restauracao", new Restauracao());
        model.addAttribute("restauracaos", dao.findAll());
        return "inserirRestauracao";
    }

    @GetMapping("/admin/restauracao/alterar/{id}")
    public String paginaAcervo(@PathVariable int id, Model model) {
        model.addAttribute("restauracao", dao.findOne(id));
        model.addAttribute("restauracaos", dao.findAll());
        return "inserirRestauracao";
    }

    @PostMapping("/admin/restauracao")
    public String inserirAcervo(@ModelAttribute Restauracao acervo, Model model) {
        dao.save(acervo);
        model.addAttribute("restauracao", new Exposicao());
        model.addAttribute("restauracaos", dao.findAll());
        return "inserirRestauracao";
    }

    @PostMapping("/admin/restauracao/deletar/{id}")
    public String deletarAcervo(@PathVariable int id, Model model) {
        dao.delete(id);
        model.addAttribute("restauracao", new Restauracao());
        model.addAttribute("restauracaos", dao.findAll());
        return "redirect:/admin/restauracao/";
    }
}
