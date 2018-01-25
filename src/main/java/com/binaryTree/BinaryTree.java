package com.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数据结构
 * 二叉树的java实现
 */
public class BinaryTree {
    private TreeNode rootNode;//根节点

    //Tree的内部类用于存储构建树的基本结构
    class TreeNode<T> {
        private T value;//数据存放的地方
        private TreeNode leftNode;//树的左节点
        private TreeNode rightNode;//树的右节点

        public TreeNode(T data) {
            this(data, null, null);
        }

        public TreeNode(T data, TreeNode leftNode, TreeNode rightNode) {
            this.value = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
    }

    /**
     * 创建二叉树结构
     * A
     * B     C
     * D    E      F
     */
    public void createTree() {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        //分配各个各个地址
        nodeA.setLeftNode(nodeB);
        nodeA.setRightNode(nodeC);
        nodeB.setLeftNode(nodeD);
        nodeB.setRightNode(nodeE);
        nodeC.setRightNode(nodeF);
        rootNode = nodeA;//负值
    }

    /**
     * 前序遍历创建二叉树
     * ABD##E##C#F##
     *
     * @param list
     */
    public void createTree(List list) {
        createTree(list.size(), list);
    }

    public TreeNode createTree(int size, List data) {
        if (data.isEmpty()) {
            return null;
        }
        String value = (String) data.get(0);
        if ("#".equals(value)) {
            data.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(value);
        if (rootNode == null) {
            rootNode = node;
        }
        data.remove(0);
        node.leftNode = createTree(size, data);
        node.rightNode = createTree(size, data);
        return node;
    }

    /**
     * 前序遍历--根左右
     *
     * @param node
     */
    public void prefixIterator(TreeNode node) {
        if (node == null) {
            return;
        } else {
            System.out.println("数据：" + node.getValue());
            if (node.leftNode != null) {
                prefixIterator(node.leftNode);
            }
            if (node.rightNode != null) {
                prefixIterator(node.rightNode);
            }
        }
    }

    /**
     * 中序遍历--左根右
     *
     * @param node
     */
    public void minInterator(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeftNode() != null) {
            minInterator(node.leftNode);
        }
        System.out.println("数据：" + node.getValue());
        if (node.getRightNode() != null) {
            minInterator(node.rightNode);
        }
    }

    /**
     * 后续遍历--左右根
     *
     * @param node
     */
    public void suffixIterator(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.leftNode != null) {
            suffixIterator(node.leftNode);
        }
        if (node.rightNode != null) {
            suffixIterator(node.rightNode);
        }
        System.out.println("数据：" + node.getValue());
    }

    /**
     * 不使用递归来遍历树
     *
     * @param node
     */
    public void prefixIteratorOther(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack stack = new Stack();
        stack.push(node);
        while (!stack.empty()) {
            TreeNode obj = (TreeNode) stack.pop();
            System.out.println("栈数据：" + obj.getValue());
            if (obj.rightNode != null) {
                stack.push(obj.rightNode);
            }
            if (obj.leftNode != null) {
                stack.push(obj.leftNode);
            }
        }
    }

    /**
     * stack来
     * 此迭代破坏了原数据的树结构
     * 因此在遍历的时候要求克隆一次，不要污染了元数据
     * 原理就是破坏其左右的指针
     */
    public void minIteratorOther() {
        if (rootNode == null) {
            return;
        }
        Stack stack = new Stack();
        stack.push(rootNode);
        while (!stack.empty()) {
            TreeNode node = (TreeNode) stack.peek();
            if (node.leftNode == null) {
                TreeNode pop = (TreeNode) stack.pop();//弹出去
                System.out.println("数据栈：" + pop.getValue());
            } else {
                stack.push(node.leftNode);
                node.leftNode = null;
                continue;
            }
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
        }
    }

    /**
     * 此迭代破坏了原数据的树结构
     * 因此在遍历的时候要求克隆一次，不要污染了元数据
     * 原理就是破坏其左右的指针
     */
    public void suffixIteratorOther() {
        if (rootNode == null) {
            return;
        }
        Stack stack = new Stack();
        stack.push(rootNode);
        while (!stack.empty()) {
            TreeNode node = (TreeNode) stack.peek();
            if (node.rightNode == null && node.leftNode == null) {
                TreeNode val = (TreeNode) stack.pop();
                System.out.println("stack:" + val.getValue());
            }
            if (node.rightNode != null) {
                stack.push(node.rightNode);
                node.rightNode = null;
            }
            if (node.leftNode != null) {
                stack.push(node.leftNode);
                node.leftNode = null;
            }
        }
    }

    /**
     * 赫夫曼树的添加
     * @param data
     */
    public void put(int data) {
        if (rootNode == null) {
            rootNode = new TreeNode(data);
            return;
        }
        TreeNode node = rootNode;
        while (true) {
            TreeNode value = new TreeNode(data);
            if (data < (int) (node.getValue())) {
                if (node.leftNode == null) {
                    node.leftNode = value;
                    return;
                } else {
                    TreeNode current = node.leftNode;
                    node = current;
                }
            } else if (data > (int) (node.getValue())) {
                if (node.rightNode == null) {
                    node.rightNode = value;
                    return;
                } else {
                    TreeNode current = node.rightNode;
                    node = current;
                }
            }
        }
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        String[] value = {"A", "B", "D", "#", "#", "E", "#", "#", "C", "#", "F", "#", "#"};
//        for (String val : value) {
//            list.add(val);
//        }
        int[] value = {50, 30, 15, 45, 60, 55, 70};
        BinaryTree binaryTree = new BinaryTree();
        for (int val : value) {
            binaryTree.put(val);
        }
        //binaryTree.createTree(list);
        //binaryTree.createTree();
        //binaryTree.prefixIterator(binaryTree.rootNode);
        binaryTree.minInterator(binaryTree.rootNode);
        //binaryTree.suffixIterator(binaryTree.rootNode);
        //binaryTree.suffixIteratorOther();
    }
}
