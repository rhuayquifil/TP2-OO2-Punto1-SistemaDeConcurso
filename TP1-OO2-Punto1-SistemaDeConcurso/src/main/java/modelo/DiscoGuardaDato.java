package modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;

public class DiscoGuardaDato implements GuardaDato {

	private String rutaArchivo;

	public DiscoGuardaDato(String rutaArchivo) {
		super();
		this.rutaArchivo = rutaArchivo;
	}

	@Override
	public void copiar(String registro) throws GuardaDatoExceptions, BaseDeDatosExceptions, IOException {
		OutputStream output = new FileOutputStream(new File(rutaArchivo), true);

		String guardar = registro + '\n';
		output.write(guardar.getBytes());
	}
}
