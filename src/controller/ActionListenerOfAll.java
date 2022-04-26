package controller;

import model.HeaderModel;
import model.HeaderTabelModel;
import model.LineModel;
import model.LineTabelModel;
import view.Frame;
import view.HeaderDialog;
import view.LineDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ActionListenerOfAll implements ActionListener {
    private Frame frame;
    private HeaderDialog headerDialog;
    private LineDialog lineDialog;

    public ActionListenerOfAll() {
    }
    public ActionListenerOfAll(Frame frame) {
        this.frame = frame;
    }
    public ActionListenerOfAll(HeaderDialog headerDialog, LineDialog lineDialog) {
        this.headerDialog = headerDialog;
        this.lineDialog = lineDialog;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load File":
                loadFile();
                break;
            case "Save File":
                saveFile();
                break;
            case "New Invoice":
                newInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "New Line":
                newLine();
                break;
            case "Delete Line":
                deleteLine();
                break;
            case "New Invoice OK":
                newInvoiceOK();
                break;
            case "New Line OK":
                newLineOK();
                break;
        }
    }
    private void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                ArrayList<HeaderModel> invoiceHeaders = new ArrayList<>();
                for (String headerLine : headerLines) {
                    String[] arr = headerLine.split(",");
                    String str1 = arr[0];
                    String str2 = arr[1];
                    String str3 = arr[2];
                    int code = Integer.parseInt(str1);
                    Date invoiceDate = Frame.dateFormat.parse(str2);
                    HeaderModel header = new HeaderModel(code, str3, invoiceDate);
                    invoiceHeaders.add(header);
                }
                frame.setHeadersArray(invoiceHeaders);
                result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fileChooser.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> linesOfLine = Files.readAllLines(linePath);
                    for (String lineOfLine : linesOfLine) {
                        String[] arr = lineOfLine.split(",");
                        String str1 = arr[0];
                        String str2 = arr[1];
                        String str3 = arr[2];
                        String str4 = arr[3];
                        int invCode = Integer.parseInt(str1);
                        double price = Double.parseDouble(str3);
                        int count = Integer.parseInt(str4);
                        HeaderModel inv = frame.getObject(invCode);
                        LineModel line = new LineModel(inv, str2, price, count);
                        inv.getLineModels().add(line);
                    }
                System.out.println("BEGIN");
                System.out.println(" Header File ----->");
                for (String headerLine : headerLines) {
                System.out.println(headerLine);
                }
                System.out.println("Line File ----->");
                for (String lineOfLine : linesOfLine){
                System.out.println(lineOfLine);
                }
                System.out.println("DONE");
                }
                HeaderTabelModel headerTableModel = new HeaderTabelModel(invoiceHeaders);
                frame.setHeaderTableModel(headerTableModel);
                frame.getHeadersTable().setModel(headerTableModel);  
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void saveFile() {
        ArrayList<HeaderModel> invoicesArray = frame.getHeadersArray();
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                FileWriter headerFileWriter = new FileWriter(headerFile);
                String headers = "";
                String lines = "";
                for (HeaderModel header : invoicesArray) {
                    headers += header.toString();
                    headers += "\n";
                    for (LineModel line : header.getLineModels()) {
                        lines += line.toString();
                        lines += "\n";
                    }
                }
                headers = headers.substring(0, headers.length()-1);
                lines = lines.substring(0, lines.length()-1);
                result = fileChooser.showSaveDialog(frame);
                File lineFile = fileChooser.getSelectedFile();
                FileWriter lineFileWriter = new FileWriter(lineFile);
                headerFileWriter.write(headers);
                lineFileWriter.write(lines);
                headerFileWriter.close();
                lineFileWriter.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
    private void newInvoice() {
        headerDialog = new HeaderDialog(frame);
        headerDialog.setVisible(true);
    }
    private void deleteInvoice() {
        int selectedInvoiceIndex = frame.getHeadersTable().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            frame.getHeadersArray().remove(selectedInvoiceIndex);
            frame.getHeaderTableModel().fireTableDataChanged();
            frame.getLinesTable().setModel(new LineTabelModel(null));
            frame.setLinesArray(null);
            frame.getCustomerNameLabel().setText("");
            frame.getInvoiceNumberLabel().setText("");
            frame.getInvoiceTotalLabel().setText("");
            frame.getInvoiceDateLabel().setText("");
        }
    }
    private void newLine() {
        lineDialog = new LineDialog(frame);
        lineDialog.setVisible(true);  
    }
    private void deleteLine() {
        int selectedLineIndex = frame.getLinesTable().getSelectedRow();
        int selectedInvoiceIndex = frame.getHeadersTable().getSelectedRow();
        if (selectedLineIndex != -1) {
            frame.getLinesArray().remove(selectedLineIndex);
            LineTabelModel lineTableModel = (LineTabelModel) frame.getLinesTable().getModel();
            lineTableModel.fireTableDataChanged();
            frame.getInvoiceTotalLabel().setText("" + frame.getHeadersArray().get(selectedInvoiceIndex).getHeaderTotal());
            frame.getHeaderTableModel().fireTableDataChanged();
            frame.getHeadersTable().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
        }
    }
    private void newInvoiceOK() {
        try {
        headerDialog.setVisible(false);
        String custName = headerDialog.getCustomerField().getText();
        String str = headerDialog.getDateField().getText();
        Date d = new Date();
        try {
            d = Frame.dateFormat.parse(str);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Cannot parse date, resetting to today.", "Invalid date format", JOptionPane.ERROR_MESSAGE);
        }
        int invNum = 0;
        for (HeaderModel inv : frame.getHeadersArray()) {
            if (inv.getHeaderNumber() > invNum) {
                invNum = inv.getHeaderNumber();
            }
        }
        invNum++;
        HeaderModel newInv = new HeaderModel(invNum, custName, d);
        frame.getHeadersArray().add(newInv);
        frame.getHeaderTableModel().fireTableDataChanged();
        headerDialog.dispose();
        headerDialog = null;
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void newLineOK() {
        try {
        lineDialog.setVisible(false);
        String name = lineDialog.getItemNameField().getText();
        String str1 = lineDialog.getItemCountField().getText();
        String str2 = lineDialog.getItemPriceField().getText();
        int count = 1;
        double price = 1;
        try {
            count = Integer.parseInt(str1);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Cannot convert number", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }
        try {
            price = Double.parseDouble(str2);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Cannot convert price", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvHeader = frame.getHeadersTable().getSelectedRow();
        if (selectedInvHeader != -1) {
            HeaderModel invHeader = frame.getHeadersArray().get(selectedInvHeader);
            LineModel line = new LineModel(invHeader,name, price, count);
            //invHeader.getLines().add(line);
            frame.getLinesArray().add(line);
            LineTabelModel lineTableModel = (LineTabelModel) frame.getLinesTable().getModel();
            lineTableModel.fireTableDataChanged();
            frame.getHeaderTableModel().fireTableDataChanged();
        }
        frame.getHeadersTable().setRowSelectionInterval(selectedInvHeader, selectedInvHeader);
        lineDialog.dispose();
        lineDialog = null;
        }catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
