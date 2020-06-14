import java.util.ArrayList;

public class Segment {

	public int a;
	public int b; 
	public int distance;
	private ArrayList<Integer> indexList = new ArrayList<Integer>(); /////////
	
	
	public Segment() {
		
		
		
	}

	public Segment(int a, int b, int distance) {
		this.a = a;
		this.indexList.add(a);
		this.indexList.add(b);
		this.b = b;
		this.distance = distance;
		
		
	}
	////////////////////
	public ArrayList<Integer> getIndexList() {
		return indexList;
	}
	
	public ArrayList<Integer> getReverseIndexList() {
		
		ArrayList<Integer> reverse = new ArrayList<Integer>();
		
		for(int i = this.indexList.size()-1; i>=0; i--) {
			reverse.add(this.indexList.get(i));
		}
		
		return reverse;
	}

	public void extendIndexList(ArrayList<Integer> indexList) {
		this.indexList.addAll(indexList);
	}
	
	public void addIndexToList(int i) {
		this.indexList.add(i);
	}

	////////////////////

	public boolean contains0(int x) {
		
		
		if(x == 0) {
			
			return true;
		}
		
		else {
			
			return false;	
		}
		
		
		
	}
public boolean contains1(int x) {
		
		
		if(x == 1) {
			
			return true;
		}
		
		else {
			
			return false;	
		}
		
		
		
	}
public boolean contains2(int x) {
	
	
	if(x == 2) {
		
		return true;
	}
	
	else {
		
		return false;	
	}
	
	
	
}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
	
	public void printLink() {
        System.out.println("Start index: " + this.getA() + " Included indexes: " + this.indexList.toString() + "  End index: " + this.getB() + "  Link length: " + this.getDistance());
    }
	
	
	
	
}
