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
import java.util.ArrayList;
import java.util.List;

public class AutorizadosDaoImp implements AutorizadosDao {

    private static AutorizadosDaoImp instance;

    static {
        instance = new AutorizadosDaoImp();
    }

    private AutorizadosDaoImp() {
    }

    public static AutorizadosDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(Autorizados a) throws SQLException {
        String sql = """
                  insert into autorizado(dni, nombre, apellido1, apellido2, parentesto)
                  values (?,?,?,?,?)
                  """;
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setString(5, a.getParentesco());

            result = pstm.executeUpdate();

        }

        return result;
    }

    @Override
    public Autorizados getById(int id) throws SQLException {
        Autorizados autoriz = null;
        String sql = "select * from autorizado where id=?";

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                autoriz = new Autorizados();

                autoriz.setId(rs.getInt("id"));
                autoriz.setDni(rs.getString("dni"));
                autoriz.setNombre(rs.getString("nombre"));
                autoriz.setApellido1(rs.getString("apellido1"));
                autoriz.setApellido2(rs.getString("apellido2"));
                autoriz.setParentesco(rs.getString("parentesto"));

            }

        }

        return autoriz;
    }

    @Override
    public List<Autorizados> getAll() throws SQLException {
        Autorizados auto = null;
        String sql = "select * from autorizado ";

        List<Autorizados> result = new ArrayList();

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                auto = new Autorizados();

                auto.setId(rs.getInt("id"));
                auto.setDni(rs.getString("dni"));
                auto.setNombre(rs.getString("nombre"));
                auto.setApellido1(rs.getString("apellido1"));
                auto.setApellido2(rs.getString("apellido2"));
                auto.setParentesco(rs.getString("parentesto"));
                result.add(auto);
            }

        }

        return result;
    }

    @Override
    public int update(Autorizados a) throws SQLException {
        String sql="""
                  update autorizado
                  set id=?, dni=?, nombre=?, apellido1=?, apellido2=?, parentesto=?
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
            pstm.setString(6, a.getParentesco());
            
            pstm.setInt(7, a.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM autorizado WHERE id=?";
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);
            result = pstm.executeUpdate();

        }
    }

    @Override
    public int getIdByDni(String dni) throws SQLException {
        int id = 0;
        String sql = "select id from autorizado where dni=?";

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, dni);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                id = rs.getInt("id");

            }

        }

        return id;
    }

}
