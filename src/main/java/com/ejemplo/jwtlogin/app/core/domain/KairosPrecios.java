package com.ejemplo.jwtlogin.app.core.domain;

import java.time.LocalDate;

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
public class KairosPrecios {

	@Id
	@Column(name = "kairos_precios", unique = true, nullable = false)
	private String kairosPrecios;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kairos_productos_id")
	private KairosProductos kairosProductos;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kairos_presentaciones_id")
	private KairosPresentaciones kairosPresentaciones;

	@Column(name = "precio_fabrica")
	private Double precioFabrica;
	@Column(name = "precio_publico")
	private Double precioPublico;
	@Column(name = "fecha_vigencia")
	private LocalDate fechaVigencia;
}
