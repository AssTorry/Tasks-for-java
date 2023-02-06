package domain;

import domain.data.PercolationStatsData;

public interface PercolationStats {
    /**
     * Выполнить эксперимент
     *
     * @param size   размер стороны решетки
     * @param trials количество решеток в эксперименте
     */
    public PercolationStatsData execute(int size, int trials);
}
