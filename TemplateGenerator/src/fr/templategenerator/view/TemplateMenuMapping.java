package fr.templategenerator.view;

import java.io.IOException;

import fr.templategenerator.MainClass;
import fr.templategenerator.model.Template;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TemplateMenuMapping {
	
    @FXML
    private MenuItem nouveauMenuItem;

    private MainClass main;

    public TemplateMenuMapping() { }
    
    @FXML
    private void initialize() {
        	    
    	    
    }
    

	
	
    //Méthode qui sera utilisée dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
     
    }
    

	//Fermer l'application
	@FXML
	public void fermer() {
		//On affiche un message car on est poli.
		Alert bye = new Alert(AlertType.INFORMATION);
		bye.setTitle("Au revoir !");
		bye.setHeaderText("See you soon...");
		bye.setContentText("Et merci d'avoir suivi ce cours");
		bye.showAndWait();
		
		//Et on clos le stage principal, donc l'application
		this.main.getStage().close();
	}
	

	
	public void nouveau() {
		
		//On affiche la popup avec une personne inexistante
	    this.main.initialisationNewTemplate(new Template(), "Création d'une personne");
				/*
				try {
				    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTemplateView.fxml"));
				    Parent root1 = (Parent) fxmlLoader.load();
				    Stage stage = new Stage();

				    NewTemplateMapping childController = fxmlLoader.getController();
				  
				    //stage.initModality(Modality.APPLICATION_MODAL);
				    //stage.initStyle(StageStyle.UNDECORATED);
				    stage.setTitle("ABC");
				    stage.setScene(new Scene(root1));  
				    stage.initOwner(nouveauMenuItem.getParentPopup().getScene().getWindow());
				    stage.showAndWait();
				    
				    Template nouveauTemplate = childController.getCurrentTemplate();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					
				}
				*/
			}
			
	public MenuItem getNouveauMenuItem() {
		return this.nouveauMenuItem;
	}

}
