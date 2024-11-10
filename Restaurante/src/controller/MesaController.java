
package controller;

import java.util.List;
import model.Mesa;
import persistence.MesaDAO;


public class MesaController {
        private MesaDAO mesaDAO;
        
        
     public MesaController() {
        this.mesaDAO = new MesaDAO();
    }
     
     
      public List<Mesa> ListarMesas() {
          return mesaDAO.ListarMesas();
      }
 
  public void actualizarEstado(String nuevoEstado, String mesa) {
    {
       mesaDAO.actualizarEstado(nuevoEstado, mesa);
    }
    }
}
