public class Plateau {
    
    private int[] dimensions;
    private String sprite;

    public Plateau(int[] topL, int[] botR){
        dimensions = new int[] {botR[0]-topL[0], botR[1]-topL[1]};
    }

    public String isOccupied(int p1, int p2){
        return "yes";
    }

    public void blit(){

    }

    public void lightUp(){

    }
}
