

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

