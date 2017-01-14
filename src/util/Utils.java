package util;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Spliterators.spliteratorUnknownSize;

public class Utils {

    //Zip with using spliterators and closures
    @NotNull
    public static <T, U, R> Stream<R> zip(Stream<T> tStream, Stream<U> uStream, BiFunction<T, U, R> zipper) {
        return StreamSupport.stream(spliteratorUnknownSize(
                new Iterator<R>() {
                    Iterator<T> itT = tStream.iterator();
                    Iterator<U> itU = uStream.iterator();

                    @Override
                    public boolean hasNext() {
                        return itT.hasNext() && itU.hasNext();
                    }

                    @Override
                    public R next() {
                        return zipper.apply(itT.next(), itU.next());
                    }
                },
                0),
                false
        );
    }
}
