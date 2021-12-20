package node;

public class Node{
    public int num;
    public Node nextNode;

    public Node(int num) {
        this.num = num;
        this.nextNode = null;
    }

    public Node(int num, Node nextNode) {
        this.num = num;
        this.nextNode = nextNode;
    }

    protected int getNum() {
        return num;
    }
}
