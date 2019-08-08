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
    
    
    //Objet servant de r�f�rence � notre classe principale
    //afin de pouvoir r�cup�rer la liste de nos objets.
    private MainClass main;

    //Un constructeur par d�faut
    public TemplateMapping() { }

    //M�thode qui initialise notre interface graphique
    //avec nos donn�es m�tier
    
    @FXML
    private void initialize() {
        // Initialize the Personne table with the two columns.
        	    
    	    
    }
    

	//M�thode qui va mettre les valeurs de notre objet dans les composants
	public void initializeDescription(Template p) {
		//On r�initialise par d�faut
		nomValeur.setText("");
		templateValeur.setText("");
		
		//Si un objet est pass� en param�tre, on modifie l'IHM
		if(p != null) {
			//ATTENTION : les accesseurs retournent des objets Property Java FX
			//Pour r�cup�rer leurs vrais valeurs vous devez utiliser la m�thode get()
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

    //M�thode qui sera utilis�e dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
        // On lie notre liste observable au composant TableView
        templateListe = new ArrayList<Template>();
       templateListe.add(main.getListDeTemplate().get(0));
       initializeButtons();
    }
}