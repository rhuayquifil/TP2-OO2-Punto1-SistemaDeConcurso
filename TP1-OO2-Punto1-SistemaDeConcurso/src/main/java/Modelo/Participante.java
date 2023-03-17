package Modelo;

import java.util.Objects;

public class Participante {

	private int dni;
	private String nombre;
	
	public Participante(int dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Participante [dni=" + dni + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		return dni == other.dni;
	}
}
