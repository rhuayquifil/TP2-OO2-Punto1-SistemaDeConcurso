package modelo;

import java.io.IOException;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;

public interface GuardaDato {

	void copiar(String registro) throws GuardaDatoExceptions, BaseDeDatosExceptions, IOException;
}
