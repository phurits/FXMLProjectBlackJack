/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PHURITS
 */
public class GameController implements Initializable, Commons {

    private Stage stage;

    @FXML
    private AnchorPane background;

    @FXML
    private Button backMainmenu;
    @FXML
    private Button bet1, bet10, bet50, bet100, bet500, bet1000, resetBet;
    @FXML
    private Button deal, hit, stand;
    @FXML
    private TextField betText;
    @FXML
    private TextField bankText;
    
    @FXML
    private Text dealerHand,playerHand;
    
    @FXML
    private ImageView dealerCard1,playerCard1;
    
    

    private int balance = MenuController.bank;  //Load balance from setup
    private int bet;

    private int dealerPoints;
    private int playerPoints;

    //Check when game is finished?
    private boolean canClicked;
    

    //CODING TIME!!! --------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bankText.setText("$" + balance);
        hit.setDisable(true);
        stand.setDisable(true);
        canClicked = false;

    }
    

    @FXML
    public void backMainmenu() {
        stage = (Stage) backMainmenu.getScene().getWindow();
        try {
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(root, W_WIDTH, W_HEIGHT);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addbet(ActionEvent e) {
        if (e.getSource() == bet1) {
            bet++;
            betText.setText("$" + bet);
        } else if (e.getSource() == bet10) {
            bet = balance + 10;
            betText.setText("$" + bet);
        } else if (e.getSource() == bet50) {
            bet = bet + 50;
            betText.setText("$" + bet);
        } else if (e.getSource() == bet100) {
            bet = bet + 100;
            betText.setText("$" + bet);
        } else if (e.getSource() == bet500) {
            bet = bet + 500;
            betText.setText("$" + bet);
        } else if (e.getSource() == bet1000) {
            bet = bet + 1000;
            betText.setText("$" + bet);
        } else if (e.getSource() == resetBet) {
            bet = 0;
            betText.setText("$" + bet);
        } else {
            System.out.println("IMPOSSIBLE TO ASSIGN");
        }
        if (bet > balance) {
            bet = balance;
            betText.setText("$" + bet);
        }
    }

    @FXML
    public void deal() {
        if (bet == 0) {
            System.out.println("BET MONEY CAN'T BE ZERO");
        } else {
            //Update Balance
            balance = balance - bet;
            bankText.setText("$" + balance);
            //Disable Buttons
            startGame(true);
            hit.setDisable(false);
            stand.setDisable(false);
        }
    }

    @FXML
    public void hit() {
    }

    @FXML
    public void stand() {
        hit.setDisable(true);
        stand.setDisable(true);

        canClicked = true;
    }

    @FXML
    public void clickedContinue() {
        if (canClicked == true) {
            startGame(false);
            betText.setText("$" + 0);
            hit.setDisable(true);
            stand.setDisable(true);
            canClicked = false;

        }
    }

    private void startGame(boolean a) {
        //Disable Action
        hit.setDisable(true);
        stand.setDisable(true);

        //Disable Bet Buttons
        bet1.setDisable(a);
        bet10.setDisable(a);
        bet50.setDisable(a);
        bet100.setDisable(a);
        bet500.setDisable(a);
        bet1000.setDisable(a);
        deal.setDisable(a);
        resetBet.setDisable(a);

    }

}
