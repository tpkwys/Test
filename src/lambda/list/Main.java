package lambda.list;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tianpanke
 * @title: Main
 * @projectName Test
 * @description: TODO
 * @date 2019/8/1 21:32
 */
public class Main {
    public static void main(String[] args) {
        List<User> userList=new ArrayList<>();
        generateUsers(10,userList);
        //分组
        Map<String, List<User>> groupBySex=userList.stream().collect(Collectors.groupingBy(User::getSex));
        for(Map.Entry<String,List<User>> entry:groupBySex.entrySet()){
            String key=entry.getKey();
            List<User> entryUserList=entry.getValue();
            System.out.println("key:"+key);
            entryUserList.stream().forEach(user->System.out.println(user.toString()));
        }
        //过滤
        //排除工号为XXXX1的用户
        List<User> filterUserList=userList.stream().filter(a->!a.getJobNumber().equals("XXXX1")).collect(Collectors.toList());
        filterUserList.stream().forEach(user -> System.out.println(user.toString()));
        //求和
        //基本类型求和
        int sumAge=userList.stream().mapToInt(User::getAge).sum();
        //BigDecimal求和
        BigDecimal totalQuainty=userList.stream().map(User::getFamilyMemberQuantity).reduce(BigDecimal.ZERO,BigDecimal::add);
        System.out.println("sumAge:"+sumAge+" totalQuainty:"+totalQuainty);
        //最值
        //最小
        Date minEntryDate=userList.stream().map(User::getEntryDate).min(Date::compareTo).get();
        //最大
        Date maxEntryDate=userList.stream().map(User::getEntryDate).max(Date::compareTo).get();
        System.out.println("minDate:"+minEntryDate.toString()+"maxDate:"+maxEntryDate.toString());
        //List转map
        Map<Long,User> userMap=userList.stream().collect(Collectors.toMap(User::getId,a->a,(k1,k2)->k1));


    }
    private static void generateUsers(int size,List<User> userList){
        for(int i=0;i<size;i++){
            User user=new User();
            user.setId(new Long(i));
            user.setAge(i+5);
            user.setEntryDate(new Date());
            user.setFamilyMemberQuantity(new BigDecimal(i+2));
            user.setJobNumber("XXXX"+i);
            user.setSex(i%2==0?"男":"女");
            user.setName("name"+i);
            userList.add(user);
        }
    }
}
