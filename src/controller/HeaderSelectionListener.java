package controller;

import model.HeaderModel;
import model.LineModel;
import model.LineTabelModel;
import view.Frame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class HeaderSelectionListener implements ListSelectionListener {
    private Frame frame;
    public HeaderSelectionListener(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvoiceIndex = frame.getHeadersTable().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            HeaderModel selectedInv = frame.getHeadersArray().get(selectedInvoiceIndex);
            ArrayList<LineModel> lines = selectedInv.getLineModels();
            LineTabelModel lineTableModel = new LineTabelModel(lines);
            frame.setLinesArray(lines);
            frame.getLinesTable().setModel(lineTableModel);
            frame.getCustomerNameLabel().setText(selectedInv.getHeaderCustomer());
            frame.getInvoiceNumberLabel().setText("" + selectedInv.getHeaderNumber());
            frame.getInvoiceTotalLabel().setText("" + selectedInv.getHeaderTotal());
            frame.getInvoiceDateLabel().setText(Frame.dateFormat.format(selectedInv.getHeaderDate()));
        }
    }

}
