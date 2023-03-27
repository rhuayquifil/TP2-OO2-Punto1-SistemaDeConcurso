package modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
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
	public void copiar(Participante participante, Concurso concurso) throws IOException {
		try (Scanner scanner = new Scanner(input)) {

			String registro = LocalDate.now() + " , " + participante.id() + " , " + concurso.id() + '\n';

			output.write(registro.getBytes());
		}
	}
}
