import java.util.ArrayList;

public class linkedCity {
	
	private int startIndex;
	private int endIndex;
	private int linkLength;
	private ArrayList<Integer> indexList = new ArrayList<Integer>();

	public linkedCity() {
		
	}
	
	public linkedCity(int startIndex, int removedIndex, int endIndex, int linkLength) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.indexList.add(startIndex);
		this.indexList.add(removedIndex);
		this.indexList.add(endIndex);
		this.linkLength = linkLength;
		
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getLinkLength() {
		return linkLength;
	}

	public void setLinkLength(int linkLength) {
		this.linkLength = linkLength;
	}
	
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
	
	public void printLink() {
		System.out.println("Start index: " + this.startIndex + " Included indexes: " + this.indexList.toString() + "  End index: " + this.endIndex + "  Link length: " + this.linkLength);
	}
	
	
}
