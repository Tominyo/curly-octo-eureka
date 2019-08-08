package fr.templategenerator.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Template {
	private IntegerProperty identifiant = new SimpleIntegerProperty(); 
	private StringProperty nom = new SimpleStringProperty();
	private StringProperty template = new SimpleStringProperty();
	
	public Template() {
		nom.set("");
		template.set("");
		identifiant.set(0);
	}

	public Template(String n, int p,String t) {
		nom.set(n);
		identifiant.set(p);
		template.set(t);
	}
	
	public StringProperty getNom() {return nom;}
	public void setNom(StringProperty nom) {this.nom = nom;}
	
	
	public IntegerProperty getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(IntegerProperty identifiant) {
		this.identifiant = identifiant;
	}

	public String toString() { return "#Nom : " + nom.get() + " - ID: " + identifiant.get() + "#";}

	public StringProperty getTemplate() {
		return template;
	}

	public void setTemplate(StringProperty template) {
		this.template = template;
	}

}
