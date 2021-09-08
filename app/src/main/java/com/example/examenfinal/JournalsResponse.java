package com.example.examenfinal;

public class JournalsResponse {
    private String name;
    private String description;
    private String portada;
    private String journal_id;

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    @Override
    public String toString() {
        return "JournalsResponse{" +
                "nombre='" + name + '\'' +
                ", descripcion='" + description + '\'' +
                ", portada='" + portada + '\'' +
                '}';
    }
}
