package org.hamburgueria;

public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido("X-Burger");

        Cliente cliente = new Cliente("Renan");

        pedido.adicionarObserver(cliente);

        pedido.atualizarStatus("Em preparo");
        pedido.atualizarStatus("Pronto");
    }
}