package ar.edu.unlam.pb2.recuperatorio;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unlam.pb2.test.PolizaInexistente;

public class CompaniaDeSeguro {
		private String nombre;
		private Set<Poliza> polizas;
		
		public CompaniaDeSeguro(String nombre) {
			this.nombre = nombre;
			this.polizas = new HashSet<Poliza>();
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public void agregarPoliza(Poliza poliza) {
			this.polizas.add(poliza);
			
		}

		public Integer obtenerLaCantidadDePolizasEmitidas() {
			return this.polizas.size();
		}

		public Boolean denunciarSiniestro(Integer nroPoliza) throws PolizaInexistente {
			for (Poliza poliza : polizas) {
				if(poliza.getNroPoliza().equals(nroPoliza)) {
					if(poliza instanceof PolizaDeAuto) {
						poliza.setFueRobado(true);
						return true;
					}else {
						poliza.setTuvoAlgunAccidente(true);
						return true;
					}
	
				}
			}
			throw new PolizaInexistente("La poliza no existe");
		}
		
		
		public Poliza getPoliza(Integer nroPoliza) {
			for (Poliza poliza : polizas) {
				if(poliza.getNroPoliza().equals(nroPoliza)) {
					return poliza;
				}
			}
			return null;
		}
}
