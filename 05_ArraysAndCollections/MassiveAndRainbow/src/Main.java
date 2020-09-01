public class Main
{
    public static void main(String[] args)
    {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colors = text.split(",?\\s+");

        String[] reversedColors = new String[7];

        for (int i = colors.length - 1; i >= 0; i--)
        {
            System.out.print(colors[i] + " ");
        }
        System.out.println(); // переход на след строку

        String reversedColor; // переменная для обмена елементов

        for(int index = 0; index < colors.length; index++) // заполняем массив обратными значениями
        {
            reversedColor = colors[colors.length - index - 1];
            colors[colors.length - index - 1] = reversedColors[index];
            reversedColors[index] = reversedColor;
        }

        for(int i = reversedColors.length - 1; i >= 0; i--) // вывод массива
        {
            System.out.print(reversedColors[i] + " ");
        }

        System.out.println("\n=============================================================");

        PatientsTemp patients = new PatientsTemp();
        float[] array = new float[patients.patientsTemp.length];
        for (int z = 0; z < patients.patientsTemp.length; z++)
        {
            patients.patientsTemp[z] = (float) (Math.random() * (patients.MAX_TEMP - patients.MIN_TEMP) + patients.MIN_TEMP);
            float temp = patients.patientsTemp[z];
            array[z] = temp;
        }

        System.out.println("Средняя температура по больнице: " + getAverageTemperature(patients.patientsTemp));
        System.out.println("\nКоличество здоровых пациентов: " + getHealthyPatientsCount(patients.patientsTemp));
    }

    public static float getAverageTemperature(float[] array) {
        float average = 0;
        for (int i = 0; i < array.length; i++)
        {
            average += array[i];
        }
        average = average / array.length;
        return average;
    }

    public static int getHealthyPatientsCount(float[] array) {
        int healthyPatients = 0;
        System.out.print("Температуры здоровых пациентов: ");
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] <= new PatientsTemp().MAX_NORM_TEMP && array[i] >= new PatientsTemp().MIN_NORM_TEMP)
            {
                System.out.print(array[i] + " ");
                healthyPatients++;
            }
        }
        return healthyPatients;
    }
}
