import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class J07017 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public boolean isPrime(){
        if (isNotAnInstanceOfInteger(first) || isNotAnInstanceOfInteger(second)) {
            return false;
        }
        int firstNumber = (Integer) first;
        int secondNumber = (Integer) second;
        return isPrimeNumber(firstNumber) && isPrimeNumber(secondNumber);
    }

    private boolean isNotAnInstanceOfInteger(Object object) {
        return !(object instanceof Integer);
    }

    private boolean isPrimeNumber(int number){
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return first + " " + second;
    }
}
