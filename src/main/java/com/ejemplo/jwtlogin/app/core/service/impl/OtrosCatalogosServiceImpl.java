package com.ejemplo.jwtlogin.app.core.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.jwtlogin.app.core.repository.OtrosCatalogosRepository;
import com.ejemplo.jwtlogin.app.core.service.OtrosCatalogosService;
import com.ejemplo.jwtlogin.core.service.ServiceBase;
import com.ejemplo.jwtlogin.dto.model.otrosCatalogos.TiposCatalogosRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosFileRequest;
import com.ejemplo.jwtlogin.dto.model.producto.ProductoOtrosCatalogosRequest;

@Service
public class OtrosCatalogosServiceImpl extends ServiceBase implements OtrosCatalogosService {

	@Autowired
	private OtrosCatalogosRepository otrosCatalogosRepository;

	private final DataFormatter dataFormatter = new DataFormatter();

	@Override
	public void saveOrUpdate(ProductoOtrosCatalogosRequest t) {
		try {
			Workbook workbook = new XSSFWorkbook(t.getFile().getInputStream());
			Sheet sheet = workbook.getSheetAt(0);

			// Suponiendo que la primera fila son encabezados
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				 if (isRowEmpty(row))
				        continue;

				ProductoOtrosCatalogosFileRequest request = new ProductoOtrosCatalogosFileRequest();
				request.setCodpro(getStringCell(row.getCell(0)));
				request.setProd(getStringCell(row.getCell(1)));
				request.setStk(getIntegerCell(row.getCell(2)));
				request.setLab(getStringCell(row.getCell(3)));
				request.setDci(getStringCell(row.getCell(4)));
				request.setPrec(getDoubleCell(row.getCell(5)));

				request.setCodtip(t.getCodtip());

				otrosCatalogosRepository.saveOrUpdate(request);
			}

			workbook.close();

		} catch (Exception e) {
			throw new RuntimeException("Error procesando archivo Excel: " + e.getMessage(), e);
		}

	}

	@Override
	public JSONArray load(TiposCatalogosRequest t) {
		String response = otrosCatalogosRepository.load(t);
		JSONObject obj = new JSONObject(response);
		return obj.getJSONArray("productos");
	}

	private String getStringCell(Cell cell) {
		if (cell == null)
			return "";

		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue().trim();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else {
			return "";
		}
	}

	private Integer getIntegerCell(Cell cell) {
		if (cell == null)
			return 0;

		if (cell.getCellType() == CellType.NUMERIC) {
			return (int) cell.getNumericCellValue();
		} else if (cell.getCellType() == CellType.STRING) {
			try {
				return Integer.parseInt(cell.getStringCellValue().trim());
			} catch (NumberFormatException e) {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	private boolean isRowEmpty(Row row) {
	    if (row == null) return true;

	    for (int c = 0; c < row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != CellType.BLANK) {
	            return false;
	        }
	    }
	    return true;
	}


	private Double getDoubleCell(Cell cell) {
		if (cell == null)
			return 0.0;

		// Obtiene el valor tal cual lo muestra Excel
		String cellValue = dataFormatter.formatCellValue(cell).trim();

		if (cellValue.isEmpty())
			return 0.0;

		cellValue = cellValue.replace("S/", "").replace("$", "").replace(",", "").replace(" ", "");

		try {
			return Double.parseDouble(cellValue);
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}

	@Override
	public JSONArray initComboCatalogos() {
		String response = otrosCatalogosRepository.initComboCatalogos();
		JSONObject obj = new JSONObject(response);
		return obj.getJSONArray("catalogos");
	}

}
