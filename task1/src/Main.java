import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[] arr = new int[n];
        Arrays.setAll(arr, i -> ++i);
        int a = 0;
        do {
            System.out.print(arr[a]);
            a = (a + m - 1) % n;
        } while (a != 0);
    }
}