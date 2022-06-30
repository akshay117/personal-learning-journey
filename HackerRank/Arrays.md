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
