package Recursion;

public class Rough {
    public static void main(String[] args) {
        drawRuler(1,4);
    }

    private static void drawRuler(int numInches, int maxLength){
        drawLine(maxLength,0);
        for (int i=1;i<=numInches;i++){
            drawInterval(maxLength-1);
            drawLine(maxLength,i);
        }
    }

    private static void drawInterval(int centralLine){
        if (centralLine >= 1){
            drawInterval(centralLine-1);
            drawLine(centralLine);
            drawInterval(centralLine-1);
        }
    }

    private static void drawLine(int maxLength,int tickLabel){
        for (int i=0;i<maxLength;i++){
            System.out.print("-");
        }
        if (tickLabel >= 0){
            System.out.print(" "+tickLabel);
        }
        System.out.print("\n");
    }

    private static void drawLine(int tickLength){
        drawLine(tickLength,-1);
    }
}
