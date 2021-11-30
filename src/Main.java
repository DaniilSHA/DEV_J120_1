public class Main {
    public static void main(String[] args) throws UserException, CloneNotSupportedException{

        User user1 = new User(58, "Petr", false);
        User user2 = (User) user1.clone();
        User user3 = new User(73, "Vovan", true);

        System.out.println("User2 Name = " + user2.getName());
        System.out.println("User2 Id = " + user2.getId());

        System.out.println("User1 == User2 ?? " + user1.equals(user2));
        System.out.println("User1 == User3 ?? " + user1.equals(user3));

        System.out.println("User1 hashCode = " + user1.hashCode());
        System.out.println("User2 hashCode = " + user2.hashCode());
        System.out.println("User3 hashCode = " + user3.hashCode());
    }
}
