import domain.PercolationStats;
import domain.PercolationStatsImpl;
import domain.data.PercolationStatsData;

public class Main {
    public static void main(String[] arg) {
        System.out.println("Сделай меня !");
        /*
        Для стандартоного ввода данных можно использовать класс Scanner
        Создать объект класса Scanner можно так - new Scanner(System.in);
        Дальше у объекта класса Scanner нужно поискать методы для чтения данных
        */
        //TODO прочитать размер из стандартного ввода
        int size = 0;
        //TODO прочитать количество решеток в эксперименте из стандартного ввода
        int trials = 0;

        PercolationStats percolationStats = new PercolationStatsImpl();
        PercolationStatsData data = percolationStats.execute(size, trials);

        //TODO вывести в стандартный вывод строковое представление data
    }
}
