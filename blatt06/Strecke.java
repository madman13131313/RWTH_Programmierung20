public class Strecke extends Strahl{
    public Strecke(Punkt a, Punkt b){
        super(a,b);
    }
    
    public String toString(){
        return "Strecke zwischen " + this.getValueP1() + " und " + this.getValueP2();
    }
    
    public boolean enthaelt(Punkt p0){
        if(this.zwischenp1p2(p0)){
            return true;
        }
        else{return false;}
        
    }
    
    public Strahl verlaengern(boolean swap){
        if(swap){
            Strahl neu= new Strahl(this.getValueP1(),this.getValueP2());
            return neu;
        }
        else{
           Strahl neu= new Strahl(this.getValueP1(),this.getValueP2()); 
           return neu;
        }
    }
    
    public boolean equals(Object obj){
        if (obj.getClass().equals(this.getClass())){
            Strecke neu=(Strecke) obj;
            if((this.getValueP1().equals(neu.getValueP1()) && this.getValueP2().equals(neu.getValueP2())) || (this.getValueP1().equals(neu.getValueP2()) && this.getValueP2().equals(neu.getValueP1()))){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }
}


