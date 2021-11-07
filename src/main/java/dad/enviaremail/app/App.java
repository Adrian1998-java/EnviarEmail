package dad.enviaremail.app;

import dad.enviaremail.control.EnviarEmailController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	EnviarEmailController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new EnviarEmailController();
		
		Scene scene = new Scene(controller.getView());
		
		primaryStage.setTitle("Enviar email");
		primaryStage.getIcons().add(new Image("/images/email-send-icon-32x32.png"));
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
