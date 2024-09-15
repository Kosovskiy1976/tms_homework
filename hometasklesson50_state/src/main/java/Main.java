public class Main {

    public static void main(String[] args) {
        MathService mathService = new MathService();
        mathService.setType(MathService.Type.MUL);

        System.out.println(mathService.operation(8,78, 34));

        MathService mathService2 = new MathService();
        mathService2.setType(MathService.Type.SUM);

        System.out.println(mathService2.operation(8,78, 34));
    }
}
