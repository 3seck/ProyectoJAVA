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

    static {
        instance = new UnidadDaoImp();
    }

    private UnidadDaoImp() {
    }

    public static UnidadDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(Unidad a) throws SQLException {
        // Obtener los ids correspondientes al código del curso, el DNI del personal y el cod del aula
        CursoDaoImp cursoDao = CursoDaoImp.getInstance();
        int idCurso = cursoDao.getIdByCodigo(a.getCodCurso());

        PersonalDaoImp personalDao = PersonalDaoImp.getInstance();
        int idPersonal = personalDao.getIdByDni(a.getDniTutor());

        AulaDaoImp aulaDao = AulaDaoImp.getInstance();
        int idAula = aulaDao.getByCodigo(a.getCodAula());

        // Crear la consulta SQL para agregar la unidad
        String sql = "INSERT INTO unidad (codigo, nombre, Observaciones, idcurso, idtutor, idaula) VALUES (?, ?, ?, ?, ?, ?)";
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {
            pstm.setString(1, a.getCodigo());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getObservaciones());
            pstm.setInt(4, idCurso);
            pstm.setInt(5, idPersonal);
            pstm.setInt(6, idAula);

            result = pstm.executeUpdate();
        }

        return result;
    }

    @Override
    public Unidad getById(int id) throws SQLException {
        Unidad uni = null;
        String sql = "select * from unidad where id=?";

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                uni = new Unidad();

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
        Unidad uni = null;
        String sql = "select * from unidad ";

        List<Unidad> result = new ArrayList();

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                uni = new Unidad();

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

        // Obtener el valor id a partir del valor de codCurso
        CursoDaoImp cursoDao = CursoDaoImp.getInstance();
        int idCurso = cursoDao.getIdByCodigo(a.getCodCurso());

        // Obtener los valores de "idtuto" e "idaula" a partir de los valores de "dniTutor" y "codAula"
        PersonalDaoImp personalDao = PersonalDaoImp.getInstance();
        int idTutor = personalDao.getIdByDni(a.getDniTutor());

        AulaDaoImp aulaDao = AulaDaoImp.getInstance();
        int idAula = aulaDao.getByCodigo(a.getCodAula());

        // actualizar la unidad
        String sql = "UPDATE unidad SET codigo = ?, nombre = ?, Observaciones = ?, idcurso = ?, idtutor = ?, idaula = ? WHERE id = ?";
        int result = 0;

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {
            pstm.setString(1, a.getCodigo());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getObservaciones());
            pstm.setInt(4, idCurso);
            pstm.setInt(5, idTutor);
            pstm.setInt(6, idAula);
            pstm.setInt(7, a.getId());

            result = pstm.executeUpdate();
        }

        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Unidad> getByCursoAca(int idcurso) throws SQLException {
        Unidad uni = null;
        String sql = " select * from unidad where idcurso = ?";

        List<Unidad> result = new ArrayList();

        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, idcurso);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                uni = new Unidad();

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
    public int getIdByCod(String codigo) throws SQLException {
        String sql = "select id from unidad where codigo=?";
        int id = 0;

        try ( Connection cn = MyDataSource.getConnection(); 
              PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, codigo);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                id = rs.getInt("id");

            }
        }
        return id;
    }

}
