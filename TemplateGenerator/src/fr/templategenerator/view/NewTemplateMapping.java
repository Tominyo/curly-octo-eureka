package fr.templategenerator.view;

import java.util.ArrayList;
import java.util.List;

import fr.templategenerator.MainClass;
import fr.templategenerator.model.Template;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class NewTemplateMapping {
  
    
    //Objet servant de r�f�rence � notre classe principale
    //afin de pouvoir r�cup�rer la liste de nos objets.
    private MainClass main;

    //Un constructeur par d�faut
    public NewTemplateMapping() { }

    //M�thode qui initialise notre interface graphique
    //avec nos donn�es m�tier
    
    @FXML
    private void initialize() {
        // Initialize the Personne table with the two columns.
        	    
    	    
    }
    
	
	
    //M�thode qui sera utilis�e dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
        // On lie notre liste observable au composant TableView
    }
}