class LinkedList{
	
	Node head;
	Node tail;
	int size =0;
	
	class Node{
		
		Object data;
		Node next;
		
		public Node(Object data) {
	
			this.data = data;
			this.next = null;
		}
	}
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) {tail = head;}
		
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		
		if(size ==0) {addFirst(input);}
		
		else {
			tail.next = newNode;
			
			tail = newNode;
			
			size++;
			
		}
	}
		
		
	public void addMiddle(int index, Object input) {
		if(index ==0) addFirst(input);
		
		else {
			Node temp1 = getNode(index-1);
			Node temp2 = temp1.next;
			
			Node newNode = new Node(input);
			
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			
			if(newNode.next == null) {
				tail = newNode;
			}
 			
		}
		
	}

	Node getNode(int index) {
		Node x = head;
		for(int i=0; i<index; i++)
			x = x.next;
		
		return x;
		
	}
	
	//TO DO 
	// add remove function
	
	
}
