/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.CursoAcademico;
import com.iesiliberis.crudcentroeducativo.entidades.Matricula;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MatriculaDaoImp implements MatriculaDao {

    private static MatriculaDaoImp instance;
    
    static{
        instance=new MatriculaDaoImp();
    }
    
    private MatriculaDaoImp(){ }
    
    public static MatriculaDaoImp getInstance(){
        return instance;
    }
    
    
    @Override
    public int add(Matricula a) throws SQLException {
      
        String sql="""
                  insert into matricula(idalumno, idunidad, descripcion, fMatricula, fBaja)
                  values (?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, a.getIdalumno());
            pstm.setInt(2, a.getIdunidad());
            pstm.setString(3, a.getDescripcion());
            pstm.setDate(4, (Date) a.getfMatricula());
            pstm.setDate(5, (Date) a.getfBaja());
            result=pstm.executeUpdate();
            
        }
        
        return result;
        
        
    }

    @Override
    public Matricula getById(int id) throws SQLException {
        Matricula matri =null;
        String sql="select * from matricula where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                matri = new Matricula();
                
                matri.setIdmatricula(rs.getInt("idmatricula"));
                matri.setIdalumno(rs.getInt("idalumno"));
                matri.setIdunidad(rs.getInt("idunidad"));
                matri.setDescripcion(rs.getString("descripcion"));
                matri.setfMatricula(rs.getDate("fMatricula"));
                matri.setfBaja(rs.getDate("fBaja"));
                
            }
            
        }
        
        return matri;
    }

    @Override
    public List<Matricula> getAll() throws SQLException {
        Matricula matri=null;
        String sql="select distinct * from matricula ";
        
        List<Matricula> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                matri =new Matricula();
                
                matri.setIdmatricula(rs.getInt("idmatricula"));
                matri.setIdalumno(rs.getInt("idalumno"));
                matri.setIdunidad(rs.getInt("idunidad"));
                matri.setDescripcion(rs.getString("descripcion"));
                matri.setfMatricula(rs.getDate("fMatricula"));
                matri.setfBaja(rs.getDate("fBaja"));
                
                result.add(matri);
            }
            
        }
        
        return result; 
    }

    @Override
    public int update(Matricula a) throws SQLException {
         String sql="""
                  update matricula
                  set idmatricula=?, idalumno=?, idunidad=?, descripcion=?, fMatricula=?, fBaja=?
                   where id=?
                   """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, a.getIdmatricula());
            pstm.setInt(2, a.getIdalumno());
            pstm.setInt(3, a.getIdunidad());
            pstm.setString(4, a.getDescripcion());
            pstm.setDate(5, (Date) a.getfMatricula());
            pstm.setDate(6, (Date) a.getfBaja());
            pstm.setInt(7, a.getIdmatricula());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}