package AlgorithmAnalysis.sec41;

public class ExperimentalAnalysis {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        String ans = repeat1('*',50000);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("method1 - "+elapsed);


        long startTime1 = System.currentTimeMillis();
        String ans2 = repeat2('*',6400000);
        long endTime1 = System.currentTimeMillis();
        long elapsed2 = endTime1 - startTime1;
        System.out.println("method2 - "+elapsed2);
    }
    private static String repeat1(char c, int n){
        String answer = "";
        for (int j=0;j<n;j++){
            answer+=c;
        }
        return answer;
    }

    private static String repeat2(char c, int n){
        StringBuilder sb = new StringBuilder();
        for (int j=0;j<n;j++){
            sb.append(c);
        }
        return sb.toString();
    }
}
