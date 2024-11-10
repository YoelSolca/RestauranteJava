
package controller;

import model.Cliente;
import persistence.ClienteDAO;


public class ClienteController {
     private ClienteDAO clienteDAO;
        
        
     
   public int IdPedido() {
     return clienteDAO.IdPedido();
   }
         
         
     
    public int agregarCliente(Cliente cliente) {
           
        return clienteDAO.agregarCliente(cliente);
    }
      
      
    public Cliente obtenerCliente(int id) {
        
    return clienteDAO.obtenerCliente(id);
    
    }

    
   public int modificarCliente(Cliente cliente) {
   
       return clienteDAO.modificarCliente(cliente);
    }
}
