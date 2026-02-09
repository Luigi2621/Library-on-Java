package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    
    protected Connection conexion;
    // Usar la nueva clase driver
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    // Especificar la base de datos en la URL (reemplaza 'nombre_base_de_datos')
    private final String DB_URL = "jdbc:mysql://localhost/ibooks?useSSL=false&serverTimezone=UTC";
    
    private final String USER = "root";
    private final String PASS = "thisisrootserver2020";
    
    public void Conectar() throws ClassNotFoundException { 
        try {System.out.println("Conexión exitosa");
            // Cargar el driver primero (opcional en versiones recientes)
            Class.forName(JDBC_DRIVER);
            // Luego establecer la conexión
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Cerrar() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }
}