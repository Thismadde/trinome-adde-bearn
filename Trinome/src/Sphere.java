import java.util.LinkedList;
import java.util.List;

public class Sphere extends Piece {
    
    private String sprite;

    public Sphere(boolean health, boolean fix, int[] pos, String team){
        super(health, fix, pos, team);
        sprite = "sphere.png";//ou un truc du genre
    }
    

    public void radar(Plateau plato){
        LinkedList<int[]> zbleh = new LinkedList<>();
        
        //-2 -2
        if(plato.isOccupied(position[0]-2,position[1]-2).equals("ok")){
            int[] npos = {position[0]-2,position[1]-2};
            zbleh.add(npos);
        }
        //-2 0
        if(plato.isOccupied(position[0]-2,position[1]).equals("ok")){
            int[] npos = {position[0]-2,position[1]};
            zbleh.add(npos);
        }
        //-2 +2
        if(plato.isOccupied(position[0]-2,position[1]+2).equals("ok")){
            int[] npos = {position[0]-2,position[1]+2};
            zbleh.add(npos);
        }
        //0 +2 
        if(plato.isOccupied(position[0],position[1]+2).equals("ok")){
            int[] npos = {position[0],position[1]+2};
            zbleh.add(npos);
        }
        //+2 +2
        if(plato.isOccupied(position[0]+2,position[1]+2).equals("ok")){
            int[] npos = {position[0]+2,position[1]+2};
            zbleh.add(npos);
        }
        //+2 0
        if(plato.isOccupied(position[0]+2,position[1]).equals("ok")){
            int[] npos = {position[0]+2,position[1]};
            zbleh.add(npos);
        }
        //+2 -2
        if(plato.isOccupied(position[0]+2,position[1]-2).equals("ok")){
            int[] npos = {position[0]+2,position[1]-2};
            zbleh.add(npos);
        }
        //0 -2
        if(plato.isOccupied(position[0],position[1]-2).equals("ok")){
            int[] npos = {position[0],position[1]-2};
            zbleh.add(npos);
        }
    }

    public void blit(){
        
    }
}
