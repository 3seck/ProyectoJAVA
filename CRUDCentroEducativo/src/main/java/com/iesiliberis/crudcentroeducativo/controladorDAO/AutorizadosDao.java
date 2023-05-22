/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;


import com.iesiliberis.crudcentroeducativo.entidades.Autorizados;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alvar
 */
public interface AutorizadosDao {
    int add(Autorizados a) throws SQLException;
    
    Autorizados getById(int id) throws SQLException;
        
    List<Autorizados> getAll()  throws SQLException;
    
    int update(Autorizados a)  throws SQLException;
    
    void delete(int id)  throws SQLException;
    
    int getIdByDni(String dni) throws SQLException;
}
