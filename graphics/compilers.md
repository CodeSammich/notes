# Compilers

source code -> compiler -> machine code

compiler --->
  -> lexer: intercepts source code
    -> performs lexica analysis   (lex being "dictionary")
	-> knows all valid tokens in the language
	-> generates a list of tokens
	int main() {                   int
		long x = 5 + 6;            IDENT main
		printf("hi");      ----->  (
		return x;                  )
	}                              {
	                               long
								   IDENT x
								   =
								   5
								   ...
  -> to parser 
    -> performs syntax analysis
	-> knows grammar of language
	-> generates a syntax tree (order to do things)
		       |
		      main
		   =                 printf          return
     long x   t               "hi"             x
		    5    6
	
  -> to semantic analyzer
    -> knows how to identify variables and values
	-> knows what tokens map to computer operations
	-> generates
	  -> symbol table
	  -> list of operations in performance order
	    -> knows how to traverse that tree
   	Symbol Table
		| main F int |
		| x     long |
		| printf F int|
	Operations List
		| +:  5, 6 |
		| =: x |
		| printf ... |
		| return: x |
  -> to optimizer
	-> makes your code more efficient (if more efficient way exists): optional
  -> to code generator	
    -> knows what operations map to what processor instructions
	-> generates program machine code
----> to machine code

### lex / flex (free lex)

program that makes lexers
- if you give lexer a file that defines the tokens in your language

### yacc (yet another compiler compiler) / bison

combines both parser and semantic analyser

### code generator

