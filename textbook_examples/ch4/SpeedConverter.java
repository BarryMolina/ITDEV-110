public class SpeedConverter {

    public static void main(String[] args) {

        final int STARTING_KPH = 60;
        final int MAX_KPH = 130;
        final int INCREMENT = 10;
        
        int kph;
        double mph;

        System.out.println("KPH\t\tMPH"); 
        System.out.println("--------------------"); 

        for (kph = STARTING_KPH; kph <= MAX_KPH; kph += INCREMENT) {
            mph = kph * 0.6214;

            System.out.printf("%d\t\t%.1f\n", kph, mph);
        }

    }
}
