package com.unisabio.conexiones_bd.admin_conects.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.unisabio.conexiones_bd.Configuracion;

public class MysqlConectBD {
     private static String url = Configuracion.obtenerValor("db.url");
    private static String username = Configuracion.obtenerValor("db.username");
    private static String password = Configuracion.obtenerValor("db.password");
    private static Connection connection;

    public static Connection getInstance() throws SQLException {

        return connection = DriverManager.getConnection(url, username, password);

    }

}
