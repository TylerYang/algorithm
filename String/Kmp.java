public class Kmp{
    private int[] preProcessPattern(String pattern){
        int i = 0, j = -1;
        int[] next = new int[pattern.length() + 1]; 
        next[i] = j;
        while(i < pattern.length()){
            if(j == -1 || pattern.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        
        return next;
    }
    
    public int KMPSearch(String pattern, String txt){
        int i = 0, j = 0;
        int[] next = preProcessPattern(pattern);
        while(i < txt.length() && j < pattern.length()){
            if(j == -1 ||  txt.charAt(i) == pattern.charAt(j)){
                i++;
                j++; 
            } else {
                j = next[j];            
            }
        }
        if(j == pattern.length()){
            return i - j;
        } else {
            return -1;
        } 
    }
    public void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args){
        Kmp k = new Kmp();
        String txt = "ABCD ASDFASFABCDABCASVZX";
        String pattern = "ABCDABC";
       
        System.out.println("Here is KMP matche result:");
        System.out.println(k.KMPSearch(pattern, txt));
        
    }
} 
