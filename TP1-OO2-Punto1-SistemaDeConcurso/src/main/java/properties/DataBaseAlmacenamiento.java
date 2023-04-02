package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import exceptions.PropertiesExceptions;
import modelo.Almacenamiento;

public class DataBaseAlmacenamiento implements Almacenamiento {

	private Properties propiedades;

	public DataBaseAlmacenamiento(String urlDataBaseProperties) throws PropertiesExceptions {
		try {
			propiedades = new Properties();

			propiedades.load(new FileInputStream(urlDataBaseProperties));

		} catch (FileNotFoundException e) {
			throw new PropertiesExceptions("Error, El archivo no exite");
		} catch (IOException e) {
			throw new PropertiesExceptions("Error, No se puede leer el archivo");
		}
	}

	public String get(String key) {
		return propiedades.getProperty(key);
	}

}
