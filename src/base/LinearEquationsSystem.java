package base;

import java.util.List;
import java.util.stream.Collectors;

import static base.LinearEquation.subtraction;

public class LinearEquationsSystem {
    private final List<LinearEquation> equations;


    public LinearEquationsSystem(List<LinearEquation> equations) {
        this.equations = equations.stream().collect(Collectors.toList());
    }

    public void triangulate(){
        //// TODO
    }
}
