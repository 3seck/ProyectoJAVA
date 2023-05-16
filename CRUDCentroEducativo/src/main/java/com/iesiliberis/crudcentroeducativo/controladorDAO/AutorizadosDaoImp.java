/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Autorizados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


 
public class AutorizadosDaoImp implements AutorizadosDao {

    @Override
    public int add(Autorizados a) throws SQLException {
        String sql="""
                  insert into autorizado(dni, nombre, apellido1, apellido2, parentescos)
                  values (?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setString(5, a.getParentesco());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Autorizados getById(int id) throws SQLException {
        Autorizados autoriz = null;
        String sql="select * from cursoacademico where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                autoriz=new Autorizados();
                
                autoriz.setId(rs.getInt("id"));
                autoriz.setDni(rs.getString("dni"));
                autoriz.setNombre(rs.getString("nombre"));
                autoriz.setApellido1(rs.getString("apellido1"));
                autoriz.setApellido2(rs.getString("apellido2"));
                autoriz.setParentesco(rs.getString("parentesco"));
                
            }
            
        }
        
        return autoriz;
    }

    @Override
    public List<Autorizados> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Autorizados a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
