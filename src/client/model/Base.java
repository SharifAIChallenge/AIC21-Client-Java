package client.model;

public class Base {
    private int workersCount;
    private int soldiersCount;
    private int xCoordinate;
    private int yCoordinate;

    public Base(int workersCount, int soldiersCount, int xCoordinate, int yCoordinate) {
        this.workersCount = workersCount;
        this.soldiersCount = soldiersCount;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getWorkersCount() {
        return workersCount;
    }

    public int getSoldiersCount() {
        return soldiersCount;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }
}
