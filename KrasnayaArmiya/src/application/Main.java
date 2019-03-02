package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Anime");
		Group root = new Group();
		Scene Animesc = new Scene(root);
		primaryStage.setScene(Animesc);
		
		Canvas canvas = new Canvas(512,512);
		root.getChildren().add(canvas);
		
		Image earth = new Image("earth.png");
		Image sun = new Image("sun.png");
		Image space = new Image("space.png");
		Image Venus = new Image("Venus.png");
		
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		//gc.drawImage(space,0,0);
		//gc.drawImage(sun,196,196);
		//gc.drawImage(earth,400,400);
		//primaryStage.show();
		
		final long startTime = System.nanoTime();
		
		new AnimationTimer() {

			@Override
			public void handle(long t) {

				double diff = (t - startTime)/1000000000.0;
				double x1 = 215 + 128*diff;
				double y1 = 230 + 128*Math.sin(diff);
				double x2 = 215 + (200*Math.cos(diff))/1.2;
				double y2 = 230 + 200*Math.sin(diff);
				gc.drawImage(space,0,0);
				gc.drawImage(earth,x1,y1);
				gc.drawImage(sun,196,196);
				gc.drawImage(Venus,x2,y2);
			}
			
		}.start();
		
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
