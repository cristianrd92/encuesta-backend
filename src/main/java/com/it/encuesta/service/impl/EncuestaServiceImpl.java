package com.it.encuesta.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.encuesta.dao.IEncuestaDao;
import com.it.encuesta.entity.Encuesta;
import com.it.encuesta.service.IEncuestaService;

@Service
public class EncuestaServiceImpl implements IEncuestaService {

	@Autowired
	private IEncuestaDao encuestaDao;

	@Override
	@Transactional(readOnly=true)
	public List<Encuesta> findAll() {
		return (List<Encuesta>) encuestaDao.findAll();
	}

	@Override
	public Encuesta save(Encuesta encuesta) {
		return encuestaDao.save(encuesta);
	}

	
	
}
