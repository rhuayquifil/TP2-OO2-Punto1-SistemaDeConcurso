package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import exceptions.ConcursoExceptions;
import modelo.Concurso;
import modelo.Copiador;
import modelo.Participante;

public class Main {

	public static void main(String[] args) {
		Participante primerParticipante = new Participante(41321062, "rodrigo");
		Participante segundoParticipante = new Participante(12345678, "mana");

//		System.out.println(primerParticipante);

		LocalDate fecha = LocalDate.now();
		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-8);
		LocalDate fecha_fin_inscripcion = fecha.plusDays(2);

//		System.out.println(fecha_inicio_inscripcion + " " + fecha_fin_inscripcion);

		try {
//			Concurso miConcurso = new Concurso("Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
//					new Copiador(System.in, new FileOutputStream(new File("\"C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt\""))));

			Concurso miConcurso = new Concurso(1, "Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
					new Copiador(System.in, new FileOutputStream(
							new File("C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt"), true)));
			miConcurso.inscribirParticipante(primerParticipante);
			miConcurso.inscribirParticipante(segundoParticipante);
//			System.out.println(miConcurso.verPuntajeAcumulado(segundoParticipante));

//			Copiador miCopiador = new Copiador(System.in, new FileOutputStream(
//					new File("C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt")));
//			miCopiador.copiar();

//			C:\Users\ezehu\git\TP1-OO2-Punto1-SistemaDeConcurso\salida.txt

			// TENES QUE HACER FUNCIONAR EL COPIADOR

//			System.out.println(miConcurso);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ConcursoExceptions e) {
			System.out.println(e.getMessage());
		}

	}

}
