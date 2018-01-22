package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
	        root.setAlignment(Pos.CENTER);
	        root.setHgap(10);
	        root.setVgap(10);
	        root.setPadding(new Insets(25, 25, 25, 25));
			
			Button btn = new Button();
	        btn.setText("Do Something");
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("TCSS-360-Shenanigans");
					alert.setHeaderText(null);
					alert.setContentText("'Something' has just been done in a JIT manner. You're welcome!");

					alert.showAndWait();
	            }
	        });
	        root.add(btn, 0, 1);

	        Text scenetitle = new Text("TCSS-360-Shenanigans");
	        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	        root.add(scenetitle, 0, 0, 1, 1);
	        
			Scene scene = new Scene(root,400,400);
			primaryStage.setTitle("TCSS-360-Shenanigans");
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); 
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
