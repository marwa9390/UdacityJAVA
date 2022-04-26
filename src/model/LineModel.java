package model;

public class LineModel {
    private String lineItem;
    private double linePrice;
    private int lineCount;
    private HeaderModel headerModel;
    
    

    public LineModel(HeaderModel headerModel, String lineItem, double linePrice, int lineCount) {
        this.headerModel = headerModel;
        this.lineItem = lineItem;
        this.linePrice = linePrice;
        this.lineCount = lineCount;
    }
    public LineModel() {
    }
    public HeaderModel getHeaderModel() {
        return headerModel;
    }

    public void setHeaderModel(HeaderModel headerModel) {
        this.headerModel = headerModel;
    }

    public String getLineItem() {
        return lineItem;
    }

    public void setLineItem(String lineItem) {
        this.lineItem = lineItem;
    }

    public double getLinePrice() {
        return linePrice;
    }

    public void setLinePrice(double linePrice) {
        this.linePrice = linePrice;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }
    
    public double getLineTotal() {
        return linePrice * lineCount;
    }

    @Override
    public String toString() {
        return headerModel.getHeaderNumber() + "," + lineItem + "," + linePrice + "," + lineCount;
    }
}
