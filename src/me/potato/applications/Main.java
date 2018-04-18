package me.potato.applications;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.potato.applications.enums.Card;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author Connor Vann!
 *
 * @Note this was created some time ago so I never got around to modifying the code to a cleaner version! If it seems
 * odd, just come and ask me!
 */
public class Main extends Application {

    //Screen dimensions
    private int width;
    private int height;
    private int value;

    //Make new card regions
    private static Region userZERO;
    private static Region userONE;
    private static Region userTWO;
    private static Region userTHREE;
    private static Region userFOUR;
    private static Region dealerZERO;
    private static Region dealerONE;
    private static Region dealerTWO;
    private static Region dealerTHREE;
    private static Region dealerFOUR;

    //Scene components
    private static Button hitButton;
    private static Button endButton;
    private static VBox root;
    private static HBox userCardHolder;
    private static HBox buttonContainer;
    private static HBox dealerCardHolder;
    private static Scene scene;

    //Card values
    private static ArrayList<Card> user = new ArrayList<>();
    private static ArrayList<Card> dealer = new ArrayList<>();
    private static ArrayList<Card> cards = new ArrayList<>();

    private static boolean dealerBusted = false;

    //Miscellaneous variable assignments

    /* Constant random variables using
     * ThreadLocalRandom, speeds up to x3
     * faster than Java.util.Random, and is
     * unique to this thread.
     */

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    /* Main is first method called upon
     * start, which uses the singular
     * method, launch, to use the Start
     * method which passes a Stage reference
     * to begin building the Window.
     */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        width = ((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        height = ((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        cards = new ArrayList<>(Arrays.asList(Card.values()));

        /* Creates rectangular regions for each card
         * that will be represented in the GUI. Size
         * is dictated by screen width and height,
         * and in the shape of a rectangle to adapt
         * to the shape of a playing card. Will set
         * the preferential size, however has
         * possibility of error if application is
         * minimized.
         */

        userZERO    = new Region(); userZERO.setPrefSize(width / 12, height / 4.5);
        userONE     = new Region(); userONE.setPrefSize(width / 12, height / 4.5);
        userTWO     = new Region(); userTWO.setPrefSize(width / 12, height / 4.5);
        userTHREE   = new Region(); userTHREE.setPrefSize(width / 12, height / 4.5);
        userFOUR    = new Region(); userFOUR.setPrefSize(width / 12, height / 4.5);
        dealerZERO  = new Region(); dealerZERO.setPrefSize(width / 12, height / 4.5);
        dealerONE   = new Region(); dealerONE.setPrefSize(width / 12, height / 4.5);
        dealerTWO   = new Region(); dealerTWO.setPrefSize(width / 12, height / 4.5);
        dealerTHREE = new Region(); dealerTHREE.setPrefSize(width / 12, height / 4.5);
        dealerFOUR  = new Region(); dealerFOUR.setPrefSize(width / 12, height / 4.5);

        /* Sets the .css limitations of the regions.
         * First, sets up image as the BACK.png image
         * in the resources folder. Then edits
         * background size to auto cover the entire
         * region to prevent inappropriately sized
         * images per region.
         */

        userZERO.setStyle(" -fx-background-image: url(\"images/BACK.png\"); -fx-background-size: cover, auto;");
        userONE.setStyle(" -fx-background-image: url(\"images/BACK.png\"); -fx-background-size: cover, auto;");
        userTWO.setStyle(" -fx-background-image: url(\"images/BACK.png\"); -fx-background-size: cover, auto;");
        userTHREE.setStyle(" -fx-background-image: url(\"images/BACK.png\"); -fx-background-size: cover, auto;");
        userFOUR.setStyle(" -fx-background-image: url(\"images/BACK.png\"); -fx-background-size: cover, auto;");
        dealerZERO.setStyle(" -fx-background-image: url(\"images/BACK.png\"); -fx-background-size: cover, auto;");
        dealerONE.setStyle(" -fx-background-image: url(\"images/BACK.png\"); -fx-background-size: cover, auto;");
        dealerTWO.setStyle(" -fx-background-image: url(\"images/BACK.png\"); -fx-background-size: cover, auto;");
        dealerTHREE.setStyle(" -fx-background-image: url(\"images/BACK.png\"); -fx-background-size: cover, auto;");
        dealerFOUR.setStyle(" -fx-background-image: url(\"images/BACK.png\"); -fx-background-size: cover, auto;");


        /* Setting up scene / Window information,
         * and root information. Adding sub-roots
         * to main-root for customized grid-pattern
         * to contain cards on two rows, and a row
         * of buttons in the middle independent
         * of the card rows.
         */

        root = new VBox(height / 10);
        root.setPrefSize(width, height);
        root.setMaxSize(width, height);
        root.setMinSize(width, height);
        root.alignmentProperty().setValue(Pos.CENTER);
        root.setStyle(" -fx-background-image: url(\"images/BACKGROUND.png\"); -fx-background-size: cover, auto;");

        hitButton = new Button("HIT");
        endButton = new Button("END");

        userCardHolder = new HBox(width / 12);
        userCardHolder.getChildren().addAll(userZERO, userONE, userTWO, userTHREE, userFOUR);
        userCardHolder.alignmentProperty().setValue(Pos.CENTER);

        buttonContainer = new HBox(width / 5);
        buttonContainer.getChildren().addAll(hitButton, endButton);
        buttonContainer.alignmentProperty().setValue(Pos.CENTER);

        dealerCardHolder = new HBox(width / 12);
        dealerCardHolder.getChildren().addAll(dealerZERO, dealerONE, dealerTWO, dealerTHREE, dealerFOUR);
        dealerCardHolder.alignmentProperty().setValue(Pos.CENTER);

        root.getChildren().add(userCardHolder);
        root.getChildren().add(buttonContainer);
        root.getChildren().add(dealerCardHolder);

        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();

        hitButton.setPrefSize(width / 4.5, height / 12);
        endButton.setPrefSize(width / 4.5, height / 12);

        setupHandlers();
        runDealerMoves();

    }

    public void setupHandlers() {

        firstDraw();

        // On Hit Button Click Event
        hitButton.setOnAction(event -> {

            // If User still can take more cards, then . . .
            if(!(user.size() > 5)) {
                int r = RANDOM.nextInt(cards.size() + 1);
                Card card = cards.get(r);
                cards.remove(card);
                user.add(card);
                switch (user.indexOf(card)) {
                    case 2:
                        userTWO.setStyle(" -fx-background-image: url(\"images/" + card.name() + ".png\"); -fx-background-size: cover, auto;");
                        break;
                    case 3:
                        userTHREE.setStyle(" -fx-background-image: url(\"images/" + card.name() + ".png\"); -fx-background-size: cover, auto;");
                        break;
                    case 4:
                        userFOUR.setStyle(" -fx-background-image: url(\"images/" + card.name() + ".png\"); -fx-background-size: cover, auto;");
                        break;
                    default:
                        System.out.println("Error, indexOf more than 4 with card " + card.name());
                        break;
                } value = 0;
                for(Card c : user) {
                    value += c.getValue();
                    if(value > 21) {
                        lose();
                        break;
                    }
                }
            } else {
                hitButton.setText("DISABLED");
            }
        });

        // On End Button Click Event
        endButton.setOnAction(event -> {
            int valueOfUser = 0;
            int valueOfDealer = 0;
            for(Card c : user) {
                valueOfUser += c.getValue();
            }
            for(Card c : dealer) {
                valueOfDealer += c.getValue();
            }
            if(valueOfUser > valueOfDealer && valueOfUser <= 21) {
                System.out.println("USER WINS!");
            } else {
                if(!dealerBusted) System.out.println("DEALER WINS!");
                else System.out.println("BOTH LOST!");
            }
            for (int c = 0; c < dealer.size(); c++) {
                switch (c) {
                    case 0:
                        dealerZERO.setStyle(" -fx-background-image: url(\"images/" + dealer.get(c).name() + ".png\"); -fx-background-size: cover, auto;");
                        break;
                    case 1:
                        dealerONE.setStyle(" -fx-background-image: url(\"images/" + dealer.get(c).name() + ".png\"); -fx-background-size: cover, auto;");
                        break;
                    case 2:
                        dealerTWO.setStyle(" -fx-background-image: url(\"images/" + dealer.get(c).name() + ".png\"); -fx-background-size: cover, auto;");
                        break;
                    case 3:
                        dealerTHREE.setStyle(" -fx-background-image: url(\"images/" + dealer.get(c).name() + ".png\"); -fx-background-size: cover, auto;");
                        break;
                    case 4:
                        dealerFOUR.setStyle(" -fx-background-image: url(\"images/" + dealer.get(c).name() + ".png\"); -fx-background-size: cover, auto;");
                        break;
                    default:
                        System.out.println("You dun' goofed and broke this!");
                        break;
                }
            }
            System.out.println("User: " + user + "\n" + "Dealer: " + dealer);
        });
    }

    public void firstDraw() {

        for(int i = 0; i < 2; i++) {
            int r = RANDOM.nextInt(cards.size() + 1);
            Card card = cards.get(r);
            cards.remove(card);
            user.add(card);
            switch (i) {
                case 0:
                    userZERO.setStyle(" -fx-background-image: url(\"images/" + card.name() + ".png\"); -fx-background-size: cover, auto;");
                    break;
                default:
                    userONE.setStyle(" -fx-background-image: url(\"images/" + card.name() + ".png\"); -fx-background-size: cover, auto;");
                    break;
            }
        }
    }

    public void lose() {
        System.out.println("Player Lost!");
    }

    public void runDealerMoves() {

        int r = RANDOM.nextInt(cards.size() - 1);
        Card card = cards.get(r);
        cards.remove(card);
        dealer.add(card);
        dealerZERO.setStyle(" -fx-background-image: url(\"images/" + card.name() + ".png\"); -fx-background-size: cover, auto;");

        while (totalValueOf(dealer) < 17) {

            r = RANDOM.nextInt(cards.size());
            card = cards.get(r);
            cards.remove(card);
            dealer.add(card);
            if(totalValueOf(dealer) > 21) {
                dealerBusted = true;
            }
        }
    }

    public int totalValueOf(ArrayList<Card> list) {
        value = 0;
        for(Card c : list) {
            value += c.getValue();
        } return value;
    }
}
