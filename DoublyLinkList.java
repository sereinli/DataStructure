/**
 * shuang xiang lian biao
 */
public class DoublyLinkList {

    private static Element header;
    private static Element end;

    public static void main(String[] args) {

        DoublyLinkList linkList = new DoublyLinkList();

        //create
        linkList.init();
        linkList.printList();

        //insert
        Element element = new Element();
        element.data = 1000;
        linkList.insert(element, 5);
        linkList.printList();

        //remove
        int position = 3;
        Element element1 = linkList.remove(position);
        if(element1 != null) {
            System.out.println("The data of removed elment position is : " + position + ", and the data is : " + element1.data);
        }
        linkList.printList();

        //reverse print the link list
        linkList.jumpToEnd();
        linkList.reversePrintList();

        linkList.clear();
        linkList.printList();
    }

    //create link header
    public void init() {
        if(header == null) {
            header = new Element();
            header.data = - 1;
        }

        Element ptr = header;
        for(int i = 1; i <= 10; i++) {
            Element element = new Element();
            element.data = i;
            element.prior = ptr;
            ptr.next = element;

            ptr = ptr.next;
        }

        ptr.next = header;
        header.prior = ptr;
    }

    public void insert(Element element, int position) {
        if(header == null) {
            return;
        }

        Element p = header;  //point to the first node

        int i = 0;
        while (p.next != header && i < position) {
            p = p.next;
            i++;
        }

        if(p == null) {
            return;
        }

        p.next.prior = element;
        element.next = p.next;
        element.prior = p;
        p.next = element;
    }

    private Element remove(int position) {
        if(header == null) {
            return null;
        }

        Element p = header;  //point to the first node

        int i = 0;
        while (p.next != header && i < position) {
            p = p.next;
            i++;
        }

        if(p == null) {
            return null;
        }

        Element element = p.next;

        p.next.next.prior = p;
        p.next = p.next.next;

        return element;
    }

    private void jumpToEnd() {
        Element p = header;
        while (p.next != header) {
            p = p.next;
        }

        end = p;
    }

    private void clear() {
        if(header == null) {
            return;
        }

        Element p = header.next;  //point to the first node
        header.next = null;
        header.prior = null;
        header = null;

        while (p != null) {
            Element q = p.next;
            p.next = null;
            p.prior = null;
            p = null;
            p = q;
        }
    }

    private void printList() {
        System.out.println("=========printList=========");
        if(header == null) {
            return;
        }

        Element p = header;  //point to the first node
        while (p.next != header) {
            System.out.println(p.next.data);
            p = p.next;
        }
    }

    private void reversePrintList() {
        System.out.println("=========printList=========");
        if(end == null) {
            return;
        }

        Element p = end;  //point to the last node
        while (p != header) {
            System.out.println(p.data);
            p = p.prior;
        }
    }

    public static class Element {
        protected int data;
        protected Element next;
        protected Element prior;
    }
}