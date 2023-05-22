/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.FamiliaresAutorizados;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alvar
 */
public interface FamiliaresAutorizadosDao {
    
    List<FamiliaresAutorizados> getAll() throws SQLException;
    
    int add(FamiliaresAutorizados f) throws SQLException;
    
}
