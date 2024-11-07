package controller;

import model.Platos;
import persistence.PlatosDAO;

public class PlatoController {
    private PlatosDAO platoDAO;

    public void platoController() {
        this.platoDAO = new PlatosDAO();
    }

    public void agregarPlato(Platos plato) {
        platoDAO.insertarPlato(plato);
    }

    public void actualizarPlato(Platos plato) {
        platoDAO.actualizarPlato(plato);
    }

    public void eliminarPlato(int id) {
        platoDAO.eliminarPlato(id);
    }

}
