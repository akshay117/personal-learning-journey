import java.util.Arrays;

class SingleDimentionArray{

int[]  arr = null;
//Creation
public SingleDimentionArray(int sizeOfArray){
  arr = new int[sizeOfArray];
  for(int i=0;i<arr.length;i++){
  arr[i] = Integer.MIN_VALUE;
  }
}


//Insertion  
public void insert(int location, int valueToInsert){
try{
  if(arr[location] == Integer.MIN_VALUE ){
    arr[location] = valueToInsert;
    System.out.println("Inserted Succesfully");
  }else {
    System.out.println("The cell is already Occupied");
  }
}catch(ArrayIndexOutOfBoundsException e){
  System.out.println("Invalid Index");
}
}
  //Traversal ||  Read
  public void print(){
    System.out.println(Arrays.toString(arr));
  }
   public void traverseArray(){
    try{
      for(int i = 0; i < arr.length ; i++){
         System.out.print(arr[i] + " ");
      }
       System.out.println("Array traversal done!");
    }catch(Exception e){
      System.out.println("Array No Longer Exist");
    }
  }

//Searching
 public void searchInArray(int itemToSearch){
    for(int i = 0 ; i < arr.length ; i ++){
      if(arr[i] == itemToSearch ){
        System.out.println("Found at Index:" + i);
        return;
      }
      }
System.out.println("Doesnt exist in this array");
    }

//Deletion 
  public void deleteFromArray(int location){
    try{
      arr[location] = Integer.MIN_VALUE;
    }catch(ArrayIndexOutOfBoundsException e){
     System.out.println("Given index is out of range") ;
    }
  }



  
  }



  
  
  
