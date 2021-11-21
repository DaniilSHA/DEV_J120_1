import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private boolean isAdmin;
    static ArrayList<Integer> baseId = new ArrayList<Integer>();

    public User(int id, String name, boolean isAdmin) throws UserException {

        if (baseId.contains(id)) {throw new UserException("идентификатор пользователя не уникален");}
        else {
            this.id = id;
            baseId.add(id);
        }

        if ((name==null) || (name.trim().equals(""))) throw new UserException("имя пользователя равно null или является пустым");
        else this.name = name;

        this.isAdmin = isAdmin;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        int newId = id;
        while (baseId.contains(newId)) {
            newId = (int) Math.round(Math.random()*100);
        }
        try {
            return new User(newId, name, isAdmin);
        } catch (UserException e) {
            throw new CloneNotSupportedException("имя пользователя равно null или является пустым");
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (obj==null) return false;

        if (!(obj instanceof User)) return false;

        if (!name.equals(((User) obj).getName())) return false;

        if (isAdmin != ((User) obj).isAdmin()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int admin = isAdmin ? 1 : 0 ;
        byte [] bytes = name.getBytes();
        int sumBytes=0;
        for (int i=0; i< bytes.length; i++)
            sumBytes += bytes[i];
        return sumBytes + admin;
    }

}
