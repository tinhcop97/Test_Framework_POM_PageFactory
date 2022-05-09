package test;

public class convertPrice {
    public int priceOnlyNumber(String price){
        price = price.replace(".","");
        price = price.replace("đ","");
        int priceNum = Integer.parseInt(price);
        return priceNum;
    }
}
