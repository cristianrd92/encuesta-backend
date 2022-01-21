package com.it.encuesta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.encuesta.entity.Encuesta;
import com.it.encuesta.service.IEncuestaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EncuestaController {

	@Autowired
	private IEncuestaService encuestaService; 
	
	@GetMapping("/encuesta")
	public List<Encuesta> ecuestas(){
		return encuestaService.findAll();
	}
	
	@PostMapping("/encuesta")
	public ResponseEntity<?> create(@Valid @RequestBody Encuesta encuesta, BindingResult result) {
		Encuesta encuestaNueva = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			encuestaNueva=encuestaService.save(encuesta);
		} catch (DataAccessException e) {
			response.put("error", "El usuario ya contesto la encuesta");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} 
		response.put("mensaje", "Encuesta realizada con exito");
		response.put("encuesta", encuestaNueva);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
