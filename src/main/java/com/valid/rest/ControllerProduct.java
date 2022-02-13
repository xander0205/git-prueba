package com.valid.rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valid.dao.ProductDao;
import com.valid.dto.ProductDTO;

@RestController
@RequestMapping(path = "/controladorProducto")
public class ControllerProduct {
	
	@Autowired
	private ProductDao productDao;
	
	 @RequestMapping(method = RequestMethod.GET, value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<ProductDTO> listarRegistros() throws SQLException {     
	    	List<ProductDTO> list = new ArrayList<>();
	        list = productDao.listarRegistros();
	        return list;
	    }
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/listarNombre", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<ProductDTO> listarRegistrosPorNombre(@RequestParam(value="nombres") String nombres) throws SQLException {     
	    	List<ProductDTO> list = new ArrayList<>();
	        list = productDao.listarRegistrosPorNombre(nombres);
	        return list;
	    }
	
	

}
