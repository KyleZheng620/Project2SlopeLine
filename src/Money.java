public class Money {
    private double money;

    public Money (){
        money = 1000.0;
    }

    public Money(double money){
        this.money = money;
    }

    public void add(double addMoney){
        money += addMoney;
    }

    public void subtract(double subMoney){
        money -= subMoney;
    }

    public double getMoney(){
        return money;
    }
}
