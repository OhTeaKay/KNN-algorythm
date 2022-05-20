import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int K; // number of neighbours
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main (String[] args) throws IOException {
        ReadFile Train = new ReadFile(new File(args[1]));
        List_of_Flowers Train_flowers = new List_of_Flowers(Train.Go_over_file()); // zczytujemy kwiatki z pliku do obiektów typu Flower

        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");

        ReadFile Test = new ReadFile(new File(args[2]));
        List_of_Flowers Test_flowers = new List_of_Flowers(Test.Go_over_file()); // zczytujemy kwiatki z pliku do obiektów typu Flower


        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");

        KNN_algorythm knn = new KNN_algorythm(Train_flowers,Test_flowers); //
        List_of_distances lod = new List_of_distances(knn.execution());// w obiekcie vector zapisujemy kwiatek testowy wraz z odległosciami do innych każdy vecktor dodajemy do tablicy

        /*for ( int i = 0 ; i < lod.distances_to_flowers_from_vector.size() ; i++){
            System.out.println(lod.distances_to_flowers_from_vector.get(i));
        }*/

        System.out.println( "┌───────────────────────────────────────────────────── •✧✧• ──────────────────────────────────────────────────────────┐\n" +
                ANSI_YELLOW +"                              -RESULTS IN A FORM OF TEST FLOWER AND ADJECENT ONES- \n" + ANSI_RESET +
                            "└──────────────────────────────────────────────────────•✧✧• ──────────────────────────────────────────────────────────┘\n");

        int KKK = Integer.parseInt(args[0]);
        K = KKK;
        Sort_content_of_vector scov = new Sort_content_of_vector(lod,KKK); // sortujemy odległości do kwiatków
        List_of_distances prep = scov.execute();

        Print_distances_and_clasifcation Pdac = new Print_distances_and_clasifcation(prep);
        Pdac.execute();


        while(true) {
            System.out.println(ANSI_YELLOW + "Insert " + ReadFile.expected_number_of_coordinates + " numbers \n" + " ↳ "+ ANSI_RESET);

            ArrayList<String> Single_cord = new ArrayList<String>();

            for (int i = 0; i < ReadFile.expected_number_of_coordinates; i++) {
                Scanner myObj = new Scanner(System.in);
                String userName = myObj.nextLine();
                Single_cord.add(userName);
            }


            Flower for_single_data = new Flower("unknown", Single_cord);
            ArrayList<Flower> floww = new ArrayList<Flower>();
            floww.add(for_single_data);
            List_of_Flowers single_arg = new List_of_Flowers(floww);
            KNN_algorythm knnn = new KNN_algorythm(Train_flowers, single_arg);
            List_of_distances lodS = new List_of_distances(knnn.execution());//


        /*for ( int i = 0 ; i < lod.distances_to_flowers_from_vector.size() ; i++){
            System.out.println(lod.distances_to_flowers_from_vector.get(i));
        }*/

            int single_number_of_neighbours = Integer.parseInt(args[0]);
            Sort_content_of_vector sort_one = new Sort_content_of_vector(lodS, single_number_of_neighbours);
            List_of_distances prep_one = sort_one.execute();

            Print_distances_and_clasifcation Pdac1 = new Print_distances_and_clasifcation(prep_one);
            Pdac1.execute();


        }



    }
}

