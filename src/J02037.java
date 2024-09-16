import java.util.Scanner;

public class J02037 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String[] nums = sc.nextLine().trim().split("\\s+");
                int total = nums.length;
                int evenCount = 0;
                for (String num : nums) {
                    int lastDigit = num.charAt(num.length() - 1) - '0';
                    if (lastDigit % 2 == 0) {
                        evenCount++;
                    }
                }
                if ((total % 2 == 0 && evenCount > total - evenCount)
                        || (total % 2 == 1 && evenCount < total - evenCount)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
