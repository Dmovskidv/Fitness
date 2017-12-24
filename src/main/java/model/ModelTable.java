package model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ModelTable implements TableModel {

    Model model = new Model();



    @Override
    public int getRowCount() {
        return model.getDate().size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String return_name = "";
        switch (columnIndex) {

            case 0:
                return_name = "ФИО клиента";
                break;
            case 1:
                return_name = "Номер карты";
                break;

        }
        return return_name;
    }

    @Override
    public Class<String> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object return_object = null;
        switch (columnIndex) {

            case 0:
                return_object = model.getDate().get(rowIndex).getLastName()+" "+model.getDate().get(rowIndex).getName()+" "+model.getDate().get(rowIndex).getFatherName();
                break;
            case 1:
                return_object = model.getDate().get(rowIndex).getNumberCard();
                break;
                    }

        return return_object;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
