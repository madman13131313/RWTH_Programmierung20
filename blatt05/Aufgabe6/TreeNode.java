 /**
 * Ein Knoten in einem binaeren Baum.
 *
 * Der gespeicherte Wert ist unveraenderlich,
 * die Referenzen auf die Nachfolger koennen aber
 * geaendert werden.
 *
 * Die Klasse bietet Methoden, um Werte aus einem Baum
 * zu suchen, einzufuegen und zu loeschen. Diese gibt
 * es jeweils noch in optimierten Varianten, um
 * rotate-to-root Baeume zu verwalten.
 */
public class TreeNode {
  /**
   * Linker Nachfolger
   */
  private TreeNode left;
  /**
   * Rechter Nachfolger
   */
  private TreeNode right;
  /**
   * Wert, der in diesem Knoten gespeichert ist
   */
  private final int value;

  /**
   * Erzeugt einen neuen Knoten ohne Nachfolger
   * @param val Wert des neuen Knotens
   */
  public TreeNode(int val) {
    this.value = val;
    this.left = null;
    this.right = null;
  }

  /**
   * Erzeugt einen neuen Knoten mit den gegebenen Nachfolgern
   * @param val Wert des neuen Knotens
   * @param left linker Nachfolger des Knotens
   * @param right rechter Nachfolger des Knotens
   */
  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.value = val;
    this.left = left;
    this.right = right;
  }
  
  /**
  * @return Wert des aktuellen Knotens
  *
  */    
  public int getValue() {
    return this.value;
  }

  /**
   * @return Der gespeicherte Wert, umgewandelt in einen String
   */
  public String getValueString() {
    return Integer.toString(this.value);
  }

  /**
   * @return true, falls der Knoten einen linken Nachfolger hat, sonst false 
   */   
  public boolean hasLeft() {
    return this.left != null;
  }
  /**
   * @return true, falls der Knoten einen rechten Nachfolger hat, sonst false 
   */   
  public boolean hasRight() {
    return this.right != null;
  }


  /**
   * @return linker Nachfolger des aktuellen Knotens
   */       
  public TreeNode getLeft() {
    return this.left;
  }
  /**
   * @return rechter Nachfolger des aktuellen Knotens
   */   
  public TreeNode getRight() {
    return this.right;
  }

  /**
   * Sucht in diesem Teilbaum nach x, ohne den Baum zu veraendern.
   * @param x der gesuchte Wert
   * @return true, falls x enthalten ist, sonst false
   */
  public boolean simpleSearch(int x) {
      if(this.getValue()==x){
          return true;
      }
      else if(this.getValue()<x){
          if(this.right==null){return false;}
          else{return this.right.simpleSearch(x);}
      }
      else{
          if(this.left==null){return false;}
          else{return this.left.simpleSearch(x);}
      }
  }

  /**
   * Fuegt x in diesen Teilbaum ein.
   * @param x der einzufuegende Wert
   */
  public void insert(int x) {
      if (this.getValue()==x){
          ;;
      }
      else if(this.getValue()>x){
          if(this.left==null){
              this.left=new TreeNode(x,null,null);
          }
          this.left.insert(x);
      }
      else{
          if(this.right==null){
              this.right=new TreeNode(x,null,null);
          }
          this.right.insert(x);
      }
  }

  /**
   * Sucht in diesem Teilbaum nach x und rotiert den Endpunkt der Suche in die
   * Wurzel.
   * @param x der gesuchte Wert
   * @return die neue Wurzel des Teilbaums
   */
  public TreeNode rotationSearch(int x) {
      if(this.getValue()==x){
          return this;
      }
      else if(this.getValue()>x){
          TreeNode root1=this.left.rotationSearch(x);
          TreeNode copy1=root1.right;
          root1.right=this;
          this.left=copy1;
          return root1;
      }   
      else{
          TreeNode root2=this.right.rotationSearch(x);
          TreeNode copy2=root2.left;
          root2.left=this;
          this.right=copy2;
          return root2;
      }        
  }
 

  /**
   * @return Geordnete Liste aller Zahlen, die in diesem Teilbaum gespeichert sind.
   */
  public String toString() {
      if(this.right==null&&this.left==null){
          return this.getValueString();
      }
      if(this.left==null){
          return this.getValueString()+","+this.right.toString();
      }
      else if(this.right==null){
          return this.left.toString()+","+this.getValueString();
      }
      else{
          return this.left.toString()+","+this.getValueString()+","+this.right.toString();
      }
  }
 
  /**
   * Erzeugt eine dot Repraesentation in str
   * @param str Stringbuilder Objekt zur Konstruktion der Ausgabe
   * @param nullNodes Hilfsvariable, um Nullknoten zu indizieren. Anfangswert sollte 0 sein. 
   * @return Den nullNodes Wert fuer den behandelten Baum
   */
  public int toDot(StringBuilder str, int nullNodes) {
    if(this.hasLeft()) {
      str.append(this.getValueString() + " -> " + this.left.getValueString() + ";"
        + System.lineSeparator());
      nullNodes = this.left.toDot(str, nullNodes);
    } else {
      str.append("null" + nullNodes + "[shape=point]" + System.lineSeparator()
        + this.getValueString() + " -> null" + nullNodes + ";" + System.lineSeparator());
      nullNodes += 1;
    }
    if(this.hasRight()) {
      str.append(this.getValueString() + " -> " + this.right.getValueString() + ";"
        + System.lineSeparator());
      nullNodes = this.right.toDot(str, nullNodes);
    } else {
      str.append("null" + nullNodes + "[shape=point]" + System.lineSeparator()
        + this.getValueString() + " -> null" + nullNodes + ";" + System.lineSeparator());
      nullNodes += 1;
    }
    return nullNodes;
  }

}
