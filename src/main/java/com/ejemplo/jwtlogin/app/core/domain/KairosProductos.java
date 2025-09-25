package com.ejemplo.jwtlogin.app.core.domain;

import java.util.List;

import com.ejemplo.jwtlogin.dto.Constantes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "kairos_productos", schema = Constantes.SCHEMA, catalog = Constantes.CATALOG)
public class KairosProductos {

	@Id
	@Column(name = "kairos_productos_id", unique = true, nullable = false)
	private String kairosProductosId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kairos_laboratorios_id")
	private KairosLaboratorios kairosLaboratorios;

	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "codigo_venta")
	private String codigoVenta;
	@Column(name = "estupefaciente")
	private String estupefaciente;
	@Column(name = "estado")
	private String estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kairosProductos")
	private List<KairosAccionProductos> kairosAccionProductos;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kairosProductos")
	private List<KairosPresentaciones> kairosPresentaciones;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kairosProductos")
	private List<KairosPrecios> kairosPrecios;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kairosProductos")
	private List<KairosDrogasProductos> kairosDrogasProductos;
}
