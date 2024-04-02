public class Bank {
    public static void main(String[] args) {

        CreditCard card1 = new CreditCard(12356,1000);
        CreditCard card2 = new CreditCard(47690,1200);
        CreditCard card3 = new CreditCard(96473,500);

        System.out.println(card1.add(300));
        System.out.println(card2.add(600));
        System.out.println(card3.remove(600));

        System.out.println();
        card1.current();
        System.out.println();
        card2.current();
        System.out.println();
        card3.current();

    }
}
