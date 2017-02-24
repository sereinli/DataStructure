/**
 * xianxinglianbiao
 */
public class LinkList {

    private static Element list;

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory() + " " + runtime.freeMemory());

        LinkList linkList = new LinkList();

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
            System.out.println("The data of removed elment data is : " + element1.data);
        }
        linkList.printList();

        linkList.clear();
        linkList.printList();

        runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory() + " " + runtime.freeMemory());
    }

    //create link list
    public void init() {
        if(list == null) {
            list = new Element();
            list.data = 100;
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
        Element p = list;

        int i = 1;
        while (p != null && i < position) {
            p = p.next;
            i++;
        }

        if(p == null) {
            return;
        }

        element.next = p.next;
        p.next = element;
    }

    private Element remove(int position) {
        Element p = list;

        int i = 1;
        while (p != null && i < position) {
            p = p.next;
            i++;
        }

        if(p == null) {
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

        Element p = list;
        while (p != null) {
            Element q = p.next;
            p.next = null;
            p = null;
            p = q;
        }

        list = null;
    }

    private void printList() {
        System.out.println("=========printList=========");
        Element element = list;
        while (element != null) {
            System.out.println(element.data);
            element = element.next;
        }
    }

    public static class Element {
        protected int data;
        protected Element next;
    }
}