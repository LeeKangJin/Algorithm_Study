
// struct -> int x, int y 
// x순 내림차순 정렬, x가 같을 때 y순 내림차순 정렬 Comparator


class order implements Comparator<struct>{

  public int compare(struct a, struct b){
  
    int firstXValue = a.x;
    int secodXvalue = b.x;
    
    int firstYValue = a.y;
    int secondYValue = b.y;
    
    if(firstXValue < secondXValue){
      return -1;
    }
    else if(firstXValue > secondXValue){
      return 1;
    }
    else{
    
      if(firstYValue < secondYValue) return -1;
      else if(firstYValue > secondYValue ) return 1;
      else return 0;
    
    
    }
  
  }


}
