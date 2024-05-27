public class Coordinate {

    private int corX;
    private int corY;

    // constructors
    public Coordinate() {}

    public Coordinate(int corX, int corY) {
        this.corX = corX;
        this.corY = corY;
    }

    //getters and setters
    public int getCorX() {
        return corX;
    }

    public void setCorX(int corX) {
        this.corX = corX;
    }

    public int getCorY() {
        return corY;
    }

    public void setCorY(int corY) {
        this.corY = corY;
    }

    //methods

    @Override
    public String toString() {
        return "(" +  corX + ", " + corY + " )";
    }

    public void setCoordinates(int x, int y) {
        this.corX = x;
        this.corY = y;
    }
}
