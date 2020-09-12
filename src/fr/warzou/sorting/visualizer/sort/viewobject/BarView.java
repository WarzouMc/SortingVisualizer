package fr.warzou.sorting.visualizer.sort.viewobject;

public class BarView implements View {

    private long viewLong;

    @Override
    public void setViewLong(long viewLong) {
        this.viewLong = viewLong;
    }

    @Override
    public long viewLong() {
        return this.viewLong;
    }
}
