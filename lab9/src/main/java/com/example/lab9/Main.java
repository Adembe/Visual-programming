package com.example.lab9;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {private Timeline timeline;

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        Image image = new Image(getClass().getResourceAsStream("zebra.jpg"));
        int numOfColumns = 5;
        int numOfRows = 1;

        final Layout layout = new Layout(numOfColumns, numOfRows);
        final Layout layout2 = new Layout(numOfColumns, numOfRows);

        final List<Piece> pieces = new ArrayList<Piece>();
        for (int col = 0; col < numOfColumns; col++) {
            for (int row = 0; row < numOfRows; row++) {
                int x = col * Piece.WIDTH;
                int y = row * Piece.HEIGHT;
                final Piece piece = new Piece(image, x, y, row > 0, col > 0, row < numOfRows - 1,
                        col < numOfColumns - 1, layout.getWidth(), layout.getHeight());
                pieces.add(piece);
            }
        }

        if (timeline != null)
            timeline.stop();
        timeline = new Timeline();
        for (final Piece piece : pieces) {
            piece.setActive();
            double shuffleX = Math.random() * (layout.getWidth() - Piece.WIDTH + 48f) - 24f - piece.getCorrectX();
            double shuffleY = Math.random() * (layout.getHeight() - Piece.HEIGHT + 30f) - 400f - piece.getCorrectY();
            timeline.getKeyFrames()
                    .add(new KeyFrame(Duration.seconds(0.1), new KeyValue(piece.translateXProperty(), shuffleX),
                            new KeyValue(piece.translateYProperty(), shuffleY)));
        }
        timeline.playFromStart();

        layout2.getChildren().addAll(pieces);
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(layout, layout2);
        root.getChildren().addAll(vbox);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
