/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.CursoAcademico;
import com.iesiliberis.crudcentroeducativo.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sergio
 */
public class UsuarioDaoImp implements UsuarioDao {

    private static UsuarioDaoImp instance;
    
    static{
        instance=new UsuarioDaoImp();
    }
    
    private UsuarioDaoImp(){ }
    
    public static UsuarioDaoImp getInstance(){
        return instance;
    }
    
    @Override
    public Usuario getById(int id) throws SQLException {
        Usuario usu=null;
        String sql="select * from usuario where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                usu=new Usuario();
                
                usu.setId(rs.getInt("id"));
                
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                
            }
            
        }
        
        return usu;
    }

    @Override
    public int add(Usuario u) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Usuario c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean valida(String Usuario, String password) throws SQLException {
        
        String sql="select * from usuario where usuario=? and password=? ";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, Usuario);
            pstm.setString(2, password);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
               return true;
                
            }
            
        }
        
        return false;
    }

   
    
}
