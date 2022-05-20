import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Sort_content_of_vector {

    List_of_distances L;
    int number_of_neighbours;



    public Sort_content_of_vector(List_of_distances l, int num){
        number_of_neighbours = num;
        L = l;
    }


    public List_of_distances execute(){


        ArrayList<Vector> distances_to_flowers_from_vector = new ArrayList<Vector>();

        for ( int j = 0 ; j < L.distances_to_flowers_from_vector.size(); j++){
            ArrayList<Double> Distances = new ArrayList<Double>();
            ArrayList<Flower> Flowers = new ArrayList<Flower>();
            Flower flow = L.distances_to_flowers_from_vector.get(j).flow;

            distances_to_flowers_from_vector.add(new Vector(Distances,Flowers,flow));
        }

        List_of_distances newer = new List_of_distances(distances_to_flowers_from_vector);


        for ( int i = 0; i < L.distances_to_flowers_from_vector.size(); i++ ) {

            for ( int y = 0; y < number_of_neighbours ; y++ ) {
                Double smallest = Collections.min(L.distances_to_flowers_from_vector.get(i).Distances);

                int index = L.distances_to_flowers_from_vector.get(i).Distances.indexOf(smallest);

                Flower SmallestF = L.distances_to_flowers_from_vector.get(i).Flowers.get(index);

                L.distances_to_flowers_from_vector.get(i).Distances.remove(smallest);
                L.distances_to_flowers_from_vector.get(i).Flowers.remove(SmallestF);


                newer.distances_to_flowers_from_vector.get(i).Flowers.add(SmallestF);
                newer.distances_to_flowers_from_vector.get(i).Distances.add(smallest);
            }

        }
        return newer;
    }
}

