package modelo;

import java.io.IOException;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;

public interface GuardaDato {

	void copiar(Participante participante, Concurso concurso)
			throws GuardaDatoExceptions, BaseDeDatosExceptions, IOException;
}
