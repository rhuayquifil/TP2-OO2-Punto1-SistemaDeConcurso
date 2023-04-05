package main;

import java.io.IOException;
import java.time.LocalDate;

import exceptions.AlmacenamientoExceptions;
import exceptions.ConcursoExceptions;
import modelo.BaseDeDatoGuardaDato;
import modelo.Concurso;
import modelo.EmailRegistroNotificacion;
import modelo.Participante;
import properties.DataBaseAlmacenamiento;

public class Main {

	public static void main(String[] args) {
		Participante primerParticipante = new Participante(41321062, "rodrigo", "ezehuayquifil@hotmail.com");
		Participante segundoParticipante = new Participante(12345678, "mana", "mana@gmail.com");

		LocalDate fecha = LocalDate.now();
		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-8);
		LocalDate fecha_fin_inscripcion = fecha.plusDays(2);

		try {
			// COPIA REGISTROS EN .TXT

//			Concurso miConcurso = new Concurso(1, "Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
//					new DiscoGuardaDato("C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt"),
//					new EmailRegistroNotificacion("524def57d07409", "a0f84bcbd4913c", "sandbox.smtp.mailtrap.io"));

			// COPIA REGISTROS EN .DATABASE

			DataBaseAlmacenamiento properties = new DataBaseAlmacenamiento("jdbc:mysql://127.0.0.1/sistema_de_concurso",
					"root", "");

			Concurso miConcurso = new Concurso(1, "R.E.H Servicio Tecnico", fecha_inicio_inscripcion,
					fecha_fin_inscripcion,
					new BaseDeDatoGuardaDato(properties,
							"INSERT INTO registro (fecha, id_participante, id_concurso)" + "VALUES (?, ?, ?);"),
					new EmailRegistroNotificacion("524def57d07409", "a0f84bcbd4913c", "sandbox.smtp.mailtrap.io"));

			miConcurso.inscribirParticipante(primerParticipante);
			miConcurso.inscribirParticipante(segundoParticipante);

		} catch (ConcursoExceptions e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (AlmacenamientoExceptions e) {
			System.out.println(e.getMessage());
		}
	}
}
