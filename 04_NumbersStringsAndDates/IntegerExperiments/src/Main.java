public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();

        container.setCount(2);
        container.count += 7844;
        System.out.println(sumDigits(container.count));
    }

    public static int sumDigits(Integer number)
    {
        //@TODO: write code here
        int digits = 0;
        String str = Integer.toString(number);

        for(int i = 0; i < str.length(); i++) {
            int ex = Character.getNumericValue(str.charAt(i));
            digits += ex;
        }

        return digits;
    }
}
