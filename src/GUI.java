
import javafx.application.Application;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;

        import java.util.Random;

public class GUI extends Application {

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
        mapGrid.setStyle("-fx-border-color: #3399CC;");//setting background color of the grid

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

        Random rand = new Random();
        Color[] colors = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED};

        int n = rand.nextInt(4)+1;

        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {


                int num = rand.nextInt(4);
                Rectangle rec = new Rectangle();
                rec.setWidth(19);
                rec.setHeight(19);
                rec.setFill(colors[num]);
                GridPane.setRowIndex(rec, r);
                GridPane.setColumnIndex(rec, c);
                mapGrid.getChildren().addAll(rec);

            }
        }

        mainLayer.setAlignment(mapGrid, Pos.CENTER);
        mainLayer.setMargin(mapGrid, new Insets(38,210,38,210));
        mainLayer.setCenter(mapGrid);


//        mapGrid.setGridLinesVisible(true);

        /*
        ******************************************
         * Creating the top part of the GUI
        ******************************************
        */


        HBox title = new HBox();
        title.setPrefSize(1300,80);

        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);

        Region region2 = new Region();
        HBox.setHgrow(region2, Priority.ALWAYS);

        //controls.setStyle("-fx-border-color: #3399CC;");//setting background color of the grid

        Label lblTitle = new Label("Path Finder");
        lblTitle.setStyle("-fx-font-size: 40pt;");
        title.getChildren().addAll(region1,lblTitle,region2);

        mainLayer.setAlignment(title, Pos.CENTER);
        mainLayer.setMargin(title, new Insets(20,210,10,210));
        mainLayer.setTop(title);


        /*
         ******************************************
         * Creating the bottom part of the GUI
         ******************************************
         */

        HBox bottom = new HBox();
        bottom.setPrefSize(1300,500);

        bottom.setStyle("-fx-border-color: #3399CC;");//setting background color of the grid





        mainLayer.setBottom(bottom);

        mainLayer.setPrefSize(1300,600);


        Scene scene = new Scene(mainLayer, 800, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}