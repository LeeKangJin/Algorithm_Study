class ArrayList{
	
	int size =0;
	int capacity = 8;
	Object[] element = new Object[capacity];
	
	public void add(Object ele) {
		
		if(size <=capacity)
			element[size++] = ele;
		
		else {
			
			Object[] temp = new Object[capacity*2];
			
			for(int i=0; i<capacity; i++) {
				temp[i] = element[i];
			}
			element = temp;
			
			capacity *=2;
			
			
		}	
		
	}
	
	public Object get(int index) {
		return element[index];
	}
	
	public void remove(int index) {
		for(int i=index; i<size+1; i++) {
			element[i] = element[i+1];
			
		}
		size--;
	}
	
  //TO DO
  //add anoter function
  
}
