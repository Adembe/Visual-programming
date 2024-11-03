package com.example.lab9;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Layout extends Pane {
    Layout(int numOfColumns, int numOfRows) {
        setStyle(" -fx-border-color: #cccccc;; " );
        double DESK_WIDTH = Piece.WIDTH * numOfColumns;
        double DESK_HEIGHT = Piece.HEIGHT * numOfRows;
        setPrefSize(DESK_WIDTH, DESK_HEIGHT);
        setMaxSize(DESK_WIDTH, DESK_HEIGHT);
        autosize();


        Path grid = new Path();
        grid.setStroke(Color.rgb(70, 70, 70));
        getChildren().add(grid);


        for (int col = 0; col < numOfColumns - 1; col++) {
            grid.getElements().addAll(
                    new MoveTo(Piece.WIDTH + Piece.WIDTH * col, 3),
                    new LineTo(Piece.WIDTH + Piece.WIDTH * col, Piece.HEIGHT * numOfRows - 3)
            );
        }


        for (int row = 0; row < numOfRows - 1; row++) {
            grid.getElements().addAll(
                    new MoveTo(5, Piece.HEIGHT + Piece.HEIGHT * row),
                    new LineTo(Piece.WIDTH * numOfColumns - 5, Piece.HEIGHT + Piece.HEIGHT * row)
            );
        }
    }

    @Override
    protected void layoutChildren() {
    }

}
