package algorithmTest;

import java.util.Scanner;

public class Section8_9 {
    static int[] combi;
    static int n,m;

    private void DFS(int L, int s) {
        if(L == m){
            for (int x : combi){
                System.out.println(x+" ");
                System.out.println();
            }
        } else{
            for (int i = s; i <= n; i++) { 
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        Section8_9 T = new Section8_9();
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 4
        m = in.nextInt(); //2
        combi= new int[m];
        T.DFS(0,1);
    }

}
