package client.model;

public class Map {
    private Cell[][] cells;
    private int width;
    private int height;

    public Map(Cell[][] cells, int width, int height) {
        this.cells = cells;
        this.width = width;
        this.height = height;
    }

    public Cell getCell(int x, int y, int distance) {
        if (Math.abs(x) + Math.abs(y) > distance)
            return null;
        if (distance + x >= width | distance + x < 0)
            return null;
        if (distance - y < 0 | distance - y >= height)
            return null;

        return cells[distance - y][distance + x];
    }
}
