package fr.templategenerator.view;

import fr.templategenerator.model.Template;

public class Context {
    private final static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }

    private Template template = new Template();

    public Template currentTemplate() {
        return template;
    }
}