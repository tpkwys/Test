package lambda.list;

/**
 * @author tianpanke
 * @title: Supplier
 * @projectName Test
 * @description: TODO
 * @date 2019/8/2 11:48
 */
@FunctionalInterface
public interface Supplier <T> {
    T get();
}
class Car{

    public static Car create(final Supplier<Car> supplier){
        return supplier.get();
    }

    public static void collide(final Car car){
        System.out.println("Collided "+car.toString());
    }
    public void follow(final  Car another){
        System.out.println("Following the "+another.toString());
    }
    public void repair(){
        System.out.println("repaired "+this.toString());
    }

}
