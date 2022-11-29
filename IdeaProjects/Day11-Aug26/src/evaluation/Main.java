package evaluation;
import java.util.*;
import java.util.Date;
class Order{
    private String status;
    private Date date;
    public void calcSubTotal(){
    }
    public void calcTax(){
        System.out.println();
    }
    public void calcTotal(){

    }
    public void calcTotalWeight(){

    }
}
class OrderDetail {
    private String taxStatus;
    Scanner sc=new Scanner(System.in);

    public void calcSubTotal(){
        System.out.println("Enter the number of the item");
        int n = sc.nextInt();
        System.out.println("The costs of item is: ");
      int[] cost=new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        //int total=cost[i];
        //System.out.println(total);
    }
    public void calcWeight(){

    }
    public void calcTax() {

            System.out.println("Enter the details of the item");
            //  int amount=sc.nextInt();
            int taxAmount = sc.nextInt();
            int price = sc.nextInt();
            float  tax = (taxAmount / price) * 100;
            System.out.println(tax+"%");
    }
}
class Item {
    private String description;
    public void getPriceForQuality(){
    }
    public void getTax(){
    }
    public void inStock(){
    }
}
class Payment {
  private float amount;
  Payment(float amount){
      this.amount=amount;
  }
}
class Cash extends Payment{
    private float cashTendered;
    Cash(float amount,float cashTendered){
        super(amount);
    }
}
class Check extends Payment{
    private String name;
    private String bankId;
    Scanner sc=new Scanner(System.in);
    Check(float amount,String name,String bankId){
        super(amount);
    }
    public void authorized(){

    }
}
class Credit extends Payment{
    private String creditName;
    private String creditType;
    Credit(float amount,String creditName,String CreditType){
        super(amount);
    }
    public void authorised(){
        System.out.println("Types of payment available  1. Online 2. Offline");
    }
}
class Customer {
    private String name;
    private String address;
}
public class Main {
    public static void main(String[] args){
     Scanner sc=new Scanner(System.in);
     OrderDetail od=new  OrderDetail();
     od.calcSubTotal();
     od.calcTax();
     System.out.println("Enter bank name");
     String name=sc.nextLine();
     System.out.println("Enter Credit type");
     String creditType=sc.nextLine();
     int amount=sc.nextInt();
     Credit p = new Credit(amount,name, creditType);
     p.authorised();

    }
}
