package fr.templategenerator.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.templategenerator.MainClass;
import fr.templategenerator.model.Template;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
    
    private List<Template> templatesListe;
    
    private List<Button> buttonsList;
    
    int i = 0;
    
    
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
	
	
	public void initializeData() {
		
buttonsList = new ArrayList<Button>();
templatesListe = new ArrayList<Template>();
		
		for(i=0; i<20; i++) {
			Button button = new Button("Template "+i);
			Template template = new Template("Template "+i, i, "Voici le Template n°"+i);
			button.setOnAction(new EventHandler() {

				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					templateValeur.setText(template.getTemplate().get());
				}
				
			});
			vbox1.getChildren().add(button);
			buttonsList.add(button);
		}
		
		
	}
	
	
    //Méthode qui sera utilisée dans l'initialisation de l'IHM 
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
       // On lie notre liste observable au composant TableView

       initializeData();
    }
}