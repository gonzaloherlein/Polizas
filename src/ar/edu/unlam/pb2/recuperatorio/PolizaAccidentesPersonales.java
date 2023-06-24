package ar.edu.unlam.pb2.recuperatorio;

import java.util.HashMap;
import java.util.Map;

public class PolizaAccidentesPersonales extends Poliza implements SegurosDeVida {

		private Persona asegurado;
		private Double sumaAsegurada;
		private Double prima;
		private Map<Persona, TipoDeBeneficiario> personas;
		
		public PolizaAccidentesPersonales(Integer nroPoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
			super(nroPoliza);
			this.asegurado = asegurado;
			this.sumaAsegurada = sumaAsegurada;
			this.prima = prima;
			this.personas = new HashMap<Persona, TipoDeBeneficiario>();
		}

		public Integer getNroPoliza() {
			return super.getNroPoliza();
		}

		public void setNroPoliza(Integer nroPoliza) {
			super.setNroPoliza(nroPoliza);
		}

		public Persona getAsegurado() {
			return asegurado;
		}

		public void setAsegurado(Persona asegurado) {
			this.asegurado = asegurado;
		}

		public Double getSumaAsegurada() {
			return sumaAsegurada;
		}

		public void setSumaAsegurada(Double sumaAsegurada) {
			this.sumaAsegurada = sumaAsegurada;
		}

		public Double getPrima() {
			return prima;
		}

		public void setPrima(Double prima) {
			this.prima = prima;
		}

		@Override
		public void agregarBeneficiario(Persona hijo, TipoDeBeneficiario tipoBeneficiario) {
			this.personas.put(hijo, tipoBeneficiario);
		}

		@Override
		public Integer obtenerCantidadDeBeneficiarios() {
			return this.personas.size();
		}

		@Override
		public Double getPremio() {
			return getPrima() + 1000;
		}
		
		
}
