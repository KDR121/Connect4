package connect4_;

/**
 *../ <-Yeah!めっちゃホリディ
 * @author kodera
 */
public class Game {
    static final int Yoko = 7;
    static final int Tate = 6;
    static final int Nagasa = 4;
    static int[][] Board = new int[Yoko][Tate];
    
    
    public static boolean Game(int PutPlace , boolean isFirst){
        //盤面に置く
        int height = 0;
        boolean Flag1 = true;
        boolean canPut = true;
        int putnumber = isFirst ? 1:2;
        
        if( PutPlace >= Yoko){
            System.out.println("その場所にはおけません,横");
            canPut = false;
        }else{
            while(Flag1){
                if(Board[PutPlace][height] != 0){
                    height += 1;
                    if(height >= Tate){//高さあげてる途中で上限突破した場合
                        System.out.println("その場所にはおけません,縦");
                        canPut = false;
                        return canPut;
                    }
                }else{
                    Flag1 = false;
                }
            }
            Board[PutPlace][height] = putnumber;
        }
        return canPut;
    }
    
    public static boolean EndCheck(){
        /*終了条件チェック*/
        int checkYTN = 0;
        //---縦横斜めチェック
        for(int i = 0; i < Yoko ; i ++){
            for( int j = 0 ; j < Tate ; j++){
                if(Board[i][j] != 0){
                    checkYTN = Board[i][j];
                    int a;
                    //横チェック
                    for(a = 0 ; a < Nagasa ; a++){
                        if( i + a >= Yoko)break;
                        if(checkYTN != Board[i+a][j])break;
                    }
                    if(a == Nagasa){
                        System.out.println("[" + i + "," +  j + "],横がそろいました");
                        return true;
                    }
                    //縦チェック
                    for(a = 0 ; a < Nagasa ; a++){
                        if( j + a >= Tate)break;
                        if( checkYTN != Board[i][j+a])break;
                    }
                    if(a == Nagasa){
                        System.out.println("[" + i + "," +  j + "],縦がそろいました");
                        return true;
                    }
                    //斜めチェック
                    for(a = 0 ; a < Nagasa ; a++ ){
                        if( i + a >= Yoko)break;
                        if( j + a >= Tate )break;
                        if(checkYTN != Board[i+a][j+a])break;
                    }
                     if(a == Nagasa){
                         System.out.println("[" + i + "," +  j + "],斜めがそろいました");
                         return true;
                     }
                }
            }
        }
        //---全部埋まっている
        int tmp = 1;
        for(int i = 0; i <Yoko ; i++){
            tmp *= Board[i][Tate-1];
        }
        if(tmp != 0 ){ 
            System.out.println("すべて埋まりました");
            return true;
        }
        
        return false;
    }
    
    public static void GameReset(){
        /*
            使用する変数を初期化する関数
        */
        for(int i = 0; i < Yoko ; i++){
            for( int j = 0 ; j < Tate ; j++){
                Board[i][j] = 0;
            }
        }
        
    }
    
    public static int[][] BoardRetain(){
        /*
            盤面状況を保持し、それを返す。
            配列の情報は以下の通り
            状態0:空○ 1:先△ 2:後▲
            5□○○○○○○○□
            4□○○○○○○○□
            3□○○○○○○○□
            2□○○○○○○○□
            1□○○○○○○○□
            0□○○○○○○○□
              □□□□□□□□□
                  0 1 2  3 4 5 6 
        */
        return Board;
    }
    
    public static void PrintScreen(){
        for(int i = Tate-1 ; i >= 0 ; i--){
            System.out.print("□");
            for(int j = 0 ; j < Yoko ; j++){
                switch(Board[j][i]){
                    case 0: System.out.print("○");break;
                    case 1: System.out.print("△");break;
                    case 2: System.out.print("▲");break;
                }
            }
            System.out.println("□");
        }
        for(int i = 0; i < Yoko+2 ; i++){
            System.out.print("□");
        }
        System.out.println();
        System.out.println();//なんとなく二行
    }
}
