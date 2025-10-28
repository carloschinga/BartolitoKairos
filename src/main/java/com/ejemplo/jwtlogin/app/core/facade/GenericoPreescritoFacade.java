package com.ejemplo.jwtlogin.app.core.facade;

import java.util.List;

import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ComboDiadesServicioMedicoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ComboMedicoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.ComboServicioMedicoResponse;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoComboRequest;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoRequest;
import com.ejemplo.jwtlogin.dto.model.genericoPreescrito.GenericoPreescritoResponse;

public interface GenericoPreescritoFacade {

	List<GenericoPreescritoResponse> load(GenericoPreescritoRequest request);

	ComboMedicoResponse initComboMedico(GenericoPreescritoComboRequest t);

	ComboServicioMedicoResponse initComboServicio(GenericoPreescritoComboRequest t);

	ComboDiadesServicioMedicoResponse initComboDiades(GenericoPreescritoComboRequest t);

}
