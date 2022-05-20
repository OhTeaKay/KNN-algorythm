import java.util.ArrayList;

public class Flower {

    String Flower_type;
    ArrayList<String> Coordinates = new ArrayList<String>();
    double distance_to_flower_test = 0;


    public Flower(String FT, ArrayList<String> C){
        Flower_type = FT;
        Coordinates = C;

    }

    public Flower(String FT, ArrayList<String> C, double dtf){
        Flower_type = FT;
        Coordinates = C;
        distance_to_flower_test = dtf;

    }

    @Override
    public String toString() {
        return "Typ kwiatka: " +
                Flower_type +
                " Współrzędne kwiatka: " + Coordinates;
    }
}

