package com.valid.dao;
import com.valid.util.StringPoolUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.valid.dto.ProductDTO;

@Repository
@Configuration
public class PorductDaoImp implements ProductDao {
	
	@Value("${spring.datasource.url}") 
    private String dbUrl;
    @Value("${spring.datasource.username}") 
    private String dbUser;
    @Value("${spring.datasource.password}") 
    private String dbPassword;
    private final LocalDate localDate = LocalDate.now();
    private Random random = new Random(); 

	
	@Override
	public List<ProductDTO> listarRegistros() {
		List<ProductDTO> listaProductos = new ArrayList<>();
        try {        	
            String sql = "Select * from product";
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement stmt = con.createStatement();            
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){ 
            	ProductDTO r = new ProductDTO();
                 r.setName(rs.getString(1));
                 r.setPrice(rs.getString(2));
                 r.setQuantity(rs.getString(3));
                 r.setDescription(rs.getString(4));
                 r.setIdProducto(rs.getInt(5));
                 r.setEstado(rs.getString(6));
                 listaProductos.add(r);
            } 
            stmt.close();           
            con.close();            
        } catch (SQLException ex) {            
            Logger.getLogger(ProductDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
	}
	
	@Override
	public List<ProductDTO> listarRegistrosPorNombre(String nombre) {
		List<ProductDTO> listaProductos = new ArrayList<>();
        try {        	
            String sql = "Select * from product where name='"+nombre+"'";
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement stmt = con.createStatement();            
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){ 
            	ProductDTO r = new ProductDTO();
                 r.setName(rs.getString(1));
                 r.setPrice(rs.getString(2));
                 r.setQuantity(rs.getString(3));
                 r.setDescription(rs.getString(4));
                 r.setIdProducto(rs.getInt(5));
                 r.setEstado(rs.getString(6));
                 listaProductos.add(r);
            } 
            stmt.close();           
            con.close();            
        } catch (SQLException ex) {            
            Logger.getLogger(ProductDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProductos;
	}
	
	
	public void insertarProducto() {
		int randomInteger = random.nextInt(9999);
		String stringRandomInteger = String.valueOf(randomInteger);
		
		if (stringRandomInteger.length() < 6) {
			int ceros = 6 - stringRandomInteger.length();
			String stringCeros = StringPoolUtil.BLANK;
			for (int vuelta = 0; vuelta < ceros; vuelta++) {
                stringCeros = stringCeros.concat(StringPoolUtil.ZERO);
            }
			 stringRandomInteger = stringCeros.concat(stringRandomInteger);
			
			
			
		}
		
		
		
	}

	@Override
	public void crearProducto() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
