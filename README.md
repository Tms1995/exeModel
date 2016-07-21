# exeModel
executable model,orm,like mybatis,hibernate but tiny and fast

You can save like this
 User user = new User();
        user.setName("zp");
        user.setAge(18);
        user.save();
        
delete:
User user = new User();
        user.setName("test");
        user.setAge(18);
        user.save();
        user.delete();

update:
 User user = User.dao.findById(1);
        user.setAge(25);
        user.update();
        
findById
User.dao.findById(1)

findTinyById// this api will ignore big columns like text,which you can add annotation @NotTooSimple
User.dao.findTinyById(1);


    
find list with sql:  
List<User> list = User.dao.findList("select * from user where name=?", "zp");

find one with sql
 User user = User.dao.findOne("select * from user where name=?", "zp");
 
select with conditions
 List<User> users = User.dao.eq("name", "zp").asc("age").selectList();
 
remove with conditions
User.dao.eq("name", "tms").remove();

or update some columns with conditions
 User.dao.eq("name", "tms").set("name", "xxf", "age", 38);//this can change tms to xxf and age to 38
 
You need code your model like this
@Table(name = "user")

public class User  extends ExecutableModel{

   public static Dao<User> dao = new Dao(User.class);//to make model executable
    private int id;
    private String name;
    private int age;
    private String details;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @NotTooSimple
    @Basic
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

and TODO cache,and dynamic log
