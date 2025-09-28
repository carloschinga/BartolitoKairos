package com.ejemplo.jwtlogin.app.core.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.repository.KairosPreciosRepository;
import com.ejemplo.jwtlogin.app.core.service.KairosPreciosService;
import com.ejemplo.jwtlogin.core.service.ServiceBase;
import com.ejemplo.jwtlogin.dto.DateUtil;
import com.ejemplo.jwtlogin.dto.model.precio.PrecioFileRequest;
import com.ejemplo.jwtlogin.dto.model.presentacion.PresentacionFileRequest;

@Service
public class KairosPreciosServiceImpl extends ServiceBase implements KairosPreciosService {

	@Autowired
	private KairosPreciosRepository kairosPreciosRepository;

	@Override
	public void saveOrUpdateFile(MultipartFile file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;

				// Extraer datos del TXT
				String productoId = line.substring(0, 7).trim();
				String presentacionId = line.substring(7, 10).trim();
				String precioFabrica = line.substring(9, 24).trim();
				String precioPublico = line.substring(25, 40).trim();
				String fechaVigencia = line.substring(40, 48).trim();

				PrecioFileRequest request = new PrecioFileRequest();
				request.setProductosId(productoId);
				request.setPresentacionesId(presentacionId);
				request.setPrecioFabrica(parsePrecio(precioFabrica));
				request.setPrecioPublico(parsePrecio(precioPublico));
				request.setFechaVigencia(DateUtil.toLocalDateKairos(fechaVigencia));

				kairosPreciosRepository.saveOrUpdate(request);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error al procesar el archivo de presentacion", e);
		}

	}
	
	private Double parsePrecio(String valor) {
	    if (valor == null || valor.trim().isEmpty()) {
	        return 0.0;
	    }
	    // 1. Quitar espacios
	    String limpio = valor.replaceAll("\\s+", "").trim();
	    // 2. Cambiar coma por punto
	    limpio = limpio.replace(",", ".");
	    // 3. Parsear a double
	    return Double.parseDouble(limpio);
	}
}
