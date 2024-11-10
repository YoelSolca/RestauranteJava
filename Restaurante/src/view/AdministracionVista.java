package view;

import controller.PedidoController;
import controller.PlatoController;
import model.Pedido;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdministracionVista extends JFrame {
    private PedidoController pedidoController;
    private PlatoController platoController;

    private JTable tablaPedidos;
    private JTable tablaPlatos;
    private JButton agregarPedidoButton;
    private JButton eliminarPedidoButton;
    private JButton agregarPlatoButton;
    private JButton eliminarPlatoButton;

    public AdministracionVista() {
        pedidoController = new PedidoController();
        platoController = new PlatoController();

        // Configuración de la interfaz gráfica (agregar componentes a JFrame, configurar layout, etc.)
        configurarUI();
        cargarDatos();

        // Eventos de botones
        agregarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar pedido
                Pedido nuevoPedido = new Pedido();
                // ... llenar datos del nuevo pedido
                //pedidoController.agregarPedido(nuevoPedido, /*detallePedido*/ null);
                cargarDatos(); // Actualizar tabla
            }
        });



        eliminarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaPlatos.getSelectedRow();
                if (selectedRow >= 0) {
                    int platoId = (int) tablaPlatos.getValueAt(selectedRow, 0);
                    platoController.eliminarPlato(platoId);
                    cargarDatos(); // Actualizar tabla
                }
            }
        });
    }

    private void configurarUI() {
        // Inicialización y configuración de la interfaz
        tablaPedidos = new JTable();
        tablaPlatos = new JTable();
        agregarPedidoButton = new JButton("Agregar Pedido");
        eliminarPedidoButton = new JButton("Eliminar Pedido");
        agregarPlatoButton = new JButton("Agregar Plato");
        eliminarPlatoButton = new JButton("Eliminar Plato");

        // Configuración de JFrame (tamaño, layout, etc.)
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(tablaPedidos);
        this.add(tablaPlatos);
        this.add(agregarPedidoButton);
        this.add(eliminarPedidoButton);
        this.add(agregarPlatoButton);
        this.add(eliminarPlatoButton);
    }

    private void cargarDatos() {
        // Cargar lista de pedidos y platos en tablas
        //List<Pedidos> pedidos = pedidoController.listarPedidos();

        // Convertir los datos a formato de tabla y asignarlos a JTable
        // (implementa una función para llenar los modelos de las tablas con pedidos y platos)
    }
}
