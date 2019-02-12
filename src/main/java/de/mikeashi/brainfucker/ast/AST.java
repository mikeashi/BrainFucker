package de.mikeashi.brainfucker.ast;

import java.util.stream.Stream;
/**
 * this class represents the Abstract Syntax Tree .
 *
 * @author Mike Ashi
 */
public class AST {
    // tree root
    private final ASTNode root;

    /**
     * Creates a new AST instance.
     * @param root the ASTNode which will represent the tree root.
     */
    public AST(final ASTNode root) {
        this.root = root;
    }

    /**
     * @return the tree root
     */
    public ASTNode getRoot() {
        return root;
    }
}
