package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
      //Function takes one argument and produces 1 result
       int increment = incrementByOne(1);
        System.out.println(increment);

        //can put Function here or make it static
       int increment2 = incrementByOneFunction.apply(1);

        System.out.println(increment2);
        int multiply = multipleBy10Function.apply(increment2);

        System.out.println(multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multipleBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4));

        //BiFunction takes 2 arguments and produces 1 result

        int bifunctioncalc = incrementByOneAndMultiply(4, 100);

        System.out.println(bifunctioncalc);

       System.out.println(
               incrementByOneAndMultiplyBiFunction.apply(4, 100)
       );


    }
                   //take int //return integer
    static Function<Integer, Integer> incrementByOneFunction = number-> number+1;

    static Function<Integer ,Integer> multipleBy10Function = number -> number*10;

    static int incrementByOne(int number){
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne+1)* numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
        return (number+1) * numToMultiplyBy;
    }
    //Function<T,R> represents a function that accepts one argument and produces a result

}
