/**
 * xianxingbiao
 */
public class List {
    private static final int MAX_LIST_SIZE = 20;

    private static int length = 0;
    private static Element[] list = new Element[MAX_LIST_SIZE];

    public static void main(String[] args) {
        init();
        System.out.println("Length is " + length + " after init.");

        Element element = new Element();
        element.data = 1000;
        insert(element, 10);

        System.out.println("Length is " + length + " after insert.");

        printList();

        Element element1 = remove(3);
        if(element1 != null) {
            System.out.println("The data of removed elment is : " + element1.data);
        }

        printList();
    }

    public static void init() {
        for(int i = 0; i < MAX_LIST_SIZE / 2; i++) {
            Element element = new Element();
            element.data = i;
            list[i] = element;
            length ++;
        }
    }

    public static void insert(Element element, int position) {
        if(length >= MAX_LIST_SIZE || position < 0 || position > length) {
            return;
        }

        for(int i = length - 1; i >= position; i--) {
            list[i + 1] = list[i];
        }

        list[position] = element;

        length++;
    }

    private static Element remove(int position) {
        if(position >= length) {
            return null;
        }

        Element element = list[position];

        for(int i = position; i < length; i++) {
            list[i] = list[i + 1];
        }

        list[length - 1] = null;
        length--;

        return element;
    }

    private static int getLength() {
        return length;
    }

    private static Element getElement(int position) {
        if(position < length) {
            return list[position];
        }

        return null;
    }

    private static void printList() {
        for(int i = 0; i < length; i++) {
            System.out.println("i = " + i + " data : " + list[i].data + "\t");
        }
    }

    public static class Element {
        protected int data;
    }
}