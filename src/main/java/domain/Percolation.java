package domain;

import domain.data.CellState;

/**
 * Интерфейс решетки
 * <p>
 * Начало координат в левом верхнем углу, OY направленна вниз OX - вправо
 * Левая верхняя ячейка (0;0)
 */
public interface Percolation {
    /**
     * Размер решетки
     */
    public int getSize();

    /**
     * Протекает ли данная решетка
     */
    public boolean hasPercolation();

    /**
     * Открыть ячейку
     *
     * @param x х координата ячейки
     * @param y у координата ячейки
     */
    public void openCell(int x, int y);

    /**
     * Количество открытых ячеек
     */
    public long getOpenCellsCount();

    /**
     * Получить состояние ячейки
     *
     * @param x х координата ячейки
     * @param y у координата ячейки
     */
    public CellState getCellState(int x, int y);

    /**
     * Закрыть все ячейки
     */
    public void closeAllCell();
}
