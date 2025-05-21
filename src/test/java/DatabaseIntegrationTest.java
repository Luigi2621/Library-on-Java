import org.junit.jupiter.api.*;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseIntegrationTest {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        // Establecer conexión con la base de datos
        connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        
        // Crear tabla de prueba (si no existe)
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "nombre VARCHAR(50) NOT NULL, " +
                    "email VARCHAR(100) UNIQUE)");
        }
    }

    @AfterEach
    void tearDown() throws SQLException {
        // Limpiar datos después de cada test
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("DELETE FROM usuarios WHERE nombre = 'Test User'");
        }
        
        // Cerrar conexión
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    void testInsertAndSelect() throws SQLException {
        // Insertar registro
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO usuarios (nombre, email) VALUES (?, ?)")) {
            
            pstmt.setString(1, "Test User");
            pstmt.setString(2, "test@example.com");
            int affectedRows = pstmt.executeUpdate();
            
            assertEquals(1, affectedRows);
        }

        // Verificar inserción
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE nombre = 'Test User'")) {
            
            assertTrue(rs.next());
            assertEquals("test@example.com", rs.getString("email"));
        }
    }

    @Test
    void testUpdate() throws SQLException {
        // Insertar datos de prueba
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO usuarios (nombre, email) VALUES (?, ?)")) {
            
            pstmt.setString(1, "Test User");
            pstmt.setString(2, "old@example.com");
            pstmt.executeUpdate();
        }

        // Actualizar email
        try (PreparedStatement pstmt = connection.prepareStatement(
                "UPDATE usuarios SET email = ? WHERE nombre = ?")) {
            
            pstmt.setString(1, "new@example.com");
            pstmt.setString(2, "Test User");
            int affectedRows = pstmt.executeUpdate();
            
            assertEquals(1, affectedRows);
        }

        // Verificar actualización
        try (PreparedStatement pstmt = connection.prepareStatement(
                "SELECT email FROM usuarios WHERE nombre = ?")) {
            
            pstmt.setString(1, "Test User");
            ResultSet rs = pstmt.executeQuery();
            
            assertTrue(rs.next());
            assertEquals("new@example.com", rs.getString("email"));
        }
    }

    @Test
    void testDelete() throws SQLException {
        // Insertar datos de prueba
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO usuarios (nombre, email) VALUES (?, ?)")) {
            
            pstmt.setString(1, "Test User");
            pstmt.setString(2, "delete@example.com");
            pstmt.executeUpdate();
        }

        // Eliminar registro
        try (PreparedStatement pstmt = connection.prepareStatement(
                "DELETE FROM usuarios WHERE nombre = ?")) {
            
            pstmt.setString(1, "Test User");
            int affectedRows = pstmt.executeUpdate();
            
            assertEquals(1, affectedRows);
        }

        // Verificar eliminación
        try (PreparedStatement pstmt = connection.prepareStatement(
                "SELECT COUNT(*) FROM usuarios WHERE nombre = ?")) {
            
            pstmt.setString(1, "Test User");
            ResultSet rs = pstmt.executeQuery();
            
            assertTrue(rs.next());
            assertEquals(0, rs.getInt(1));
        }
    }
}