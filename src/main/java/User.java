public class User {
    public String name;
    public Status Prof;
    public int lenth;

    public User(String name, Status prof, int lenth) {
        this.name = name;
        this.Prof = prof;
        this.lenth = lenth;
    }

    public long calculation() {
        long salary = 0;
        int coefficient = 0;
        switch (Prof) {
            case WORKER:
                coefficient = 1;
                break;
            case HR:
                coefficient = 2;
                break;
            case DIRECTOR:
                coefficient = 3;
                break;
        }
        salary = 1000 * lenth * coefficient;
        return salary;
    }

    public long calculadd(int add) {
        long salary = 0;
        salary = this.calculation() + add;
        return salary;
    }


}
