package fr.upyourbizz.web.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class GrowlBean {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void display() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Message d'information", text));
    }
}
