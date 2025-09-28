package com.ejemplo.jwtlogin.app.core.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.repository.KairosDrogasProductosRepository;
import com.ejemplo.jwtlogin.app.core.repository.KairosDrogasRepository;
import com.ejemplo.jwtlogin.app.core.service.KairosDrogasService;
import com.ejemplo.jwtlogin.core.service.ServiceBase;
import com.ejemplo.jwtlogin.dto.model.accionTerapeutica.AccionProductosFileRequest;
import com.ejemplo.jwtlogin.dto.model.droga.DrogaFileRequest;
import com.ejemplo.jwtlogin.dto.model.droga.DrogaProductoFileRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoFileRequest;

@Service
public class KairosDrogasServiceImpl extends ServiceBase implements KairosDrogasService {

	@Autowired
	private KairosDrogasRepository drogaRepository;
	
	@Autowired
	private KairosDrogasProductosRepository kairosDrogasProductosRepository; 
	

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
				String descripcion = new String(descripcionRaw.getBytes(StandardCharsets.ISO_8859_1),
						StandardCharsets.UTF_8);

				if (estado.isEmpty()) {
					estado = " "; // Activo
				}

				DrogaFileRequest request = new DrogaFileRequest();
				request.setDrogasId(codigo);
				request.setDescripcion(descripcion);
				request.setEstado(estado);

				drogaRepository.saveOrUpdate(request);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error al procesar el archivo de drogas", e);
		}
	}

	@Override
	public void saveOrUpdateDrogaProductoFile(MultipartFile file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;

				// Extraer datos del TXT
				String drogasId = line.substring(0, 5).trim();
				String productosId = line.substring(7, 12).trim();
				String importanciaAsociacion = line.substring(31, 32).trim();
				String especificacionPresentacion = "";
				String viaAdministracion = "";
				String medioPresentacion = "";

				DrogaProductoFileRequest request = new DrogaProductoFileRequest();
				request.setDrogasId(drogasId);
				request.setProductosId(productosId);
				request.setImportanciaAsociacion(importanciaAsociacion);
				request.setEspecificacionPresentacion(especificacionPresentacion);
				request.setViaAdministracion(viaAdministracion);
				request.setMedioPresentacion(medioPresentacion);

				kairosDrogasProductosRepository.saveOrUpdate(request);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error al procesar el archivo de drogas", e);
		}

	}

}
