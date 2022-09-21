package tttmodell;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TTTController implements Initializable {

	@FXML
	GridPane gridPaneGitter;

	@FXML
	Pane paneZelle00;

	@FXML
	Pane paneZelle01;

	@FXML
	Pane paneZelle02;

	@FXML
	Pane paneZelle10;

	@FXML
	Pane paneZelle11;

	@FXML
	Pane paneZelle12;

	@FXML
	Pane paneZelle20;

	@FXML
	Pane paneZelle21;

	@FXML
	Pane paneZelle22;

	@FXML
	Text textGewonnen;

	private TTTModell dasSpiel = null;

	private void gitterAktualisieren() {

		for (int i = 0; i < 3; i++) {
			for (int a = 0; a < 3; a++) {

				Pane paneZelle = (Pane) gridPaneGitter.lookup("#paneZelle" + i + a);

				char c = dasSpiel.getZelle(i, a);

				if (paneZelle.getChildren().isEmpty() && c != ' ') {
					if(c != 'O') {
					Text text = new Text();
					text.setText("X");
					Font font = new Font(50);
					text.setFont(font);
					text.setFill(Color.MEDIUMSEAGREEN);
					text.setX(25);
					text.setY(60);

					paneZelle.getChildren().add(text);
				}
				
				if(c != 'X') {
				Text text = new Text();
				text.setText("O");
				Font font = new Font(50);
				text.setFont(font);
				text.setFill(Color.MEDIUMSEAGREEN);
				text.setX(25);
				text.setY(60);

				paneZelle.getChildren().add(text);
			}
		}
		}
		}
		//Wenn Computer gewinnt :(
		if (dasSpiel.gewinnErmitteln()) {
			textGewonnen.setText("Verloren :(");
		}
		// Wenn Spieler gewinnt :) 
		if (dasSpiel.gewinnErmitteln2()) {
			textGewonnen.setText("Gewonnen :D");
	}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		paneZelle00.setOnMouseClicked(this::handlePaneZelle);
		paneZelle01.setOnMouseClicked(this::handlePaneZelle);
		paneZelle02.setOnMouseClicked(this::handlePaneZelle);
		paneZelle10.setOnMouseClicked(this::handlePaneZelle);
		paneZelle11.setOnMouseClicked(this::handlePaneZelle);
		paneZelle12.setOnMouseClicked(this::handlePaneZelle);
		paneZelle20.setOnMouseClicked(this::handlePaneZelle);
		paneZelle21.setOnMouseClicked(this::handlePaneZelle);
		paneZelle22.setOnMouseClicked(this::handlePaneZelle);

		dasSpiel = new TTTModell();

		textGewonnen.setText("");
	}

	public void handlePaneZelle(MouseEvent event) {
		Node zelle = (Node) event.getSource();
		String fxId = zelle.getId();
		int length = fxId.length();
		int i = Integer.parseInt(fxId.substring(length - 1, length));
		int a = Integer.parseInt(fxId.substring(length - 2, length - 1));

		dasSpiel.spielereins(a, i);
		gitterAktualisieren();
		if(dasSpiel.gewinnErmitteln()== false) {
		dasSpiel.freierKasten();
		gitterAktualisieren();
	}
	}
}
