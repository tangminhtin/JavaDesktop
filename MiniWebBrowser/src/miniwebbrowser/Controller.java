/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniwebbrowser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author TangMinhTin - CE130438 - tintmce130438@fpt.edu.vn
 */
public class Controller implements Initializable {

    String link = "https://";   // Link
    String addressLink; // address

    @FXML
    TextField txtAddress;

    @FXML
    WebView wvWeb;

    WebEngine webEngine;

    /**
     * Go to web site
     *
     * @param actionEvent click
     */
    public void go(ActionEvent actionEvent) {
        addressLink = txtAddress.getText(); // get address
//        webEngine.load(link + addressLink); // load address
        webEngine.load("https://www.google.com/search?q=" + addressLink); // search
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        webEngine = wvWeb.getEngine();  // get engine
        webEngine.load(link + "www.google.com"); // load address google
    }

}
