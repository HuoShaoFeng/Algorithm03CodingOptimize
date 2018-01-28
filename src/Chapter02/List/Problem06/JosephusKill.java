package Chapter02.List.Problem06;

public class JosephusKill {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n1;

        int m = 3;
//        Node left = getTheLastNode(n1,m);
//        System.out.println("left : " + left.data);

        Node left1 = getTheLastNode1(n1,m);
        System.out.println("left1 : " + left1.data);
    }



    private static Node getTheLastNode(Node head,int m) {
        if(head==null || m<1 || head.next==head)
            return head;

        Node last = head;
        while(last.next!=head){
            last = last.next;
        }

        int count = 0;

        while (head!=last){ //只要还多于一个节点
            if(++count==m){
                last.next = head.next;
                count=0;
            }else {
                last = last.next;
            }
            head = last.next;
        }

        return head;
    }

    private static Node getTheLastNode1(Node head, int m) {
        if(head==null || m<1 || head.next==head)
            return head;

        //得到环中节点的数量
        Node tmp = head.next;
        int count=1;
        while (tmp!=head){
            count++;
            tmp=tmp.next;
        }

//        int lastIndex=0;
//        for (int i = 2; i <= count; i++) {
//            lastIndex = (lastIndex+m)%i;
//        }

        int lastIndex = getLive(count,m);

        while (--lastIndex!=0){
            head = head.next;
        }

        return head;
    }

    private static int getLive(int count, int m) {
        if(1==count)
            return 1;
        return (getLive(count-1,m)+m-1)%count+1;

    }


}
