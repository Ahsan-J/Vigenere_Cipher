/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenerecipher;

/**
 *
 * @author Xcalaiberz
 */
public class VigenereCipher {

    /**
     * @param args the command line arguments
     */
    static char CipherLetters[][];
    public static char [][] initialize(){
        char C [][] = new char[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                C[i][j]=(char) (('A')+(i+j)%26);
            }
        }
        return C;
    }
    public static void main(String[] args) {
        CipherLetters=initialize();
        System.out.println(encrypt("We have a meeting in two minutes","CODEX"));
        String message = encrypt("We have a meeting in two minutes","CODEX");
        System.out.println("");
        System.out.println(decrypt(message,"CODEX"));
    }
    
    
//    public static void display(){
//        for(int i=0;i<26;i++){
//            for(int j=0;j<26;j++){
//                System.out.print(CipherLetters[i][j]);
//            }
//            System.out.println("");
//        }
//    }
    
    public static char getEncryptedChar(char A,char B){
        A = Character.toUpperCase(A);
        B = Character.toUpperCase(B);
        return CipherLetters[(int) (A-'A')][(int) (B-'A')];
    }
    public static char getDecryptedChar(char A,char B){
        A = Character.toUpperCase(A);
        B = Character.toUpperCase(B);
        for(int i=0;i<26;i++){
            if(CipherLetters[i][(int) (B-'A')]==A){
                return (char) ('A'+i);
            }
        }
        return ' ';//Equivalent to Null
    }
    public static String encrypt(String Message,final String Key){
        Message = Message.toUpperCase();
        Message = Message.replaceAll(" ","");
        String Encrypted = new String();
        for(int i=0;i<Message.length();i++){
            Encrypted = Encrypted + getEncryptedChar(Message.charAt(i),Key.charAt(i%Key.length()));
        }
        return Encrypted;
    }
    public static String decrypt(String Message,final String Key){
        Message = Message.toUpperCase();
        Message = Message.replaceAll(" ","");
        String Decrypted = new String();
        for(int i=0;i<Message.length();i++){
            Decrypted = Decrypted + getDecryptedChar(Message.charAt(i),Key.charAt(i%Key.length()));
        }
        return Decrypted;
    }
}
