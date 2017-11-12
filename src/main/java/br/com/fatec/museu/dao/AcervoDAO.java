package br.com.fatec.museu.dao;

import br.com.fatec.museu.model.Acervo;
import org.springframework.data.repository.CrudRepository;

public interface AcervoDAO extends CrudRepository<Acervo, Integer> {
}