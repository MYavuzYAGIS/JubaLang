package com.jubalang.juba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Juba {
    public static void main(String[] args) throws IOException{

        private static void runFile(String path) throws IOException{
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            run(new String(bytes, Charset.defaultCharset()));
        }
        // Add Repl 
        private static void runPrompt() throws IOException{
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(input);
            for(;;){
                System.out.print("> ");
                String line = reader.readLine();
                if (line == null) break;
                run(line);
            }
        }
        private static void run(String source){
            Scanner scanner = new Scanner(source);
            List<Token> tokens = scanner.scanTokens();
        
            // scan and print tokens
            for (Token token: tokens){
                System.out.println(token);
            }
        }

        // error checking
        static void error(int line, String message){
            report(line, "", message);
        }
        private static void report(int line, String where, String message){
            System.err.println(
                "[line "+ line +"] Error"+ where + ": " + message);

            hadError=true;
        }

        if (args.length > 1) {
            System.out.println("Usage: juba [script]");
            System.exit(64);
        }else if(args.length==1){
            runFile(args[0]);
        }else{
            runPrompt();
        }
    }
}