import java.util.ArrayList;

import processing.core.PApplet;

public class GroupModel {
	    
	    
	    private int[] colors;
	    private String name;
	    private int amount;
	    private int x;
	    private int y;

	    public GroupModel(String name, int amounts, int x, int y, int[] colors) {
	        this.name = name;
	        this.amount = amounts;
	        this.x = x;
	        this.y = y;
	        this.colors = colors;
	    }

	    public GroupModel() { }

	    public int getX() {
	    	
	        return x;
	    }

	    public void setX(int x) {
	    	
	        this.x = x;
	    }

	    public int getY() {
	    	
	        return y;
	    }

	    public void setY(int y) {
	    	
	        this.y = y;
	    }

	    public int[] getColor() {
	    	
	        return colors;
	    }

	    public void setColor(int[] color) {
	    	
	        this.colors = color;
	    }
	    public String getNombre() {
	    	
	        return name;
	    }

	    public void setNombre(String names) {
	    	
	        this.name = names;
	    }

	    public int getamount() {
	    	
	        return amount;
	    }

	    public void setamount(int amount) {
	    	
	        this.amount = amount;
	    }
	    
	   
	    
	}

