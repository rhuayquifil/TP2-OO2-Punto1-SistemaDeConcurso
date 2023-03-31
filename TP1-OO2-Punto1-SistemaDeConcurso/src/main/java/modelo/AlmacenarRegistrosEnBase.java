package modelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;

public class AlmacenarRegistrosEnBase implements GuardaDato {

	private Almacenamiento properties;
	private String sqlInsertRegistro;

	public AlmacenarRegistrosEnBase(Almacenamiento properties, String sqlInsertRegistro) {
		super();
		this.properties = properties;
		this.sqlInsertRegistro = sqlInsertRegistro;
	}

	@Override
	public void copiar(String registro) throws GuardaDatoExceptions, BaseDeDatosExceptions, IOException {

		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
				properties.get("contrasena"));
				java.sql.PreparedStatement state = conn.prepareStatement(sqlInsertRegistro)) {

//			"INSERT INTO registro (fecha, id_participante, id_concurso)" + "VALUES (?, ?, ?);"

			String[] parts = registro.split(" , ");

			java.sql.Date fechaRegistro = java.sql.Date.valueOf(parts[0]);
			state.setDate(1, fechaRegistro);

			state.setInt(2, Integer.valueOf(parts[1]));

			state.setInt(3, Integer.valueOf(parts[2]));

			int cantidad = state.executeUpdate();

			if (cantidad <= 0) {
				throw new GuardaDatoExceptions("error al ingresar Registro");
			}

		} catch (SQLException | NumberFormatException e) {
			throw new BaseDeDatosExceptions("error al prosesar consulta");
		}
	}

}
