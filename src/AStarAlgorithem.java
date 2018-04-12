import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarAlgorithem {

    private Node nodeGrid[][]= new Node[20][20];
    private static PriorityQueue<Node> openSet;

    public void initialiseNodeGrid(){
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                Node node = new Node();
                nodeGrid[r][c] = node;
            }
        }
    }


    public static  void main(String[] args){



    }

    public static void Algorithem(){

        openSet = new PriorityQueue<Node>(10, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                if (n1.getTotalDistance() < n2.getTotalDistance()) {
                    return -1;
                } else if (n1.getTotalDistance() > n2.getTotalDistance()) {
                    return 1;
                } else {
                    return 0;
                }

            }
        });

    }




}
