package graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Graph extends JPanel {
	public static LinkedList<Point> points;
	public static int xScale=10;
	public static int yScale=1;
	public static int xMax=500;
	public static int yMax=600;
	public static int ptSize = 5;
	public static void main(String[] args) {
		JFrame frame = new JFrame("Grapher");
		frame.setSize(xMax,yMax);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Graph graph = new Graph();
		frame.add(graph);
		points = new LinkedList<Point>();
		for(int x = 0; x<=xMax;x++){
			points.add(new Point(x,yMax-100-(x*x)));
		}
	}
	public void paintComponent(Graphics g){
		//System.out.println("hi");
		super.paintComponent(g);
		repaint();
		g.setColor(Color.BLACK);
		//g.drawLine(0,0,500,500);
		for(int i=0;i<points.size()-1;i++){
			g.fillOval(points.get(i).x*xScale, points.get(i).y*yScale, ptSize, ptSize);
			g.drawLine(points.get(i).x*xScale,points.get(i).y*yScale,
					points.get(i+1).x*xScale,points.get(i+1).y*yScale);
		}
		g.fillOval(points.get(points.size()-1).x*xScale,points.get(points.size()-1).y*yScale,ptSize,ptSize);

	}

}
