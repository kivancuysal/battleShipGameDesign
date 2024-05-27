import java.util.List;

public class Ship {

    private int size;
    private ShipType type;
    private Direction direction;
    private List<Coordinate> coordinates;
    private boolean isSunk;

    //constructors
    public Ship(ShipType type, Direction direction, boolean isSunk) {
        this.type = type;
        this.direction = direction;
        this.isSunk = isSunk;

        if (this.type == ShipType.CARRIER) {
            size = 5;
        } else if (this.type == ShipType.BATTLESHIP) {
            size = 4;
        } else if (this.type == ShipType.CRUISER) {
            size = 3;
        } else {
            size = 2;
        }
    }

    // getters and setters
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public boolean getIsSunk() {
        return isSunk;
    }

    public void setIsSunk(boolean isSunk) {
        this.isSunk = isSunk;
    }
}