package com.CursoSpring.Aplicacao1.repository;

import com.CursoSpring.Aplicacao1.model.Convidado;
import com.CursoSpring.Aplicacao1.model.Evento;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado,String> {
    Iterable<Convidado> findByEvento(Evento evento);
}
