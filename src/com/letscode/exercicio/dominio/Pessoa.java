package com.letscode.exercicio.dominio;

import java.util.Random;

public class Pessoa {
    private String genero;
    private Long tempo;

    public Pessoa(String genero, Long tempo) {
        this.genero = genero;
        this.tempo = tempo;
    }

    public Pessoa(String genero) {
        this.genero = genero;
        this.tempo = (new Random()).nextLong(100);
    }

    public void entrarNoBanheiro(Banheiro banheiro) throws InterruptedException {
        banheiro.entrar(this);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getTempo() {
        return tempo;
    }

    public void setTempo(Long tempo) {
        this.tempo = tempo;
    }
}
