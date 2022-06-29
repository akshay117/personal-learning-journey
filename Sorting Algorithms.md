# Sorting Algorithms [I B S H M Q R]

## Insertion Sort

 Time Complexity : O (N ^2) Worst case when element are sorted in reverse order.
 
 Space Complexity : O (1)
 
 Stable Algorithm
 
 ```
 To sort an array of size N in ascending order do these following steps:
 1 Iterate over the array from arr[1] to arr [n].
 2 Compare the current element (key) with its preceeding element.
 3 If the key element is smaller than its preceeding elements , compare it to the elements before.
 4 Move the greater elements one position up to make space for the swapped element.
  
 ```

```java

static void insertionSort( int[] arr ){
 int n = arr.length;
 
 for(int i = 1; i < n; i++)
  int key = arr[i]; 
  int j = i-1;
  /*
  move elements of array that are greater than key to one position ahead of thier current position
  */
  while( j>=0 && arr[j] > key ){  
  arr[j+1] = arr[j];
  j = j-1;
   }
  arr[j+1] = key;  //This line inserts the element at correct position
}

```


## Bubble Sort

Time Complexity : O (N ^2) 
 
 Space Complexity : O (1)
 
Stable Algorithm ,Iterative Sorting
 
 ```
 It cycles through the data structure and for each cycle compares the current element with the next element, 
 Swapping them if necessary.Bubble Sort is an iterative sorting algorithm that imitates the movement of bubbles in sparkling water.
 The bubbles represents the elements of the data structure.The bigger bubbles reach the top faster than smaller bubbles,
 and this algorithm works in the same way.It iterates through the data structure and for each cycle compares the current element with the next one,
 swapping them if they are in the wrong order.
 It's a simple algorithm to implement, but not much efficient: 
 on average, quadratic sorting algorithms with the same time complexity such as
 Selection Sort or Insertion Sort perform better.
 
 ```
 
 ```java
 void bubbleSort( int[] arr ){
 int temp = 0;
 int n = arr.length; 
 for(int i = 0 ; i < n; i++){
  for(int j= 1 ; j < n-1 ; j++) {
    if( arr[j-1] > arr [j] ){
     temp = arr[j-1];
     arr[j-1] = arr[j];
     arr[j] = temp;
    }
   }
  }
 }
 
 ```

## Selection Sort

Time Complexity : O (N ^2) 
 
Space Complexity : O (1)

```
Initialize minimum value(min_idx) to location 0
Traverse the array to find the minimum element in the array
While traversing if any element smaller than min_idx is found then swap both the values.
Then, increment min_idx to point to next element
Repeat until array is sorted
```

```java

void selectionSort(int arr[])
{
    int n = arr.length;
    for (int i = 0; i < n-1; i++)
    {
        int min_idx = i;
        for (int j = i+1; j < n; j++)
            if (arr[j] < arr[min_idx])
                min_idx = j;
        int temp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = temp;
    }
}
```

## Heap Sort
 
## Merge Sort

## Quick Sort

## Radix Sort / Bucket Sort
