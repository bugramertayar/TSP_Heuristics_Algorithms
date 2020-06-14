import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;


public class greedy_alg {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ArrayList<String> statement=new ArrayList<String>();	
		int i=0;
		
		try {
			InputStream is = new FileInputStream("XYcords.txt");
			BufferedReader bufRead = new BufferedReader(new InputStreamReader(is));	
			try {
				statement.add(bufRead.readLine());
				
				while(statement.get(i) != null) {
					statement.add(bufRead.readLine());
					i++;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println(getDistance(statement));
	
		long stopTime = System.currentTimeMillis();
		System.out.println((double)(stopTime - startTime)/1000 + " seconds");
	
	}

	public static int getDistance(ArrayList<String> arr) {
	
		ArrayList<Integer> all_distance = new ArrayList<Integer>();
	
		int k = 0;

		Segment segment2[];
		segment2= new Segment[1129];
		LinkedList<Segment> segment = new LinkedList<Segment>();
	
		for (int i = 0; i < arr.size()-1; i++) {
			
			String[] first=arr.get(i).trim().split("\\s+");
			
			for (int j = 1; j < arr.size()-1;j++) {
				segment2[k] = new Segment();
				
				if(i>=j) {
					
					continue;
				}
				
				String[] second=arr.get(j).trim().split("\\s+");
				int xDistance=Math.abs(Integer.parseInt(first[0])-Integer.parseInt(second[0]));
				int yDistance=Math.abs(Integer.parseInt(first[1])-Integer.parseInt(second[1]));
				int totalDistance=(int)Math.sqrt((xDistance*xDistance +yDistance*yDistance));

					segment2[k].setA(i);
					segment2[k].setB(j);
					segment2[k].addIndexToList(i);
					segment2[k].addIndexToList(j);
					segment2[k].setDistance(totalDistance);
					
					segment.add(segment2[k]);		
				all_distance.add(totalDistance);
				k++;

			}	
		}
//		for(int u = 0; u<1129;u++) {
//			
//			System.out.println(segment2[u].getA() + ".koordinat ve "+ segment2[u].getB() + ".koordinat distance=  " + segment2[u].getDistance());
//		}

		System.out.println();
			delete(segment,0,0,0,0);
			node node8[];
			  node8 = new node[48];
			  
		deleteY(node8,segment,0,arr);
		
		for(int y = 0; y<segment.size();y++) {
	 		System.out.println(segment.get(y).getIndexList()  + " distance: " + segment.get(y).getDistance());
		}
	
	int toplam = 0;
	connect(node8,segment, 0, arr);
	
	ArrayList<Integer> son_index = new ArrayList<Integer>();
	son_index.add(0);
	son_index.add(38);
	connect2(node8,segment, 0, arr);
	Segment son_segment = new Segment(0,38,2539);
	
	segment.add(son_segment);
	Plot plot2 = Plot.plot(Plot.plotOpts().
	        title("Travelling Salesman Problem (Greedy Aproach)").
	        legend(Plot.LegendFormat.BOTTOM)).
	    xAxis("x", Plot.axisOpts().
	        range(0, 8900)).
	    yAxis("y", Plot.axisOpts().
	        range(0, 5600)).
	    series("Data", Plot.data().
	        xy(node8[segment.get(0).getIndexList().get(0)].getX(), node8[segment.get(0).getIndexList().get(0)].getY()).xy(node8[segment.get(0).getIndexList().get(2)].getX(), node8[segment.get(0).getIndexList().get(2)].getY()).xy(node8[segment.get(0).getIndexList().get(3)].getX(), node8[segment.get(0).getIndexList().get(3)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(4)].getX(), node8[segment.get(0).getIndexList().get(4)].getY()).xy(node8[segment.get(0).getIndexList().get(5)].getX(), node8[segment.get(0).getIndexList().get(5)].getY()).xy(node8[segment.get(0).getIndexList().get(6)].getX(), node8[segment.get(0).getIndexList().get(6)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(7)].getX(), node8[segment.get(0).getIndexList().get(7)].getY()).xy(node8[segment.get(0).getIndexList().get(8)].getX(), node8[segment.get(0).getIndexList().get(8)].getY()).xy(node8[segment.get(0).getIndexList().get(9)].getX(), node8[segment.get(0).getIndexList().get(9)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(10)].getX(), node8[segment.get(0).getIndexList().get(10)].getY()).xy(node8[segment.get(0).getIndexList().get(11)].getX(), node8[segment.get(0).getIndexList().get(11)].getY()).xy(node8[segment.get(0).getIndexList().get(12)].getX(), node8[segment.get(0).getIndexList().get(12)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(13)].getX(), node8[segment.get(0).getIndexList().get(13)].getY()).xy(node8[segment.get(0).getIndexList().get(14)].getX(), node8[segment.get(0).getIndexList().get(14)].getY()).xy(node8[segment.get(0).getIndexList().get(15)].getX(), node8[segment.get(0).getIndexList().get(15)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(16)].getX(), node8[segment.get(0).getIndexList().get(16)].getY()).xy(node8[segment.get(0).getIndexList().get(17)].getX(), node8[segment.get(0).getIndexList().get(17)].getY()).xy(node8[segment.get(0).getIndexList().get(18)].getX(), node8[segment.get(0).getIndexList().get(18)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(19)].getX(), node8[segment.get(0).getIndexList().get(19)].getY()).xy(node8[segment.get(0).getIndexList().get(20)].getX(), node8[segment.get(0).getIndexList().get(20)].getY()).xy(node8[segment.get(0).getIndexList().get(21)].getX(), node8[segment.get(0).getIndexList().get(21)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(22)].getX(), node8[segment.get(0).getIndexList().get(22)].getY()).xy(node8[segment.get(0).getIndexList().get(23)].getX(), node8[segment.get(0).getIndexList().get(23)].getY()).xy(node8[segment.get(0).getIndexList().get(24)].getX(), node8[segment.get(0).getIndexList().get(24)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(25)].getX(), node8[segment.get(0).getIndexList().get(25)].getY()).xy(node8[segment.get(0).getIndexList().get(26)].getX(), node8[segment.get(0).getIndexList().get(26)].getY()).xy(node8[segment.get(0).getIndexList().get(27)].getX(), node8[segment.get(0).getIndexList().get(27)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(28)].getX(), node8[segment.get(0).getIndexList().get(28)].getY()).xy(node8[segment.get(0).getIndexList().get(29)].getX(), node8[segment.get(0).getIndexList().get(29)].getY()).xy(node8[segment.get(0).getIndexList().get(30)].getX(), node8[segment.get(0).getIndexList().get(30)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(31)].getX(), node8[segment.get(0).getIndexList().get(31)].getY()).xy(node8[segment.get(0).getIndexList().get(32)].getX(), node8[segment.get(0).getIndexList().get(32)].getY()).xy(node8[segment.get(0).getIndexList().get(33)].getX(), node8[segment.get(0).getIndexList().get(33)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(34)].getX(), node8[segment.get(0).getIndexList().get(34)].getY()).xy(node8[segment.get(0).getIndexList().get(35)].getX(), node8[segment.get(0).getIndexList().get(35)].getY()).xy(node8[segment.get(0).getIndexList().get(36)].getX(), node8[segment.get(0).getIndexList().get(36)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(37)].getX(), node8[segment.get(0).getIndexList().get(37)].getY()).xy(node8[segment.get(0).getIndexList().get(38)].getX(), node8[segment.get(0).getIndexList().get(38)].getY()).xy(node8[segment.get(0).getIndexList().get(39)].getX(), node8[segment.get(0).getIndexList().get(39)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(40)].getX(), node8[segment.get(0).getIndexList().get(40)].getY()).xy(node8[segment.get(0).getIndexList().get(41)].getX(), node8[segment.get(0).getIndexList().get(41)].getY()).xy(node8[segment.get(0).getIndexList().get(42)].getX(), node8[segment.get(0).getIndexList().get(42)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(43)].getX(), node8[segment.get(0).getIndexList().get(43)].getY()).xy(node8[segment.get(0).getIndexList().get(44)].getX(), node8[segment.get(0).getIndexList().get(44)].getY()).xy(node8[segment.get(0).getIndexList().get(45)].getX(), node8[segment.get(0).getIndexList().get(45)].getY()).
	        xy(node8[segment.get(0).getIndexList().get(46)].getX(), node8[segment.get(0).getIndexList().get(46)].getY()).xy(node8[segment.get(0).getIndexList().get(47)].getX(), node8[segment.get(0).getIndexList().get(47)].getY()).xy(node8[segment.get(0).getIndexList().get(0)].getX(),node8[segment.get(0).getIndexList().get(0)].getY()),
	        
	        Plot.seriesOpts().
	            marker(Plot.Marker.DIAMOND).
	            markerColor(Color.GREEN).
	            markerSize(8).
	            color(Color.BLACK));

	try {
		plot2.save("Travelling Salesman Problem (Greedy Aproach)", "png");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 
     System.out.println("**************************************************************************************************************************************************************************************************");
 
     for(int p = 0; p < segment.size();p++) {
 		
 		toplam += segment.get(p).getDistance();
 
 	}
     	segment.get(0).getIndexList().add(0);  
 		System.out.println(segment.get(0).getA() + ".index: ve " + segment.get(0).getIndexList() + " " + segment.get(0).getA() + ".index  " + "distance: " + (segment.get(1).getDistance()+segment.get(0).getDistance()));
 		System.out.print("total distance: ");
		return toplam;
	}
	
public static void delete(LinkedList<Segment> segment,int son,int bas,int sayac2,int denetleme) {

		int ü = son;
		int m = 0;
		int z= 0;
		int j = sayac2;
		int sayac = 0;
         while(segment.get(j).getA() == bas) {
        	 
        	 sayac++;
        	 j++;
		}

         while(sayac > 2) {
        	ü = son;
        	m = 0;
     		z= 0;
        	 
        	 while(segment.get(ü).getA() == bas) {
     			
     			if(segment.get(ü).getDistance() > m) {
     				
     				m = segment.get(ü).getDistance();	
     				z = ü;
     			}
     			ü++;
     	
     		}
     		segment.remove(z);
           
        	 sayac--;
         }
  
     if(denetleme<45) {

    	  delete( segment, (son+2), (bas+1), (sayac2+2), (denetleme+1));
    	  
    	 
      }
	} 
	
public static void deleteY(node node[],LinkedList<Segment> segment,int denetleme,ArrayList<String> arr) {

		int m = 0;
		int z= 0;
		int j = 0;
		int sayac = 0;
		
		if(denetleme == 0) {
		for(int i = 0; i<48 ; i++) {
			
			node[i] = new node();
		}
		}
	    while(j < segment.size()) {
	    	
       	 if(segment.get(j).getB() == denetleme || segment.get(j).getA()==denetleme) {
        	 
        	 sayac++;   
		}
       	 
       	 j++;
		}
 LinkedList<Integer> deneme = new LinkedList<Integer>();
 while(sayac > 1) {	
	 
	 j = 0;
	 LinkedList<Integer> arr2 = new LinkedList<Integer>();
	 
	 while(j < segment.size()) {
	    	
       	 if(segment.get(j).getB() == denetleme || segment.get(j).getA()==denetleme) {
        	 
       		 arr2.add(j);   
		}   	 
      	 j++;
		}
 int g = 0;
 m=0;
 
 for(int lengt = 0; lengt < arr2.size();lengt++) {
	 
	 if(segment.get(arr2.get(lengt)).getDistance()>m) {
		 m = segment.get(arr2.get(lengt)).getDistance();	 
		 z = arr2.get(lengt);
		 g = lengt; 
	 }
 }
	    arr2.remove(g);
	    segment.remove(z);
	    
		 deneme.add(z);
		 
     sayac--;   
}
 
 if(denetleme<47) {

 deleteY(node,segment, (denetleme+1),arr);
 }
}
public static void node_proccess(node node[],  LinkedList<Segment> segment,int denetleme,ArrayList<String> arr) {
	
	
	if(denetleme==0) {
		for (int i = 0; i < arr.size()-1; i++) {
			
			node[i] = new node();
			String[] first=arr.get(i).trim().split("\\s+");
			
				node[i].setX(Integer.parseInt(first[0]));
				node[i].setY(Integer.parseInt(first[1]));
		
			}	
		
	}

	int j = 0;
	int sayac = 0;
	
	 while(j < segment.size() ) {
	    	
       	 if(segment.get(j).getB() == denetleme  || segment.get(j).getA()==denetleme) {
        	 
        	 sayac++;       
		}
       
	j++;
}
	 	node[denetleme].setSayac(sayac);
		node[denetleme].setA(denetleme);
	 if(denetleme<47) {

		 node_proccess(node, segment, (denetleme+1),arr);
		}	
 
}
public static void connect(node node[],LinkedList<Segment> segment,int denetleme,ArrayList<String> arr) {
	
	if(denetleme == 0) {
		
		node_proccess(node,segment,0,arr);
	}
	
	
	Segment segment2[];
	segment2 = new Segment[48];

	for(int y = 0; y<48;y++) {

	   	 segment2[y] =new Segment();
	    }
	
	for(int i = 0;i<48;i++) {
	
		if(node[i].getSayac()!= 1 || node[i].getSayac()!= 0) {
			
			
			for(int j=0;j<48;j++) {
				int m =10000;
				if(node[i].getSayac()!= 1 && i!=j && node[j].getSayac()!= 1 && node[i].getSayac()< 3 && node[j].getSayac()< 3) {
					
					int xDistance = Math.abs(node[i].getX()-node[j].getX());
					int yDistance = Math.abs(node[i].getY()-node[j].getY());
					int totalDistance=(int)Math.sqrt((xDistance*xDistance +yDistance*yDistance));
					if(totalDistance<m) {
					int temp = 0;
					int temp2 = 0;
					segment2[j].setA(i);
					segment2[j].setB(j);
					segment2[j].addIndexToList(i);
					segment2[j].addIndexToList(j);
					segment2[j].setDistance(totalDistance);
					temp = node[i].getSayac()+1;
					node[i].setSayac(temp);
					temp2 = node[j].getSayac()+1;
					node[j].setSayac(temp2);
					m = totalDistance;
					segment.add(segment2[j]);
					}		
				}		
			}
	    }
	 }
}

public static void connect2(node node[],LinkedList<Segment> segment,int denetleme,ArrayList<String> arr) {

	int v = 0;
	int z = 1;
	int minDist = 100000;
	int minIndex = 0;
	boolean isStartIndex = false;  //false = startIndex : true = endIndex
	while(v < segment.size()-1) {
		minDist = 100000;
		while(z < segment.size()) {

			segment.get(v).getB();
			int xDist = Math.abs(node[segment.get(v).getB()].getX() - node[segment.get(z).getA()].getX());
			int yDist = Math.abs(node[segment.get(v).getB()].getY() - node[segment.get(z).getA()].getY());
			int totalDist = (int)Math.sqrt((xDist*xDist) + (yDist*yDist));
			if(totalDist < minDist) {minDist = totalDist; minIndex = z; isStartIndex = false;}
			xDist = Math.abs(node[segment.get(v).getB()].getX() - node[segment.get(z).getB()].getX());
			yDist = Math.abs(node[segment.get(v).getB()].getY() - node[segment.get(z).getB()].getY());
			totalDist = (int)Math.sqrt((xDist*xDist) + (yDist*yDist));
			if(totalDist < minDist) {minDist = totalDist; minIndex = z; isStartIndex = true;}

			z++;
		}
		
		if (isStartIndex == true) {

			segment.get(v).setB(segment.get(minIndex).getB());
   			segment.get(v).setDistance((segment.get(v).getDistance() + minDist + segment.get(minIndex).getDistance()));
			segment.get(v).extendIndexList(segment.get(minIndex).getIndexList());
			segment.remove(minIndex);
		} else {

			segment.get(v).setA((segment.get(minIndex).getA()));
			segment.get(v).setDistance((segment.get(v).getDistance() + minDist + segment.get(minIndex).getDistance()));
			segment.get(v).extendIndexList(segment.get(minIndex).getReverseIndexList());
			segment.remove(minIndex);
		}
		
		v++;
		z = v+1;
	
}

	

if(denetleme<4) {
	for(int y = 0; y<segment.size();y++) {
 		System.out.println(segment.get(y).getIndexList()  + " distance: " + segment.get(y).getDistance());
 		
 	}
	
	connect2( node,segment,denetleme+1,arr);
	
	
}

}
}
