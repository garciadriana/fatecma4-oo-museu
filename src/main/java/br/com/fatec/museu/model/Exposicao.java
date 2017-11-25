package br.com.fatec.museu.model;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "exposicao")
@Entity
public class Exposicao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private boolean temporario;
    private String descricao;
    private String sala;
    private LocalDate dataInicio;
    private LocalDate datafim;
    private String imagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isTemporario() {
        return temporario;
    }

    public void setTemporario(boolean temporario) {
        this.temporario = temporario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDate datafim) {
        this.datafim = datafim;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
