package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import exceptions.PropertiesExceptions;
import modelo.GuardaDato;

public class DataBase implements GuardaDato {

	private Properties propiedades;

	public DataBase(String urlDatabaseProperties) throws PropertiesExceptions {
		try {
			propiedades = new Properties();

			propiedades.load(new FileInputStream(urlDatabaseProperties));

		} catch (FileNotFoundException e) {
			throw new PropertiesExceptions("Error, El archivo no exite");
		} catch (IOException e) {
			throw new PropertiesExceptions("Error, No se puede leer el archivo");
		}
	}

	public String get(String key) {
		return propiedades.getProperty(key);
	}

	@Override
	public void copiar(String datosAGuardar) throws IOException {
//		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
//				properties.get("contrasena"));
//				java.sql.PreparedStatement state = conn.prepareStatement(sqlInsertCatalogo)) {
//
//			state.setInt(1, 0);
//			state.setString(2, catalogo.getNombre());
//			state.setInt(3, catalogo.getCantidadDeProductos());
//
//			if (catalogo.isEstado()) {
//				state.setInt(4, 1);
//			} else {
//				state.setInt(4, 0);
//			}
//
//			int cantidad = state.executeUpdate();
//
//			if (cantidad > 0) {
////				throw new DAOExceptions("Catalogo ingresado con exito");
//			} else {
//				throw new DAOExceptions("error al ingresar Catalogo");
//			}
//
//		} catch (SQLException e) {
//			throw new BaseDeDatosExceptions("error al prosesar consulta");
//		}

	}

}
