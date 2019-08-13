package lambda.list;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author tianpanke
 * @title: User
 * @projectName Test
 * @description: TODO
 * @date 2019/8/1 21:30
 */
public class User {
    private Long id;

    private String name;

    private int age;

    private String jobNumber;

    private String sex;

    private Date entryDate;

    private BigDecimal familyMemberQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public BigDecimal getFamilyMemberQuantity() {
        return familyMemberQuantity;
    }

    public void setFamilyMemberQuantity(BigDecimal familyMemberQuantity) {
        this.familyMemberQuantity = familyMemberQuantity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", jobNumber='" + jobNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", entryDate=" + entryDate +
                ", familyMemberQuantity=" + familyMemberQuantity +
                '}';
    }
}
