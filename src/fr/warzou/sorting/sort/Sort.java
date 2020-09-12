package fr.warzou.sorting.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class Sort {

    public static int VALUES_LENGTH = 1138;
    private List<Integer> values = new ArrayList<>();
    private int selected;
    private List<Integer> sortingValues = new ArrayList<>();
    private boolean end = false;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void sort() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < VALUES_LENGTH; i++)
            integerList.add(i);
        this.values = integerList;
        this.executorService.submit(() -> {
            Collections.shuffle(integerList);
            this.values = integerList;
            this.selected = 0;

            AtomicReference<String> noSortAtomic = new AtomicReference<>("");
            integerList.forEach(aLong -> noSortAtomic.set(noSortAtomic.get() + aLong + ", "));

            String noSort = noSortAtomic.get();
            noSort = noSort.substring(0, noSort.length() - 2);
            System.out.println(noSort);

            boolean isSort = false;
            while (!isSort) {
                boolean tempIsSort;
                boolean isLast = false;
                for (int i = 0; i < VALUES_LENGTH - 1; i++) {
                    int min = Math.min(integerList.get(i), integerList.get(i + 1));
                    tempIsSort = integerList.get(i) == min;
                    this.selected = i;
                    if (!tempIsSort) {
                        Collections.swap(integerList, i, i + 1);
                        this.values = integerList;
                        sleep(1);
                    }
                    isLast = i == VALUES_LENGTH - 2;
                }
                if (!isLast)
                    continue;
                for (int i = 0; i < VALUES_LENGTH - 1; i++) {
                    this.selected = i;
                    int min = Math.min(integerList.get(i), integerList.get(i + 1));
                    isSort = true;
                    sleep(1);
                    this.selected = VALUES_LENGTH - 1;
                    if (min != integerList.get(i)) {
                        isSort = false;
                        this.sortingValues.clear();
                        break;
                    }
                    this.sortingValues.add(i);
                }
            }
            sleep(1);
            this.end = true;

            AtomicReference<String> sortAtomic = new AtomicReference<>("");
            integerList.forEach(aLong -> sortAtomic.set(sortAtomic.get() + aLong + ", "));
            String sort = sortAtomic.get();
            sort = sort.substring(0, sort.length() - 2);
            System.out.println(sort);
        });
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getValues() {
        return this.values;
    }

    public int getSelected() {
        return this.selected;
    }

    public List<Integer> getSortingValues() {
        return this.sortingValues;
    }

    public boolean isEnd() {
        return this.end;
    }
}
