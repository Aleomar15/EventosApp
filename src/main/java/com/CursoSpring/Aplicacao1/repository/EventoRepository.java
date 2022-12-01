package com.CursoSpring.Aplicacao1.repository;

import com.CursoSpring.Aplicacao1.model.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento,String> {
    Evento findById(long id);
}
