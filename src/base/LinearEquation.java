package base;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

import static util.Utils.zip;

public class LinearEquation {
    private final List<Double> leftSide;
    private final Double rightSide;

    public LinearEquation(List<Double> leftSide, Double rightSide) {
        this.leftSide = leftSide.stream().collect(Collectors.toList());
        this.rightSide = rightSide;
    }

    //@return left - right

    @Contract("!null, !null -> !null")
    public static LinearEquation subtraction(LinearEquation left, LinearEquation right) {
        return new LinearEquation(
                zip(left.leftSide.stream(), right.leftSide.stream(), (a, b) -> a - b)
                        .collect(Collectors.toList()),
                left.rightSide - right.rightSide);
    }

    @NotNull
    public static LinearEquation multiply(@NotNull LinearEquation linearEquation, Double coefficient) {
        return new LinearEquation(
                linearEquation.leftSide.stream().map((a) -> a * coefficient).collect(Collectors.toList()),
                linearEquation.rightSide * coefficient);
    }

    public boolean isZero(){
        return !leftSide.stream().allMatch((a) -> a == 0);
    }

    public Double getRightSide() {
        return rightSide;
    }

    public List<Double> getLeftSide() {
        return leftSide.stream().collect(Collectors.toList());
    }
}
