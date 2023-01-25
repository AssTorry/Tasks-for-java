package domain.data;

/**
 * Результат выполнения эксперимента с решетками
 */
public class PercolationStatsData {
    /**
     * Размер решеток в эксперименте
     */
    public int size;
    /**
     * Количество решеток в экспериметне
     */
    public int trials;
    /**
     * Среднее отношение открытых ячеек к закрытым по всем протекшим решеткам
     */
    public double p;
    /**
     * Минимальное отношение открытых ячеек к закрытым по всем протекшим решеткам
     */
    public double pMin;
    /**
     * Максимальное отношение открытых ячеек к закрытым по всем протекшим решеткам
     */
    public double pMax;

    public PercolationStatsData(int size, int trials, double p, double pMin, double pMax) {
        this.size = size;
        this.trials = trials;
        this.p = p;
        this.pMin = pMin;
        this.pMax = pMax;
    }

    @Override
    public String toString() {
        //TODO заменить на адекватное представление класса в строку
        return super.toString();
    }
}
