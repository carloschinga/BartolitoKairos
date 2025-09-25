package com.ejemplo.jwtlogin.app.core.domain;

import java.util.List;

import com.ejemplo.jwtlogin.dto.Constantes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "kairos_laboratorios", schema = Constantes.SCHEMA, catalog = Constantes.CATALOG)
public class KairosLaboratorios {

	@Id
	@Column(name = "kairos_laboratorios_id", unique = true, nullable = false)
	private String kairosLaboratoriosId;

	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "estado")
	private String estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kairosLaboratorios")
	private List<KairosProductos> kairosProductos;

}
