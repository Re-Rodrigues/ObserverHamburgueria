package org.hamburgueria;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void inscrever(Pedido pedido) {
        pedido.adicionarObserver(this);
    }

    @Override
    public void atualizar(String status) {
        this.ultimaNotificacao = nome + ", pedido '" + status.split(":")[0] + "' está " + status.split(":")[1];
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}