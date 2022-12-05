package com.CursoSpring.Aplicacao1.repository;

import com.CursoSpring.Aplicacao1.model.Convidado;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado,String> {
}
