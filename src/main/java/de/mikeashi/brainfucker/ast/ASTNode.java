package de.mikeashi.brainfucker.ast;

import de.mikeashi.brainfucker.expression.Expression;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * this class represents an Abstract Syntax Tree Node.
 *
 * @author Mike Ashi
 */
public class ASTNode {
    // parent node
    private ASTNode parent;
    private final List<ASTNode> children = new LinkedList<>();
    private final Expression expression;

    /**
     * Creates a new ASTNode instance.
     * @param expression the expression to be stored.
     */
    public ASTNode(Expression expression) {
        this.expression = expression;
    }

    /**
     * @return the stored expression.
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Add child to the node.
     * @param node the node to be added as child.
     */
    public void addChild(ASTNode node) {
        children.add(node);
        node.parent = this;
    }

    /**
     * @return The Node's Parent.
     */
    public ASTNode getParent() {
        return parent;
    }

    /**
     * @return The Node's children.
     */
    public List<ASTNode> getChildren() {
        return children;
    }

}
