public class KMP{
    public int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        for(int i = 1; i < pattern.length(); i++) {
            int index = next[i - 1];
            while(index >= 0 && pattern.charAt(index + 1) != pattern.charAt(i)) {
                index = next[index];
            }
            if(pattern.charAt(i) == pattern.charAt(index + 1)) {
                next[i] = index + 1;
            } else {
                next[i] = -1;
            }
        }
        return next;
    }

    public int kmpMatch(String target, String pattern) {
        int[] next = getNext(pattern);
        int targetIdx = 0, patternIdx = 0;
        while(targetIdx < target.length() && patternIdx < pattern.length()){
            if(target.charAt(targetIdx) == pattern.charAt(patternIdx)){
                targetIdx++;
                patternIdx++;
            } else if(patternIdx == 0) {
                targetIdx++;
            } else {
                patternIdx = next[patternIdx - 1] + 1;
            }
            System.out.println("match");
        }
        if(patternIdx == pattern.length()) {
            return targetIdx - patternIdx;
        } else {
            return -1;
        }
    }
    public static void main(String[] args){ 
        KMP kmp = new KMP();
        String pattern = "aab";
        String target = "bbaa";
        System.out.println(kmp.kmpMatch(target, pattern));
    }

}
