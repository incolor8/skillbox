public class CargoCar {
    public static int cargoCar;
    public static int container;
    public static int box;

    public final int MAX_BOX = 27;
    public final int MAX_CONTAINER = 12;

    public CargoCar(int box) {

            container = (int) Math.ceil(box / (double) (MAX_BOX));
            cargoCar = (int) Math.ceil(container / (double) (MAX_CONTAINER));
    }

    public void printBox() {
        int boxCount = 1;
        int containerCount = 1;
        for (int cargoCount = 1; cargoCount <= cargoCar; cargoCount++) {
            System.out.println("Грузовик: " + cargoCount);
            for (int a = 1; a <= MAX_CONTAINER && containerCount <= container; a++) {
                System.out.println("\tКонтейнер: " + containerCount);
                for (int i = 1; i <= MAX_BOX && boxCount <= box; i++) {
                    System.out.println("\t\tЯщик " + boxCount);
                    ++boxCount;
                }
                containerCount++;
            }
        }
    }
}
