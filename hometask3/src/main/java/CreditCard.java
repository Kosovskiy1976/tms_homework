public class CreditCard {
    private int number;
    private int account;

    public CreditCard(int number, int account) {
        this.number = number;
        this.account = account;
    }

    public String add(int sum) {
        account = account + sum;
        return "Средства " + sum + " зачислены на карту " + number;
    }

    public String remove(int sum) {
        if ((account - sum) >= 0) {
            account = account - sum;
            return "Средства " + sum + " сняты с карты " + number;
        }
        else return "На счете карты " + number + " не хватает средств";

    }
    public void current(){
        System.out.println("Номер счета " + number);
        System.out.println("Сумма на карте " + account);
    }

}
