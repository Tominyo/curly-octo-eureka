package fr.templategenerator.view;

import java.io.IOException;

import fr.templategenerator.MainClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TemplateMenuMapping {
	
    @FXML
    private MenuItem nouveauMenuItem;
    
    //Objet servant de référence à notre classe principale
    //afin de pouvoir récupérer la liste de nos objets.
    private MainClass main;

    //Un constructeur par défaut
    public TemplateMenuMapping() { }

    //Méthode qui initialise notre interface graphique
    //avec nos données métier
    
    @FXML
    private void initialize() {
        // Initialize the Personne table with the two columns.
        	    
    	    
    }
    

	
	
    //Méthode qui sera utilisée dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
     
    }

	
	public void nouveau() {
				
				try {
				    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTemplateView.fxml"));
				    Parent root1 = (Parent) fxmlLoader.load();
				    Stage stage = new Stage();
				    //stage.initModality(Modality.APPLICATION_MODAL);
				    //stage.initStyle(StageStyle.UNDECORATED);
				    stage.setTitle("ABC");
				    stage.setScene(new Scene(root1));  
				    stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					
				}
			}
			

}
