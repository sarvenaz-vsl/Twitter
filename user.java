package eyd;
import java.util.ArrayList;
public class user
{
    private static String userName;
    private static String password;
    private static ArrayList <String> following=new ArrayList<String>();
    private static ArrayList <String> follower=new ArrayList<String>();


    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        user.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        user.password = password;
    }


    public static ArrayList<String> getFollowing() {
        return following;
    }

    public static void setFollowing(ArrayList<String> following) {
        user.following = following;
    }

    public static ArrayList<String> getFollower() {
        return follower;
    }

    public static void setFollower(ArrayList<String> follower) {
        user.follower = follower;
    }
}
