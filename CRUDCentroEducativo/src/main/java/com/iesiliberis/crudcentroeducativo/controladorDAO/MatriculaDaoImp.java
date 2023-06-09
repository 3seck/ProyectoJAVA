/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Matricula;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDaoImp implements MatriculaDao {

    private static MatriculaDaoImp instance;

    static {
        instance = new MatriculaDaoImp();
    }

    private MatriculaDaoImp() {
    }

    public static MatriculaDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(Matricula a) throws SQLException {

        AlumnoDaoImp alum = AlumnoDaoImp.getInstance();
        int idAlumno = alum.getByDni(a.getDniAlumno());

        UnidadDaoImp uni = UnidadDaoImp.getInstance();
        int idUnidad = uni.getIdByCod(a.getCodUnidad());

        String sql = """
                  insert into matricula(idalumno, idunidad, descripcion, fMatricula, fBaja)
                  values (?,?,?,?,?)
                  """;
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, idAlumno);
            pstm.setInt(2, idUnidad);
            pstm.setString(3, a.getDescripcion());
            pstm.setDate(4, new java.sql.Date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()));
            if (a.getfBaja() != null) {
                pstm.setDate(5, new java.sql.Date(a.getfBaja().getTime()));
            } else {
                pstm.setDate(5, null);
            }
            result = pstm.executeUpdate();

        }

        return result;

    }

    @Override
    public Matricula getById(int id) throws SQLException {
        Matricula matri = null;
        String sql = "select * from matricula where idmatricula=?";

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
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
        Matricula matri = null;
        String sql = "select * from matricula ";

        List<Matricula> result = new ArrayList();

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                matri = new Matricula();

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
        String sql = """
                  update matricula
                  set idmatricula=?, idalumno=?, idunidad=?, descripcion=?, fMatricula=?, fBaja=?
                   where id=?
                   """;
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, a.getIdmatricula());
            pstm.setInt(2, a.getIdalumno());
            pstm.setInt(3, a.getIdunidad());
            pstm.setString(4, a.getDescripcion());
            pstm.setDate(5, (Date) a.getfMatricula());
            pstm.setDate(6, (Date) a.getfBaja());
            pstm.setInt(7, a.getIdmatricula());

            result = pstm.executeUpdate();

        }

        return result;
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM matricula WHERE idmatricula=? ";
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            result = pstm.executeUpdate();

        }

    }

    @Override
    public List<Matricula> getbyAlumno(int idAlumno) throws SQLException {
        List<Matricula> matriculas = new ArrayList<>();
        String sql = "SELECT * FROM matricula WHERE idalumno = ?";

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {
            pstm.setInt(1, idAlumno);

            try ( ResultSet rs = pstm.executeQuery();) {
                while (rs.next()) {
                    Matricula m = new Matricula();
                    m.setIdmatricula(rs.getInt("id"));
                    m.setIdalumno(rs.getInt("idalumno"));
                    m.setIdunidad(rs.getInt("idunidad"));
                    m.setDescripcion(rs.getString("descripcion"));
                    m.setfMatricula(rs.getDate("fMatricula"));
                    m.setfBaja(rs.getDate("fBaja"));

                    matriculas.add(m);
                }
            }
        }

        return matriculas;

    }

    @Override
    public List<Matricula> getByUnidadCodigo(String codigoUnidad) throws SQLException {
        List<Matricula> lst = new ArrayList<>();
        String sql = "SELECT * FROM matricula WHERE idunidad = (SELECT id FROM unidad WHERE codigo = ?)";
        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {
            pstm.setString(1, codigoUnidad);
            try ( ResultSet rs = pstm.executeQuery();) {
                while (rs.next()) {
                    Matricula mat = new Matricula();
                    mat.setIdmatricula(rs.getInt("id"));
                    mat.setIdalumno(rs.getInt("idalumno"));
                    mat.setIdunidad(rs.getInt("idunidad"));
                    mat.setDescripcion(rs.getString("descripcion"));
                    mat.setfMatricula(rs.getDate("fMatricula"));
                    mat.setfBaja(rs.getDate("fBaja"));
                    lst.add(mat);
                }
            }
        }
        return lst;
    }

    @Override
    public int darBaja(int id) throws SQLException {

        String sql = """
          insert into matriculabaja (idmatricula, idalumno, idunidad, descripcion, fmatricula, fBaja)
          select idmatricula, idalumno, idunidad, descripcion, fmatricula, curdate()
          from matricula
          where idmatricula=? ;           
          """;
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            result = pstm.executeUpdate();
        }

        return result;

    }

    @Override
    public int getIdByCodUnidadyDni(String codUnidad, String dni) throws SQLException {

        int idMatricula = 0;

        AlumnoDaoImp alum = AlumnoDaoImp.getInstance();
        int idAlumno = alum.getByDni(dni);

        UnidadDaoImp uni = UnidadDaoImp.getInstance();
        int idUnidad = uni.getIdByCod(codUnidad);

        String sql = "select idmatricula from matricula where idalumno=? and idunidad=?";

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {
            pstm.setInt(1, idAlumno);
            pstm.setInt(2, idUnidad);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                idMatricula = rs.getInt("idmatricula");
            }
        }

        return idMatricula;
    }

    
    //Se orddena a traves de join no por la lista de ID curso 
    @Override
    public List<Matricula> getMatriculaByCursoAca(int idcursoaca) throws SQLException {
        Matricula matri = null;
        String sql = """
                     SELECT m.*
                     FROM matricula m 
                     inner JOIN unidad ON m.idunidad = unidad.id
                     inner join curso on curso.id=unidad.idcurso
                     inner join cursoacademico on  cursoacademico.id=curso.idcursoacademico
                     where cursoacademico.id=?""";

        List<Matricula> result = new ArrayList();

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, idcursoaca);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                matri = new Matricula();

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

}
