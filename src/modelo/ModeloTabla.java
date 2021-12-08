package modelo;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModeloTabla extends AbstractTableModel {
    private List<ModeloEmpleado> list;
    private String column[] = {"Nombre", "ID", "Salario"};

    public ModeloTabla(List<ModeloEmpleado> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModeloEmpleado emp = list.get(rowIndex);
        switch (columnIndex){
            case 0: return emp.getNombre();
            case 1: return emp.getId();
            case 2: return emp.getSalario();
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column);
    }
}
