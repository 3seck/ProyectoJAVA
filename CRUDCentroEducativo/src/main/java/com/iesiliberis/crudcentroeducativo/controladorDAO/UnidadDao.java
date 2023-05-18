/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;


import com.iesiliberis.crudcentroeducativo.entidades.Unidad;
import java.sql.SQLException;
import java.util.List;


public interface UnidadDao {
 
    int add(Unidad a) throws SQLException;
    
    Unidad getById(int id) throws SQLException;
        
    List<Unidad> getAll()  throws SQLException;
    
    int update(Unidad a)  throws SQLException;
    
    void delete(int id)  throws SQLException;
    
    List <Unidad> getByCursoAca(int idcurso) throws SQLException;
    

    
    
}
