package fr.templategenerator;

import java.io.IOException;

import fr.templategenerator.model.Template;
import fr.templategenerator.view.NewTemplateMapping;
import fr.templategenerator.view.TemplateMapping;
import fr.templategenerator.view.TemplateMenuMapping;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainClass extends Application {

	//Nous créons des variable de classes afin de pouvoir y accéder partout
	//Ceci afin de pouvoir y positionner les éléments que nous avons fait
	//Il y a un BorderPane car le conteneur principal de notre IHM
	//est un BorderPane, nous reparlerons de l'objet Stage
	private Stage stagePrincipal;
	private Scene mainScene;
	private Scene optionScene;
	private BorderPane conteneurPrincipal;
	private TemplateMapping controleur;

	@Override
	public void start(Stage primaryStage) throws IOException {
		stagePrincipal = primaryStage;
		//Ca ne vous rappelle pas une JFrame ?
		stagePrincipal.setTitle("Générateur de Template");
		
		//Nous allons utiliser nos fichier FXML dans ces deux méthodes
		
		initialisationConteneurPrincipal();
		initialisationContenu();
		
	}

	private void initialisationConteneurPrincipal() {
		//On créé un chargeur< de FXML
		FXMLLoader loader = new FXMLLoader();
		//On lui spécifie le chemin relatif à notre classe
		//du fichier FXML a charger : dans le sous-dossier view
		loader.setLocation(MainClass.class.getResource("view/ConteneurPrincipal.fxml"));
		try {
			//Le chargement nous donne notre conteneur
			conteneurPrincipal = (BorderPane) loader.load();
			//On définit une scène principale avec notre conteneur
			Scene scene = new Scene(conteneurPrincipal);
			//Que nous affectons à notre Stage
			stagePrincipal.setScene(scene);
			
			//Initialisation de notre contrôleur
			TemplateMenuMapping controleur = loader.getController();
			//On spécifie la classe principale afin de pour récupérer le Stage
			//Et ainsi fermer l'application
			controleur.setMainApp(this);
			
			stagePrincipal.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialisationContenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/GeneratorView.fxml"));
		try {
			//Nous récupérons notre conteneur qui contiendra les données
			//Pour rappel, c'est un AnchorPane...
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();
			//Qui nous ajoutons à notre conteneur principal
			//Au centre, puisque'il s'agit d'un BorderPane
			conteneurPrincipal.setCenter(conteneurPersonne);
			
			//Nous récupérons notre mappeur via l'objet FXMLLoader
			controleur = loader.getController();
			//Nous lui passons notre instance de classe
			//pour qu'il puisse récupérer notre liste observable
			controleur.setMainApp(this);
			
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Méthode qui va va afficher la popup d'édition
	//ou de création d'une personne et initialiser son contrôleur
	public void initialisationNewTemplate(Template temp, String titre) {
	    try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainClass.class.getResource("view/NewTemplateView.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        
	        // Création d'un nouveau Stage qui sera dépendant du Stage principal
	        Stage stageDialogue = new Stage();
	        stageDialogue.setTitle(titre);
	        stageDialogue.initModality(Modality.WINDOW_MODAL);
	        
	        //Avec cette instruction, notre fenêtre modifiée sera modale
	        //par rapport à notre stage principal
	        //stageDialogue.initOwner(stagePrincipal);
	        Scene scene = new Scene(page);
	        stageDialogue.setScene(scene);
	        
	        // initialisation du contrôleur
	        NewTemplateMapping controller = loader.getController();
	        //On passe la personne avec laquelle nous souhaitons travailler
	        //une existante ou une nouvelle
	        controller.setTemplate(temp);
	        controller.setMainApp(this);
	        
	        // Show the dialog and wait until the user closes it
	        stageDialogue.showAndWait();
	        //return controller.isOkClicked();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}

	
	public static void main(String[] args) {
		launch(args);
	}
	

	
	private ObservableList<Template> listeDeTemplate = FXCollections.observableArrayList();
	
	public MainClass() {
		listeDeTemplate.add(new Template("Code HTML", 1, "<!Doctype>...."));
		listeDeTemplate.add(new Template("Code XML", 2, "<?xml endoding:utf-8 ?>...."));

	}
		
	public ObservableList<Template> getListDeTemplate(){return listeDeTemplate;}
	
	public void addTemplate(Template temp) {
		listeDeTemplate.add(temp);
	}
	
	public void afficherNewTemplate() {
		stagePrincipal.setScene(optionScene);
	}
	
	public void afficherMain() {
		stagePrincipal.setScene(mainScene);
	}
	
	public Stage getStage() {
		return stagePrincipal;
	}
	
	public TemplateMapping getControl() {
		return controleur;
	}
	
	
}
