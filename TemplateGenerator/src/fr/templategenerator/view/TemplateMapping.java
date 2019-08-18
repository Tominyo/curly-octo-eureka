package fr.templategenerator.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.templategenerator.MainClass;
import fr.templategenerator.model.Template;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
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
    	
    }

	
	public void initializeData() {
		
		Path source = Paths.get("");
		
		List<String> result = new ArrayList<>();
		try (Stream<Path> walk = Files.walk(Paths.get("templates"))) {

			result = walk.filter(Files::isRegularFile)
					.map(x -> x.toString()).collect(Collectors.toList());

			result.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		for (Iterator<String> i = result.iterator(); i.hasNext();) {
		    String item = i.next();
		    source = Paths.get(item);
		    Template templateFile = new Template();
		    

			//Ouverture d'un Reader en lecture :
			try ( BufferedReader reader = Files.newBufferedReader(source, StandardCharsets.UTF_8) )  {
				
				
				String line;
				String texte = "";
				
				while ((line = reader.readLine()) != null) {
					texte += line;
					texte += "\n";
					System.out.println(line);
				}
				StringProperty titre = new SimpleStringProperty(source.getFileName().toString());
				StringProperty texteP = new SimpleStringProperty(texte);
				
				templateFile.setNom(titre);
				templateFile.setTemplate(texteP);
				
				
				
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			main.addTemplate(templateFile);
		}
		
		

		
		vbox1.getChildren().clear();
		ObservableList<Template> liste = this.main.getListDeTemplate();
			
		buttonsList = new ArrayList<Button>();
		templatesListe = new ArrayList<Template>();
		
		
		
		for (Iterator<Template> i = main.getListDeTemplate().iterator(); i.hasNext();) {
		    Template item = i.next();
		    
		    Button button = new Button(item.getNom().get());
		    
		    button.setOnAction(new EventHandler<ActionEvent>() {
		
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					templateValeur.setText(item.getTemplate().get());
					//templateValeur.setText(liste.get(i).getTemplate().get());
				}
		
		    });
		    vbox1.getChildren().add(button);
		    buttonsList.add(button);
    
		    //System.out.println(item);
		}
		
	}
	
	public void addData(Template temp) {
		
		Template newTemplate = temp;
		
		
	    Button button = new Button(newTemplate.getNom().get());
	    
	    button.setOnAction(new EventHandler<ActionEvent>() {
	
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				templateValeur.setText(newTemplate.getTemplate().get());
				//templateValeur.setText(liste.get(i).getTemplate().get());
			}
	
	    });
		
		vbox1.getChildren().add(button);
	}
	
	
    //Méthode qui sera utilisée dans l'initialisation de l'IHM 
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
        //System.out.print(this.main.getListDeTemplate());
       // On lie notre liste observable au composant TableView

       initializeData();
    }
}