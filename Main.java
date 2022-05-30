package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static String path = "D:/zz_omms1/Documentos/NetBeansProjects/jflex_01/src/main/Lexer.flex";
    public static void main(String[] args) throws IOException {
//        generateLexer(path);
        test();
    }
    
    public static void generateLexer(String path) {
        File file = new File(path);
        JFlex.Main.generate(file);
    }
    
    public static void test() throws IOException {
        String testPath = "D:/zz_omms1/Documentos/NetBeansProjects/jflex_01/src/main/test.txt";
        try {
            Reader rd = new BufferedReader(new FileReader(testPath));
            Lexer lx = new Lexer(rd);
            String output = "";
            while (true) {
                Tokens tokens = lx.yylex();
                if (tokens == null) {
                    output += "END";
                    System.out.println(output);
                    return;
                }
                switch(tokens){
                    case ERROR:
                        output += "Undefined symbol\n";
                        break;
                    case Identificador:
                        output += "ID: " + lx.lexeme + "\n";
                        break;
                    case Reservada:
                        output += "PC: " + lx.lexeme + "\n";
                        break;
                    default:
                        output += "Token: " + tokens + "\n";
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
