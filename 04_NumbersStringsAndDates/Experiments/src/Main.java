import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//          Грузовики, контейнеры, ящики
//          Грузовик => 12 контейнеров
//          Контейнер => 27 ящиков

        System.out.println("Введите количество ящиков: ");
        CargoCar.box = new Scanner(System.in).nextInt();

        CargoCar cargo = new CargoCar(CargoCar.box);
        cargo.printBox();
    }
}
