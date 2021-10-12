import java.util.Random;
import processing.core.PApplet;

public class Circulos {
	
	private int x;
	private int y;
	private int speedx;
	private int speedy;
	
	boolean selec;
	boolean up;
	boolean right;
	
	int[] color;
	String name; 
	

	public Circulos (String namegroup, int posx, int posy, int[] groupcolor) {
		
		Random r = new Random();
		
		x = posx;
		y = posy;
		
		speedx = (int)(Math.random()*4 + 1);
		speedy = (int)(Math.random()*4 + 1);
		
		selec = false;
		up = r.nextBoolean();
		right = r.nextBoolean();
		
		color = groupcolor;
		
		name = namegroup;
		
	}
	
	public void draw(PApplet app) {
		
		
		
		if(selec==false) {
			
		if(up==true) {y-=speedy;}
		if(up==false) {y+=speedy;}}
		
		if(right==true) {x+=speedx;}
		if(right==false) {x-=speedx;}
		
		app.fill(color[0],color[1],color[2]);
		
		app.ellipse(x, y, 30, 30);
		
		if(selec==true) {
			
			app.text(name, x, y+35);
		}
		
		
		if(x<15) {right=true;}
		if(x>485) {right=false;}
		
		if(y<15) {up=false;}
		if(y>485) {up=true;}
	}
	

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
	public void setSelec(boolean hold) {
		
		this.selec = hold;
	}
	
}