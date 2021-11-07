package dad.enviaremail.control;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EnviarEmailModel {

	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty remitente = new SimpleStringProperty();
	private StringProperty destinatario = new SimpleStringProperty();
	private StringProperty asunto = new SimpleStringProperty();
	private StringProperty asuntoArea = new SimpleStringProperty();
	private StringProperty puerto = new SimpleStringProperty();
	private StringProperty passwrd = new SimpleStringProperty();
	
	private BooleanProperty conexion = new SimpleBooleanProperty();

	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	

	public final String getNombre() {
		return this.nombreProperty().get();
	}
	

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	

	public final StringProperty remitenteProperty() {
		return this.remitente;
	}
	

	public final String getRemitente() {
		return this.remitenteProperty().get();
	}
	

	public final void setRemitente(final String remitente) {
		this.remitenteProperty().set(remitente);
	}
	

	public final StringProperty destinatarioProperty() {
		return this.destinatario;
	}
	

	public final String getDestinatario() {
		return this.destinatarioProperty().get();
	}
	

	public final void setDestinatario(final String destinatario) {
		this.destinatarioProperty().set(destinatario);
	}
	

	public final StringProperty asuntoProperty() {
		return this.asunto;
	}
	

	public final String getAsunto() {
		return this.asuntoProperty().get();
	}
	

	public final void setAsunto(final String asunto) {
		this.asuntoProperty().set(asunto);
	}
	

	public final StringProperty asuntoAreaProperty() {
		return this.asuntoArea;
	}
	

	public final String getAsuntoArea() {
		return this.asuntoAreaProperty().get();
	}
	

	public final void setAsuntoArea(final String asuntoArea) {
		this.asuntoAreaProperty().set(asuntoArea);
	}
	

	public final StringProperty puertoProperty() {
		return this.puerto;
	}
	

	public final String getPuerto() {
		return this.puertoProperty().get();
	}
	

	public final void setPuerto(final String puerto) {
		this.puertoProperty().set(puerto);
	}
	

	public final StringProperty passwrdProperty() {
		return this.passwrd;
	}
	

	public final String getPasswrd() {
		return this.passwrdProperty().get();
	}
	

	public final void setPasswrd(final String passwrd) {
		this.passwrdProperty().set(passwrd);
	}
	

	public final BooleanProperty conexionProperty() {
		return this.conexion;
	}
	

	public final boolean isConexion() {
		return this.conexionProperty().get();
	}
	

	public final void setConexion(final boolean conexion) {
		this.conexionProperty().set(conexion);
	}
}
