import com.sun.jdi.DoubleValue;

public class Print_distances_and_clasifcation {
    List_of_distances P;

    public Print_distances_and_clasifcation(List_of_distances prep){
         P = prep;

    }

    public void execute(){
        double licz = P.distances_to_flowers_from_vector.size();
        double mian = P.distances_to_flowers_from_vector.size();

        for ( int i = 0 ; i < P.distances_to_flowers_from_vector.size() ; i++) {
            System.out.println(P.distances_to_flowers_from_vector.get(i));

            String[] arr = new String[P.distances_to_flowers_from_vector.get(i).Flowers.size()];

            for (int j = 0; j < P.distances_to_flowers_from_vector.get(i).Flowers.size(); j++){
                arr[j] = P.distances_to_flowers_from_vector.get(i).Flowers.get(j).Flower_type;
            }
            int n = arr.length;
            int max_count = 1;
            String res = arr[0];
            int curr_count = 1;


            for (int h = 1; h < n; h++)
            {
                if (arr[h] == arr[h - 1])
                    curr_count++;
                else
                {
                    if (curr_count > max_count)
                    {
                        max_count = curr_count;
                        res = arr[h - 1];
                    }
                    curr_count = 1;

                }
            }


            if (curr_count > max_count)
            {
                max_count = curr_count;
                res = arr[n - 1];
            }

            String flower = P.distances_to_flowers_from_vector.get(i).flow.Flower_type;
            if (!res.equals(flower)) {
                licz--;
            }
            int count_accuracy = 0;

            for ( int l = 0 ; l < arr.length; l++){
                if (arr[l].equals(res)){
                    count_accuracy++;
                }
            }

            System.out.println("Wynik klasyfikacji: " + Main.ANSI_YELLOW  + res + Main.ANSI_RESET + "\n");
            System.out.println(Main.ANSI_YELLOW + "Accuracy: " + ((double) count_accuracy / (double)Main.K) * 100 + "%" + "\n" + Main.ANSI_RESET);

        }
        if (mian != 1)
        System.out.println("Overall Accuracy = " + licz/mian *100 + "%");
    }
}
