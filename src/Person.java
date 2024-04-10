
//abstract class that provide the fields of person
public abstract class Person implements Observer {
   // Attributes
   private final int id;
   private String name;
   private int age;
   private final String gender;

   // Constructor
   public Person(int id, String name, int age, String gender) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.gender = gender;
   }

   // Methods to get attributes
   public void update(String message)
   {
      System.out.println(message);

   }
   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   public String getGender() {
      return gender;
   }


   // Methods to set attributes
   public void setName(String name) {
      this.name = name;
   }

   public void setAge(int age) {
      this.age = age;
   }
}