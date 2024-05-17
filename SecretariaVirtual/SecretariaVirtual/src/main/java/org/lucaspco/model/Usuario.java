package org.lucaspco.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private Integer id;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private String nomeResponsavel;
    private String telefoneResponsavel;
    private int cpf;
    private String senha;
    private List<Prontuario> prontuarios = new ArrayList<>();

    // Default constructor
    public Usuario() {
    }

    // Constructor with nome
    public Usuario(String nome) {
        this.nome = nome;
    }

    // Constructor with id and nome
    public Usuario(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Usuario(Integer id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }
    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Prontuario> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List<Prontuario> prontuarios) {
        this.prontuarios = prontuarios;
    }

    public void addProntuario(Prontuario prontuario) {
        prontuarios.add(prontuario);
        prontuario.setUsuario(this);
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", nomeResponsavel='" + nomeResponsavel + '\'' +
                ", telefoneResponsavel='" + telefoneResponsavel + '\'' +
                ", cpf=" + cpf +
                ", senha='" + senha + '\'' +
                ", prontuarios=" + prontuarios +
                '}';
    }
}
