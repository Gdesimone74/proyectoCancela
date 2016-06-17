package app;

import javax.swing.*;

import vista.PanelCentral;
import vista.PanelOeste;
import mapa.Camino;
import mapa.Mapa;
import sun.net.www.content.image.gif;

import java.awt.*;

public class Inicio {
	private static JFrame frame;
	public static PanelCentral panelCentral;
	public static PanelOeste panelOeste;
	public static Mapa mapa = new Mapa();
	public static Camino camino = new Camino(mapa);
		
	private static void show() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        System.out.println("holaa");
        System.out.println("holaa");
        System.out.println("la concha tu madre");
        System.out.println("vamoo");
        System.out.println("grrr");
        
        int i=0;
       if(i==0)
       {
    	   while(i<10)
    	   {
    		   i++;
    		   System.out.println("asd");
    		   while(i>40)
    		   {
    			   int j=1;
    		   }
    	   }
       }
        
      
    }
	    
	private static void components() {
		Container c = frame.getContentPane();
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		c.add(new PanelCentral(), BorderLayout.CENTER);
		c.add(new PanelOeste(), BorderLayout.WEST);
	} 
	
	public static void cerrarVentana() {
		frame.dispose();
		System.exit(0);
	}

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	frame = new JFrame("Progra III");
            	components();
                show();
            }
        });
    }
}
