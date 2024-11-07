package controller;

import model.DetallePedido;
import model.Pedidos;
import persistence.PedidosDAO;

import java.util.List;

public class PedidoController {
    private PedidosDAO pedidoDAO;

    public PedidoController() {
        this.pedidoDAO = new PedidosDAO();
    }
    public void agregarPedido(Pedidos pedido, DetallePedido detallePedido) {
        pedidoDAO.RegistrarPedido(pedido);
        pedidoDAO.RegistrarDetalle(detallePedido);
    }

    public Pedidos obtenerPedido(int id) {
        return pedidoDAO.verPedido(id);
    }

    public List<Pedidos> listarPedidos() {
        return pedidoDAO.listarPedidos();
    }
}