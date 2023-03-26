package modelo;

import java.io.IOException;

public class almacenarRegistrosEnBase implements GuardaDato {

	private Almacenamiento properties;

	public almacenarRegistrosEnBase(Almacenamiento properties) {
		super();
		this.properties = properties;
	}

	@Override
	public void copiar(String datosAGuardar) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void copiar(Participante participante, Concurso concurso) {

	}

}
