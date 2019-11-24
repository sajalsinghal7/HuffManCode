import java.util.Comparator;

class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.weight - o2.weight;
    }
}