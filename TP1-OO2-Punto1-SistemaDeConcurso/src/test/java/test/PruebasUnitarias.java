package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import exceptions.ConcursoExceptions;
import modelo.Concurso;
import modelo.Participante;

class PruebasUnitarias {

//	@Test
//	void Un_participante_se_inscribe_en_un_concurso() {
//		Participante primerParticipante = new Participante(41321062, "rodrigo");
//
//		LocalDate fecha = LocalDate.now();
//
//		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-10);
//		LocalDate fecha_fin_inscripcion = fecha.plusDays(20);
//
//		Concurso miConcurso = new Concurso("Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion);
//
//		try {
//			miConcurso.inscribirParticipante(primerParticipante);
//		} catch (ConcursoExceptions e) {
//			fail("Participante no se inscribio al concurso");
//		}
//
//		assertEquals(true, miConcurso.estaInscripto(primerParticipante));
//	}

//	@Test
//	void Un_participante_se_inscribe_en_un_concurso_el_primer_día_de_abierta_la_inscripción() {
//		Participante primerParticipante = new Participante(41321062, "rodrigo");
//
//		LocalDate fecha_inicio_inscripcion = LocalDate.now();
//		LocalDate fecha_fin_inscripcion = fecha_inicio_inscripcion.plusDays(20);
//
//		Concurso miConcurso = new Concurso("Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion);
//
//		try {
//			miConcurso.inscribirParticipante(primerParticipante);
//
//			assertEquals(10, miConcurso.verPuntajeAcumulado(primerParticipante));
//
//		} catch (ConcursoExceptions e) {
//			fail("fallo el test");
//		}
//	}

	@Test
	void Un_participante_intenta_inscribirse_fuera_del_rango_de_inscripción() {
		Participante primerParticipante = new Participante(41321062, "rodrigo");

		LocalDate fecha = LocalDate.now();

		LocalDate fecha_inicio_inscripcion = fecha.plusDays(-30);
		LocalDate fecha_fin_inscripcion = fecha.plusDays(-2);

		Concurso miConcurso = new Concurso("Mi Primer Concurso", fecha_inicio_inscripcion, fecha_fin_inscripcion);

		try {
			miConcurso.inscribirParticipante(primerParticipante);

			fail("fallo, se inscribio el participante");
		} catch (ConcursoExceptions e) {
			assertEquals("No se pudo inscribir participante. Fuera del las fechas limites de inscripcion",
					e.getMessage());
		}
	}
}
