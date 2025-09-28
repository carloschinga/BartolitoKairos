package com.ejemplo.jwtlogin.app.core.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.repository.KairosLaboratoriosRepository;
import com.ejemplo.jwtlogin.app.core.service.KairosLaboratoriosService;
import com.ejemplo.jwtlogin.core.service.ServiceBase;
import com.ejemplo.jwtlogin.dto.model.laboratorio.LaboratorioFileRequest;

@Service
public class KairosLaboratoriosServiceImpl extends ServiceBase implements KairosLaboratoriosService {

	@Autowired
	private KairosLaboratoriosRepository kairosLaboratoriosRepository; 
	
	@Override
	public void saveOrUpdateFile(MultipartFile file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;

				// Extraer datos del TXT
				String codigo = line.substring(0, 6).trim();
				String estado = line.length() > 21 ? line.substring(21).trim() : "";
				String descripcionRaw = line.substring(6, line.length() - estado.length()).trim();

				// Reinterpretar la cadena suponiendo que está mal leída en ISO-8859-1
				String descripcion = new String(descripcionRaw.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

				
				if (estado.isEmpty()) {
					estado = " "; // Activo
				}

				LaboratorioFileRequest request = new LaboratorioFileRequest();
				request.setLaboratoriosId(codigo);
				request.setDescripcion(descripcion);
				request.setEstado(estado);

				kairosLaboratoriosRepository.saveOrUpdate(request);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error al procesar el archivo de laboratorios", e);
		}
		
	}

}
