package com.jubalang.juba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import tokenTypes
import static com.jubalang.juba.TokenType.*;

// create scanner for Juba Lang
class Scanner{
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start=0;
    private int current =0;
    private int line =1;
    
    Scanner(String source) {
        this.source=source;
    }
    List<Token> scanTokens(){
        while(!isAtEnd()){
            start = current;
            scanToken()
        }
        tokens.add(new Token(EOF," ",null,line));
        return tokens;
    }
}

