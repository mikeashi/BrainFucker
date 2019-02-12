# BrainFucker
Java Brainfuck Interpreter

### What is BrainFuck?

Brainfuck is a turing-complete minimal programming language. It is designed to be easily implemented by any programming language.
Brainfuck language consist of a simple machine model, a pointer and 8 commands.

More information:
<http://en.wikipedia.org/wiki/Brainfuck>

### What is BrainFucker?
BrainFucker is a Java Brainfuck Interpreter which reads the Brainfuck instructions from a given file than run them through the Lexer, which will turn them into a list of tokens, which will get analysed by the SyntaxAnalyzer and turned into an AST that can be executed by the Interpreter.

## Usage
    brainfucker examples/hello_world.bf

## Examples

check the examples folder which contains a 'Hallo World' example.
