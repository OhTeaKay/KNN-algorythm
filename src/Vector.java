import java.util.ArrayList;
import java.util.HashMap;


public class Vector {

    ArrayList<Double> Distances = new ArrayList<Double>();
    ArrayList<Flower> Flowers = new ArrayList<Flower>();
    Flower flow;

    public Vector(ArrayList<Double> D, ArrayList<Flower> F, Flower f) {
        Distances = D;
        Flowers = F;
        flow = f;


    }

    @Override
    public String toString() {
        return " Odległość kwiatka testowego o danych { " + flow + " } do kolejnych kwiatków: " +

                "\n" + Distances +
                "\n" + Flowers + "";
    }
}
