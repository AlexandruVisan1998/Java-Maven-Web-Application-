package com.example.FormSubmission;


public class Greeting {

    //private long id;
   // private String content;

    private String nume;
    private String grupa;
    private String motivulCererii;


    public String getNume ( ) {
        return nume;
    }

    public void setNume ( String nume ) {
        this.nume = nume;
    }

    public String getGrupa ( ) {
        return grupa;
    }

    public void setGrupa ( String grupa ) {
        this.grupa = grupa;
    }

    public String getMotivulCererii ( ) {
        return motivulCererii;
    }

    public void setMotivulCererii ( String motivulCererii ) {
        this.motivulCererii = motivulCererii;
    }
}