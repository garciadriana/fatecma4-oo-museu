package br.com.fatec.museu.dao;

import br.com.fatec.museu.model.Acervo;
import br.com.fatec.museu.model.Exposicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExposicaoDAO extends JpaRepository<Exposicao, Integer> {
}