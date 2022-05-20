import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    static int expected_number_of_coordinates = 0;

    public File File_Path;
    ArrayList<Flower> Flowers = new ArrayList<Flower>();

    public ReadFile(File  FP){
    File_Path = FP;
    }

    public ArrayList<Flower> Go_over_file() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(File_Path));

        int line_nubmer_of_error = 0;

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {

            String[] floatStrings = line.split(",");

            ArrayList<String> Coord = new ArrayList<String>();
            String Flower_name = "";

            for (int i = 0; i < floatStrings.length; i++) {
                if (i == floatStrings.length - 1){
                    Flower_name = floatStrings[i];
                }else{
                    Coord.add(floatStrings[i]);
                }
            }

            Flower New_flower = new Flower(Flower_name, Coord);

            Flowers.add(New_flower);

            if ( Flowers.size() == 1){
                expected_number_of_coordinates = floatStrings.length - 1;

            }else{
                if (Flowers.get(Flowers.size() - 1).Coordinates.size() != expected_number_of_coordinates){
                System.err.println("Wrong cooridnates at line no " + line_nubmer_of_error);
                System.exit( 2);
                };

            };
            line_nubmer_of_error++;
        }
            for (int i = 0; i < Flowers.size() ; i++){
                System.out.println(Flowers.get(i));
            }
            return Flowers;
    }
}
