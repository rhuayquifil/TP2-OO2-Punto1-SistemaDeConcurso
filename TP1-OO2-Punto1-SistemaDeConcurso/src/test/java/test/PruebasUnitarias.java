package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import FakeObject.EmailFakeNotificacion;
import exceptions.ConcursoExceptions;
import modelo.AlmacenarRegistrosEnDisco;
import modelo.Concurso;
import modelo.Participante;

class PruebasUnitarias {

	@Test
	void Un_participante_se_inscribe_en_un_concurso() {
		Participante primerParticipante = new Participante(41321062, "rodrigo", "ezehuayquifil@hotmail.com");

		LocalDate fecha = LocalDate.now();

		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-10);
		LocalDate fecha_fin_inscripcion = fecha.plusDays(20);

		try {

//			el test debe correr sin escribir en disco
//			o en la base de datos o enviar el email de forma verdadera

			Concurso miConcurso = new Concurso(1, "Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
					new AlmacenarRegistrosEnDisco(
							"C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt"),
					new EmailFakeNotificacion("524def57d07409", "a0f84bcbd4913c", "sandbox.smtp.mailtrap.io"));

			//
			miConcurso.inscribirParticipante(primerParticipante);

			assertEquals(true, miConcurso.estaInscripto(primerParticipante));

		} catch (ConcursoExceptions e) {
			fail("Participante no se inscribio al concurso");
		} catch (FileNotFoundException e) {
			fail("exceptions FileNotFoundException");
		} catch (IOException e) {
			fail("exceptions IOException");
		}
	}

//	@Test
//	void Un_participante_se_inscribe_en_un_concurso_el_primer_día_de_abierta_la_inscripción() {
//		Participante primerParticipante = new Participante(12345678, "manu");
//
//		LocalDate fecha_inicio_inscripcion = LocalDate.now();
//		LocalDate fecha_fin_inscripcion = fecha_inicio_inscripcion.plusDays(20);
//
//		try {
//
//			Concurso miConcurso = new Concurso(1, "Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
//					new Copiador(System.in, new FileOutputStream(
//							new File("C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt"), true)));
//
//			miConcurso.inscribirParticipante(primerParticipante);
//
//			assertEquals(10, miConcurso.verPuntajeAcumulado(primerParticipante));
//
//		} catch (ConcursoExceptions e) {
//			fail("Participante no se inscribio al concurso");
//		} catch (FileNotFoundException e) {
//			fail("exceptions FileNotFoundException");
//		} catch (IOException e) {
//			fail("exceptions IOException");
//		}
//	}

//	@Test
//	void Un_participante_intenta_inscribirse_fuera_del_rango_de_inscripción() {
//		Participante primerParticipante = new Participante(87654321, "franco");
//
//		LocalDate fecha = LocalDate.now();
//
//		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-30);
//		LocalDate fecha_fin_inscripcion = fecha.plusDays(-2);
//
//		try {
//
//			Concurso miConcurso = new Concurso(1, "Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion,
//					new Copiador(System.in, new FileOutputStream(
//							new File("C:\\Users\\ezehu\\git\\TP1-OO2-Punto1-SistemaDeConcurso\\salida.txt"), true)));
//
//			miConcurso.inscribirParticipante(primerParticipante);
//
//			fail("fallo, se inscribio el participante");
//
//		} catch (ConcursoExceptions e) {
//			assertEquals("No se pudo inscribir participante. Fuera del las fechas limites de inscripcion",
//					e.getMessage());
//		} catch (FileNotFoundException e) {
//			fail("exceptions FileNotFoundException");
//		} catch (IOException e) {
//			fail("exceptions IOException");
//		}
//	}
}
