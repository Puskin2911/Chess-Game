package app.controller.player;

public abstract class Player {
	public boolean whiteSide;
	public boolean humanPlayer;

	public boolean isWhiteSide() {
		return this.whiteSide == true;
	}

	public boolean isHumanPlayer() {
		return this.humanPlayer == true;
	}
}
