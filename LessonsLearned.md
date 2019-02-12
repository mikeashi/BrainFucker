# Lessons Learned

This file documents the lessons, that I have learned through out this project.

## Overview

I started working on this project to get a better understanding of the working mechanics of compilers/interpreters.


## Theory
+ how does compilers work.
+ what is a lexer/tokenizer.

## Practice
+ reading files character by character using Intstream.
+ use streams to generate a map to get the value of enums.

## log

### 28.01.2019
+ I have read about lexical analysers and tokenizer.
+ Create the File class which is responsible of reading files and providing their contents to the analysers.
+ Create the Token enum which provides a list of tokens representing BF operations.
+ Create the Lexer class which will get all tokens from source files.

### 09.02.2019
+ Create the SyntaxAnalyzer class which will generate an AST that represent the given tokens.
+ Create the AST class which will represent the Abstract Syntax Tree.
+ Create the ASTNode class which will represent the Abstract Syntax Tree Node.
### 12.02.2019
+ Create the IO interfaces and default IO classes.
