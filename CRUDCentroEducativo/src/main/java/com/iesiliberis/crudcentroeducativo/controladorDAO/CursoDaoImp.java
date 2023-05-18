/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Curso;
import com.iesiliberis.crudcentroeducativo.entidades.CursoAcademico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDaoImp implements CursoDao {

    private static CursoDaoImp instance;

    static {
        instance = new CursoDaoImp();
    }

    private CursoDaoImp() {
    }

    public static CursoDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(Curso c) throws SQLException {
        String sql = """
                  insert into curso(codigo,nombre,Observaciones,idcursoacademico)
                  values (?,?,?,?)
                  """;
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, c.getCodigo());
            pstm.setString(2, c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4, c.getIdcursoacademico());

            result = pstm.executeUpdate();

        }

        return result;
    }

    @Override
    public Curso getById(int id) throws SQLException {
        Curso curso = null;
        String sql = "select * from curso where id=?";

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            try ( ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    curso = new Curso();

                    curso.setId(rs.getInt("id"));
                    curso.setCodigo(rs.getString("codigo"));
                    curso.setNombre(rs.getString("nombre"));
                    curso.setObservaciones(rs.getString("Observaciones"));
                    curso.setIdcursoacademico(rs.getInt("idcursoacademico"));
                }
            }

        }

        return curso;
    }

    @Override
    public List<Curso> getAll() throws SQLException {
        Curso cursoaca = null;
        String sql = "select * from curso";

        List<Curso> result = new ArrayList();

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cursoaca = new Curso();

                cursoaca.setCodigo(rs.getString("Codigo"));
                cursoaca.setNombre(rs.getString("Nombre"));
                cursoaca.setObservaciones(rs.getString("Observaciones"));

                result.add(cursoaca);
            }
        }
        return result;

    }

    @Override
    public List<Curso> getAllByCursoAcademico(int idcursoacademico) throws SQLException {

        Curso cursoaca = null;
        String sql = "select * from curso where idcursoacademico = ?";

        List<Curso> result = new ArrayList();
        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, idcursoacademico);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Curso c = new Curso();
                c.setId(rs.getInt("id"));
                c.setCodigo(rs.getString("codigo"));
                c.setNombre(rs.getString("nombre"));
                c.setObservaciones(rs.getString("Observaciones"));
                c.setIdcursoacademico(rs.getInt("idcursoacademico"));

                result.add(c);
            }
        }
        return result;
    }

    @Override
    public int update(Curso a) throws SQLException {
        String sql = """
                  update curso
                  set codigo=?, nombre=?, observaciones=?
                   where id=?
                   """;
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, a.getCodigo());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getObservaciones());
            pstm.setInt(4, a.getId());

            result = pstm.executeUpdate();

        }

        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CursoAcademico getCursoAcademico(Curso cu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Curso getcodigoById(int id) throws SQLException {
        Curso curso = null;
        String sql = "select * from curso where id=?";

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                curso = new Curso();

                curso.setId(rs.getInt("id"));
                curso.setCodigo(rs.getString("codigo"));
                curso.setNombre(rs.getString("nombre"));
                curso.setObservaciones(rs.getString("Observaciones"));
                curso.setIdcursoacademico(rs.getInt("idcursoacademico"));

            }

        }
        return curso;
    }

    @Override
    public int getIdByCodigo(String codigo) throws SQLException {

        String sql = "select id from curso where codigo=?";
        int id = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, codigo);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                id = rs.getInt("id");

            }
        }
        return id;
    }

    @Override
    public List<Integer> getIDsByCursoAca(int idCursoAcademico) throws SQLException {
        Integer id = null;
        String sql = "SELECT id FROM curso WHERE idcursoacademico = ?";

        List<Integer> result = new ArrayList<>();

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {
            pstm.setInt(1, idCursoAcademico);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
                result.add(id);
            }
        }
        return result;
    }
}
