package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import view.Frame;

public class HeaderTabelModel extends AbstractTableModel {
    private ArrayList<HeaderModel> headerModels;
    private String[] tabelLabels = {"Number", "Date", "Customer", "Total"};

    public HeaderTabelModel(ArrayList<HeaderModel> headersArray) {
        this.headerModels = headersArray;
    }
    @Override
    public int getRowCount() {
        return headerModels.size();
    }
    @Override
    public int getColumnCount() {
        return tabelLabels.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HeaderModel header = headerModels.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {return header.getHeaderNumber();}
            case 1 -> {return Frame.dateFormat.format(header.getHeaderDate());}
            case 2 -> {return header.getHeaderCustomer();}
            case 3 -> {return header.getHeaderTotal();}
        }
        return null;
    }
    @Override
    public String getColumnName(int header) {
        return tabelLabels[header];
    }
}
