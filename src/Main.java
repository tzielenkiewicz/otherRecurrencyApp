import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner howMany = new Scanner(System.in);
        System.out.print("How many numbers in the table?: ");
        n = howMany.nextInt();
        int table[] = new int[n];

        System.out.println("Your table contains: ");
        for (int i = 0; i < n; i++) {
            table[i] = i;
            System.out.print(table[i] + " ");
        }

        tableTrans(0, table.length-1, table);

        System.out.println();
        System.out.println("And now it has changed:");
        for (int item:table) {
            System.out.print(item + " ");
        }
    }

    private static void tableTrans(int start, int end, int table[]) {
        if (start < end) {
            int temp = table[start];
            table[start] = table [end];
            table[end] = temp;
            tableTrans(start + 1, end - 1, table);
        }
    }
}
