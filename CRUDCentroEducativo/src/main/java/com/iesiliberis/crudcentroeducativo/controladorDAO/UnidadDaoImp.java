/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Unidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UnidadDaoImp implements UnidadDao {

    private static UnidadDaoImp instance;
    
    static{
        instance=new UnidadDaoImp();
    }
    
    private UnidadDaoImp(){ }
    
    public static UnidadDaoImp getInstance(){
        return instance;
    }
    
    
    
    @Override
    public int add(Unidad a) throws SQLException {
       
        String sql="""
                  insert into unidad (codigo, nombre, Observaciones, idcurso, idtutor, idaula)
                  values (?,?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, a.getCodigo());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getObservaciones());
            pstm.setInt(4, a.getIdcurso());
            pstm.setInt(5, a.getIdtutor());
            pstm.setInt(6, a.getIdaula());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
          
        
    }

    @Override
    public Unidad getById(int id) throws SQLException {
        Unidad uni=null;
        String sql="select * from unidad where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                uni=new Unidad();
                
                uni.setId(rs.getInt("id"));
                uni.setCodigo(rs.getString("codigo"));
                uni.setNombre(rs.getString("nombre"));
                uni.setObservaciones(rs.getString("Observaciones"));
                uni.setIdcurso(rs.getInt("idcurso"));
                uni.setIdtutor(rs.getInt("idtutor"));
                uni.setIdaula(rs.getInt("idaula"));
                
            }
            
        }
        
        return uni;
    }

    @Override
    public List<Unidad> getAll() throws SQLException {
        Unidad uni =null;
        String sql="select * from unidad ";
        
        List<Unidad> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                uni=new Unidad();
                
                uni.setId(rs.getInt("id"));
                uni.setCodigo(rs.getString("codigo"));
                uni.setNombre(rs.getString("nombre"));
                uni.setObservaciones(rs.getString("Observaciones"));
                uni.setIdcurso(rs.getInt("idcurso"));
                uni.setIdtutor(rs.getInt("idtutor"));
                uni.setIdaula(rs.getInt("idaula"));
                result.add(uni);
            }
            
        }
        
        return result; 
    }

    @Override
    public int update(Unidad a) throws SQLException {
       
        String sql="""
                  update unidad
                  set id=?, codigo=?, nombre=?, Observaciones=?, idcurso=?, idtutor=?, idaula=?
                   where id=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, a.getId());
            pstm.setString(2, a.getCodigo());
            pstm.setString(3, a.getNombre());
            pstm.setString(4, a.getObservaciones());
            pstm.setInt(5, a.getIdcurso());
            pstm.setInt(6, a.getIdtutor());
            pstm.setInt(7, a.getIdaula());
            pstm.setInt(8, a.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
