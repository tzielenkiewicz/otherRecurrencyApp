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
        int[] table2 = new int[]{0, 4, 6, 9, 10, 14, 15, 18, 19, 20};
        int start = 0;
        int end = table2.length;
        Scanner value = new Scanner(System.in);
        System.out.println();
        System.out.println("Following table is given: ");
        for (int item:table2) System.out.print(item + " ");

        System.out.println();
        System.out.print("Which number are you looking for in given table?: ");
        int requestedVal = value.nextInt();
        lookForValue(requestedVal, start, end, table2);
    }

    private static void lookForValue(int requestedVal, int start, int end, int[] tab) {

        if (tab[end-1] < requestedVal || tab[start] > requestedVal)
            System.out.println("This value was not found in that table...");
        else if (tab[(start + end)/2] == requestedVal) {
            System.out.println("This value is found in the table with the index of " + (start + end)/2);
            System.exit(0);

        }
        else if (tab[(start + end)/2] > requestedVal) {
            lookForValue(requestedVal, start, (start + end)/2, tab);
        }
        else if (tab[(start + end)/2] < requestedVal) {
            lookForValue(requestedVal, (start + end)/2, end, tab);
        }


    }

    private static void tableTrans(int start, int end, int[] table) {
        if (start < end) {
            int temp = table[start];
            table[start] = table [end];
            table[end] = temp;
            tableTrans(start + 1, end - 1, table);
        }
    }
}
