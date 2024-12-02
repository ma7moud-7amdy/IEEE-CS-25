import java.util.Scanner;

public class ArrivaOfTheGeneral {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = input.nextInt();
        }
        int maxIndex = 0;
        int max = heights[0];
        // find maximum height 
        for (int i = 1; i < n; i++) {
            if (heights[i] > max) {
                max = heights[i];
                maxIndex = i;
            }
        }
        int minIndex = n - 1;
        int min = heights[minIndex];
        // find minimum height 
        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] < min) {
                min = heights[i];
                minIndex = i;
            }
        }
        int time = 0;
        if (maxIndex < minIndex) {
            time = maxIndex + (n - 1 - minIndex);
        } else {
            time = maxIndex + (n - 2 - minIndex);
        }
        
        System.out.println(time);

    }
}