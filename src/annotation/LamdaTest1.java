package annotation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author tianpanke
 * @title: LamdaTest1
 * @projectName Test
 * @description: TODO
 * @date 2019/7/18 11:52
 */
public class LamdaTest1 {
    public static void main(String[] args) {
        List<String> languages= Arrays.asList("Java","Scala","C++","Haskell","Lisp");
        System.out.println("Language which start with J:");
        filter(languages,(str)->str.startsWith("J"));
        System.out.println("Language whick end with with a:");
        filter(languages,(str)->str.endsWith("a"));
        System.out.println("Print all languages:");
        filter(languages,(str)->true);
        System.out.println("Print no languages:");
        filter(languages,(str)->false);
        System.out.println("Print language who length greater than 4:");
        filter(languages,(str)->str.length()>4);
        Predicate<String> startWithJ=(n)->n.startsWith("J");
        Predicate<String> fourLetterLong=(n)->n.length()==4;
        languages.stream().filter(startWithJ.and(fourLetterLong)).forEach((n)-> System.out.println("\nName,which starts with J and four letter long is :"+n));

    }
    public static void filter(List<String> list, Predicate<String> condition){
        for(String name:list){
            if(condition.test(name)){
                System.out.println(name+" ");
            }
        }
    }
}
