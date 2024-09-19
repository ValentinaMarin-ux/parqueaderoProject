package parqueaderoApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	private static final String URL = "jdbc:mysql://localhost:3306/parqueadero";
	private static final String USER = "root";
	private static final String PASSWORD = "Miau";

	public static void main(String[] args) {
	 try {
	 Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
	 Statement statement = connection.createStatement();
	 
	 
	 // Crear
	 String insertSQL = "INSERT INTO vehiculo (placa,color,marca,cc,id_descripcion) VALUES ('JLP427', 'Negro','mazda', 1500,2  )";
	 statement.executeUpdate(insertSQL);
	 String insertSQLMoto = "INSERT INTO vehiculo (placa,color,marca,cc,id_descripcion) VALUES ('IEE230', 'blanco','yamaha', 1000,1  )";
	 statement.executeUpdate(insertSQLMoto);
	 
	 
	// Leer
	 String selectSQL = "SELECT * FROM vehiculo";
	 ResultSet resultSet = statement.executeQuery(selectSQL);
	 while (resultSet.next()) {
	 String placa = resultSet.getString("placa");
	 String color = resultSet.getString("color");
	 String marca = resultSet.getString("marca");
	 int cc = resultSet.getInt("cc");
	 int idDescripcion = resultSet.getInt("id_descripcion");
	 System.out.println("Placa: " + placa + ", color: " + color + ", marca: " + marca
			 + ", cc: " + cc + ", Tipo: " + idDescripcion);
	 }
	 
    // Actualizar
	 String updateSQL = "UPDATE vehiculo SET color = 'Rojo' WHERE placa =  'JLP427'";
	 statement.executeUpdate(updateSQL);

	// Eliminar
	 String deleteSQL = "DELETE FROM vehiculo WHERE placa = 'IEE230'";
	 statement.executeUpdate(deleteSQL);
	 
	
	
	 
	 resultSet.close();
	 statement.close();
	 connection.close();
	 
	 
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	}
}
