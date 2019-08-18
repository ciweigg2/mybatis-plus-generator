mybatis-plus最好的代码生成封装 包含了代码自动生成 简单测试接口

```java
/**
 * 测试例子呀 别在这里测试 这边只是举例
 */
public class Jyw {

	@Autowired
	private IUserService userService;

	public void testSelect() {

		UpdateWrapper<UserModel> wrapper = new UpdateWrapper<>();
		wrapper.eq("password", "195d91be1e3ba6f1c857d46f24c5a454"); //等于
		wrapper.ne("username", "domain");//不等于
		wrapper.gt("age", 18); //大于
		wrapper.ge("age", 22); //大于等于
		wrapper.lt("age", 22); //小于
		wrapper.le("age", 22); //小于等于
		wrapper.between("age", "22", "25"); //between value1 和 value2之间
		wrapper.notBetween("age", "22", "25");//not between value1 和 value2之间, null 不会查出来
		wrapper.like("username", "domain"); //%value %
				wrapper.likeLeft("username", "1");  //%value
		wrapper.likeRight("username", "zhangsan");
//		value %
				wrapper.isNull("age"); //age == null 的数据
		wrapper.in("age", "31", "33");
//		age 是 31 33 的
		wrapper.notIn("age", "22", "23");
//		age 不是 22 22 的，age为null的 不会查出来
		wrapper.inSql("id", "select id from tb_user where id > 3"); // id 为 后面语句中查出来的id集合的 记录 相当于 where id in (4,5,6);       SELECT username,password,phone,email,created,updated FROM tb_user WHERE id IN (select id from tb_user where id > 3)
		wrapper.notInSql("id", "select id from tb_user where id < 22");//id 不小于 22 的记录
		wrapper.notInSql("id", "select id from tb_user where id < 22");//id 不小于 22 的记录,null 也查出来， 因为null 不在小于22的范围内
		wrapper.groupBy("age"); //通过 age 分组，age相同为一组， 一组只有一条记录就是组的第一条记录
		wrapper.orderByAsc("id", "age");//以id，age 升序排序，先对id排序， id相同， 对age排序
		wrapper.orderBy(true, true, "id", "age"); //和上面效果相同
		wrapper.orderByDesc("id", "age");//以id，age 降序排序，先对id排序， id相同， 对age排序


		//having
		//    需要注意的是，
		//
		//    having 子句中的每一个元素也必须出现在select列表中。有些数据库例外，如oracle.
		//            having子句和where子句都可以用来设定限制条件以使查询结果满足一定的条件限制。
		//    having子句限制的是组，而不是行。where子句中不能使用聚集函数，而having子句中可以。
		//    当加上其他sql语句时，执行顺序如下：
		//    S-F-W-G-H-O 组合
		//
		//    select –>where –> group by–> having–>order by
		//
		//    顺序是不能改变的

		//
		//        SELECT
		//                username,
		//                city,
		//        SUM(price)
		//        FROM
		//                tb_user
		//        GROUP BY
		//        city
		//                HAVING
		//        SUM(price) > 2000

		wrapper.groupBy("city").having("sum(price)>2000");

		wrapper.having("sum(age)>22");

		wrapper.eq("username", "domain").or().eq("age", "22");
//		username = domain 或者 age = 22

		//OR 嵌套
		wrapper.eq("username", "domain")
				.or(i -> i.eq("age", "22").eq("phone", "13333333334"));// username = domain 或者 (age = 22 and phone = 13333333334)

		//and 嵌套
		wrapper.eq("age", "22")
				.and(i -> i.eq("phone", "13333333333").or().eq("phone", "13333333334"));// age ==22 and (phone =13333333333 or phone = 13333333334)

		//nested ,正常嵌套 username=domain 或者 age<22
		wrapper.nested(i -> i.eq("username", "domain").or().lt("age", "22"));

		wrapper.set("username", "domain").eq("username", "niuniu");

		List<UserModel> tbUsers = userService.list(wrapper);

		/**
		 * QueryWrapper， 可以指定要查询哪些字段
		 */
		QueryWrapper<UserModel> queryWrapper = new QueryWrapper<>();
		queryWrapper.select("username", "password", "phone");
		queryWrapper.eq("username", "domain");
		List<UserModel> userModels = userService.list(queryWrapper);

		for (UserModel userModel : userModels) {
			System.out.println(userModel.getName());
		}

	}

}
```
