package org.hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Observer> observers = new ArrayList<>();
    private String nome;

    public Pedido(String nome) {
        this.nome = nome;
    }

    public void adicionarObserver(Observer o) {
        observers.add(o);
    }

    public void atualizarStatus(String status) {
        notificar(nome + ":" + status);
    }

    private void notificar(String statusCompleto) {
        for (Observer o : observers) {
            o.atualizar(statusCompleto);
        }
    }
}