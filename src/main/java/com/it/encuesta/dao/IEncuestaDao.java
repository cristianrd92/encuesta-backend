package com.it.encuesta.dao;

import org.springframework.data.repository.CrudRepository;

import com.it.encuesta.entity.Encuesta;

public interface IEncuestaDao extends CrudRepository<Encuesta, Long>{

}
