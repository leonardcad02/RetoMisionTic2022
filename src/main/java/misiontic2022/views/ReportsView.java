package misiontic2022.views;

import misiontic2022.controller.ReportesController;
import misiontic2022.model.vo.PrimerInformeBancoVo;
import misiontic2022.model.vo.SegundoInformeBancoVo;
import misiontic2022.model.vo.TercerInformeBancoVo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ReportsView extends JFrame{
    public static ReportesController controlador =  new ReportesController();
    private JButton btnFirst;
    private JButton btnSecond;
    private JButton btnThird;
    private JPanel mainPanel;
    private JLabel Bienvenidos;
    private JButton salirButton;
    private JTable result;


    public ReportsView(){
        setContentPane(mainPanel);
        setTitle("Aplicación MVC Reportes Proyecto de Vivienda");
        setSize(550,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    List<PrimerInformeBancoVo> proyecto = controlador.listarProyectosPorBanco();
                    DefaultTableModel tableModel = new DefaultTableModel();
                    result.setModel(tableModel);
                    tableModel.addColumn("ID_Proyecto");
                    tableModel.addColumn("Nombre");
                    tableModel.addColumn("Primer Apellido");
                    tableModel.addColumn("Ciudad");
                    for (PrimerInformeBancoVo infoProyectoVo : proyecto) {
                        tableModel.addRow(new Object[]{
                                infoProyectoVo.getId(),
                                infoProyectoVo.getNombre(),
                                infoProyectoVo.getPrimerApelido(),
                                infoProyectoVo.getCiudadResidencia(),
                        });
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Error en la consulta", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        btnSecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<SegundoInformeBancoVo> proyecto = controlador.listarSegundoInformeBanco();
                    DefaultTableModel tableModel = new DefaultTableModel();
                    result.setModel(tableModel);

                    tableModel.addColumn("ID_Proyecto");
                    tableModel.addColumn("Constructora");
                    tableModel.addColumn("Numero Habitaciones");
                    tableModel.addColumn("Ciudad");
                    for (SegundoInformeBancoVo infoProyectoVo : proyecto) {
                        tableModel.addRow(new Object[]{
                                infoProyectoVo.getId(),
                                infoProyectoVo.getConstructora(),
                                infoProyectoVo.getNumeroHabitaciones(),
                                infoProyectoVo.getCiudad(),
                        });
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Error en la consulta", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnThird.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    List<TercerInformeBancoVo> proyecto = controlador.listarTercerInformeBanco();
                    DefaultTableModel tableModel = new DefaultTableModel();
                    result.setModel(tableModel);
                    tableModel.addColumn("ID_Compra");
                    tableModel.addColumn("Constructora");
                    tableModel.addColumn("Banco_Viculado");
                    for (TercerInformeBancoVo infoProyectoVo : proyecto) {
                        Object[] fila = {infoProyectoVo.getId(), infoProyectoVo.getConstructora(), infoProyectoVo.getBancoVinculado()};
                        tableModel.addRow(fila);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Error en la consulta", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // salir de la ventana
                dispose();
            }
        });
    }

}
