public class Main {
    public static void main(String[] args) {

        String[][] array = new String[7][7];
        /**
        for (int i = 0; i < array.length; i++)
        {
            if (i > 0) {
                System.out.println(" ");
            }
            for (int j = 0; j < array.length; j++) {
                if (i == 0 && j == 6 || i == 6 && j == 6 || i == 0 && j == 0 || i == 6 && j == 0) {
                    array[j][i] = "X";
                } else if (i == 1 && j == 5 || i == 5 && j == 5 || i == 1 && j == 1 || i == 5 && j == 1) {
                    array[j][i] = "X";
                } else if (i == 2 && j == 4 || i == 4 && j == 4 || i == 2 && j == 2 || i == 4 && j == 2) {
                    array[j][i] = "X";
                } else if (i == 3 && j == 3) {
                    array[j][i] = "X";
                } else { array[j][i] = " "; }
                System.out.print(array[j][i]);
            }
        } */

        for (int i = 0; i < array.length; i++)
        {
            if (i > 0) {
                System.out.println(" ");
            }
            for (int j = 0; j < array.length; j++)
            {
                if (i == j || j == array.length - i - 1) {
                    array[j][i] = "X";
                } else { array[j][i] = " "; }
                System.out.print(array[j][i]);
            }
        }

    }
}