import java.math.*;
public class Punkt extends BigDecimalUtility{
    private final BigDecimal x;
    private final BigDecimal y;
    
    public Punkt(BigDecimal setX, BigDecimal setY){
        this.x=setX;
        this.y=setY;
    }
    
    public Punkt(double setX, double setY){
        this.x=BigDecimal.valueOf(setX);
        this.y=BigDecimal.valueOf(setY);
    }
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
    
    public BigDecimal getValueX(){
        return this.x;
    }
    
    public BigDecimal getValueY(){
        return this.y;
    }
    
    public BigDecimal abstand(Punkt other){
        BigDecimal ab;
        ab=sqrt(((this.getValueX().subtract(other.getValueX())).pow(2)).add((this.getValueY().subtract(other.getValueY())).pow(2)));
        return ab;
    }
    
    public boolean equals(Object obj){
        if (obj instanceof Punkt){
        Punkt nue=(Punkt) obj;
            if(equalValues(this.getValueX(),nue.getValueX()) && equalValues(this.getValueY(),nue.getValueY())){
                return true;
            }else{return false;}
        }
        else{return false;}
    }
}
