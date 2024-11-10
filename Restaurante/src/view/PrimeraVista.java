package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrimeraVista extends JFrame {

    public PrimeraVista() {
        setTitle("Sistema de Gestión de Restaurante");
        setSize(600, 400); // Tamaño reducido
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1, 0, 0)); // 2 filas sin espacios entre ellas

        // Panel para administración
        JPanel panelAdmin = new JPanel(new BorderLayout());
        JButton btnGestionPlatos = new JButton("Administración");
        btnGestionPlatos.setFont(new Font("Arial", Font.BOLD, 24));
        btnGestionPlatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema iniciar = null;
                iniciar = new Sistema("Administración");
                iniciar.setVisible(true);
            }
        });
        panelAdmin.add(btnGestionPlatos, BorderLayout.CENTER);

        // Panel para clientes
        JPanel panelClientes = new JPanel(new BorderLayout());
        JButton btnGestionClientes = new JButton("Clientes");
        btnGestionClientes.setFont(new Font("Arial", Font.BOLD, 24));
        btnGestionClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema iniciar = null;
                iniciar = new Sistema("Cliente");
                iniciar.setVisible(true);
            }
        });
        panelClientes.add(btnGestionClientes, BorderLayout.CENTER);

        // Añadir los paneles al panel principal
        mainPanel.add(panelAdmin);
        mainPanel.add(panelClientes);

        // Añadir el panel principal a la ventana
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PrimeraVista().setVisible(true);
        });
    }
}
