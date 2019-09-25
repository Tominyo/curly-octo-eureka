package fr.templategenerator.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.ResourceBundle;

import fr.templategenerator.MainClass;
import fr.templategenerator.model.Template;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewTemplateMapping implements Initializable{
	
	@FXML
	private TextField templateNameTF;
	
	@FXML 
	private TextArea templateContentTA;
	
	@FXML
	private AnchorPane newTemplateAP;

    private MainClass main;

    public NewTemplateMapping() { }
    
    private Template template;
    
    private Stage stageNewTemplate;
    
    private final ReadOnlyObjectWrapper<Template> currentTemplate = new ReadOnlyObjectWrapper<>();

    public ReadOnlyObjectProperty<Template> currentCustomerProperty() {
        return currentTemplate.getReadOnlyProperty() ;
    }

    public Template getCurrentTemplate() {
        return currentTemplate.get();
    }

    
    @FXML
    private void initialize() {    
    	    
    }
    
	@FXML
	private void saveTemplate() {
		
		StringProperty templateName = new SimpleStringProperty();
		templateName.set(templateNameTF.getText());
		
		StringProperty templateContent = new SimpleStringProperty();
		templateContent.set(templateContentTA.getText());

		this.main.afficherMain();
		
	}
	
	@FXML
	public void sauvegarder() {
		StringProperty templateName = new SimpleStringProperty();
		templateName.set(templateNameTF.getText());
		
		StringProperty templateContent = new SimpleStringProperty();
		templateContent.set(templateContentTA.getText());
		
		Template temp = new Template(templateName.get(),1,templateContent.get());
		
		Path source = Paths.get("templates/"+ templateName.get()+".txt");
		
		//Ouverture d'un Writer en écriture :
		try ( BufferedWriter writer = Files.newBufferedWriter(source, StandardCharsets.ISO_8859_1) )  {
			
			  String str = "";
			  str = templateContent.get();
		      //On écrit la chaîne
		      writer.write(str);
		      //On ferme le flux
		      writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		main.getListDeTemplate().add(temp);
		for (Iterator<Template> i = main.getListDeTemplate().iterator(); i.hasNext();) {
		    Template item = i.next();
		    //System.out.println(item);
		}
		
		main.getControl().addData(temp);
		//stageNewTemplate.close();
	}
    
	
	
    //Méthode qui sera utilisée dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
        stageNewTemplate = main.getStage();

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		template = new Template();
		
	}
	
	

	
	public Template getNewTemplate(){
		return template;
	}
	
	public void setTemplate(Template t) {
		this.template = t;
	}
	
	
}