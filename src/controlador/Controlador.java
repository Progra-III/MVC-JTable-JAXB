package controlador;

import modelo.JAXBParser;
import modelo.ListaEmpleado;
import modelo.ModeloEmpleado;
import modelo.ModeloTabla;
import vista.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    private Vista vista;
    private ModeloEmpleado modelEmp;

    public Controlador() {
        this.modelEmp = new ModeloEmpleado();
        this.vista = new Vista();
        vista.addListener(new claseAction());
    }

    private JTable tablaLista(){
        ListaEmpleado list = new ListaEmpleado();
        list.add(new ModeloEmpleado("Beverly Ugalde",7777,50000));
        list.add(new ModeloEmpleado("Patricia Jenkins",6666,50000));
        list.add(new ModeloEmpleado("Gabriel Jenkins",9999,50000));
        list.add(new ModeloEmpleado("Eduardo Ugalde",8888,50000));

        JTable tabla = new JTable();
        tabla.setModel(new ModeloTabla(list.getList()));
        return tabla;
    }
    private JTable tablaXML(){
        ListaEmpleado list1 = new ListaEmpleado();
        list1.add(new ModeloEmpleado("Marcos Ramirez",1111, 85000));
        list1.add(new ModeloEmpleado("Pedro Juarez",2222, 55000));
        list1.add(new ModeloEmpleado("Maria dobles",3333, 98000));
        list1.add(new ModeloEmpleado("Juan Castro",4444, 62000));
        list1.add(new ModeloEmpleado("Antonieta Flores",5555, 83300));
        list1.add(new ModeloEmpleado("Juana Lopez",6666, 12400));
        list1.add(new ModeloEmpleado("Hugo Barrientos",7777, 87500));

        JAXBParser parser = new JAXBParser();
        parser.marshall(list1, "empleados.xml");

        ListaEmpleado list2 = (ListaEmpleado) parser.unmarshall(new ListaEmpleado(), "empleados.xml");

        JTable table = new JTable();
        table.setModel(new ModeloTabla(list2.getList()));
        return table;
    }

    private class claseAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int valor = Integer.parseInt(e.getActionCommand());
            switch (valor){
                case 1:
                    String data[][] = { {"Marco","101","670000"},
                                        {"Paula","102","780000"},
                                        {"Marta","103","890000"}};
                    String column[] = {"Nombre", "ID", "Salario"};
                    JTable jt = new JTable(data,column);
                    JScrollPane sp1 = new JScrollPane(jt);
                    vista.addTable(sp1);
                    break;
                case 2:
                    JTable jtLista = tablaLista();
                    JScrollPane sp2 = new JScrollPane(jtLista);
                    vista.addTable(sp2);
                    break;
                case 3:
                    JTable jtXML = tablaXML();
                    JScrollPane sp3 = new JScrollPane(jtXML);
                    vista.addTable(sp3);
                    break;
            }

        }
    }
}
