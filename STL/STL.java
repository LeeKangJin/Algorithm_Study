package ExpertB;

public class STL {

	
	
	
}

class Set{}//중복 불가 , 순서 없음

class List{}//중복 불가, 순서 있음, 속도 느림

class Hash{}// Key - Value 


class Queue{}

class Stack{}

class Tree{}

class BinaryTree{}

class Grape{
	int[][] grape;
	
	
	
	
	public Grape(int edgeNumber) {
		this.grape = new int[edgeNumber][edgeNumber];
		
	}




	public void add(int a, int b) {
		grape[a][b] = 1;
		grape[b][a] = 1;
		
	}
	
	
	
}


class LinkedList{
	
}
