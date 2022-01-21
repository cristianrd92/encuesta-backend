package com.it.encuesta.service;

import java.util.List;

import com.it.encuesta.entity.Encuesta;

public interface IEncuestaService {
	
	public List<Encuesta> findAll();
	public Encuesta save(Encuesta encuesta);
}
