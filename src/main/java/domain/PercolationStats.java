package domain;

import domain.data.PercolationStatsData;

/**
 * Интерфейс для выполнения эксперимента
 */
public interface PercolationStats {
    /**
     * Выполнить эксперимент
     *
     * @param size   размер стороны решетки
     * @param trials количество решеток в эксперименте
     */
    public PercolationStatsData execute(int size, int trials);
}
