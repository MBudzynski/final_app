package pl.sda.finalapp.beans;

import org.springframework.stereotype.Service;


public class WelcomeTextService implements TextProvider {


    private String text;

    public WelcomeTextService() {
        this.text = "Welcome";
    }

    public WelcomeTextService(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
