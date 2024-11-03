package com.example.lab9;


import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class Piece extends Parent {
    public static final int HEIGHT = 380;
    public static final int WIDTH = 125;

    private final double correctX;
    private final double correctY;

    private double startDragX;
    private double startDragY;

    private Shape pieceStroke;
    private Shape pieceClip;
    private ImageView imageView = new ImageView();
    private Point2D dragAnchor;

    public Piece(Image image, final double correctX, final double correctY, boolean topTab, boolean leftTab,
                 boolean bottomTab, boolean rightTab, final double deskWidth, final double deskHeight) {

        this.correctX = correctX;
        this.correctY = correctY;
        pieceClip = createPiece();
        pieceClip.setFill(Color.WHITE);
        pieceClip.setStroke(null);
        pieceStroke = createPiece();
        pieceStroke.setFill(null);
        pieceStroke.setStroke(Color.BLACK);
        imageView.setImage(image);
        imageView.setClip(pieceClip);

        setFocusTraversable(true);
        getChildren().addAll(imageView, pieceStroke);

        setCache(true);
        setInactive();

        setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                toFront();
                startDragX = getTranslateX();
                startDragY = getTranslateY();
                dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {

                if (getTranslateX() > (-10) && getTranslateX() < (10) &&
                        getTranslateY() > (-10) && getTranslateY() < (10)) {
                    setTranslateX(0);
                    setTranslateY(0);
                    setInactive();
                }
            }
        });

        setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                double newTranslateX = startDragX + me.getSceneX() - dragAnchor.getX();
                double newTranslateY = startDragY + me.getSceneY() - dragAnchor.getY();
                setTranslateX(newTranslateX);
                setTranslateY(newTranslateY);
            }
        });
    }

    private Shape createPiece() {
        Shape shape = createPieceRectangle();
        shape.setTranslateX(correctX);
        shape.setTranslateY(correctY);
        shape.setLayoutX(WIDTH);
        shape.setLayoutY(HEIGHT);
        return shape;

    }

    private Rectangle createPieceRectangle() {
        Rectangle rec = new Rectangle();
        rec.setX(-WIDTH);
        rec.setY(-HEIGHT);
        rec.setWidth(WIDTH);
        rec.setHeight(HEIGHT);
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

    public double getCorrectX() {
        return correctX;
    }

    public double getCorrectY() {
        return correctY;
    }
}
