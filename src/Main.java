public class Main {
    public static void main(String[] args) {
        NaturalComp nc = new NaturalComp();
        ArrayBubbleSort<Integer> abs = new ArrayBubbleSort<>(nc);
        ArrayInsertSort<Integer> ais = new ArrayInsertSort<>(nc);
        ArrayQuickSort<Integer> aqs = new ArrayQuickSort<>(nc);
        ArraySelectSort<Integer> ass = new ArraySelectSort<>(nc);
        ArrayMaxHeapSort<Integer> amhs = new ArrayMaxHeapSort<>(nc);
        ArrayMergeSort<Integer> ams = new ArrayMergeSort<>(nc);
        int n=100000;
        System.out.println("Ilość danych: " +n);

        //dane losowe
        System.out.println("Wyniki dla danych losowych:");
        Integer[] tab1 = Generator.generateRandom(n);
        execute(abs, tab1.clone());
        execute(ais , tab1.clone());
        execute(aqs, tab1.clone());
        execute(ass, tab1.clone());
        execute(amhs, tab1.clone());
        execute(ams, tab1.clone());

        //dane rosnące
        System.out.println("Wyniki dla danych rosnących:");
        Integer[] tab2 = Generator.generateAsc(n);
        execute(abs, tab2.clone());
        execute(ais , tab2.clone());
        execute(aqs, tab2.clone());
        execute(ass, tab2.clone());
        execute(amhs, tab2.clone());
        execute(ams, tab2.clone());

        //dane malejące
        System.out.println("Wyniki dla danych malejących:");
        Integer[] tab3 = Generator.generateDesc(n);
        execute(abs, tab3.clone());
        execute(ais , tab3.clone());
        execute(aqs, tab3.clone());
        execute(ass, tab3.clone());
        execute(amhs, tab3.clone());
        execute(ams, tab3.clone());


    }
    public static void execute(ArraySorter<Integer> sorter, Integer[] arr){
        long start = System.currentTimeMillis();
        sorter.sort(arr);
        long stop = System.currentTimeMillis();
        System.out.println(sorter.getClass()+" time to process: "+(stop-start));
    }
}
