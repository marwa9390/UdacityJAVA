package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class LineTabelModel extends AbstractTableModel {

    private ArrayList<LineModel> lineModels;
    private String[] tableLabels = {"Item Name", "Item Price", "Count", "Item Total"};

    public LineTabelModel(ArrayList<LineModel> linesArray) {
        this.lineModels = linesArray;
    }
    @Override
    public int getRowCount() {
        return lineModels == null ? 0 : lineModels.size();
    }
    @Override
    public int getColumnCount() {
        return tableLabels.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (lineModels == null) {
            return null;
        } else {
            LineModel line = lineModels.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> line.getLineItem();
                case 1 -> line.getLinePrice();
                case 2 -> line.getLineCount();
                case 3 -> line.getLineTotal();
                default -> null;
            };
        }
    }
    @Override
    public String getColumnName(int column) {
        return tableLabels[column];
    }

}
