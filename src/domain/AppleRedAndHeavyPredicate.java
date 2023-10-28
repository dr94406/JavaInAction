package domain;

import static domain.Color.*;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return RED.equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
