package dad.enviaremail.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class EnviarEmailController implements Initializable {

	//Model
	private EnviarEmailModel model = new EnviarEmailModel(); 
	
	//View 
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

	
	public EnviarEmailController() throws IOException
	{
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
		
		puertoText.textProperty().bindBidirectional(model.puertoProperty());
		
		passwrdText.textProperty().bindBidirectional(model.passwrdProperty());
		
		conexionCheck.selectedProperty().bindBidirectional(model.conexionProperty());

	}

	public BorderPane getView() {
		return view;
	}
	
	@FXML
	void onCerrarButton(ActionEvent event) {

	}

	@FXML
	void onEnviarButton(ActionEvent event) {

	}

	@FXML
	void onVaciarButton(ActionEvent event) {

	}

}
