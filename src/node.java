
public class node {

	public int a;
	
	
	public int sayac;
	public int x;
	public int y;
	
	
	public node() {
		
		
		
	}

	public node(int a, int sayac,int x, int y) {
		this.a = a;
		this.sayac = sayac;
		this.x = x;
		this.y = y;
	
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public node( int sayac) {
		this.sayac = sayac;
	
	}
	
	
	public int getSayac() {
		return sayac;
	}

	public void setSayac(int sayac) {
		this.sayac = sayac;
	}

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


	
	
	
	
	
	
}
