package de.mikeashi.brainfucker.interpreter;

import de.mikeashi.brainfucker.ast.AST;
import de.mikeashi.brainfucker.ast.ASTNode;
import de.mikeashi.brainfucker.expression.Expression;
import de.mikeashi.brainfucker.expression.RootExpression;
import de.mikeashi.brainfucker.expression.source.*;
import de.mikeashi.brainfucker.io.printer.Printer;
import de.mikeashi.brainfucker.io.printer.output;
import de.mikeashi.brainfucker.io.reader.Reader;
import de.mikeashi.brainfucker.io.reader.input;

import java.util.ArrayList;
import java.util.List;
/**
 * this class is responsible of providing the memory and executing the programme.
 *
 * @author Mike Ashi
 */
public class Interpreter {
    // printer
    private output printer;
    // reader
    private input reader;
    // memory
    private List<Byte> memory = new ArrayList<>();
    // address pointer
    private int pointer=0;
    // AST
    private AST sourceAST;
    /**
     * Creates a new Interpreter instance.
     * @param ast the programme expressions as AST.
     */
    public Interpreter(final AST ast) {
        newByte();
        printer = new Printer();
        reader = new Reader();
        sourceAST = ast;
    }

    /**
     * Creates a new Interpreter instance.
     * @param printer printer
     * @param reader reader
     * @param sourceAST ast.
     */
    public Interpreter(output printer, input reader, AST sourceAST) {
        newByte();
        this.printer = printer;
        this.reader = reader;
        this.sourceAST = sourceAST;
    }

    /**
     * executes the programme.
     */
    public void execute(){
        read(sourceAST.getRoot());
    }

    /**
     * reads an ASTNode and execute its expressions
     * @param node the ASTNode.
     */
    private void read(ASTNode node){
        for (ASTNode child: node.getChildren()) {
            Expression expression = child.getExpression();
            execute(expression,child);
        }
    }

    /**
     * Executes the given expression
     * @param expression the expression to be executed
     * @param node the ASTNode.
     */
    private void execute(Expression expression,ASTNode node) {
        if(expression instanceof RootExpression){
            return ;
        }else if (expression instanceof IncrementExpression){
            increase();
        }
        else if (expression instanceof DecrementExpression){
            decrease();
        }
        else if (expression instanceof PointerRightExpression){
            moveRight();
        }
        else if (expression instanceof PointerLeftExpression){
            moveLeft();
        }
        else if (expression instanceof OutputExpression){
            output();
        }
        else if (expression instanceof InputExpression){
            getInput();
        }
        else if (expression instanceof LoopExpression){
            executeLoop(node);
        }else {
            throw new IllegalArgumentException("Node with unknown expression type: " + expression);
        }
    }

    /**
     * Executes the given loop.
     * @param node the ASTNode.
     */
    private void executeLoop(ASTNode node) {
        while (memory.get(pointer) != 0){
            read(node);
        }
    }

    /**
     * gets user input.
     */
    private void getInput() {
       memory.set(pointer,reader.read());
    }

    /**
     * prints the current character.
     */
    private void output() {
        printer.print((char) memory.get(pointer).byteValue());
    }

    /**
     * moves the pointer to the left.
     * @throws IllegalStateException if invalid memory address.
     */
    private void moveLeft() {
        this.pointer--;
        if (this.pointer < 0) {
            throw new IllegalStateException("Trying to access an invalid memory address");
        }
    }
    /**
     * moves the pointer to the right.
     */
    private void moveRight() {
        this.pointer++;
        if (this.pointer > memory.size() - 1) {
            newByte();
        }
    }
    /**
     * increases the current byte.
     */
    private void increase() {
        byte b = memory.get(pointer);
        b++;
        this.memory.set(this.pointer, b);
    }
    /**
     * decreases the current byte.
     */
    private void decrease() {
        byte b = memory.get(pointer);
        b--;
        memory.set(pointer, b);
    }

    /**
     * adds a new byte.
     */
    private void newByte() {
        byte b = 0;
        memory.add(b);
    }
}
