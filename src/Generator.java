import java.util.Random;

public class Generator {
    public static Integer[] generateRandom(int n){
        Random rand = new Random();
        Integer[] tab = new Integer[n];
        for (int i = 0; i < n; i++) {
            tab[i] = rand.nextInt(n*10);
        }
        return tab;
    }
    public static Integer[] generateDesc(int n){
        Integer[] tab = new Integer[n];
        for (int i = 0; i < n; i++) {
            tab[i] = n-i;
        }
        return tab;

    }
    public static Integer[] generateAsc(int n){
        Integer[] tab = new Integer[n];
        for (int i = 0; i < n; i++) {
            tab[i] = i;
        }
        return tab;
    }
}
