package domain;

import domain.data.CellState;

import java.awt.*;
import java.util.Arrays;
import java.util.Stack;

import static domain.data.CellState.*;

/**
 * Реализация {@link Percolation}.
 */
public class PercolationImpl3 implements Percolation {

    private final CellState[][] array;
    private final int size;
    private boolean hasPercolation;
    private int openCells;

    public PercolationImpl3(int size) {
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
        if (array[x][y] != LOCK) return;

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

    private void setCellStateFull(int xCell, int yCell) {
        if (array[xCell][yCell] != OPEN) return;

        array[xCell][yCell] = FULL;

        Stack<Point> stack = new Stack<>();
        stack.add(new Point(xCell, yCell));

        while (!stack.isEmpty()) {
            Point point = stack.pop();
            int y = point.y;
            int x = point.x;
            if (y == size - 1) {
                hasPercolation = true;
            }
            if (y < size - 1 && array[x][y + 1] == OPEN) {
                array[x][y + 1] = FULL;
                stack.add(new Point(x, y + 1));
            }
            if (x < size - 1 && array[x + 1][y] == OPEN) {
                array[x + 1][y] = FULL;
                stack.add(new Point(x + 1, y));
            }
            if (y > 0 && array[x][y - 1] == OPEN) {
                array[x][y - 1] = FULL;
                stack.add(new Point(x, y - 1));
            }
            if (x > 0 && array[x - 1][y] == OPEN) {
                array[x - 1][y] = FULL;
                stack.add(new Point(x - 1, y));
            }
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
