package domain.data;

/**
 * Состояние ячейки
 */
public enum CellState {
    /**
     * Ячейка открыта
     */
    OPEN,
    /**
     * Ячейка закрыта
     */
    LOCK,
    /**
     * Ячейка открыта и протекает
     *
     * Ячейка протекает если хотя бы одна соседняя ячейка протекает,
     * или если это не закрытая ячейка в самой верхней строке (y координата = 0)
     */
    FULL
}
