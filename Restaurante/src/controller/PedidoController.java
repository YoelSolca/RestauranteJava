package controller;

import model.DetallePedido;
import model.Pedido;
import java.util.List;
import persistence.PedidoDAO;

public class PedidoController {
    private PedidoDAO pedidoDAO;

    public PedidoController() {
        this.pedidoDAO = new PedidoDAO();
    }
    public void agregarPedido(Pedido pedido) {
        pedidoDAO.RegistrarPedido(pedido);
    }
    
    public int RegistrarDetalle(DetallePedido det){
            return pedidoDAO.RegistrarDetalle(det);
    }
    
    public List verPedidoDetalle(int id_pedido){
        return pedidoDAO.verPedidoDetalle(id_pedido);
    }

    public Pedido verPedido(int id_pedido){
        return pedidoDAO.verPedido(id_pedido);
    }
    
    public Pedido obtenerPedido(int id) {
        return pedidoDAO.verPedido(id);
    }

    public List<Pedido> listarPedidos() {
        return pedidoDAO.listarPedidos();
    }

    public int idPedido() {
            return pedidoDAO.IdPedido();
    }
     
    public boolean actualizarEstado(int id) {
        return pedidoDAO.actualizarEstado(id);
    }
}