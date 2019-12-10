public class PigDice {
    public static void main(String[] args) {
        Dice dice = new Dice(6);
        dice.roll();
        System.out.println(dice);
        dice.roll();
        System.out.println(dice);

    }
}
