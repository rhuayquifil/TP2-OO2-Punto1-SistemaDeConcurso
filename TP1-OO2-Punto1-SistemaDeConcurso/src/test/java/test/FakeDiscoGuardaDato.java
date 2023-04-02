package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;
import modelo.GuardaDato;

public class FakeDiscoGuardaDato implements GuardaDato {

	private String resultado;
	private String rutaArchivo;

	public FakeDiscoGuardaDato(String rutaArchivo) {
		super();
		this.resultado = "";
		this.rutaArchivo = rutaArchivo;
	}

	@Override
	public void copiar(String registro) throws GuardaDatoExceptions, BaseDeDatosExceptions, IOException {
		OutputStream output = new FileOutputStream(new File(rutaArchivo), true);

		resultado = registro;
	}

	String resultado() {
		return resultado;
	}
}
