package org.lucaspco.model;

public class Prontuario {

    private Integer id;
    private String prontuario;
    private Usuario usuario;  // Link to the Usuario class

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Prontuario {" +
                "id=" + id +
                ", prontuario='" + prontuario + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
