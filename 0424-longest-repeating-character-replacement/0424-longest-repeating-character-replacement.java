class Solution {
    public int characterReplacement(String s, int k) {
       int[] count = new int[26]; // frequency of characters
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            count[ch - 'A']++;

            // track max frequency
            maxFreq = Math.max(maxFreq, count[ch - 'A']);

            // if more replacements needed than k → shrink window
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; 
        
    }
}