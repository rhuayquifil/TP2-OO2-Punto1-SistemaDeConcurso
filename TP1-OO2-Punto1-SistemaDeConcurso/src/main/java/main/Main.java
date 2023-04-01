package main;

import java.io.IOException;
import java.time.LocalDate;

import exceptions.ConcursoExceptions;
import exceptions.PropertiesExceptions;
import modelo.AlmacenarRegistrosEnBase;
import modelo.Concurso;
import modelo.EmailRegistroInscripcion;
import modelo.Participante;
import properties.DataBase;

public class Main {

	public static void main(String[] args) {
		Participante primerParticipante = new Participante(41321062, "rodrigo", "ezehuayquifil@hotmail.com");
		Participante segundoParticipante = new Participante(12345678, "mana", "mana@gmail.com");

//		System.out.println(primerParticipante);

		LocalDate fecha = LocalDate.now();
		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-8);
		LocalDate fecha_fin_inscripcion = fecha.plusDays(2);

//		System.out.println(fecha_inicio_inscripcion + " " + fecha_fin_inscripcion);

		try {
			// COPIA REGISTROS EN .TXT

//			Concurso miConcurso = new Concurso(1, "Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
//					new AlmacenarRegistrosEnDisco(
//							"C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt"),
//					new EmailRegistroInscripcion("524def57d07409", "a0f84bcbd4913c", "sandbox.smtp.mailtrap.io"));

			DataBase properties = new DataBase(
					"C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\TP1-OO2-Punto1-SistemaDeConcurso\\src\\main\\java\\properties\\database.properties");

			// COPIA REGISTROS EN .DATABASE

//			Concurso miConcurso = new Concurso(1, "R.E.H Servicio Tecnico", fecha_inicio_inscripcion,
//					fecha_fin_inscripcion, new AlmacenarRegistrosEnBase(properties,
//							"INSERT INTO registro (fecha, id_participante, id_concurso)" + "VALUES (?, ?, ?);"));

			// COPIA REGISTROS EN .DATABASE CON NOTIFICACION VIA EMAIL

			Concurso miConcurso = new Concurso(1, "R.E.H Servicio Tecnico", fecha_inicio_inscripcion,
					fecha_fin_inscripcion,
					new AlmacenarRegistrosEnBase(properties,
							"INSERT INTO registro (fecha, id_participante, id_concurso)" + "VALUES (?, ?, ?);"),
					new EmailRegistroInscripcion("524def57d07409", "a0f84bcbd4913c", "sandbox.smtp.mailtrap.io"));

			miConcurso.inscribirParticipante(primerParticipante);
//			miConcurso.inscribirParticipante(segundoParticipante);
//			System.out.println(miConcurso.verPuntajeAcumulado(segundoParticipante));

//			System.out.println(miConcurso);
		} catch (PropertiesExceptions e) {
			System.out.println(e.getMessage());
		} catch (ConcursoExceptions e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
