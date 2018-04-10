import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane mainLayer = new BorderPane();
        mainLayer.setPadding(new Insets(0, 0, 0, 0));

            GridPane mapGrid = new GridPane();

        mapGrid.setStyle("-fx-border-color: #3399CC;");//setting background color of the grid
        mapGrid.setHgap(20);//setting horizontal gap between grid lines
        mapGrid.setVgap(20);// setting vertical gap between lines
        mapGrid.setPadding(new Insets(0, 0, 0, 0));//setting padding in the grid cell
        mapGrid.setPrefSize(100,100);

        //creating column constraints for 10 columns
        for (int i = 0; i < 20; i++) {
            ColumnConstraints column = new ColumnConstraints();
//            column.setPercentWidth(100/20);//setting width of each column
            mapGrid.getColumnConstraints().add(column);



        }
        //creating row constraints for 20 rows
        for (int i = 0; i < 20; i++) {
            RowConstraints row = new RowConstraints();
//            row.setPercentHeight(100/20);//setting height of each row
            mapGrid.getRowConstraints().add(row);
        }

            mainLayer.setCenter(mapGrid);
            mapGrid.setGridLinesVisible(true);

            HBox controls = new HBox();
            controls.setPrefSize(1300,150);

            HBox bottom = new HBox();
            bottom.setPrefSize(1300,300);

        bottom.setStyle("-fx-border-color: #3399CC;");//setting background color of the grid

            controls.setStyle("-fx-border-color: #3399CC;");//setting background color of the grid

            mainLayer.setTop(controls);

            mainLayer.setBottom(bottom);

            mainLayer.setPrefSize(1300,600);
//



//        GridPane grid = new GridPane();
//        int numRows = 4 ;
//        int numColumns = 3 ;
//        for (int row = 0 ; row < numRows ; row++ ){
//            RowConstraints rc = new RowConstraints();
//            rc.setFillHeight(true);
//            rc.setVgrow(Priority.ALWAYS);
//            grid.getRowConstraints().add(rc);
//        }
//        for (int col = 0 ; col < numColumns; col++ ) {
//            ColumnConstraints cc = new ColumnConstraints();
//            cc.setFillWidth(true);
//            cc.setHgrow(Priority.ALWAYS);
//            grid.getColumnConstraints().add(cc);
//        }
//
//        for (int i = 0 ; i < 9 ; i++) {
//            Button button = createButton(Integer.toString(i+1));
//            grid.add(button, i % 3, i / 3);
//        }
//        grid.add(createButton("#"), 0, 3);
//        grid.add(createButton("0"), 1, 3);
//        grid.add(createButton("*"), 2, 3);
//
//        Scene scene = new Scene(grid);
//        primaryStage.setScene(scene);
//        primaryStage.show();

        Scene scene = new Scene(mainLayer, 800, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    private Button createButton(String text) {
//        Button button = new Button(text);
//        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        button.setOnAction(e -> System.out.println(text));
//        return button ;
//    }





//    }

}