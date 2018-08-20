package lang;




public class SingleLinkTest {

    private Node first;

    public void add(String data){
        Node node= new Node(data);
        node.next=first;
        first=node;
    }

    public Node find(String data) {
        Node node=first;
        while (node!=null){
            if (node.data.equals(data)){
                return node;
            }else {
                node=node.next;
            }
        }
        return null;
    }
    public void delete(String data){
        Node node=first;
        Node tmp=first;
        while (node!=null){
            if (node.data.equals(data)){
                if (first==tmp){first=node.next;break;}
                tmp.next=node.next;
                break;
            }else {
                tmp=node;
                node=node.next;
            }
        }
    }
    private static class  Node{
        String data;
        Node next;
        public Node(){
            super();
        }
        public Node(String data){
            super();
            this.data=data;
        }
    }
    public void display(){
        Node node =first;
        StringBuilder sb = new StringBuilder();
        while (node!=null){
            sb.append(node.data).append(" ");
            node=node.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        SingleLinkTest linkTest = new SingleLinkTest();

        linkTest.add("a");
        linkTest.add("b");
        linkTest.add("c");
        linkTest.add("d");
        linkTest.add("e");
        linkTest.add("a");
        linkTest.add("b");
        linkTest.add("c");
        linkTest.add("d");
        linkTest.add("e");
        linkTest.display();
        System.out.println(linkTest.find("e").data);
        linkTest.delete("e");
        linkTest.delete("e");
        linkTest.display();


    }
}
