import java.util.ArrayList;

public class Node {

    private int x;
    private int y;
    private Node parent = null;
    private double distanceToDestination;
    private double distanceFromParent;
    private double totalDistance;
    private ArrayList<Node> neighbours = new ArrayList<Node>();

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public double getDistanceToDestination() {
        return distanceToDestination;
    }

    public void setDistanceToDestination(double distanceToDestination) {
        this.distanceToDestination = distanceToDestination;
    }

    public double getDistanceFromParent() {
        return distanceFromParent;
    }

    public void setDistanceFromParent(double distanceFromParent) {
        this.distanceFromParent = distanceFromParent;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }
}
