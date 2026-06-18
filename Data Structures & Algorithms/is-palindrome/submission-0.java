class Solution {
    public boolean isPalindrome(String s) {
        int right = s.length() - 1;
        int left = 0;

        while (left <= right) {
            Character currRight = Character.toLowerCase(s.charAt(right));
            Character currLeft = Character.toLowerCase(s.charAt(left));

            if(!Character.isLetterOrDigit(currRight)) {
                right--;
                continue;
            }
            if(!Character.isLetterOrDigit(currLeft)) {
                left++;
                continue;
            }

            if (!currRight.equals(currLeft)) {
                return false;
            }

            right--;
            left++;
        }
        return true;
    }
}
