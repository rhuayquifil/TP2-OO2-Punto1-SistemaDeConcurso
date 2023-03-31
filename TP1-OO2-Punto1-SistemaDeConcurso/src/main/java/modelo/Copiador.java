package modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;

public class Copiador implements GuardaDato {

	private InputStream input;
	private OutputStream output;

	public Copiador(InputStream input, OutputStream output) {
		super();
		this.input = input;
		this.output = output;
	}

	@Override
	public void copiar(String registro) throws GuardaDatoExceptions, BaseDeDatosExceptions, IOException {
		String guardar = registro + '\n';
		output.write(guardar.getBytes());
	}
}
