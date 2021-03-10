package services;

import models.Look;
import models.Wardrobe;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public interface StatisticsService {
    float getJumperPriceSum(List<Look> list);
    float getMaxPrice(List<Look> list);
    float getAveragePrice(List<Look> list);
    Map<Boolean, List<Look>> getGroupByCondition(List<Look> list, Predicate<Look> booleanCondition);
    List<String> getMostPopularTypeOfUpperCloth(List<Wardrobe> wardrobeList);
}
