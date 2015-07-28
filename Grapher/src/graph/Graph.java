package graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Graph extends JPanel {
	public static LinkedList<Point2D.Float> points =  new LinkedList<Point2D.Float>();
	public static LinkedList<Term> equation;
	public static int xScale=10;
	public static int yScale=1;
	public static int xMax=500;
	public static int xMin=-500;
	public static int yMax=600;
	public static int yMin=-600;
	public static float xStep=1;
	public static float yStep=1;
	public static int ptSize = 6;
	public static void main(String[] args) {
		JFrame frame = new JFrame("Grapher");
		frame.setSize(Math.abs(xMax-xMin),Math.abs(yMax-yMin));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Graph graph = new Graph();
		frame.add(graph);
		
		equation = new LinkedList<Term>();
		equation.add(new Term(1,3));
		equation.add(new Term(-3,2));
		equation.add(new Term(2,1));
		equation.add(new Term(15,0));
		
		for(int x = xMin; x<=xMax;x++){
			float sum = 0;
			for(int i=0;i<equation.size();i++){
				sum+=equation.get(i).getValue(x);
			}
			points.add(new Point2D.Float(x,(int) sum*-1));
		}
	}
	public static void graph(LinkedList<Point2D.Float> points){
		Graph.points=points;
		
		JFrame frame = new JFrame("Grapher");
		frame.setSize(Math.abs(xMax-xMin),Math.abs(yMax-yMin));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Graph graph = new Graph();
		frame.add(graph);
		
	}
	public static void graph(LinkedList<Term> equation, float dx){
		for(int x = xMin; x<=xMax;x+=dx){
			float sum = 0;
			for(int i=0;i<equation.size();i++){
				sum+=equation.get(i).getValue(x);
			}
			points.add(new Point2D.Float(x,(int) sum*-1));
		}
		graph(points);
	}
	public static void graph(LinkedList<Term> equation, int xMin, int xMax, float dx){
		Graph.xMin=xMin;
		Graph.xMax=xMax;
		for(int x = Graph.xMin; x<=Graph.xMax;x+=dx){
			float sum = 0;
			for(int i=0;i<equation.size();i++){
				sum+=equation.get(i).getValue(x);
			}
			points.add(new Point2D.Float(x,(int) sum*-1));
		}
		graph(points);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		repaint();
		g.setColor(Color.BLACK);
		g.drawLine(0, yMax, Math.abs(xMax-xMin), yMax); //x-axis
		g.drawLine(Math.abs(xMin),0,Math.abs(xMin),Math.abs(yMax-yMin)); //y-axis
		g.setColor(Color.BLACK);
		if(points!=null){
			for(int i=0;i<points.size()-1;i++){
				g.fillOval((int)((points.get(i).x*xScale-(ptSize/2))+Math.abs(xMin)), (int)(points.get(i).y*yScale-(ptSize/2)+Math.abs(yMax)), ptSize, ptSize);
				g.drawLine((int)(points.get(i).x*xScale+Math.abs(xMin)),(int)(points.get(i).y*yScale+Math.abs(yMax)),
						(int)(points.get(i+1).x*xScale+Math.abs(xMin)),(int)(points.get(i+1).y*yScale+Math.abs(yMax)));
			}
			g.fillOval((int)((points.get(points.size()-1).x*xScale-(ptSize/2))+Math.abs(xMin)), (int)(points.get(points.size()-1).y*yScale-(ptSize/2)+Math.abs(yMax)), ptSize, ptSize);
		}
		/*
		for(int i=0;i<equation.size();i++){
			System.out.print(equation.get(i).toString());
			if(i!=(equation.size()-1))
				System.out.print("+");
		}
		System.out.print("\n");
		*/
	}

}
