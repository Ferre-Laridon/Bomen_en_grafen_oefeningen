package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty()) System.out.println("De heap is leeg");
        else System.out.println(values);
    }

    public E getMin() {
        if (this.isEmpty()) throw new IllegalStateException("Kan niet zoeken in een lege heap");
        return this.values.get(0);
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty()) values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        int indexLaatste = this.values.size() - 1;
        int indexOuder = (indexLaatste - 1) / 2;
        E laatste = this.values.get(indexLaatste);
        E ouder = this.values.get(indexOuder);

        while (laatste.compareTo(ouder) < 0) {

            this.values.set(indexOuder, laatste);
            this.values.set(indexLaatste, ouder);

            indexLaatste = indexOuder;
            indexOuder = (indexLaatste - 1) / 2;
            laatste = this.values.get(indexLaatste);
            ouder = this.values.get(indexOuder);
        }
    }

    public E removeSmallest() {
        if (this.isEmpty()) throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        int indexEerste = 0;
        E eerste = this.values.get(0);
        int indexLinkerKind = 1;
        E linkerKind = this.values.get(1);
        int indexRechterKind = 2;
        E rechterKind = this.values.get(2);
        E kleinsteKind = linkerKind;
        int indexKleinsteKind = 1;
        if (rechterKind.compareTo(linkerKind) > 0) {
            kleinsteKind = rechterKind;
            indexKleinsteKind = 2;
        }


        while (eerste.compareTo(linkerKind) > 0 || eerste.compareTo(rechterKind) > 0) {
            while (this.values.size() - 1 >= indexRechterKind) {
                this.values.set(indexKleinsteKind, eerste);
                this.values.set(indexEerste, kleinsteKind);

                indexEerste = indexKleinsteKind;

                indexLinkerKind = 2 * indexEerste + 1;
                linkerKind = this.values.get(indexLinkerKind);

                indexRechterKind = 2 * indexEerste + 2;
                rechterKind = this.values.get(indexRechterKind);

                if (linkerKind.compareTo(rechterKind) > 0) kleinsteKind = rechterKind;
                else kleinsteKind = linkerKind;
            }
        }
    }

    public ArrayList<E> getPath(E value) {
        // TODO zie oefening 6;
        return null;
    }
}
