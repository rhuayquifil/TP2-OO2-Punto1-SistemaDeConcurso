package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import exceptions.ConcursoExceptions;
import exceptions.PropertiesExceptions;
import modelo.Concurso;
import modelo.Copiador;
import modelo.Participante;

public class Main {

	public static void main(String[] args) {
		Participante primerParticipante = new Participante(41321062, "rodrigo");
//		Participante segundoParticipante = new Participante(12345678, "mana");

//		System.out.println(primerParticipante);

		LocalDate fecha = LocalDate.now();
		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-8);
		LocalDate fecha_fin_inscripcion = fecha.plusDays(2);

//		System.out.println(fecha_inicio_inscripcion + " " + fecha_fin_inscripcion);

		try {
			// COPIA REGISTROS EN .TXT

			Concurso miConcurso = new Concurso(1, "Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
					new Copiador(System.in, new FileOutputStream(
							new File("C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt"), true)));

			// COPIA REGISTROS EN .DATABASE

//			Concurso miConcurso = new Concurso(1, "Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
//					new DataBase(
//							"C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\TP1-OO2-Punto1-SistemaDeConcurso\\src\\main\\java\\properties\\database.properties"));

			miConcurso.inscribirParticipante(primerParticipante);
//			miConcurso.inscribirParticipante(segundoParticipante);
//			System.out.println(miConcurso.verPuntajeAcumulado(segundoParticipante));

//			System.out.println(miConcurso);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ConcursoExceptions e) {
			System.out.println(e.getMessage());
		} catch (PropertiesExceptions e) {
			System.out.println(e.getMessage());
		}

	}

}
