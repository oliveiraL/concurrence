package com.letscode.exercicio;

import com.letscode.exercicio.dominio.Banheiro;
import com.letscode.exercicio.dominio.Pessoa;



import java.util.Random;

public class Bathroom {

    public static void main(String[] args) throws InterruptedException {
        Banheiro banheiro = new Banheiro();
        Random random = new Random();
        for (int i = 0; i < 30; i++){
            if (random.nextBoolean()){
                (new Pessoa("M")).entrarNoBanheiro(banheiro);
            }else {
                (new Pessoa("F")).entrarNoBanheiro(banheiro);
            }
        }
    }


}
