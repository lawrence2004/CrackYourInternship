package CrackYourInternship.Day5;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int score = 0;
        for(int i = 0;i<k;i++) score += cardPoints[i];
        int last = n - 1;
        int tempScore = score;
        for(int i = k - 1;i>=0;i--) {
            tempScore -= cardPoints[i];
            tempScore += cardPoints[last--];
            score = Math.max(score, tempScore); 
        }
        return score;
    }
}
