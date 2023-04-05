package properties;

import java.util.Objects;
import java.util.Properties;

import exceptions.AlmacenamientoExceptions;
import modelo.Almacenamiento;

public class DataBaseAlmacenamiento implements Almacenamiento {

	private Properties propiedades;

//	"C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\TP1-OO2-Punto1-SistemaDeConcurso\\src\\main\\java\\properties\\database.properties"

	public DataBaseAlmacenamiento(String urlBaseDeDatos, String usuario, String contrasena)
			throws AlmacenamientoExceptions {

		if (Objects.isNull(urlBaseDeDatos)) {
			throw new AlmacenamientoExceptions("Datos nulos");
		}

		if (Objects.isNull(usuario)) {
			throw new AlmacenamientoExceptions("Datos nulos");
		}

		if (Objects.isNull(contrasena)) {
			throw new AlmacenamientoExceptions("Datos nulos");
		}

		propiedades = new Properties();

		propiedades.put("url", urlBaseDeDatos);
		propiedades.put("usuario", usuario);
		propiedades.put("contrasena", contrasena);
	}

	public String get(String key) {
		return propiedades.getProperty(key);
	}

}
