package com.example.biydaalt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    private Timeline timeline;

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        Image image = new Image(getClass().getResourceAsStream(
                "watame.png"));
        int numberOfColumns = 4;
        int numberOfRows = 4;

        final Desk desk = new Desk(numberOfColumns, numberOfRows);


        final List<Piece> pieces  = new ArrayList<Piece>();
        for (int col = 0; col < numberOfColumns; col++) {
            for (int row = 0; row < numberOfRows; row++) {
                int x = col * Piece.SIZE;
                int y = row * Piece.SIZE;
                final Piece piece = new Piece(image, x, y,
                        desk.getWidth(), desk.getHeight());
                pieces.add(piece);
            }
        }
        desk.getChildren().addAll(pieces);


        Button closeButton = new Button("X");
        closeButton.setStyle("-fx-font-size: 30PX;" +
                " -fx-background-radius: 80px;");
        closeButton.setOnAction(e -> {
            primaryStage.close();
        });


        //shuffle
        if (timeline != null) timeline.stop();
        timeline = new Timeline();

//            Random rand = new Random();
//            for(int j = 0; j < 10000; j++){
//                int x = rand.nextInt((int) Math.sqrt(4));
//                int y = rand.nextInt((int) Math.sqrt(4));
//            }

        for (final Piece piece : pieces) {
            piece.setActive();
            double shuffleX = Math.random() *
                    (desk.getWidth() - Piece.SIZE + 30f ) - 10f - piece.getCorrectX();

            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                    new KeyValue(piece.translateXProperty(), shuffleX)));
        }
        timeline.playFromStart();

        ImageView thumbnail = new ImageView(image );
        thumbnail.setFitHeight(100);
        thumbnail.setFitWidth(100);

        HBox bBox = new HBox(8);
        bBox.setPadding(new Insets(50, 0, 0, 0));
        bBox.getChildren().addAll(thumbnail, closeButton);
        bBox.setSpacing(230);
        bBox.setAlignment(Pos.CENTER);

        VBox vb = new VBox(10);
        vb.getChildren().addAll(desk,bBox);
        root.getChildren().addAll(vb);
        vb.setPadding(new Insets(10, 10, 10, 10));
    }

//    public void swap(Piece cellA, Piece cellB) {
//
//        ImageView tmp = cellA.getImageView();
//        cellA.setImageView(cellB.getImageView());
//        cellB.setImageView(tmp);
//
//    }


    public static class Desk extends Pane {
        Desk(int numOfColumns, int numOfRows) {
            setStyle("-fx-background-color: #cccccc; ");
            double DESK_WIDTH = Piece.SIZE * numOfColumns;
            double DESK_HEIGHT = Piece.SIZE * numOfRows;
            setPrefSize(DESK_WIDTH,DESK_HEIGHT);
            setMaxSize(DESK_WIDTH, DESK_HEIGHT);
            autosize();


            Path grid = new Path();
            grid.setStroke(Color.rgb(70, 70, 70));
            getChildren().add(grid);


            for (int col = 0; col < numOfColumns - 1; col++) {
                grid.getElements().addAll(
                        new MoveTo(Piece.SIZE + Piece.SIZE * col, 3),
                        new LineTo(Piece.SIZE + Piece.SIZE * col, Piece.SIZE * numOfRows - 3)
                );
            }


            for (int row = 0; row < numOfRows - 1; row++) {
                grid.getElements().addAll(
                        new MoveTo(5, Piece.SIZE + Piece.SIZE * row),
                        new LineTo(Piece.SIZE * numOfColumns - 5, Piece.SIZE + Piece.SIZE * row)
                );
            }
        }
        @Override protected void layoutChildren() {}
    }


    public static class Piece extends Parent {
        public static final int SIZE = 100;
        private final double correctX;
        private final double correctY;
        private double dragX;
        private double dragY;
        private Shape stroke;
        private Shape clip;
        private ImageView imageView = new ImageView();
        private Point2D dragAnchor;

        public Piece(Image image, final double correctX, final double correctY,
                     final double deskWidth, final double deskHeight) {
            this.correctX = correctX;
            this.correctY = correctY;

            clip = createPiece();
            clip.setFill(Color.WHITE);
            clip.setStroke(null);
            stroke = createPiece();
            stroke.setFill(null);
            stroke.setStroke(Color.BLACK);
            imageView.setImage(image);
            imageView.setClip(clip);
            setFocusTraversable(true);
            getChildren().addAll(imageView, stroke);
            setCache(true);


            setOnMousePressed(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    toFront();
                    dragX = getTranslateX();
                    dragY = getTranslateY();
                    dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());
                }
            });
            setOnMouseReleased(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    if (getTranslateX() < (10) && getTranslateX() > (- 10) &&
                            getTranslateY() < (10) && getTranslateY() > (- 10)) {
                        setTranslateX(0);
                        setTranslateY(0);
                        setInactive();
                    }
                }
            });
            setOnMouseDragged(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    double newTranslateX = dragX
                            + me.getSceneX() - dragAnchor.getX();
                    double newTranslateY = dragY
                            + me.getSceneY() - dragAnchor.getY();
                    double minTranslateX = - 45f - correctX;
                    double maxTranslateX = (deskWidth - Piece.SIZE + 50f ) - correctX;
                    double minTranslateY = - 30f - correctY;
                    double maxTranslateY = (deskHeight - Piece.SIZE + 70f ) - correctY;
                    if ((newTranslateX> minTranslateX ) &&
                            (newTranslateX< maxTranslateX) &&
                            (newTranslateY> minTranslateY) &&
                            (newTranslateY< maxTranslateY)) {
                        setTranslateX(newTranslateX);
                        setTranslateY(newTranslateY);
                    }
                }
            });
        }

        private Shape createPiece() {
            Shape shape = createPieceRectangle();
            shape.setTranslateX(correctX);
            shape.setTranslateY(correctY);
            shape.setLayoutX(50f);
            shape.setLayoutY(50f);
            return shape;
        }

        private Rectangle createPieceRectangle() {
            Rectangle rec = new Rectangle();
            rec.setX(-50);
            rec.setY(-50);
            rec.setWidth(SIZE);
            rec.setHeight(SIZE);
            return rec;
        }

        public void setActive() {
            setDisable(false);
            setEffect(new DropShadow());
            toFront();
        }

        public void setInactive() {
            setEffect(null);
            setDisable(true);
            toBack();
        }

        public double getCorrectX() { return correctX; }



//        public ImageView getImageView() {
//            return currentImageView;
//        }
//
//        public void setImageView(ImageView imageView) {
//            this.currentImageView = imageView;
//        }
//        public boolean isEmpty() {
//            return currentImageView == null;
//        }
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}