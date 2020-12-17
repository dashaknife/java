package clothes;

import clothes.type.TypeOfUpperClothes;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wardrobe implements Display{
    private ArrayList<Look> looks;

    public Wardrobe(ArrayList<Look> looks){
        this.looks = new ArrayList<>();
        this.looks = looks;
    }

    @Override
    public void display() {
        ListIterator<Look> lookListIterator = looks.listIterator();
        while (lookListIterator.hasNext()){
            lookListIterator.next().display();
        }
    }

    public ArrayList<Look> getLooks() {
        return looks;
    }

    public static float getJumperPriceSum(List<Look> list) {
        return (float) Stream.ofNullable(list).flatMap(x->x.stream()).
                    filter(x -> x.getUpperClothes().equals(TypeOfUpperClothes.Jumper.getUpper_s())).
                    mapToDouble((Look::getPrice)).
                    sum();

    }

    public static float getMaxPrice(List<Look> list) {
        return (float) list.stream().
                mapToDouble(Look::getPrice).
                max().orElseThrow(NoSuchElementException::new);
    }

    public static float getAveragePrice(List<Look> list) {
        return (float) list.stream().
                mapToDouble(Look::getPrice).
                average().orElseThrow(NoSuchElementException::new);
    }

    public static Map<Boolean, List<Look>> getGroupByCondition(List<Look> list,Predicate<Look> booleanCondition) {
        return list.stream().
                collect(Collectors.partitioningBy(booleanCondition));
    }

    public static List<String> getMostFrequentBandageMaterials(List<Wardrobe> wardrobeList) {

        List<String> result = new ArrayList<>();
        wardrobeList.stream()
                .flatMap(x -> x.getLooks().stream())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(Look::isExpensive))
                .forEach((key, value) -> value.stream()
                        .collect(Collectors.groupingBy(x -> x.getUpperClothes(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .ifPresent(x -> result.add(x.getKey())));
        return result;
    }
}
