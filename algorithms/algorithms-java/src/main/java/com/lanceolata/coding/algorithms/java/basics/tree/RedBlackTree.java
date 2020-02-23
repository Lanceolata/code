package com.lanceolata.coding.algorithms.java.basics.tree;

public class RedBlackTree<T extends Comparable<T>> {

    private Node<T> root;    // 根结点

    /**
     * The number of entries in the tree
     */
    private transient int size = 0;

    public Node<T> search(T key) {
        if (key == null)
            throw new NullPointerException();
        Node<T> p = root;
        while (p != null) {
            int cmp = key.compareTo(p.key);
            if (cmp < 0)
                p = p.left;
            else if (cmp > 0)
                p = p.right;
            else
                return p;
        }
        return null;
    }

    public boolean insert(T key) {
        if (key == null) {
            throw new NullPointerException();
        }
        Node<T> t = root;
        if (t == null) {
            root = new Node<>(key, null);
            size++;
            return true;
        }
        int cmp;
        Node<T> parent;
        do {
            parent = t;
            cmp = key.compareTo(t.key);
            if (cmp < 0)
                t = t.left;
            else if (cmp > 0)
                t = t.right;
            else
                return false;
        } while (t != null);

        Node<T> node = new Node<>(key, parent);
        if (cmp < 0)
            parent.left = node;
        else
            parent.right = node;
        fixAfterInsertion(node);
        size++;
        return true;
    }

    /** From CLR */
    private void fixAfterInsertion(Node<T> x) {
        x.color = RED;

        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                // parentOf(x) 是左侧节点
                // 获得parent同层的右侧节点
                Node<T> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    // 左右都为红色，则都设置为黑色，父父节点设置为黑色
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    // 旋转为左侧连续红色
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    // 右旋转
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                // parentOf(x) 是右侧节点
                // 获得parent同层的左侧节点
                Node<T> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    // 旋转为右侧连续红色
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    // 左旋转
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }

    public T remove(T key) {
        Node<T> p = search(key);
        if (p == null)
            return null;

        T oldValue = p.key;
        remove(p);
        return oldValue;
    }

    private void remove(Node<T> p) {
        size--;

        // 若删除结点有两个子结点，用后继结点（大于删除结点的最小结点）替换删除结点
        if (p.left != null && p.right != null) {
            Node<T> s = successor(p);
            p.key = s.key;
            p = s;
        }

        // 若删除结点只有一个子结点，用子结点替换删除结点
        Node<T> replacement = (p.left != null ? p.left : p.right);

        if (replacement != null) {
            // Link replacement to parent
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left  = replacement;
            else
                p.parent.right = replacement;

            // Null out links so they are OK to use by fixAfterDeletion.
            p.left = p.right = p.parent = null;

            // Fix replacement
            if (p.color == BLACK)
                fixAfterRemove(replacement);
        } else if (p.parent == null) { // return if we are the only node.
            // 只有一个根节点
            root = null;
        } else { //  No children. Use self as phantom replacement and unlink.
            // 无子节点
            // 当前节点为黑色
            if (p.color == BLACK)
                fixAfterRemove(p);

            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }
    }

    /** From CLR */
    private void fixAfterRemove(Node<T> x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                Node<T> sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib))  == BLACK &&
                        colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else { // symmetric
                Node<T> sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK &&
                        colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, BLACK);
    }

    static <T extends Comparable<T>> Node<T> successor(Node<T> t) {
        if (t == null)
            return null;
        else if (t.right != null) {
            Node<T> p = t.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            Node<T> p = t.parent;
            Node<T> ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    private static <T extends Comparable<T>> boolean colorOf(Node<T> p) {
        return (p == null ? BLACK : p.color);
    }

    private static <T extends Comparable<T>> Node<T> parentOf(Node<T> p) {
        return (p == null ? null: p.parent);
    }

    private static <T extends Comparable<T>> void setColor(Node<T> p, boolean c) {
        if (p != null)
            p.color = c;
    }

    private static <T extends Comparable<T>> Node<T> leftOf(Node<T> p) {
        return (p == null) ? null: p.left;
    }

    private static <T extends Comparable<T>> Node<T> rightOf(Node<T> p) {
        return (p == null) ? null: p.right;
    }

    /** From CLR */
    private void rotateLeft(Node<T> p) {
        if (p != null) {
            Node<T> r = p.right;
            p.right = r.left;
            if (r.left != null)
                r.left.parent = p;
            r.parent = p.parent;
            if (p.parent == null)
                root = r;
            else if (p.parent.left == p)
                p.parent.left = r;
            else
                p.parent.right = r;
            r.left = p;
            p.parent = r;
        }
    }

    /** From CLR */
    private void rotateRight(Node<T> p) {
        if (p != null) {
            Node<T> l = p.left;
            p.left = l.right;
            if (l.right != null) l.right.parent = p;
            l.parent = p.parent;
            if (p.parent == null)
                root = l;
            else if (p.parent.right == p)
                p.parent.right = l;
            else
                p.parent.left = l;
            l.right = p;
            p.parent = l;
        }
    }

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    /**
     * Node in the Tree.
     */
    static final class Node<T extends Comparable<T>> {
        T key;
        RedBlackTree.Node<T> left;
        RedBlackTree.Node<T> right;
        RedBlackTree.Node<T> parent;
        boolean color = BLACK;

        /**
         * Make a new cell with given key, value, and parent, and with
         * {@code null} child links, and BLACK color.
         */
        Node(T key, RedBlackTree.Node<T> parent) {
            this.key = key;
            this.parent = parent;
        }

        /**
         * Returns the value associated with the key.
         *
         * @return the value associated with the key
         */
        public T getKey() {
            return key;
        }

        /**
         * Replaces the value currently associated with the key with the given
         * value.
         *
         * @return the value associated with the key before this method was
         *         called
         */
        public T setKey(T key) {
            T oldValue = this.key;
            this.key = key;
            return oldValue;
        }
    }
}
