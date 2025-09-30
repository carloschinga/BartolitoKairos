package com.ejemplo.jwtlogin.app.core.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.jwtlogin.app.core.repository.KairosProductosRepository;
import com.ejemplo.jwtlogin.app.core.service.KairosProductosService;
import com.ejemplo.jwtlogin.core.service.ServiceBase;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoFileRequest;

@Service
public class KairosProductosServiceImpl extends ServiceBase implements KairosProductosService {

    private final AuthenticationManager authenticationManager;

	@Autowired 
	private KairosProductosRepository kairosProductosRepository;

    KairosProductosServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

	@Override
	public void saveOrUpdateFile(MultipartFile file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;

				// Extraer datos del TXT
				String productoId = line.substring(0, 7).trim();
				String laboratoriosId = line.substring(49, 53).trim();
				String descripcionRaw = line.substring(7, 49).trim();
				String psicofarmaco = line.substring(53, 54).trim();
				String codigoVenta = line.substring(55, 56).trim();
				String estupefaciente = line.substring(56, 57).trim();
				String estado = line.substring(57, 58).trim();

				// Reinterpretar la cadena suponiendo que está mal leída en ISO-8859-1
				String descripcion = new String(descripcionRaw.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

				if (psicofarmaco.isEmpty()) {
					psicofarmaco = "NO PSICO"; 
				}
				
				if (estado.isEmpty()) {
					estado = "ACTIVO"; 
				}
				
				if (estupefaciente.isEmpty()) {
					estupefaciente = "NO EST"; 
				}
				
				ProductoFileRequest request = new ProductoFileRequest();
				request.setProductosId(productoId);
				request.setLaboratoriosId(laboratoriosId);
				request.setDescripcion(descripcion);
				request.setPsicofarmaco(psicofarmaco);
				request.setCodigoVenta(codigoVenta);
				request.setEstupefaciente(estupefaciente);
				request.setEstado(estado);

				kairosProductosRepository.saveOrUpdate(request);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error al procesar el archivo de productos", e);
		}
		
	}

	@Override
	public JSONArray load() {
		String response = kairosProductosRepository.load();
	    JSONObject obj = new JSONObject(response);
	    return obj.getJSONArray("productos");
	}
	
	
	
}
