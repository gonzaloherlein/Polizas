package ar.edu.unlam.pb2.recuperatorio;

public interface SegurosDeVida {

	void agregarBeneficiario(Persona hijo, TipoDeBeneficiario hijo2);

	Integer obtenerCantidadDeBeneficiarios();

	Double getPremio();

}
