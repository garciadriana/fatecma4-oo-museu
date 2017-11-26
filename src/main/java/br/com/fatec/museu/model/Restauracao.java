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
    @Column(length = 1024)
    private String descricao;
    private String sala;
    private String dataInicio;
    private String dataFim;
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
