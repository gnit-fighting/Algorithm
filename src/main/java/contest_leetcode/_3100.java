package contest_leetcode;

public class _3100 {
    public static void main(String[] args) {
        System.out.println(new _3100().maxBottlesDrunk(13,6));
    }
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int fullBottles = numBottles;
        int emptyBottles = 0;
        int bottlesDrunk = 0;


        while (fullBottles != 0) {

            bottlesDrunk += fullBottles;
            emptyBottles += fullBottles;
            fullBottles -= fullBottles;

            //exchange
            while (emptyBottles >= numExchange) {
                emptyBottles -= numExchange;
                fullBottles++;
                numExchange++;
            }

        }
        return bottlesDrunk;

    }
}
