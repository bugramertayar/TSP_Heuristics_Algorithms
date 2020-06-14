import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class NearestNeighborAlgorithm {

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
		
			
		ArrayList<Integer> avoidList=new ArrayList<Integer>();
	
		int road=0;
		int index=1;
		int increment=0;
		int maxRoad=0;
		int tempStart = index;
		
		for (int k = 0;k < statement.size()-1; k++) {
			
			avoidList.add(index);
			
			road=getDistance(index,statement,avoidList, tempStart);
			System.out.print("Start="+ (index) +"  road "+road);
			
			maxRoad+=road;
			
			index=getIndex(index,statement,avoidList, tempStart);
			System.out.println(" index "+ (index));
			
			
			increment++;
			
		}
		
		
		System.out.println("Number of Visited Index  = "+increment);
		System.out.println("Tour Length  = "+maxRoad);
		
		
	
		long stopTime = System.currentTimeMillis();
		System.out.println((double)(stopTime - startTime)/1000 + " seconds");
		
		
		drawVisual();
		
		
	}
	
	
	
	
	public static int getDistance(int startPointIndex,ArrayList<String> arr,ArrayList<Integer> avoidArr, int tempStart) {
		
		String[] first=arr.get(startPointIndex).trim().split("\\s+");
		int min=10000;
		for (int i = 0; i < arr.size()-1; i++) {
			
			
			if(avoidArr.contains(i)) 
			{
				continue;
			}
			else {
			
				String[] second=arr.get(i).trim().split("\\s+");
				int xDistance=Math.abs(Integer.parseInt(first[0])-Integer.parseInt(second[0]));
				int yDistance=Math.abs(Integer.parseInt(first[1])-Integer.parseInt(second[1]));
				int totalDistance=(int)Math.sqrt((xDistance*xDistance +yDistance*yDistance));
				
				if(totalDistance<min) {
					min=totalDistance;
				}
				
			}
		}
		if(min==10000) {
			String[] lastLoc=arr.get(tempStart).trim().split("\\s+");
			int lastxDistance=Math.abs(Integer.parseInt(first[0])-Integer.parseInt(lastLoc[0]));
			int lastyDistance=Math.abs(Integer.parseInt(first[1])-Integer.parseInt(lastLoc[1]));
			int lasttotalDistance=(int)Math.sqrt((lastxDistance*lastxDistance + lastyDistance*lastyDistance));
			return lasttotalDistance;
		}
		
		return min;
	}
	
	
	
	
	public static int getIndex(int startPointIndex,ArrayList<String> arr,ArrayList<Integer> avoidArr, int tempStart) {
		
		String[] first=arr.get(startPointIndex).trim().split("\\s+");
		int min=10000;
		int index=0;
		for (int i = 0; i < arr.size()-1; i++) {
			
			
			if(avoidArr.contains(i)) 
			{
				continue;
			}
			else {
			
				String[] second=arr.get(i).trim().split("\\s+");
				int xDistance=Math.abs(Integer.parseInt(first[0])-Integer.parseInt(second[0]));
				int yDistance=Math.abs(Integer.parseInt(first[1])-Integer.parseInt(second[1]));
				int totalDistance=(int)Math.sqrt((xDistance*xDistance +yDistance*yDistance));
				
				if(totalDistance<min) {
					min=totalDistance;
					index=i;
				}
				
			}
		}
		if(min==10000) {
			return tempStart;
		}
		
		return index;
	}
	
	
	
	public static void drawVisual() {
		
		Plot plot = Plot.plot(Plot.plotOpts().
		        title("Nearest Neighbor Algorithm").
		        legend(Plot.LegendFormat.BOTTOM)).
		    xAxis("x", Plot.axisOpts().
		        range(0, 8000)).
		    yAxis("y", Plot.axisOpts().
		        range(0, 5600)).
		    series("Data", Plot.data().
		        xy(2233,10).
		        xy(3177,756).
		        xy(3082,1644).
		        xy(3023,1942).
		        xy(3484,2829).
		        xy(3245,3305).
		        xy(4483,3369).
		        xy(5185,3258).
		        xy(5468,2606).
		        xy(5199,2182).
		        xy(4612,2035).
		        xy(4307,2322).
		        xy(4706,2674).
		        xy(5989,2873).
		        xy(6347,2683).
		        xy(6426,3173).
		        xy(6807,2993).
		        xy(7509,3239).
		        xy(7462,3590).
		        xy(7573,3716).
		        xy(7541,3981).
		        xy(7248,3779).
		        xy(7352,4506).
		        xy(7608,4458).
		        xy(7762,4595).
		        xy(7732,4723).
		        xy(7555,4819).
		        xy(7280,4899).
		        xy(7611,5184).
		        xy(5900,3561).
		        xy(6271,2135).
		        xy(6898,1885).
		        xy(6734,1453).
		        xy(7265,1268).
		        xy(7392,2244).
		        xy(7545,2801).
		        xy(6101,1110).
		        xy(6107, 669).
		        xy(5530,1424).
		        xy(4608,1198).
		        xy(4985, 140).
		        xy(1916,1569).
		        xy(1112,2049).
		        xy(1633,2809).
		        xy(  10,2676).
		        xy(  23,2216).
		        xy( 675,1006).
		        xy( 401, 841).
		        xy(2233,  10),
		        Plot.seriesOpts().
		            marker(Plot.Marker.DIAMOND).
		            markerColor(Color.GREEN).
		            color(Color.BLACK));

		try {
			plot.save("visualization", "png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

}
