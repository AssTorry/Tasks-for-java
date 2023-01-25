package domain;

import domain.data.CellState;

/**
 * Реализация {@link Percolation}.
 */
public class PercolationImpl implements Percolation {

    private int size;

    public PercolationImpl(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        //TODO реализовать метод
        return 0;
    }

    @Override
    public boolean hasPercolation() {
        //TODO реализовать метод
        return false;
    }

    @Override
    public void openCell(int x, int y) {
        //TODO реализовать метод
    }

    @Override
    public long getOpenCellsCount() {
        //TODO реализовать метод
        return 0;
    }

    @Override
    public CellState getCellState(int x, int y) {
        //TODO реализовать метод
        return null;
    }

    @Override
    public void closeAllCell() {
        //TODO реализовать метод
    }
}
