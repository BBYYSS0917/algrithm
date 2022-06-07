/**
 * @author Donquixote
 * @date 2022/06/08
 **/
public class CalExchangeRate {
    public static void main(String[] args) {
        int step = 1;
        final int MIN_USD_RATE = 64000;
        final int MAX_USD_RATE = 66000;
        final int MIN_SGD_RATE = 48000;
        final int MAX_SGD_RATE = 50000;
        for (int usd_rate = MIN_USD_RATE; usd_rate <= MAX_USD_RATE; usd_rate = usd_rate + step) {
            for (int sgd_rate = MIN_SGD_RATE; usd_rate <= MAX_SGD_RATE; sgd_rate = sgd_rate + step) {
                if (2000000 * usd_rate == 2713988 * sgd_rate) {
                    System.out.println(usd_rate);
                    System.out.println("\n");
                    System.out.println(sgd_rate);
                    return;
                }
            }
        }
        System.out.println("expect rate not exist");
    }
}
