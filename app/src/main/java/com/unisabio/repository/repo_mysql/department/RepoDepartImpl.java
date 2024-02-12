package com.unisabio.repository.repo_mysql.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unisabio.conexiones_bd.admin_conects.mysql.MysqlConectBD;
import com.unisabio.repository.RepositoryDepartment;
import com.unisabio.repository.models.models_extends.Department;

public class RepoDepartImpl implements RepositoryDepartment {
    
private Connection getConnection() throws SQLException {
        return MysqlConectBD.getInstance();
    }

    @Override
    public List<Department> listar() {

        List<Department> listDepartments = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DEPARTMENTS")) {
            while (rs.next()) {
                listDepartments.add(crearDepartment(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listDepartments;

    }

    @Override
    public Department porId(int id) {
        Department depart = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM DEPARTMENTS WHERE id_department=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    depart = crearDepartment(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depart;

    }

    @Override
    public void crear(Department departamento) {

        String sql = "INSERT INTO DEPARTMENTS(name_department) VALUES(?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, departamento.getNombre());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    @Override
    public void editar(Department departamento, int id) {

        String sql = "UPDATE DEPARTMENTS SET name_department=? WHERE id_department=?";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, departamento.getNombre());
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Department departamento, int id) {
        String sql = "DELETE FROM DEPARTMENTS WHERE id_department=?";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Department crearDepartment(ResultSet rs) throws SQLException {
        Department depart = new Department();
        depart.setNombre(rs.getString("name_department"));
        return depart;
    }


}
