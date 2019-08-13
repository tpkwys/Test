/**
 * @author tianpanke
 * @title: NiceNumberRegular
 * @projectName Test
 * @description: 靓号匹配规则
 * @date 2019/7/6 14:32
 */
public interface NiceNumberRegular {
    String AAAA=".*(\\d)\\1{3}$";
    String AABB=".*(\\d)\\1{1}((?!\\1)\\d)\\2{1}$";
    String ABBB=".*(\\d)((?!\\1)\\d)\\2{2}$";
    String ABCD=".*(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){3}\\d$";
}
