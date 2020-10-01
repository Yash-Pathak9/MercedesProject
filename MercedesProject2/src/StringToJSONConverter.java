import java.util.Scanner;

class Node {
    char operator;
    Node node1;
    Node node2;

    public Node (char operator){
        this.operator = operator;
        node1 = null;
        node2 = null;
    }
}
public class StringToJSONConverter {

    public Node util(String s, int start, int end) {

        int mid = (start+end)/2;
        if (s.length()%2 == 0 || !(s.charAt(mid) == '|' || s.charAt(mid) == '&' || s.charAt(mid) == '=')){
            return new Node('!');
        }
        Node node = new Node(s.charAt(mid));
        if (!(s.charAt(end) == ')' || s.charAt(end) == '(')) {
            node.node1 = new Node(s.charAt(start));
            node.node2 = new Node(s.charAt(end));
        } else {
            node.node1 = util(s, start + 1, mid - 1);
            node.node2 = util(s, mid + 1, end - 1);

            if (node.node1.operator == '!' || node.node2.operator == '!') node.operator = '!';
        }
        return node;
    }

    public StringBuilder depthFirstSearch (Node node, int spacing) {
        StringBuilder s = new StringBuilder();

        if (node == null) return s;

        s.append(" ".repeat(Math.max(0, spacing)));

        if (node.operator == 'q') {
            s.append("{\n \"query\": {\n");
            s.append(depthFirstSearch(node.node1, spacing+2));
            s.append("\n }\n}");
            return s;
        }
        else if (node.operator == '&')
            s.append("\"and\": ");
        else if (node.operator == '|')
            s.append("\"or\": ");
        else if (node.operator == '=') {
            s.append(node.node1.operator).append(":").append(node.node2.operator);
            return s;
        }

        s.append("{\n");
        s.append(depthFirstSearch(node.node1, spacing+1));
        s.append(",\n");
        s.append(depthFirstSearch(node.node2, spacing+1));
        s.append("\n");
        s.append(" ".repeat(Math.max(0, spacing)));
        s.append("}");

        return s;
    }

    public static void main(String[] args) {
        StringToJSONConverter converter = new StringToJSONConverter();

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine().replaceAll("\\s", "");
        StringBuilder temp = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            temp.append(s.charAt(i));
            if (s.charAt(i) == '|' || s.charAt(i) == '&') {
                i++;
            }
        }
        if (temp.length()%2 != 0 && (temp.length()/2-1) % 2 == 0 && (temp.charAt(temp.length()/2) == '|'
                || (temp.charAt(temp.length()/2) == '&') || (temp.charAt(temp.length()/2) == '='))) {
            temp.insert(0, "(");
            temp.append(")");
        }

        Node node = new Node('q');
        node.node1 = converter.util(temp.toString(), 0, temp.length()-1);

        if (node.node1.operator == '!') System.out.println("Invalid input String!");
        else System.out.println(converter.depthFirstSearch(node, 0));
    }
}
