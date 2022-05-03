package com.letscode.exercicio.dominio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Banheiro {


    static Semaphore banheiroVazio = new Semaphore(1);

    static Semaphore masculino = new Semaphore(1);
    static Integer qntMasculino = 0;

    static Semaphore feminino = new Semaphore(1);
    static Integer qntFeminino = 0;
    private final ExecutorService threadpool = Executors.newFixedThreadPool(3);

    public void entrar(Pessoa pessoa) throws InterruptedException {


        if (pessoa.getGenero().equals("M")) {

            if (qntMasculino == 0) banheiroVazio.acquire();

            if (feminino.availablePermits() == 0 || qntFeminino >= 3) {
                banheiroVazio.acquire();
                masculino.acquire();
            }

            qntMasculino++;


        } else {

            if (qntFeminino == 0) banheiroVazio.acquire();


            if (masculino.availablePermits() == 0 || qntMasculino >= 3) {
                banheiroVazio.acquire();
                feminino.acquire();
            }
            qntFeminino++;
        }

        threadpool.submit(() -> {
            try {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Semaphoro banheiro -> " + banheiroVazio.getQueueLength());
                System.out.println("Semaphoro masculino -> " + masculino.getQueueLength());
                System.out.println("Semaphoro feminino -> " + feminino.getQueueLength());
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Entrando no banheiro -> " + pessoa.getGenero() + ", e vai ficar: "+pessoa.getTempo()+ " "+ Thread.currentThread().getName());
                Thread.sleep(pessoa.getTempo());
                System.out.println("Saindo no banheiro -> " + pessoa.getGenero()+ " "+ Thread.currentThread().getName());
                System.out.println("------------------------------------------------------------------------------------------");
                    if (pessoa.getGenero().equals("M")) {
                        qntMasculino--;
                        if (qntMasculino == 0) {
                            masculino.release();
                            banheiroVazio.release();
                        }
                    } else {
                        qntFeminino--;
                        if (qntFeminino == 0) {
                            masculino.release();
                            banheiroVazio.release();
                        }
                    }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


}
