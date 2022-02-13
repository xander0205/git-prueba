package com.valid.dao;

import java.sql.SQLException;
import java.util.List;

import com.valid.dto.ProductDTO;

public interface ProductDao {

	List<ProductDTO> listarRegistros();
	List<ProductDTO> listarRegistrosPorNombre(String nombre);
	
	void crearProducto() throws SQLException;
		
}
