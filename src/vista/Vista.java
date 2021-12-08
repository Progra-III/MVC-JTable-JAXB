package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    JPanel total = new JPanel(new BorderLayout());
    JPanel norte = new JPanel(new FlowLayout());
    JPanel centro = new JPanel();
    JRadioButton rbTablaBase = new JRadioButton("Tabla Base");
    JRadioButton rbTablaLista = new JRadioButton("Tabla Lista");
    JRadioButton rbTablaXML = new JRadioButton("Tabla XML");

    public Vista() throws HeadlessException{
        super("Ejemplo JTable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        addComponents(getContentPane());
        setVisible(true);
    }

    private void addComponents(Container contentPane) {
        ButtonGroup group = new ButtonGroup();
        rbTablaLista.setActionCommand("1");
        rbTablaBase.setActionCommand("2");
        rbTablaXML.setActionCommand("3");
        group.add(rbTablaBase);
        group.add(rbTablaLista);
        group.add(rbTablaXML);
        norte.add(rbTablaBase);
        norte.add(rbTablaLista);
        norte.add(rbTablaXML);
        total.add(norte, BorderLayout.NORTH);
        total.add(centro, BorderLayout.CENTER);
        contentPane.add(total);
    }
    public void addTable(JScrollPane scroll){
        if (centro.getComponentCount() > 0){
            centro.remove(0);
        }
        centro.add(scroll);
        centro.validate();// se valida por si se hace algun cambio se actualice
    }

    public void addListener(ActionListener action){
        rbTablaBase.addActionListener(action);
        rbTablaLista.addActionListener(action);
        rbTablaXML.addActionListener(action);
    }
}
