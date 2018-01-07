package model;

public class CashBox {


    private double allKassa;
    private double priceService;
    private int operation;


    public CashBox(double allKassa, double priceService, int operation) {
        this.allKassa = allKassa;
        this.priceService = priceService;
        this.operation = operation;
    }


    public double count(){

        // double allKassa = (operation>1)?  allKassa + priceService : priceService;
        allKassa = allKassa+priceService;
        return allKassa;
    }


    public double getAllKassa() {
        return allKassa;
    }

    public double getPriceService() {
        return priceService;
    }

}
