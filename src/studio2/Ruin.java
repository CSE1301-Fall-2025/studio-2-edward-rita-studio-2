

public class Ruin {
    public static void main(String[] args){
        int startAmount = 100;
        double winChance = 0.4;
        int winLimit = 105;
        int totalSimulations = 50;
        int game = 0;
        int ruin = 0;
        int win = 0;
        double expectedRuin = 0;
        for (int date = 1; date <= totalSimulations; date ++ ){
            while (startAmount > 0 && startAmount < winLimit) {
                game += 1;
                if (Math.random() < winChance) {
                    startAmount += 1;  
                }
                else {
                    startAmount -= 1;
                }
            }
            System.out.println("Today you played " + game + " times.");
            game = 0;
            System.out.print("It is day "+ date+ ".");
            if (startAmount >= winLimit) {
                System.out.println("you win today!");
                win += 1;
            }
            else{
                System.out.println("you ruin!");
                ruin += 1;
            }
            startAmount = 100;
        }
        System.out.println(ruin);
        System.out.println("The ruin rate is " + (double)ruin/totalSimulations *100 + "%.");
        expectedRuin = 1 - ((double)startAmount/winLimit);
        System.out.println("The expected ruin rate is "+ (double)expectedRuin*100 + "%");
    }

}
