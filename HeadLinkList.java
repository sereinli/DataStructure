/**
 * xianxinglianbiao
 */
public class HeadLinkList {

    private static Element list;

    public static void main(String[] args) {

        HeadLinkList linkList = new HeadLinkList();

        //create
        linkList.init();
        linkList.printList();

        //insert
        Element element = new Element();
        element.data = 1000;
        linkList.insert(element, 5);
        linkList.printList();

        //remove
        Element element1 = linkList.remove(3);
        if(element1 != null) {
            System.out.println("The data of removed elment is : " + element1.data);
        }
        linkList.printList();

        linkList.clear();
        linkList.printList();
    }

    //create link list
    public void init() {
        if(list == null) {
            list = new Element();
        }

        Element ptr = list;
        for(int i = 1; i <= 10; i++) {
            Element element = new Element();
            element.data = i;
            ptr.next = element;

            ptr = ptr.next;
        }
    }

    public void insert(Element element, int position) {
        if(list == null) {
            return;
        }

        Element p = list.next;  //point to the first node

        int i = 1;
        while (p != null && i < position) {
            p = p.next;
            i++;
        }

        if(p == null || i > position) {
            return;
        }

        element.next = p.next;
        p.next = element;
    }

    private Element remove(int position) {
        if(list == null) {
            return null;
        }

        Element p = list.next;  //point to the first node

        int i = 1;
        while (p != null && i < position) {
            p = p.next;
            i++;
        }

        if(p == null || i > position) {
            return null;
        }

        Element element = p.next;

        p.next = p.next.next;

        return element;
    }

    private void clear() {
        if(list == null) {
            return;
        }

        Element p = list.next;  //point to the first node
        list.next = null;
        list = null;

        while (p != null) {
            Element q = p.next;
            p.next = null;
            p = null;
            p = q;
        }
    }

    private void printList() {
        System.out.println("=========printList=========");
        if(list == null) {
            return;
        }

        Element p = list.next;  //point to the first node
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public static class Element {
        protected int data;
        protected Element next;
    }
}