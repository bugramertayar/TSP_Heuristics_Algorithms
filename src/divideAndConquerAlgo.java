import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

public class divideAndConquerAlgo {
	
	static List<Integer> indexList = new ArrayList<Integer>();
	static List<linkedCity> lC = new ArrayList<linkedCity>();
	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		List<String> points=new ArrayList<String>();	
		List<Integer> Xcord = new ArrayList<Integer>();
		List<Integer> Ycord = new ArrayList<Integer>();
		int i=0;
		
		try {
			InputStream iS = new FileInputStream("XYcords.txt");
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(iS));	
			try {
				points.add(buffRead.readLine());
				while(points.get(i) != null) {
					points.add(buffRead.readLine());
					indexList.add(i);
					String [] XY = points.get(i).trim().split("\\s+");
					Xcord.add(Math.abs(Integer.parseInt(XY[0])));
					Ycord.add(Math.abs(Integer.parseInt(XY[1])));
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
		
		
		divide_tsp(points, Xcord, Ycord);
		
		////////Plot Codes//////////
		Plot plot = Plot.plot(Plot.plotOpts().
		        title("Traveling Salesman Problem (Divide and Conquer)").
		        legend(Plot.LegendFormat.BOTTOM)).
		    xAxis("x", Plot.axisOpts().
		        range(0, 8000)).
		    yAxis("y", Plot.axisOpts().
		        range(0, 5600)).
		    series("Data", Plot.data().
		        xy(Xcord.get(lC.get(0).getIndexList().get(0)), Ycord.get(lC.get(0).getIndexList().get(0))).xy(Xcord.get(lC.get(0).getIndexList().get(1)), Ycord.get(lC.get(0).getIndexList().get(1))).xy(Xcord.get(lC.get(0).getIndexList().get(2)), Ycord.get(lC.get(0).getIndexList().get(2))).xy(Xcord.get(lC.get(0).getIndexList().get(3)), Ycord.get(lC.get(0).getIndexList().get(3))).xy(Xcord.get(lC.get(0).getIndexList().get(4)), Ycord.get(lC.get(0).getIndexList().get(4))).xy(Xcord.get(lC.get(0).getIndexList().get(5)), Ycord.get(lC.get(0).getIndexList().get(6))).xy(Xcord.get(lC.get(0).getIndexList().get(7)), Ycord.get(lC.get(0).getIndexList().get(7))).xy(Xcord.get(lC.get(0).getIndexList().get(8)), Ycord.get(lC.get(0).getIndexList().get(8))).xy(Xcord.get(lC.get(0).getIndexList().get(9)), Ycord.get(lC.get(0).getIndexList().get(9))).xy(Xcord.get(lC.get(0).getIndexList().get(10)), Ycord.get(lC.get(0).getIndexList().get(10))).xy(Xcord.get(lC.get(0).getIndexList().get(11)), Ycord.get(lC.get(0).getIndexList().get(11))).xy(Xcord.get(lC.get(0).getIndexList().get(12)), Ycord.get(lC.get(0).getIndexList().get(12))).xy(Xcord.get(lC.get(0).getIndexList().get(13)), Ycord.get(lC.get(0).getIndexList().get(13))).xy(Xcord.get(lC.get(0).getIndexList().get(14)), Ycord.get(lC.get(0).getIndexList().get(14))).xy(Xcord.get(lC.get(0).getIndexList().get(15)), Ycord.get(lC.get(0).getIndexList().get(15))).xy(Xcord.get(lC.get(0).getIndexList().get(16)), Ycord.get(lC.get(0).getIndexList().get(16))).xy(Xcord.get(lC.get(0).getIndexList().get(17)), Ycord.get(lC.get(0).getIndexList().get(17))).xy(Xcord.get(lC.get(0).getIndexList().get(18)), Ycord.get(lC.get(0).getIndexList().get(18))).xy(Xcord.get(lC.get(0).getIndexList().get(19)), Ycord.get(lC.get(0).getIndexList().get(19))).xy(Xcord.get(lC.get(0).getIndexList().get(20)), Ycord.get(lC.get(0).getIndexList().get(20))).xy(Xcord.get(lC.get(0).getIndexList().get(21)), Ycord.get(lC.get(0).getIndexList().get(21))).xy(Xcord.get(lC.get(0).getIndexList().get(22)), Ycord.get(lC.get(0).getIndexList().get(22))).xy(Xcord.get(lC.get(0).getIndexList().get(23)), Ycord.get(lC.get(0).getIndexList().get(23))).xy(Xcord.get(lC.get(0).getIndexList().get(24)), Ycord.get(lC.get(0).getIndexList().get(24))).xy(Xcord.get(lC.get(0).getIndexList().get(25)), Ycord.get(lC.get(0).getIndexList().get(25))).xy(Xcord.get(lC.get(0).getIndexList().get(26)), Ycord.get(lC.get(0).getIndexList().get(26))).xy(Xcord.get(lC.get(0).getIndexList().get(27)), Ycord.get(lC.get(0).getIndexList().get(27))).xy(Xcord.get(lC.get(0).getIndexList().get(28)), Ycord.get(lC.get(0).getIndexList().get(28))).xy(Xcord.get(lC.get(0).getIndexList().get(29)), Ycord.get(lC.get(0).getIndexList().get(29))).xy(Xcord.get(lC.get(0).getIndexList().get(30)), Ycord.get(lC.get(0).getIndexList().get(30))).xy(Xcord.get(lC.get(0).getIndexList().get(31)), Ycord.get(lC.get(0).getIndexList().get(31))).xy(Xcord.get(lC.get(0).getIndexList().get(32)), Ycord.get(lC.get(0).getIndexList().get(32))).xy(Xcord.get(lC.get(0).getIndexList().get(33)), Ycord.get(lC.get(0).getIndexList().get(33))).xy(Xcord.get(lC.get(0).getIndexList().get(34)), Ycord.get(lC.get(0).getIndexList().get(34))).xy(Xcord.get(lC.get(0).getIndexList().get(35)), Ycord.get(lC.get(0).getIndexList().get(35))).xy(Xcord.get(lC.get(0).getIndexList().get(36)), Ycord.get(lC.get(0).getIndexList().get(36))).xy(Xcord.get(lC.get(0).getIndexList().get(37)), Ycord.get(lC.get(0).getIndexList().get(37))).xy(Xcord.get(lC.get(0).getIndexList().get(38)), Ycord.get(lC.get(0).getIndexList().get(38))).xy(Xcord.get(lC.get(0).getIndexList().get(39)), Ycord.get(lC.get(0).getIndexList().get(39))).xy(Xcord.get(lC.get(0).getIndexList().get(40)), Ycord.get(lC.get(0).getIndexList().get(40))).xy(Xcord.get(lC.get(0).getIndexList().get(41)), Ycord.get(lC.get(0).getIndexList().get(41))).xy(Xcord.get(lC.get(0).getIndexList().get(42)), Ycord.get(lC.get(0).getIndexList().get(42))).xy(Xcord.get(lC.get(0).getIndexList().get(43)), Ycord.get(lC.get(0).getIndexList().get(43))).xy(Xcord.get(lC.get(0).getIndexList().get(44)), Ycord.get(lC.get(0).getIndexList().get(44))).xy(Xcord.get(lC.get(0).getIndexList().get(45)), Ycord.get(lC.get(0).getIndexList().get(45))).xy(Xcord.get(lC.get(0).getIndexList().get(46)), Ycord.get(lC.get(0).getIndexList().get(46))).xy(Xcord.get(lC.get(0).getIndexList().get(47)), Ycord.get(lC.get(0).getIndexList().get(47))).xy(Xcord.get(lC.get(0).getIndexList().get(48)), Ycord.get(lC.get(0).getIndexList().get(48))),
		        Plot.seriesOpts().
		            marker(Plot.Marker.DIAMOND).
		            markerColor(Color.GREEN).
		            markerSize(8).
		            color(Color.BLACK));

		try {
			plot.save("divide&conquer", "png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		////////////////////////////
		
		long endTime = System.currentTimeMillis();
		System.out.println("Work time: " + (double)(endTime - beginTime)/1000 + " seconds");
	}
	
	
	public static void divide_tsp (List<String> cities, List<Integer> Xcord, List<Integer> Ycord) {
		
		List<Integer> sortedY = new ArrayList<Integer>();
		sortedY.addAll(Ycord);
		sortedY.sort(null);
		split_cities(Xcord, Ycord, sortedY);
		System.out.println("************************* joining tours for n = 3 *************************");
		for (int i = 0; i<lC.size(); i++) {
			lC.get(i).printLink();
		}
		
		join_tours(Xcord, Ycord);
		System.out.println("************************* joining tours for n = 6 *************************");
		for (int i = 0; i<lC.size(); i++) {
			lC.get(i).printLink();
		}
		
		join_tours(Xcord, Ycord);
		System.out.println("************************* joining tours for n = 12 ************************");
		for (int i = 0; i<lC.size(); i++) {
			lC.get(i).printLink();
		}
		
		join_tours(Xcord, Ycord);
		System.out.println("************************* joining tours for n = 24 ************************");
		for (int i = 0; i<lC.size(); i++) {
			lC.get(i).printLink();
		}
		
		join_tours(Xcord, Ycord);
		System.out.println("************************* joining tours for n = 48 ************************");
		for (int i = 0; i<lC.size(); i++) {
			lC.get(i).printLink();
		}
		
		int x = Math.abs(Xcord.get(lC.get(0).getStartIndex()) - Xcord.get(lC.get(0).getEndIndex()));
		int y = Math.abs(Ycord.get(lC.get(0).getStartIndex()) - Ycord.get(lC.get(0).getEndIndex()));
		int total = (int)Math.sqrt((x*x) + (y*y));
		lC.get(0).setEndIndex(lC.get(0).getStartIndex());
		lC.get(0).setLinkLength(lC.get(0).getLinkLength() + total);
		lC.get(0).addIndexToList(lC.get(0).getStartIndex());
		System.out.println("********************* joining start point to end point ********************");
		for (int i = 0; i<lC.size(); i++) {
			lC.get(i).printLink();
		}
		System.out.println("Tour completed with length of : " + lC.get(0).getLinkLength());
		
	}
	
	
	public static void split_cities (List<Integer> Xcord, List<Integer> Ycord, List<Integer> sortedY) {
		
		if(sortedY.size()<=3) {
			
			exhaustive_tsp(Xcord, Ycord, sortedY);
			
		} else {
			int middle = sortedY.size()/2;
			List<Integer> firstHalf = sortedY.subList(0, middle);
			split_cities(Xcord, Ycord, firstHalf);
			List<Integer> secondHalf = sortedY.subList(middle, sortedY.size());
			split_cities(Xcord, Ycord, secondHalf);
		}
		
	}
	
	public static void exhaustive_tsp(List<Integer> Xcord, List<Integer> Ycord, List<Integer> splitY) {
		List<Integer> lengthList = new ArrayList<Integer>();
		List<Integer> sortedLength = new ArrayList<Integer>();
		int i = 0;
		int j = 1;
		
		while(i <= splitY.size()-1) {
			if(j == splitY.size()) {j = 0;}
			int xDist = Math.abs(Xcord.get(Ycord.indexOf(splitY.get(i))) - Xcord.get(Ycord.indexOf(splitY.get(j))));
			int yDist = Math.abs(splitY.get(i) - splitY.get(j));
			int totalDist = (int)Math.sqrt((xDist*xDist) + (yDist*yDist));
			lengthList.add(totalDist);
			i++;
			j++;
		}
		sortedLength.addAll(lengthList);
		sortedLength.sort(null);
		if (lengthList.indexOf(sortedLength.get(0)) == (lengthList.indexOf(sortedLength.get(1))+1)%3) {
			int dist = sortedLength.get(0)+sortedLength.get(1);
			int startInd = Ycord.indexOf(splitY.get((lengthList.indexOf(sortedLength.get(0))+2) % 3));
			int endInd = Ycord.indexOf(splitY.get((lengthList.indexOf(sortedLength.get(0))+1) % 3));
			indexList.remove((Integer)Ycord.indexOf(splitY.get(lengthList.indexOf(sortedLength.get(0)))));
			lC.add(new linkedCity(startInd, (Integer)Ycord.indexOf(splitY.get(lengthList.indexOf(sortedLength.get(0)))), endInd, dist));
			
		} else if ((lengthList.indexOf(sortedLength.get(0))+1)%3 == lengthList.indexOf(sortedLength.get(1))) {
			int dist = sortedLength.get(0)+sortedLength.get(1);
			int startInd = Ycord.indexOf(splitY.get(lengthList.indexOf(sortedLength.get(0)) % 3));
			int endInd = Ycord.indexOf(splitY.get((lengthList.indexOf(sortedLength.get(0))+2) % 3));
			indexList.remove((Integer)Ycord.indexOf(splitY.get((lengthList.indexOf(sortedLength.get(0))+1)%3)));
			lC.add(new linkedCity(startInd, (Integer)Ycord.indexOf(splitY.get((lengthList.indexOf(sortedLength.get(0))+1)%3)), endInd, dist));
		}			
		
		
	}
	
	public static void join_tours (List<Integer> Xcord, List<Integer> Ycord) {
		int i = 0;
		int j = 1;
		int minDist = 100000;
		int minIndex = 0;
		boolean isStartIndex = false;  //false = startIndex : true = endIndex
		while(i < lC.size()) {
			minDist = 100000;
			while(j < lC.size()) {

				lC.get(i).getEndIndex();
				int xDist = Math.abs(Xcord.get(lC.get(i).getEndIndex())) - Xcord.get(lC.get(j).getStartIndex());
				int yDist = Math.abs(Ycord.get(lC.get(i).getEndIndex())) - Ycord.get(lC.get(j).getStartIndex());
				int totalDist = (int)Math.sqrt((xDist*xDist) + (yDist*yDist));
				if(totalDist < minDist) {minDist = totalDist; minIndex = j; isStartIndex = false;}
				xDist = Math.abs(Xcord.get(lC.get(i).getEndIndex())) - Xcord.get(lC.get(j).getEndIndex());
				yDist = Math.abs(Ycord.get(lC.get(i).getEndIndex())) - Ycord.get(lC.get(j).getEndIndex());
				totalDist = (int)Math.sqrt((xDist*xDist) + (yDist*yDist));
				if(totalDist < minDist) {minDist = totalDist; minIndex = j; isStartIndex = true;}

				j++;
			}
			
			if (isStartIndex == true) {

				lC.get(i).setEndIndex(lC.get(minIndex).getEndIndex());
				lC.get(i).setLinkLength(lC.get(i).getLinkLength() + minDist + lC.get(minIndex).getLinkLength());
				lC.get(i).extendIndexList(lC.get(minIndex).getIndexList());
				lC.remove(minIndex);
			} else {

				lC.get(i).setEndIndex(lC.get(minIndex).getStartIndex());
				lC.get(i).setLinkLength(lC.get(i).getLinkLength() + minDist + lC.get(minIndex).getLinkLength());
				lC.get(i).extendIndexList(lC.get(minIndex).getReverseIndexList());
				lC.remove(minIndex);
			}
			
			i++;
			j = i+1;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

