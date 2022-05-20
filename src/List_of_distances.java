import java.util.ArrayList;

public class List_of_distances {
    ArrayList<Vector> distances_to_flowers_from_vector;

    public List_of_distances(ArrayList<Vector> Ds){

        distances_to_flowers_from_vector = Ds;

    }

    @Override
    public String toString() {
        return "List_of_distances{" +
                "distances_to_flowers_from_vector=" + distances_to_flowers_from_vector +
                '}';
    }
}
