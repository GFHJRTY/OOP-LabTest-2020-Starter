package ie.tudublin;

import java.util.ArrayList;

import javafx.scene.text.TextAlignment;

import processing.core.PApplet;

import processing.data.Table;

import processing.data.TableRow;

public class Gantt extends PApplet
{	

	ArrayList<Task> tasks = new ArrayList<Task>();

	float xborder;

	float yborder;

	float spac;

	float xstart;

	float rx;

	float rx2;

	float ry1;

	float ry2;

	float ln;

	float x;

	float h;

	int r;
	
	public void settings()
	{

		size(800, 600);

		xborder = width*0.1f;

		yborder = height*0.15f;

		spac = width*0.028f;

		xstart = 3*xborder/2;

		h = yborder/4;

	}

	public void loadTasks()
	{

	Table table = loadTable("tasks.csv","header");

    for(TableRow row : table.rows()){

    Task t = new Task(row);

    tasks.add(t);
		
	}

	//load data

}

	public void printTasks()
	{

		for(Task t:tasks)
        {

			System.out.println(t);
			
        }
		
	}

	//print list

	void display(){

		    x = xstart;

	for(int j = 1 ; j <= 30 ; j++){

			textAlign(CENTER,CENTER);
	
			stroke(0, 0, 100);
	
			line(x,2*yborder/3,x,height - 2*yborder/3);
	
			fill(0,0,100);
			
			text(j,x,yborder/3);
	
			x += spac; 
	
		}

		//draw the number 1-30  and lines

    for(int i = 0; i < tasks.size() ; i++){

		colorMode(HSB,100);

		Task t = tasks.get(i);

		rx = xstart + (t.getStart()-1)*spac;

		ln = t.getEnd() - t.getStart();

		float y = map(i, 0, tasks.size(), yborder, height - yborder);

		fill(0,0,100);

		textAlign(CENTER,CENTER);

		text(t.getName(), xborder, y);

		fill(i*255/30,100,100);

		noStroke();

		rect(rx,y - 10,ln*spac,h,30);

	}

	//draw rectangles and text

	} 
	
	public void mousePressed()
	{

        for(int i = 0 ; i < tasks.size() ; i++){

	    float y = map(i, 0, tasks.size(), yborder, height - yborder);

		Task t = tasks.get(i);

		rx = xstart + (t.getStart()-1)*spac;

		ln = t.getEnd() - t.getStart();

		rx2 = rx + ln*spac;

		ry1 = y - 10;

		ry2 = y - 10 + h;

		if(mouseX >= rx && mouseX <= rx2 &&
		
		   mouseY >= ry1 && mouseY <= ry2){

			println("Mouse pressed");

		}

		}

	}

	//check if the mouse in the area of rectangle or not

	public void mouseDragged()
	{

		println("Mouse dragged");

	}

	//Altering the rectangle

	
	
	public void setup() 
	{

		loadTasks();

		printTasks();

		//load and print

	}
	
	public void draw()
	{			

		background(0);

		display();

		//call display function

	}
}
