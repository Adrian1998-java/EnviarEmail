package dad.enviaremail.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class EnviarEmailController implements Initializable {

	// Model
	private EnviarEmailModel model = new EnviarEmailModel();


	// View
	@FXML
	private BorderPane view;

	@FXML
	private TextField nombreText;

	@FXML
	private TextField remitenteText;

	@FXML
	private TextField destinatarioText;

	@FXML
	private TextField asuntoText;

	@FXML
	private CheckBox conexionCheck;

	@FXML
	private TextArea asuntoAreaText;

	@FXML
	private TextField puertoText;

	@FXML
	private PasswordField passwrdText;

	@FXML
	private Button enviarButton;

	@FXML
	private Button vaciarButton;

	@FXML
	private Button cerrarButton;

	public EnviarEmailController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EmailView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {

		nombreText.textProperty().bindBidirectional(model.nombreProperty());

		remitenteText.textProperty().bindBidirectional(model.remitenteProperty());

		destinatarioText.textProperty().bindBidirectional(model.destinatarioProperty());

		asuntoText.textProperty().bindBidirectional(model.asuntoProperty());

		asuntoAreaText.textProperty().bindBidirectional(model.asuntoAreaProperty());
		asuntoAreaText.setWrapText(true);

		puertoText.textProperty().bindBidirectional(model.puertoProperty());

		passwrdText.textProperty().bindBidirectional(model.passwrdProperty());

		conexionCheck.selectedProperty().bindBidirectional(model.conexionProperty());

		// PARA NO ESTAR TODO EL RATO RELLENANDO CAMPOS
		nombreText.setText("smtp.gmail.com");
		puertoText.setText("465");
		conexionCheck.setSelected(true);
		remitenteText.setText("dad.iesdpm@gmail.com");
		passwrdText.setText("chucknorri$21");
		destinatarioText.setText("scraggy1998@gmail.com");
		asuntoText.setText("Hola");
		asuntoAreaText.setText("Esto es un mensaje");

	}

	public BorderPane getView() {
		return view;
	}

	@FXML
	void onEnviarButton(ActionEvent event) {
		try {
			Email email = new SimpleEmail();
			
			email.setHostName(model.getNombre());
			email.setSmtpPort(Integer.parseInt(model.getPuerto()));
			email.setAuthenticator(new DefaultAuthenticator(model.getRemitente() , model.getPasswrd()));
			email.setSSLOnConnect(model.isConexion());
			email.setFrom(model.getRemitente());
			email.setSubject(model.getAsunto());
			email.setMsg(model.getAsuntoArea());
			email.addTo(model.getDestinatario());
			email.addTo(model.getDestinatario());

			email.send();

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Mensaje enviado");
			alert.setHeaderText("Mensaje Enviado con exito a '" + model.getDestinatario()+"'");
			alert.setContentText("");

			alert.showAndWait();

			destinatarioText.clear();
			asuntoText.clear();
			asuntoAreaText.clear();

		} catch (EmailException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("No se pudo enviar el email");
			alert.setContentText("Se ha dado el siguiente error: \n" + e);

			alert.showAndWait();
		}

	}

	@FXML
	void onVaciarButton(ActionEvent event) {

		nombreText.clear();
		remitenteText.clear();
		destinatarioText.clear();
		asuntoText.clear();
		asuntoAreaText.clear();
		puertoText.clear();
		passwrdText.clear();
		conexionCheck.setSelected(false);
	}

	@FXML
	void onCerrarButton(ActionEvent event) {
		System.exit(0);
	}
}
