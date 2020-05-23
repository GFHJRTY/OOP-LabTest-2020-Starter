package ie.tudublin;

import processing.data.TableRow;

public class Task{

    private String Taskname;

    private float Start;
    
    private float End;

    public Task(String Taskname,float Start,float End){

    this.Taskname = Taskname;

    this.Start = Start;

    this.End = End;

    }

    public Task(TableRow tr)
    {

        this(tr.getString("Taskname"), tr.getFloat("Start"),tr.getFloat("End"));

    }

    public String getName() {

        return Taskname;

    }

    public void setName(String Taskname) {

        this.Taskname = Taskname;

    }

    public float getStart() {

        return Start;

    }

    public void setStart(float Start) {

        this.Start = Start;

    }

    public float getEnd() {

        return End;

    }

    public void setEnd(float End) {

        this.End = End;

    }

    @Override

    public String toString() {

        return "Tasks [Taskname=" + Taskname + ", Start=" + Start + ", End=" + End + "]";

    }

}