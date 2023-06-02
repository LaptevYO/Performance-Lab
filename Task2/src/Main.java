import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        float x2 = 0;
        float y2 = 0;
        float[] circle = new float[3];
        ArrayList<Float> ArrayList= new ArrayList<>();

        Scanner scanner = new Scanner(new File(args[0]));
        while(scanner.hasNextFloat())
            ArrayList.add((float) scanner.nextFloat());

        scanner = new Scanner(new File(args[1]));
        for (int j = 0; scanner.hasNextFloat(); j++)
            circle[j] = scanner.nextFloat();

        for(int i = 0;i < ArrayList.size();i+=2) {
            x2 = ArrayList.get(i);
            y2 = ArrayList.get(i+1);
            double result = (Math.pow((x2 - circle[0]), 2)) + (Math.pow((y2 - circle[1]), 2));
            if (result > Math.pow(circle[2], 2)) {
                System.out.println("2");
            } else if (result == Math.pow(circle[2], 2)) {
                System.out.println("0");
            } else {
                System.out.println("1");
            }
        }
    }
}