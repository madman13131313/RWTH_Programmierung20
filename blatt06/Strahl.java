public class Strahl extends Gerade{
    private final Punkt startPunkt;
    
    public Strahl(Punkt a, Punkt b){
        super(a, b);
        this.startPunkt=a;
    }
    
    public boolean startFromp1(){
        if (this.getValueP1().equals(this.startPunkt)){return true;}
        else{return false;}
    }
    
    public boolean startFromp2(){
        if (this.getValueP2().equals(this.startPunkt)){return true;}
        else{return false;}
    }
    
    public String toString(){
        if(this.startFromp2()){
            return "Strahl beginnt in " + this.startPunkt + " und passiert lediglich " + this.getValueP1();
        }
        else{
            return "Strahl beginnt in " + this.startPunkt + " und passiert lediglich " + this.getValueP2();
        }
        
    }
    
    public Gerade verlaengern(){
        Gerade neu=new Gerade(this.getValueP1(),this.getValueP2());
        return neu;
    }
    
    public boolean enthaelt(Punkt p0){
        if(this.startFromp2()){
            if(this.zwischenp1p2(p0) || this.vorp1(p0)){
                return true;
            }
            else{return false;}
        }
        else if(this.startFromp1()){
            if(this.zwischenp1p2(p0) || this.hinterp2(p0)){
                return true;
            }
            else{return false;}
        }
        else{return false;}    
    }
    
    public boolean equals(Object obj){
        if (obj.getClass().equals(this.getClass())){
            Strahl neu=(Strahl) obj;
            if(this.startPunkt.equals(neu.startPunkt) && this.enthaelt(neu.getValueP1()) && this.enthaelt(neu.getValueP2())){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }
}
