package com.ejemplo.jwtlogin.app.core.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.repository.KairosAccionProductosRepository;
import com.ejemplo.jwtlogin.app.core.repository.KairosAccionTerapeuticasRepository;
import com.ejemplo.jwtlogin.app.core.service.KairosAccionTerapeuticasService;
import com.ejemplo.jwtlogin.core.service.ServiceBase;
import com.ejemplo.jwtlogin.dto.model.accionTerapeutica.AccionProductosFileRequest;
import com.ejemplo.jwtlogin.dto.model.accionTerapeutica.AccionTerapeuticaFileRequest;

@Service
public class KairosAccionTerapeuticasServiceImpl extends ServiceBase implements KairosAccionTerapeuticasService {

	@Autowired
	private KairosAccionTerapeuticasRepository kairosAccionTerapeuticasRepository; 
	
	@Autowired
	private KairosAccionProductosRepository kairosAccionProductosRepository; 
	
	@Override
	public void saveOrUpdateFile(MultipartFile file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;

				// Extraer datos del TXT
				String codigo = line.substring(0, 5).trim();
				String estado = line.length() > 50 ? line.substring(50).trim() : "";
				String descripcionRaw = line.substring(5, line.length() - estado.length()).trim();

				// Reinterpretar la cadena suponiendo que está mal leída en ISO-8859-1
				String descripcion = new String(descripcionRaw.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

				
				if (estado.isEmpty()) {
					estado = " "; // Activo
				}

				AccionTerapeuticaFileRequest request = new AccionTerapeuticaFileRequest();
				request.setAccionTerapeuticasId(codigo);
				request.setDescripcion(descripcion);
				request.setEstado(estado);

				kairosAccionTerapeuticasRepository.saveOrUpdate(request);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error al procesar el archivo de laboratorios", e);
		}
	}

	@Override
	public void saveOrUpdateAccionProductoFile(MultipartFile file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;

				// Extraer datos del TXT
			    String accionTerapeuticaId = line.substring(0, 5).trim();   // 5 caracteres
	            String productosId = line.substring(5, 12).trim();          // 6 caracteres (posición 5 a 10)
	            String importanciaAsociacion = line.substring(31, 32).trim(); 

	            String especificacionPresentacion = "";
	            String viaAdministracion = "";
	            String medioPresentacion = "";
	
				AccionProductosFileRequest request = new AccionProductosFileRequest();
				request.setAccionTerapeuticasId(accionTerapeuticaId);
				request.setProductosId(productosId);
				request.setImportanciaAsociacion(importanciaAsociacion);
				request.setEspecificacionPresentacion(especificacionPresentacion);
				request.setViaAdministracion(viaAdministracion);
				request.setMedioPresentacion(medioPresentacion);

				kairosAccionProductosRepository.saveOrUpdate(request);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error al procesar el archivo de laboratorios", e);
		}
	}

}
