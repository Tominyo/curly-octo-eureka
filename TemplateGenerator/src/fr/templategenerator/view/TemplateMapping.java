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

public class TemplateMapping {
    @FXML
    private Label nomValeur;
    @FXML
    private TextArea templateValeur;
    @FXML
    private VBox vbox1;
    
    private List<Template> templateListe;
    
    
    //Objet servant de référence à notre classe principale
    //afin de pouvoir récupérer la liste de nos objets.
    private MainClass main;

    //Un constructeur par défaut
    public TemplateMapping() { }

    //Méthode qui initialise notre interface graphique
    //avec nos données métier
    
    @FXML
    private void initialize() {
        // Initialize the Personne table with the two columns.
        	    
    	    
    }
    

	//Méthode qui va mettre les valeurs de notre objet dans les composants
	public void initializeDescription(Template p) {
		//On réinitialise par défaut
		nomValeur.setText("");
		templateValeur.setText("");
		
		//Si un objet est passé en paramètre, on modifie l'IHM
		if(p != null) {
			//ATTENTION : les accesseurs retournent des objets Property Java FX
			//Pour récupérer leurs vrais valeurs vous devez utiliser la méthode get()
			nomValeur.setText(p.getNom().get());
			templateValeur.setText(p.getTemplate().get());
		}
	}
	
	public void initializeButtons() {
		
		Template template1 = templateListe.get(0);
		
		Button btn1 = new Button();
 	    btn1.setText(template1.getNom().get());
 	    btn1.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					templateValeur.setText(template1.getTemplate().get());
				}
 	    	
 	    });
 	    vbox1.getChildren().add(btn1);
	}

    //Méthode qui sera utilisée dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
        // On lie notre liste observable au composant TableView
        templateListe = new ArrayList<Template>();
       templateListe.add(main.getListDeTemplate().get(0));
       initializeButtons();
    }
}