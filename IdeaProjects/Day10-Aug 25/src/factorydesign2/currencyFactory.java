package factorydesign2;
import java.io.IOException;
class Currency{
    String cName;
    String cSymbol;
    void getCurrency(){

    }
    void getSymbol(){

    }
}
class India extends Currency{
    void getCurrency(){
        System.out.println("Currency name of India is Rupee");
    }
    void getSymbol(){
        System.out.println("Currency symbol of India is Rs");
    }
}
class Japan extends Currency{
    void getCurrency(){
        System.out.println("Currency name of Japan is yen");
    }
    void getSymbol(){
        System.out.println("Currency symbol of Japan is .......");
    }
}
class GetCurrencyFactory{
    Currency getCurrency(String currencyType){
        if(currencyType==null){
            return null;
        }
        if(currencyType.equalsIgnoreCase("INDIA")){
            return new India();
        }
        if(currencyType.equalsIgnoreCase("JAPAN")){
            return new Japan();
        }
        return null;
    }
}
public class currencyFactory {
    public static void main(String[] args) throws IOException {
        GetCurrencyFactory gcf = new GetCurrencyFactory();
        Currency c1=gcf.getCurrency("INDIA");
        c1.getCurrency();
        c1.getSymbol();
        Currency c2=gcf.getCurrency("JAPAN");
        c2.getCurrency();
        c2.getSymbol();
    }
}
