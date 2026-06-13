class Solution {

    /**
    * Intuition: we don't need to simulate the queue with one of our own.
    *   - If there is a sanwhich that at least one student will take, that student will
    *     eventually get to the front of the queue and take that sandwich.
    *   - if we track how many of each student that want each sandwich, we can check this easily.
    *
    *   1. Count the number of students who prefer each sandwsandwichich type (here, 0 for circular or 1 for square)
    *   2. Check the sandwhiches in order:
    *       - If at least one student wants the current sandwich, decrement the student count and total sandwhiches remaining by 1.
    *       - If no student wants it, stop immediately since no other student would be able to get a sandwich at that point.
    *   3. Return the remaining count.
    */
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int result = n;
        int[] count = new int[2]; // idx 0 for circular sandwich, 1 for square
        
        // track how many students want each type of sandwich in count[]
        for (int i = 0; i < n; i++) {
            count[students[i]]++;
        }

        // If at least one student wants the current sandwich type, decrement the amount of sanwiches of that type and move on
        // if we ever see a sandwhich type that no student wants, we know we cannot feed any more students.
        for (int i = 0; i < n; i++) {
            if(count[sandwiches[i]] > 0) {
                result--;
                count[sandwiches[i]]--;
            } else {
                break;
            }
        }

        return result;
    }
}