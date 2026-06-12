class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> points = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) { // add two previous
                int temp = points.pop();
                int newScore = temp + points.peek();
                points.push(temp);
                points.push(newScore);
            } else if (op.equals("D")) { // double the previous score
                points.push(points.peek() * 2);
                System.out.println("new score " + points.peek());
            } else if (op.equals("C")) { // invalidate the previous score
                points.pop();
            } else
                points.push(Integer.parseInt(op));
        }

        int total = 0;
        for(int score : points) {
            total+= score;
        }
        return total;
    }
}