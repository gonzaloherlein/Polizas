package ar.edu.unlam.pb2.recuperatorio;

public class Vivienda extends Bien{
		private String calle;
		private String localidad;
		private String municipio;
		private String provincia;
		
		public Vivienda(String calle, String localidad, String municipio, String provincia) {
			this.calle = calle;
			this.localidad = localidad;
			this.municipio = municipio;
			this.provincia = provincia;
		}

		public String getCalle() {
			return calle;
		}

		public void setCalle(String calle) {
			this.calle = calle;
		}

		public String getLocalidad() {
			return localidad;
		}

		public void setLocalidad(String localidad) {
			this.localidad = localidad;
		}

		public String getMunicipio() {
			return municipio;
		}

		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}

		public String getProvincia() {
			return provincia;
		}

		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}
		
		
}
