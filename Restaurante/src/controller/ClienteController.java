package controller;


import model.Cliente;
import persistence.ClienteDAO;

public class ClienteController {
    private ClienteDAO clienteDAO;


    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public void agregarCliente(Cliente cliente) {
        clienteDAO.agregarCliente(cliente);
    }

    public Cliente obtenerCliente(int id) {
        return clienteDAO.obtenerCliente(id);
    }

    public void editarCliente(Cliente cliente) {
        clienteDAO.modificarCliente(cliente);
    }

    public void eliminarCliente(int id) {
        clienteDAO.eliminarCliente(id);
    }

}
