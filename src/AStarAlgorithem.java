import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarAlgorithem {

    private static Node nodeGrid[][]= new Node[20][20];
    private static PriorityQueue<Node> openSet;
    private static ArrayList<Node> closedSet;

    public static void initialiseNodeGrid(){
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                Node node = new Node(r,c);
                nodeGrid[r][c] = node;
            }
        }
    }

    public static void addNeighbours(){

    }



    public static void Algorithem(){

        GridPane mapGrid = GUI.getMapGrid();

        initialiseNodeGrid();
        addNeighbours();

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

        Node start = nodeGrid[0][0];
        Node end = nodeGrid[5][20]; //5th row 16th column


        openSet.add(start);




        while(!openSet.isEmpty()){

            while (!openSet.isEmpty()) {
                Node node = openSet.poll();
                int x = node.getX();
                int y = node.getY();
                Rectangle rec = new Rectangle();
                rec.setWidth(19);
                rec.setHeight(19);
                rec.setFill(Color.RED);
                mapGrid.add(rec,y,x);

            }

        }



    }




}
