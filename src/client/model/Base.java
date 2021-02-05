package client.model;

// TODO: convert to cell
public class Base {
    private int xCoordinate;
    private int yCoordinate;

    public Base(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }
}
