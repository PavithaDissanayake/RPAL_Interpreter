package Symbols;

import java.util.HashMap;

public class E extends Symbol {
    private int index;
    private E parent;
    private boolean isRemoved = false;
    public HashMap<Id, Symbol> values;
    
    public E(int i) {
        super("e");
        this.setIndex(i);
        this.values = new HashMap<Id, Symbol>();
    }
    
    public void setIndex(int i) {
        this.index = i;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void setParent(E e) {
        this.parent = e;
    }
    
    public E getParent() {
        return this.parent;
    }
    
    public void setIsRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }
    
    public boolean getIsRemoved() {
        return this.isRemoved;
    }
    
    // method to lookup a symbol in the symbol table
    public Symbol lookup(Id id){
        for (Id key : this.values.keySet()) {
            if (key.getData().equals(id.getData())){
                return this.values.get(key);
            }
        }
        // if the symbol is not found in the current scope, look in the parent scope
        if (this.parent != null) {
            return this.parent.lookup(id);
        }
        else {
            // if the symbol is not found in the parent scope, return the symbol with identifier data
            return new Symbol(id.getData());
        }
    }
}