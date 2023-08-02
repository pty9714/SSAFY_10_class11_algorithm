public class Solution {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int tc = 1; tc <= testCases; tc++) {
            int n = scanner.nextInt();
            String answer;
            
            if (n % 2 == 0) {
                answer = "Alice";
            } else {
                answer = "Bob";
            }
            
            System.out.println("#" + tc + " " + answer);
        }
        
        scanner.close();
    }
}
