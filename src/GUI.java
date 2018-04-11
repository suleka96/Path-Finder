
import javafx.application.Application;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;

        import java.util.Random;

public class GUI extends Application {


    private TextField txtStartX;
    private TextField txtStartY;
    private TextField txtEndX;
    private TextField txtEndY;
    private RadioButton Chebyshev;
    private RadioButton Euclidean;
    private RadioButton Manhattan;
    private Button draw;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane mainLayer = new BorderPane();

//        mapGrid.setHgap(20);//setting horizontal gap between grid lines
//        mapGrid.setVgap(20);// setting vertical gap between lines
        mainLayer.setPadding(new Insets(0, 0, 0, 0));

        GridPane mapGrid = new GridPane();
//        mapGrid.setStyle("-fx-border-color: #3399CC;");//setting background color of the grid

        //creating column constraints for 10 columns
        for (int i = 0; i < 20; i++) {
            ColumnConstraints column = new ColumnConstraints();
//            column.setPercentWidth(100/20);//setting width of each column
            column.setFillWidth(true);
            column.setHgrow(Priority.ALWAYS);
            mapGrid.getColumnConstraints().add(column);
        }
        //creating row constraints for 20 rows
        for (int i = 0; i < 20; i++) {
            RowConstraints row = new RowConstraints();
            row.setFillHeight(true);
            row.setVgrow(Priority.ALWAYS);
//            row.setPercentHeight(100/20);//setting height of each row

            mapGrid.getRowConstraints().add(row);
        }


        int grid [][] = GridBuilder.getGrid();

        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {

                Rectangle rec = new Rectangle();
                rec.setWidth(19);
                rec.setHeight(19);

                switch(grid[r][c]){
                    case 1 : rec.setFill(Color.LIGHTGREEN); break;
                    case 2 : rec.setFill(Color.YELLOWGREEN); break;
                    case 3 : rec.setFill(Color.LIGHTGRAY); break;
                    case 4 : rec.setFill(Color.BLUE); break;
                    default: rec.setFill(Color.GREENYELLOW);
                }

                GridPane.setRowIndex(rec, r);
                GridPane.setColumnIndex(rec, c);
                mapGrid.getChildren().addAll(rec);

            }
        }

        mainLayer.setAlignment(mapGrid, Pos.CENTER);
        mainLayer.setMargin(mapGrid, new Insets(83,220,100,220));
        mainLayer.setCenter(mapGrid);


//        mapGrid.setGridLinesVisible(true);

        /*
        ******************************************
         * Creating the top part of the GUI
        ******************************************
        */

        HBox title = new HBox();
        title.setPrefSize(800,80);

        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);

        Region region2 = new Region();
        HBox.setHgrow(region2, Priority.ALWAYS);

        //controls.setStyle("-fx-border-color: #3399CC;");//setting background color of the grid

        Label lblTitle = new Label("Path Finder");
        lblTitle.setStyle("-fx-font-size: 40pt;");
        title.getChildren().addAll(region1,lblTitle,region2);

        mainLayer.setAlignment(title, Pos.CENTER);
        mainLayer.setMargin(title, new Insets(20,210,0,210));
        mainLayer.setTop(title);


        /*
         ******************************************
         * Creating the bottom part of the GUI
         ******************************************
         */

        GridPane controls = new GridPane();


        //creating column constraints for 10 columns
        for (int i = 0; i < 10; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setFillWidth(true);
            column.setHgrow(Priority.ALWAYS);
            controls.getColumnConstraints().add(column);
        }
        //creating row constraints for 20 rows
        for (int i = 0; i < 10; i++) {
            RowConstraints row = new RowConstraints();
            row.setFillHeight(true);
            row.setVgrow(Priority.ALWAYS);

            controls.getRowConstraints().add(row);
        }

//        controls.setGridLinesVisible(true);
        controls.setPrefSize(800,300);
        mainLayer.setBottom(controls);

        Label startX = new Label("Start X");
        controls.add(startX,1,2,1,1);

        Label startY = new Label("Start Y");
        controls.add(startY,3,2,1,1);

        Label endX = new Label("End X");
        controls.add(endX,6,2,1,1);

        Label endY = new Label("End Y");
        controls.add(endY,8,2,1,1);

        Label lblCost = new Label("Cost: ");
        controls.add(lblCost,4,0,1,1);

        Label cost = new Label("00");
        controls.add(cost,5,0,1,1);

        txtStartX = new TextField();
        txtStartX.setPrefWidth(10);
        controls.add(txtStartX,1,3,1,1);

        txtStartY = new TextField();
        txtStartY.setPrefWidth(10);
        controls.add(txtStartY,3,3,1,1);

        txtEndX = new TextField();
        txtEndX.setPrefWidth(10);
        controls.add(txtEndX,6,3,1,1);

        txtEndY = new TextField();
        txtEndY.setPrefWidth(10);
        controls.add(txtEndY,8,3,1,1);

        ToggleGroup group = new ToggleGroup();

        Manhattan = new RadioButton("Manhattan");
        Manhattan.setToggleGroup(group);
        Manhattan.setSelected(true);

        Euclidean = new RadioButton("Euclidean");
        Euclidean.setToggleGroup(group);

        Chebyshev = new RadioButton("Chebyshev");
        Chebyshev.setToggleGroup(group);

        controls.add(Manhattan,2,5,2,1);
        controls.add(Euclidean,4,5,2,1);
        controls.add(Chebyshev,7,5,2,1);

        draw =new Button("DRAW");
        controls.add(draw,4,7,2,2);

        Scene scene = new Scene(mainLayer, 800, 950);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}