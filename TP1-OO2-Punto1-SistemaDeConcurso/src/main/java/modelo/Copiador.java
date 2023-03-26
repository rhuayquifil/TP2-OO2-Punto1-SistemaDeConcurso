package modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Copiador implements GuardaDato {

	private InputStream input;
	private OutputStream output;

	public Copiador(InputStream input, OutputStream output) {
		super();
		this.input = input;
		this.output = output;
	}

	@Override
	public void copiar(String datosAGuardar) throws IOException {
		try (Scanner scanner = new Scanner(input)) {

//			output.write(scanner.nextLine().getBytes());

//			String saltoDeLinea = "\r\n";

			output.write(datosAGuardar.getBytes());
//			output.write(saltoDeLinea.getBytes());
		}
	}
}
