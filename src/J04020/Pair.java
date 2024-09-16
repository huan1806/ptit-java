package J04020;

public class Pair<A, B> {
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
