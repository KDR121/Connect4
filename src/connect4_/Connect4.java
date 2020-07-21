/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4_;

/**
 *
 * @author kodera
 */
public class Connect4 {
    
    static boolean isEnd = false;//false:終了条件を満たしていない true:満たした
    static boolean isFirstPlayer = true;//true:先手よ false:後手よ
    static boolean canPut = true;//true:置けました！ false:置けませんでした。。。
    
    public static void main(String[] args) {
        int PutPlace  = 0;
        Game.GameReset();
        while(!isEnd){
            if(isFirstPlayer){
                PutPlace = Computer.decidesComputerPlace1(isFirstPlayer);
            }else{
                PutPlace = Computer.decidesComputerPlace2(isFirstPlayer);
            }
            canPut = Game.Game(PutPlace , isFirstPlayer);//game開始
            if(canPut){
                Game.PrintScreen();
                isFirstPlayer = isFirstPlayer ? false : true;
            }
            isEnd = Game.EndCheck();
            
        }
        if(!isFirstPlayer){
            System.out.println("Player1の勝利");
        }else{
            System.out.println("Player2の勝利");
        }
    }
    
}
