package view.Tests;

import controller.PlatoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeraVista extends JFrame {

    public PrimeraVista() {
        setTitle("Sistema de Gestión de Restaurante");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {

        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));

        // Botón para administracion
        JButton btnGestionPlatos = new JButton("Administracion");
        btnGestionPlatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes abrir la ventana o panel de gestión de platos
                new PlatoController(); // Llama al controlador adecuado
            }
        });

        // Botón para clientes
        JButton btnGestionClientes = new JButton("Clientes");
        btnGestionClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí podrías abrir una ventana o panel para gestionar clientes
                // Ejemplo: new ClienteController().abrirVista();
            }
        });

        mainPanel.add(btnGestionPlatos);
        mainPanel.add(btnGestionClientes);

        add(mainPanel, BorderLayout.CENTER);
    }
}
