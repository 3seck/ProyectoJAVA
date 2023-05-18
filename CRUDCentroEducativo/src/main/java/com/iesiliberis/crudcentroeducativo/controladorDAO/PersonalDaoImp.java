/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Personal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonalDaoImp implements PersonalDao {

     private static PersonalDaoImp instance;
    
    static{
        instance=new PersonalDaoImp();
    }
    
    private PersonalDaoImp(){ }
    
    public static PersonalDaoImp getInstance(){
        return instance;
    }
    
    
    
    
    @Override
    public int add(Personal a) throws SQLException {
        String sql="""
                  insert into personal(dni, nombre, apellido1,apellido2,direccion, cp, poblacion, provincia, telefono, email, tipo)
                  values (?,?,?,?,?,?,?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setString(5, a.getDireccion());
            pstm.setString(6, a.getCp());
            pstm.setString(7, a.getPoblacion());
            pstm.setString(8, a.getProvincia());
            pstm.setString(9, a.getTelefono());
            pstm.setString(10, a.getEmail());
            pstm.setInt(11, a.getTipo());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Personal getById(int id) throws SQLException {
        Personal persona=null;
        String sql="select * from personal where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                persona=new Personal();
                
                persona.setId(rs.getInt("id"));
                persona.setDni(rs.getString("dni"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido1(rs.getString("apellido1"));
                persona.setApellido2(rs.getString("apellido2"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCp(rs.getString("cp"));
                persona.setPoblacion(rs.getString("poblacion"));
                persona.setProvincia(rs.getString("provincia"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setEmail(rs.getString("email"));
                persona.setTipo(rs.getInt("tipo"));
                
            }
            
        }
        
        return persona;
    }

    @Override
    public List<Personal> getAll() throws SQLException {
          Personal persona=null;
        String sql="select distinct * from personal order by id ";
        
        List<Personal> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                persona = new Personal();
                
                persona.setId(rs.getInt("id"));
                persona.setDni(rs.getString("dni"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido1(rs.getString("apellido1"));
                persona.setApellido2(rs.getString("apellido2"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCp(rs.getString("cp"));
                persona.setPoblacion(rs.getString("poblacion"));
                persona.setProvincia(rs.getString("provincia"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setEmail(rs.getString("email"));
                persona.setTipo(rs.getInt("tipo"));
                result.add(persona);
            }
            
        }
        
        return result;
    }

    @Override
    public int update(Personal a) throws SQLException {
        String sql="""
                  update personal
                  set id=?, dni=?, nombre=?, apellido1=?, apellido2=?, direccion=?, cp=?, poblacion=?, provincia=?, telefono=?, email=?, tipo=?
                   where id=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, a.getId());
            pstm.setString(2, a.getDni());
            pstm.setString(3, a.getNombre());
            pstm.setString(4, a.getApellido1());
            pstm.setString(5, a.getApellido2());
            pstm.setString(6, a.getDireccion());
            pstm.setString(7, a.getCp());
            pstm.setString(8, a.getPoblacion());
            pstm.setString(9, a.getProvincia());
            pstm.setString(10, a.getTelefono());
            pstm.setString(11, a.getEmail());
            pstm.setInt(12, a.getTipo());
            pstm.setInt(13, a.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM personal WHERE id=?";
        int result = 0;
        
        try (Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);) {
            
            pstm.setInt(1, id);
            result = pstm.executeUpdate();
            
        }
    }

    @Override
    public int moverAntiguo(Personal a) throws SQLException {
         String sql="""
                  insert into personalAntiguo (dni, nombre, apellido1,apellido2,direccion, cp, poblacion, provincia, telefono, email, tipo)
                  values (?,?,?,?,?,?,?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setString(5, a.getDireccion());
            pstm.setString(6, a.getCp());
            pstm.setString(7, a.getPoblacion());
            pstm.setString(8, a.getProvincia());
            pstm.setString(9, a.getTelefono());
            pstm.setString(10, a.getEmail());
            pstm.setInt(11, a.getTipo());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public List<Personal> getAllAntiguos() throws SQLException {
         Personal persona=null;
        String sql="select distinct * from personalAntiguo order by id ";
        
        List<Personal> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                persona = new Personal();
                
                persona.setId(rs.getInt("id"));
                persona.setDni(rs.getString("dni"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido1(rs.getString("apellido1"));
                persona.setApellido2(rs.getString("apellido2"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCp(rs.getString("cp"));
                persona.setPoblacion(rs.getString("poblacion"));
                persona.setProvincia(rs.getString("provincia"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setEmail(rs.getString("email"));
                persona.setTipo(rs.getInt("tipo"));
                result.add(persona);
            }
            
        }
        
        return result;
    }

    @Override
    public int getIdByDni(String dni) throws SQLException {
        int id =0;
        String sql="select id from personal where dni=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, dni);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                
                id = rs.getInt("id");
                
                
                
            }
            
        }
        
        return id;
    }
    
}
