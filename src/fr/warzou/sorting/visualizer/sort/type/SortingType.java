package fr.warzou.sorting.visualizer.sort.type;

public enum SortingType {

    BUBBLE("Bubble sort");

    private String name;
    SortingType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static SortingType byID(int id) {
        if (values().length > id) {
            return values()[id];
        }
        return null;
    }
}
