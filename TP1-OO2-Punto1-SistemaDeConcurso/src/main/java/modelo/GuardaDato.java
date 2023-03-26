package modelo;

import java.io.IOException;

public interface GuardaDato {

	void copiar(String datosAGuardar) throws IOException;

	void copiar(Participante participante, Concurso concurso);
}
