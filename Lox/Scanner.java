package Lox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Lox.TokenType.*;

class Scanner{
  private final String source;
  private final List<Token> tokens = new ArrayList<>();
  private int start = 0; //points to first char in lexeme being scanned
  private int current = 0; //points to the char currently being considered
  private int line = 1;

  Scanner(String source){
    this.source = source;
  }

  List<Token> scanTokens(){
    while(!isAtEnd()){
      // we are at the start of the next lexeme
      start = current;
      scanToken();
    }

    tokens.add(new Token(EOF, "", null, line)); // append an EOF token at the end
    return tokens;
  }

  private boolean isAtEnd(){
    return current >= source.length();
  }
}