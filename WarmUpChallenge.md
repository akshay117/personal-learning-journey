

# WarmUp Challenge 

## Sales By Match

https://www.hackerrank.com/interview/interview-preparation-kit/warmup/challenges

```java
public static int sockMerchant(int n, List<Integer> ar) {
       Set<Integer> set = new  HashSet<>();
       int count = 0;
       for(int a : ar){
           if(!set.contains(a)){
                set.add(a);
           }else {
               count++;
               set.remove(a);
           }
        }  
     return count;
    }
```
## Repeated String
https://www.hackerrank.com/challenges/repeated-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

```java
 public static long repeatedString(String s, long n) {
    
     char[] string= s.toCharArray();
        int slength= s.length();
        long repeat=n/slength;
        long rem=n%slength;
        long count=0;
        for(int i=0;i<slength;i++)
        {
            if(string[i]=='a')
            count++;
        }
        count*=repeat;
        for(int i=0;i<rem;i++)
        {
            if(string[i]=='a')
            count++;
        }       
        return count;
    }
}
```


## Jumbing on the clouds
https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup


```java
   public static int jumpingOnClouds(List<Integer> c) {
    
      int count = -1;
            for (int i = 0; i < c.size(); i++, count++) {
            if (i + 2 < c.size() && c.get(i+2) == 0) i++;
        }
        return count;
}
```


## Counting Valleys

https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

```java
 public static int countingValleys(int steps, String path) {
      int sum = 0;
      int count = 0;
      char[] ch = path.toCharArray();
    for(int i=0;i<steps;i++){
    if(ch[i]=='U'){
      if(++sum==0)
        count++;
    }
    else sum--;
  }
  return count;
}
```
#  2D Array
https://www.hackerrank.com/challenges/2d-array/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

```java

    public static int hourglassSum(List<List<Integer>> arr) {
    
     int maxSum = -64; //Because the minimum it could be is -9*7 = -63
        int startCol = 0;
        
        //Each iteration of the outer loop is one hour glass:
        for (int row = 0; row <= 3; row++){
            int sum = 0; //Initialize this specific hourglass' sum
            for (int col = startCol; col < startCol + 3; col ++) {
                sum += arr.get(row).get(col); //Gets current index that col and row are on
                if (col == startCol) { //Only doing it if it's on the startCol ensures we only add middle piece once
                    sum += arr.get(row+1).get(startCol+1);
                }
                sum += arr.get(row+2).get(col); //Gets the corresponding index in the bottom row
            }
            startCol = (startCol < 3) ? startCol + 1 : 0; // If there is space for another hourglass in this row, goto                                                               // the next Col
            if (startCol != 0) { //If there is space for another hourglass in this row, continue in the same row
                row--;             //You need to decrement in order to do this bc for loop will increment
            }
            if (sum > maxSum) {
                maxSum = sum;
            } //keeps track of what the maximum sum is so we can print it at the end
        }
        
         return maxSum; 
         
    }
```
