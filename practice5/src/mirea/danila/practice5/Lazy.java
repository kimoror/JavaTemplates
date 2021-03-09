package mirea.danila.practice5;

public class Lazy {
    private double weight;
    private double height;
    private static Lazy object;
    private Lazy(double weight, double height){
       this.weight = weight;
       this.height = height;
    }

    public static synchronized Lazy getObject(double weight, double height){
        if(object == null){
            object =  new Lazy(weight, height);
        }
        return object;
    }

    @Override
    public String toString() {
        return "Lazy{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
