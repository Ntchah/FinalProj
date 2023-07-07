package scene;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import resource.AudioManager;
import resource.AudioManager.Audios;
import resource.ImageManager;
import resource.ImageManager.Images;
import utility.Configuration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MainMenuScene {

	private Canvas canvas;
	private GraphicsContext gc;
	private static StackPane root;
	private Stage stage;
	private MenuButtonList button;
	private static Scene scene;
	private static SettingScene setting;
	
	
	public MainMenuScene(Stage stage) {
		
		this.stage = stage;
		canvas = new Canvas(Configuration.GAME_WIDTH, Configuration.GAME_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		button = new MenuButtonList();
		setting = new SettingScene();
		setting.getVolumeSlider().setValue(50);
		setUp();
		
	}
	
	public void setBackground(Image image) {
		
		gc.drawImage(image, 0, 0, Configuration.GAME_WIDTH, Configuration.GAME_HEIGHT);

	}
	
	public void draw(GraphicsContext gc) {
		
		root = new StackPane();
		root.setPrefSize(Configuration.GAME_WIDTH, Configuration.GAME_HEIGHT);
		root.getChildren().addAll(canvas);
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Balloons Battle");
		stage.setResizable(false);
		
	}
	
	
	public void setUp() {
		

		button.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				root.getChildren().add(new MapSelectScene());
				AudioManager.getSoundTrack(Audios.BUTTON_CLICKED).play();
				
			}
			
		});
		
		button.getHelpButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				root.getChildren().add(new HelpScene());
				AudioManager.getSoundTrack(Audios.BUTTON_CLICKED).play();


				
			}
			
		});
		
		button.getSettingButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				root.getChildren().add(setting);
				AudioManager.getSoundTrack(Audios.BUTTON_CLICKED).play();
				
			}
			
		});
		
		button.getCreditButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				root.getChildren().add(new CreditScene());
				AudioManager.getSoundTrack(Audios.BUTTON_CLICKED).play();
				
				

			}
			
		});
		
		button.getQuitButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				root.getChildren().add(new ExitScene());
				AudioManager.getSoundTrack(Audios.BUTTON_CLICKED).play();

			}
			
		});
		
		setBackground(ImageManager.getImage(Images.MAIN_MENU));
		draw(gc);
		root.getChildren().add(button);
		
	}

	public static StackPane getRoot() {
		
		return root;
		
	}

	public static Scene getScene() {
		return scene;
	}

	public static SettingScene getSetting() {
		return setting;
	}
	
}
