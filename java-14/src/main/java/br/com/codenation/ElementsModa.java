package br.com.codenation;

public class ElementsModa implements Comparable<ElementsModa> {
    int element;
    int quantity;

    public ElementsModa(int element, int quantity) {
        this.element = element;
        this.quantity = quantity;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(ElementsModa o) {
        return this.getQuantity() - o.getQuantity();
    }
}
