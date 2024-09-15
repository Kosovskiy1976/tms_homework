import lombok.Setter;

@Setter
public class MathService {

    private Type type;

    public int operation(int a, int b, int c) {

        return switch (type){
            case SUM -> a + b + c;
            case MUL -> a*b*c;
        };
    }


    public static enum Type{
        SUM,
        MUL
    }
}


