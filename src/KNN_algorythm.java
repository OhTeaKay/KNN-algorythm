import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class KNN_algorythm {

    List_of_Flowers Train;
    List_of_Flowers Test;
    int number_of_coordinates;
    ArrayList<Vector> Vectors = new ArrayList<Vector>();


    public KNN_algorythm(List_of_Flowers TR, List_of_Flowers TE) {
        Train = TR;
        Test = TE;
        number_of_coordinates = Train.Flower_L.get(0).Coordinates.size();
    }

    public ArrayList<Vector> execution(){

        for (int i = 0; i < Test.Flower_L.size(); i++) {

            ArrayList<Double> Distances = new ArrayList<Double>();
            ArrayList<Flower> Flowers = new ArrayList<Flower>();
            Vector v = new Vector(Distances,Flowers,Test.Flower_L.get(i));

            for (int l = 0; l < Train.Flower_L.size(); l++) {
                Double sum_of_subtractions = 0.0;

                for (int j = 0; j < number_of_coordinates; j++) {

                Double one_coordinate_distance =
                        pow((Double.parseDouble(Test.Flower_L.get(i).Coordinates.get(j)) -
                        Double.parseDouble(Train.Flower_L.get(l).Coordinates.get(j))),2);


                sum_of_subtractions += one_coordinate_distance;
                }

                if (Test.Flower_L.get(i).Coordinates != Train.Flower_L.get(l).Coordinates){
                v.Flowers.add(Train.Flower_L.get(l));
                v.Distances.add(sqrt(sum_of_subtractions));}


            }
            Vectors.add(v);
        }

        return Vectors;
    }
}
