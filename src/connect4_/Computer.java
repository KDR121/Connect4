/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author kodera
 */
public class Computer {
    public static int decidesComputerPlace1(boolean IsFirst ) {
        /*
            打つ場所を決めるAI関数:returnは0~6
            IsFirst: true== 先手,false==後手
        */
        Random r = new Random();
        return r.nextInt(7);
    }
    
    public static int decidesComputerPlace2(boolean IsFirst ) {
        /*
            打つ場所を決めるAI関数:returnは0~6
            IsFirst: true== 先手,false==後手
        */
        Random r = new Random();
        return r.nextInt(7);
    }
}
