package com.unisabio.repository.repo_mysql.period;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.unisabio.conexiones_bd.admin_conects.mysql.MysqlConectBD;
import com.unisabio.repository.RepositoryPeriodo;
import com.unisabio.repository.models.models_extends.Periodo;

public class RepositoryPeriodoMysqlImpl implements RepositoryPeriodo {

    private Connection getConnection() throws SQLException {
        return MysqlConectBD.getInstance();
    }

    @Override
    public List<Periodo> listar() {
        List<Periodo> listPeriodoes = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM PERIODS")) {
            while (rs.next()) {
                listPeriodoes.add(crearPeriodo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listPeriodoes;
    }

    @Override
    public Periodo porId(int Id) {
        
        Periodo periodo = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PERIODS WHERE id_period=?")) {
            stmt.setInt(1, Id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                  periodo = crearPeriodo(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return periodo;

    }


    @Override
    public void crear(Periodo periodo) {
        String sql = "INSERT INTO PERIODS(year_period,semester) VALUES(?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,periodo.getAnio());
            stmt.setInt(2,periodo.getSemestre());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    @Override
    public void editar(Periodo periodo, int id) {
        String sql = "UPDATE PERIODS SET code_period = ?,year_period = ?, semester = ? WHERE id_course=?";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1,periodo.getCod());
                    stmt.setString(2,periodo.getAnio());
                    stmt.setInt(3,periodo.getSemestre());
                    stmt.setInt(4, id);
                    stmt.executeUpdate();       
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Periodo periodo, int id) {
        String sql = "DELETE FROM PERIODS WHERE id_period=?";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Periodo crearPeriodo(ResultSet rs) throws SQLException {
        
        Periodo periodo = new Periodo();

        periodo.setSemestre(rs.getInt("semester"));
        periodo.setCod(rs.getString("code_period"));
        periodo.setAnio(String.valueOf(LocalDate.parse( rs.getString("year_period")).getYear()));

        return periodo;
    }

    
} 

    

