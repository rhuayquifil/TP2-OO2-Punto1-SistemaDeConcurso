package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;
import modelo.Almacenamiento;
import modelo.GuardaDato;

public class FakeBaseDeDatoGuardaDato implements GuardaDato {

	private String resultado;
	private Almacenamiento properties;
	private String sqlInsertRegistro;

	public FakeBaseDeDatoGuardaDato(Almacenamiento properties, String sqlInsertRegistro) {
		super();
		this.resultado = "";
		this.properties = properties;
		this.sqlInsertRegistro = sqlInsertRegistro;
	}

	@Override
	public void copiar(String registro) throws GuardaDatoExceptions, BaseDeDatosExceptions, IOException {

		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
				properties.get("contrasena"));
				java.sql.PreparedStatement state = conn.prepareStatement(sqlInsertRegistro)) {

			resultado = registro;

			int cantidad = state.executeUpdate();

			if (cantidad <= 0) {
				throw new GuardaDatoExceptions("error al ingresar Registro");
			}

		} catch (SQLException | NumberFormatException e) {
			throw new BaseDeDatosExceptions("error al prosesar consulta");
		}
	}

	String resultado() {
		return resultado;
	}
}
