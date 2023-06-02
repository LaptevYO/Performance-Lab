import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int sum = 0, average = 0, step = 0;
        ArrayList<Integer> ArrayList= new ArrayList<>();

        Scanner scanner = new Scanner(new File(args[0]));
        while(scanner.hasNextInt())
            ArrayList.add(scanner.nextInt());
        for (int i = 0; i < ArrayList.size(); i++) {
            sum += ArrayList.get(i);
        }
        average = sum / Integer.valueOf(ArrayList.size());
        for (int i = 0; i < ArrayList.size(); i++) {
            step += Math.abs(ArrayList.get(i) - average);
        }
        System.out.println(step);
    }
}