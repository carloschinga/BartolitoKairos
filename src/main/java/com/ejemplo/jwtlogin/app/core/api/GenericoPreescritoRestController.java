package com.ejemplo.jwtlogin.app.core.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.jwtlogin.app.core.facade.GenericoPreescritoFacade;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ComboDiadesServicioMedicoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ComboMedicoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ComboServicioMedicoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoComboRequest;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoRequest;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoResponse;

@CrossOrigin(origins = "*", maxAge = 360)
@RestController
@RequestMapping("/genericoPreescrito")
public class GenericoPreescritoRestController {

	@Autowired
	private GenericoPreescritoFacade genericoPreescritoFacade;

	@PostMapping("/load")
	public List<GenericoPreescritoResponse> load(GenericoPreescritoRequest request) {
		return genericoPreescritoFacade.load(request);
	}

	@GetMapping("/initMedico")
	public ComboMedicoResponse initComboMedico() {
		return genericoPreescritoFacade.initComboMedico();
	}

	@PostMapping("/initServicio")
	public ComboServicioMedicoResponse initComboServicio(@RequestBody GenericoPreescritoComboRequest request) {
		return genericoPreescritoFacade.initComboServicio(request);
	}

	@PostMapping("/initDiades")
	public ComboDiadesServicioMedicoResponse initComboDiades(@RequestBody GenericoPreescritoComboRequest request) {
		return genericoPreescritoFacade.initComboDiades(request);
	}

}
