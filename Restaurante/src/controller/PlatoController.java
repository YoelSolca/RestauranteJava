package controller;

import model.Plato;
import java.util.List;
import persistence.PlatoDAO;

public class PlatoController {
    private PlatoDAO platoDAO;

    public PlatoController(){
        this.platoDAO = new PlatoDAO();
    }

    public boolean agregarPlato(Plato plato) {
        return platoDAO.insertarPlato(plato);
    }

    public void actualizarPlato(Plato plato) {
        platoDAO.actualizarPlato(plato);
    }

    public void eliminarPlato(int id) {
        platoDAO.eliminarPlato(id);
    }
    
      public List listadoPlatos() {
        return platoDAO.Listar();
    }

    
    
    
}
