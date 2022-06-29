

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
