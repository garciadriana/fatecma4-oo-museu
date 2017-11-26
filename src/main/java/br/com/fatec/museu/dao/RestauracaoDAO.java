package br.com.fatec.museu.dao;

import br.com.fatec.museu.model.Exposicao;
import br.com.fatec.museu.model.Restauracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauracaoDAO extends JpaRepository<Restauracao, Integer> {
}