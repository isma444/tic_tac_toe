public abstract class BordGame {
    private View view;
    private int size;
    private Cell[][] tabCell;
    private InteractionUtilisateur interaction;
    private Player firstPlayer ;
    private Player secondPlayer;

    public abstract int[] getMoveFromPlayer(Player player);
}
