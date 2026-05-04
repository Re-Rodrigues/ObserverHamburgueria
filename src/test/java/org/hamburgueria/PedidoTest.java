package org.hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Pedido pedido = new Pedido("X-Burger");
        Cliente cliente = new Cliente("Cliente 1");

        cliente.inscrever(pedido);
        pedido.atualizarStatus("Pronto");

        assertEquals(
                "Cliente 1, pedido 'X-Burger' está Pronto",
                cliente.getUltimaNotificacao()
        );
    }

    @Test
    void deveNotificarClientes() {
        Pedido pedido = new Pedido("X-Burger");

        Cliente c1 = new Cliente("Cliente 1");
        Cliente c2 = new Cliente("Cliente 2");

        c1.inscrever(pedido);
        c2.inscrever(pedido);

        pedido.atualizarStatus("Saiu para entrega");

        assertEquals("Cliente 1, pedido 'X-Burger' está Saiu para entrega", c1.getUltimaNotificacao()
        );

        assertEquals(
                "Cliente 2, pedido 'X-Burger' está Saiu para entrega",
                c2.getUltimaNotificacao()
        );
    }

    @Test
    void naoDeveNotificarCliente() {
        Pedido pedido = new Pedido("X-Burger");
        Cliente cliente = new Cliente("Cliente 1");

        pedido.atualizarStatus("Pronto");

        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientePedidoCerto() {
        Pedido pedido1 = new Pedido("X-Burger");
        Pedido pedido2 = new Pedido("X-Salada");

        Cliente c1 = new Cliente("Cliente 1");
        Cliente c2 = new Cliente("Cliente 2");

        c1.inscrever(pedido1);
        c2.inscrever(pedido2);

        pedido1.atualizarStatus("Pronto");

        assertEquals(
                "Cliente 1, pedido 'X-Burger' está Pronto",
                c1.getUltimaNotificacao()
        );

        assertEquals(null, c2.getUltimaNotificacao());
    }
}