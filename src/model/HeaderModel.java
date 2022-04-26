package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HeaderModel {
    private int headerNumber;
    private String headerCustomer;
    private Date headerDate;
    private ArrayList<LineModel> lineModels;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public HeaderModel() {
    }

    public HeaderModel(int headerNumber, String headerCustomer, Date headerDate) {
        this.headerNumber = headerNumber;
        this.headerCustomer = headerCustomer;
        this.headerDate = headerDate;
    }


    public Date getHeaderDate() {
        return headerDate;
    }

    public void setHeaderDate(Date headerDate) {
        this.headerDate = headerDate;
    }

    public int getHeaderNumber() {
        return headerNumber;
    }

    public void setHeaderNumber(int headerNumber) {
        this.headerNumber = headerNumber;
    }

    public String getHeaderCustomer() {
        return headerCustomer;
    }

    public void setHeaderCustomer(String headerCustomer) {
        this.headerCustomer = headerCustomer;
    }

    public ArrayList<LineModel> getLineModels() {
        if (lineModels == null) {
            lineModels = new ArrayList<>();
        }
        return lineModels;
    }

    public void setLineModels(ArrayList<LineModel> lineModels) {
        this.lineModels = lineModels;
    }
    
    public double getHeaderTotal() {
        double total = 0.0;
        
        for (int i = 0; i < getLineModels().size(); i++) {
            total += getLineModels().get(i).getLineTotal();
        }
        
        return total;
    }

    @Override
    public String toString() {
        return headerNumber + "," + dateFormat.format(headerDate) + "," + headerCustomer;
    }
    
}
