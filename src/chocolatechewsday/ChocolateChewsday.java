/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chocolatechewsday;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ChocolateChewsday {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for(int c = 0; c < 10; c++){
            Scanner reader = new Scanner(System.in);
            int n = reader.nextInt();
            reader.nextLine();
            String nameList[] = new String [n];
            int ScoreE[][] = new int [n][3];
            
            String name = reader.nextLine();
            reader.nextLine();
            for(int t = 0; t <n ; t++){
                if(name.equals("*"))break;
                nameList[t] = name;
                boolean ct = true;
                while(ct == true){
                    String Lines = reader.nextLine();
                    reader.nextLine();
                    if(!Lines.equals("*") && Lines.substring(0,2).equals("J ")){
                        String[] Scores=Lines.split(" ");
                        ScoreE[t][0] += Integer.parseInt(Scores[1]);
                        ScoreE[t][1] += Integer.parseInt(Scores[2]);
                        ScoreE[t][2] += Integer.parseInt(Scores[3]);
                    }else{
                        name = Lines;
                        ct = false;
                    }
                }
            }
            
            int TScore[] = new int [n];
            int large =0;
            int lanum = 0;
            int La[] = new int [n];
            int a = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < 3; j++){
                    TScore[i] += ScoreE[i][j];
                }
            }
            
            for(int i = 0; i < n; i++){
                if(TScore[i]> large){
                    large = TScore[i];
                    lanum = i;
                    La[0] = lanum;
                }
                if(TScore[i]==large){
                    if(ScoreE[i][2] > ScoreE[lanum][2]){
                        large = TScore[i];
                        lanum = i;
                        La[0] = lanum;
                    }
                    if(ScoreE[i][2] == ScoreE[lanum][2]){
                        if(ScoreE[i][1] > ScoreE[lanum][1]){
                            large = TScore[i];
                            lanum = i;
                            La[0] = lanum;
                        }
                        if(ScoreE[i][1] == ScoreE[lanum][1]){
                            if(ScoreE[i][0] > ScoreE[lanum][0]){
                                large = TScore[i];
                                lanum = i;
                                La[0] = lanum;
                            }
                           
                        }
                    }
                }
            }
            System.out.println(nameList[lanum]);
            
        }
    }
    
}
