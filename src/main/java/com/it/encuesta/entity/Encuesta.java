package com.it.encuesta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="encuesta")
public class Encuesta implements Serializable{

	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable=false)
		@NotNull(message="El campo gusto es obligatorio, no se guardo información")
		private String gusto;
		
		@Column(unique=true)
		@NotNull(message="El campo email es obligatorio, no se guardo información")
		@Email(message="El campo email no esta correctamente formado")
		private String email;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getGusto() {
			return gusto;
		}

		public void setGusto(String gusto) {
			this.gusto = gusto;
		}
		
		
}
