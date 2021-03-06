import java.math.*;
public class Gerade extends BigDecimalUtility{
    private final Punkt p1;
    private final Punkt p2;
    
    public Gerade(Punkt pp1,Punkt pp2){
        if (equalValues(pp1.getValueX(),pp2.getValueX()) && equalValues(pp1.getValueX(),pp2.getValueX())){
            System.out.println("Gleiche Punkte!");
            this.p1=null;
            this.p2=null;
        }
        else{
            if(pp1.getValueX().compareTo(pp2.getValueX())<0){
                this.p1=pp1;
                this.p2=pp2;
            }
            else if(pp1.getValueX().compareTo(pp2.getValueX())>0){
                this.p1=pp2;
                this.p2=pp1;
            } 
            else{
                if(pp1.getValueY().compareTo(pp2.getValueY())<0){
                    this.p1=pp1;
                    this.p2=pp2;
                }
                else{
                    this.p1=pp2;
                    this.p2=pp1;
                }
            }
        }
    }
    
    public Punkt getValueP1(){
        return this.p1;
    }
    
    public Punkt getValueP2(){
        return this.p2;
    }
    
    public String toString(){
        return "Gerade durch " + this.getValueP1() +" und " + this.getValueP2();
    }
    
    public boolean enthaelt(Punkt p0){
        BigDecimal k=(this.getValueP1().getValueY().subtract(this.getValueP2().getValueY())).divide(this.getValueP1().getValueX().subtract(this.getValueP2().getValueX()));
        if(equalValues(k,(this.getValueP1().getValueY().subtract(p0.getValueY())).divide(this.getValueP1().getValueX().subtract(p0.getValueX())))){
            return true;
        }
        else{return false;}
    }
    
    public boolean zwischenp1p2(Punkt p0){
        if (this.enthaelt(p0) && equalValues(p0.abstand(this.getValueP1()).add(p0.abstand(this.getValueP1())),this.getValueP1().abstand(this.getValueP2()))){
            return true;
        }
        else{return false;}
    }
    
    public boolean vorp1(Punkt p0){
        if (this.enthaelt(p0) && p0.abstand(this.getValueP1()).compareTo(p0.abstand(this.getValueP2()))<0 &&!this.zwischenp1p2(p0)){
            return true;
        }
        else{return false;}
    }
    
    public boolean hinterp2(Punkt p0){
        if (this.enthaelt(p0) &&! this.vorp1(p0) &&!this.zwischenp1p2(p0)){
            return true;
        }
        else{return false;}
    }
    
    public boolean equals(Object obj){
        if (obj.getClass().equals(this.getClass())){
            Gerade neu=(Gerade) obj;
            if(this.enthaelt(neu.getValueP1()) && this.enthaelt(neu.getValueP2())){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }
}
