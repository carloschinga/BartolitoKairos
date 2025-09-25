package com.ejemplo.jwtlogin.app.core.domain;

import com.ejemplo.jwtlogin.dto.Constantes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "kairos_accion_productos", schema = Constantes.SCHEMA, catalog = Constantes.CATALOG)
public class KairosAccionProductos {

	@Id
	@Column(name = "kairos_accion_productos_id", unique = true, nullable = false)
	private String kairosAccionProductosId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kairos_acciones_terapeuticas_id")
	private KairosAccionTerapeuticas kairosAccionesTerapeuticas;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kairos_productos_id")
	private KairosProductos kairosProductos;

	@Column(name = "especificacion_presentacion")
	private String especificacionPresentacion;
	@Column(name = "via_administracion")
	private String viaAdministracion;
	@Column(name = "medio_presentacion")
	private String medioPresentacion;
	@Column(name = "importancia_asociacion")
	private String importanciaAsociacion;

}
