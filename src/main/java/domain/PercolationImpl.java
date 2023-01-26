package domain;

import domain.data.CellState;

import java.util.Arrays;

import static domain.data.CellState.*;

/**
 * Реализация {@link Percolation}.
 */
public class PercolationImpl implements Percolation {

    private final CellState[][] array;
    private final int size;
    private boolean hasPercolation;
    private int openCells;

    public PercolationImpl(int size) {
        array = new CellState[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(array[i], LOCK);
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean hasPercolation() {
        return hasPercolation;
    }

    @Override
    public void openCell(int x, int y) {
        openCells = openCells + 1;
        array[x][y] = OPEN;
        boolean isNewOpenCellPercolated = false;

        if (y == 0) {
            isNewOpenCellPercolated = true;
        }

        if (y < size - 1 && array[x][y + 1] == FULL) {
            isNewOpenCellPercolated = true;
        }
        if (x < size - 1 && array[x + 1][y] == FULL) {
            isNewOpenCellPercolated = true;
        }
        if (y > 0 && array[x][y - 1] == FULL) {
            isNewOpenCellPercolated = true;
        }
        if (x > 0 && array[x - 1][y] == FULL) {
            isNewOpenCellPercolated = true;
        }

        if (isNewOpenCellPercolated) {
            setCellStateFull(x, y);
        }
    }

    private void setCellStateFull(int x, int y) {
        if (array[x][y] != OPEN || hasPercolation) {
            return;
        }
        array[x][y] = FULL;

        if (y == size - 1) {
            hasPercolation = true;
            return;
        }

        if (y < size - 1) {
            setCellStateFull(x, y + 1);
        }
        if (x < size - 1) {
            setCellStateFull(x + 1, y);
        }
        if (y > 0) {
            setCellStateFull(x, y - 1);
        }
        if (x > 0) {
            setCellStateFull(x - 1, y);
        }
    }

    @Override
    public long getOpenCellsCount() {
        return openCells;
    }

    @Override
    public CellState getCellState(int x, int y) {
        return array[x][y];
    }

    @Override
    public void closeAllCell() {
        for (int i = 0; i < size; i++) {
            Arrays.fill(array[i], LOCK);
        }
        hasPercolation = false;
        openCells = 0;
    }
}
