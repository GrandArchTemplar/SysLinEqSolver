package base;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

import static base.LinearEquation.subtraction;

@NotNull
public class LinearEquationsSystem {
    private final List<LinearEquation> equations;


    public LinearEquationsSystem(@NotNull List<LinearEquation> equations) {
        this.equations = equations.stream().collect(Collectors.toList());
    }

    public void triangulate() {

    }
}
