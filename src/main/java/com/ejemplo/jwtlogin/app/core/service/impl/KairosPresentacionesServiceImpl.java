package com.ejemplo.jwtlogin.app.core.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.repository.KairosPresentacionesRepository;
import com.ejemplo.jwtlogin.app.core.service.KairosPresentacionesService;
import com.ejemplo.jwtlogin.core.service.ServiceBase;
import com.ejemplo.jwtlogin.dto.model.presentacion.PresentacionFileRequest;

@Service
public class KairosPresentacionesServiceImpl extends ServiceBase implements KairosPresentacionesService {

	@Autowired
	private KairosPresentacionesRepository kairosPresentacionesRepository;

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
				String descripcionRaw = line.substring(10, 79).trim();
				String estado = line.substring(96, 97).trim();

				// Reinterpretar la cadena suponiendo que está mal leída en ISO-8859-1
				String descripcion = new String(descripcionRaw.getBytes(StandardCharsets.ISO_8859_1),
						StandardCharsets.UTF_8);

				if (estado.isEmpty()) {
					estado = "ACTIVO";
				}

				PresentacionFileRequest request = new PresentacionFileRequest();
				request.setProductosId(productoId);
				request.setPresentacionesId(presentacionId);
				request.setDescripcion(descripcion);
				request.setEstado(estado);

				kairosPresentacionesRepository.saveOrUpdate(request);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error al procesar el archivo de presentacion", e);
		}

	}

}
