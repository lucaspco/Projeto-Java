package org.lucaspco.model;

import java.time.LocalDateTime;

public class Agendamento {

    private Integer id;
    private LocalDateTime dataHora;
    private Usuario usuario;
    private String descricao;

    // Constructors
    public Agendamento() {
    }

    public Agendamento(LocalDateTime dataHora, Usuario usuario, String descricao) {
        this.dataHora = dataHora;
        this.usuario = usuario;
        this.descricao = descricao;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // toString method
    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", dataHora=" + dataHora +
                ", usuario=" + usuario +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}