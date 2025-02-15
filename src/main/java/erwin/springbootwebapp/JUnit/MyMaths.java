package erwin.springbootwebapp.JUnit;

public class MyMaths {

    public int calcualateSum(int[] numbers){
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
