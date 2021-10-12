

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import processing.core.PApplet;

public class Main extends PApplet{
	
	public static void main(String[] args) {
		PApplet.main("Main");
		
	}
	
	private int x;
	private int y;
	private int r;
	private int g;
	private int b;
	
	private Socket s; 
	private BufferedReader lec;
	
	ArrayList<GroupModel>grupos;
	
	ArrayList<Circulos> listaCir;
	
	@Override
	public void settings() {
		
		size(500,500);
		 
	}
	


	
	
	
	@Override
	public void setup() {
		int[] Colorproof = new int[] {0,0,0};
		
		serverConfig();
		
		grupos = new ArrayList();
		listaCir = new ArrayList();
		x=350;
		y=350;
		
		textAlign(CENTER,CENTER);
		ellipseMode(CENTER);
	}
	
	@Override
	public void draw() {
	background(255);
	
	if(grupos.size()!=0) {
		
		
		//mouse
		
				for(int j=0; j < listaCir.size();j++) {
					
					if (mouseX>listaCir.get(j).getX()-15 
							
					&&mouseX<listaCir.get(j).getX()+15
					
					&& mouseY>listaCir.get(j).getY()-15
					
					&&mouseY<listaCir.get(j).getY()+15)
					{
						listaCir.get(j).setSelec(true);}
					
					else {listaCir.get(j).setSelec(false);}
					
					
	
			//listDraw
		
			 for(int i = 0; i < listaCir.size();i++) {
	    		 listaCir.get(i).draw(this);
	    	 }
			
		
			
		
		
		
			
		}
	}
	 
  
    
	}

	
		
		
		

	public void serverConfig() {
		new Thread(
				()->{
					try {
						ServerSocket server = new ServerSocket(5000);
						System.out.println("Esperando...");
						s = server.accept();
						System.out.println("conectado");
						InputStream is = s.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						lec = new BufferedReader(isr);
						
						while(true) {
							String line = lec.readLine();
							System.out.println(line);
							if(line.equals("B")) {
								listaCir.clear();
								grupos.clear();
								
							}else {
								Gson gson = new Gson();
								GroupModel Group = gson.fromJson(line, GroupModel.class);
								grupos.add(Group);
								  for(int i = 0; i < Group.getamount();i++) {
							        	Circulos newP = new Circulos(Group.getNombre(), Group.getX(), Group.getY(), Group.getColor());
							        	listaCir.add(newP);
							        }
							
							}
							
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();
	}

 }