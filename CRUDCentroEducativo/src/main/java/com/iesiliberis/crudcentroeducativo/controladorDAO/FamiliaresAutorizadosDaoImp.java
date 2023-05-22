/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.FamiliaresAutorizados;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvar
 */
public class FamiliaresAutorizadosDaoImp implements FamiliaresAutorizadosDao {

    private static FamiliaresAutorizadosDaoImp instance;

    static {
        instance = new FamiliaresAutorizadosDaoImp();
    }

    private FamiliaresAutorizadosDaoImp() {
    }

    public static FamiliaresAutorizadosDaoImp getInstance() {
        return instance;
    }
    
    @Override
    public List<FamiliaresAutorizados> getAll() throws SQLException {
        FamiliaresAutorizados fami = null;
        String sql = "select * from autorizaciones ";

        List<FamiliaresAutorizados> result = new ArrayList();

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                fami = new FamiliaresAutorizados();

                fami.setIdalumno(rs.getInt("idalumno"));
                fami.setIdautorizado(rs.getInt("idautorizado"));

                result.add(fami);
            }

        }

        return result;
    }

    @Override
    public int add(FamiliaresAutorizados f) throws SQLException {
        AlumnoDaoImp alum = AlumnoDaoImp.getInstance();
        int idAlumno = alum.getByDni(f.getDniAlumno());

        AutorizadosDaoImp autori = AutorizadosDaoImp.getInstance();
        int idAutorizado = autori.getIdByDni(f.getDniAutorizado());

        String sql = """
                  insert into autorizaciones(idalumno, idautorizado)
                  values (?,?)
                  """;
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, idAlumno);
            pstm.setInt(2, idAutorizado);
            
            result = pstm.executeUpdate();

        }

        return result;
    }
    
}
