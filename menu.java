package eyd;

import java.util.*;
import static eyd.Twitter.menuAccess;
import static eyd.user.getUserName;

public class menu
{
    static HashMap<String ,String>bio=new HashMap<>();
    static HashMap<String,ArrayList> follows =new HashMap<>();
    static ArrayList<tweet> tweets=new ArrayList<tweet>();
    static HashMap<String, String> userPassCheck = new HashMap<String, String>();
    static HashMap<Integer, ArrayList> like = new HashMap<Integer, ArrayList>();
    static int tweetsID=1;

    public static void signUp(String userName, String password)
    {
        if(!menuAccess) {
                if (userPassCheck.containsValue(userName))
                    System.out.println("A Twitter account already exists with this username,please try again");
                else
                {
                    ArrayList<String>followingList=new ArrayList<>();
                    String firstBio="No bio!!";
                    userPassCheck.put(userName, password);
                    follows.put(userName,followingList);
                    bio.put(userName,firstBio);
                    System.out.println("You signed up successfully");
                }
        }
        else
            System.out.println("You should log out first");
    }
    public static void logIn(String userName,String password)
    {
        if(!menuAccess){
        if (userPassCheck.get(userName).equals(password)) {
            System.out.println("You logged in successfully");
            user.setUserName(userName);
            user.setPassword(password);
            menuAccess =true;
        } else
            System.out.println("Your password is not correct");
    }
      else
              System.out.println("You should log out first");
    }
    public static void follow(String followUser)
    {
        if(menuAccess)
        {
            user user=new user();
            if(userPassCheck.containsKey(followUser))
            {
                if(!eyd.user.getUserName().equals(followUser))
                {
                    if(follows.get(eyd.user.getUserName()).contains(followUser))
                        System.out.println("You have followed this username!!");
                    else
                    {
                        ArrayList<String> followings = follows.get(user.getUserName());
                        followings.add(followUser);
                        System.out.println("you followed " + followUser + " successfully");
                    }
                }
                else
                    System.out.println("You can not follow yourself!!!");
            }
            else
                System.out.println("This username does not exist");
        }
        else
            System.out.println("You should log in first");
    }
    public static void unfollow(String unfollowUser)
    {
        if(menuAccess)
        {
            if(userPassCheck.containsKey(unfollowUser))
            {
                user user=new user();
                ArrayList<String> followings = new ArrayList<>();
                followings = follows.get(user.getUserName());
                if (followings.remove(unfollowUser))
                    System.out.println("You unfollowed " + unfollowUser + " successfully");
                else
                    System.out.println("You didnt have followed this user");
            }
           else
               System.out.println("this username doesnt exist");
        }
        else
            System.out.println("You should log in first");
    }
    public static void follower()
    {
        if(menuAccess)
        {
            ArrayList<String>followers=new ArrayList<>();
            for (String users : follows.keySet()){
                ArrayList<String> followings = follows.get(users);
                if (followings.contains(user.getUserName())){
                    followers.add(users);
                }
            }
            if(followers.isEmpty())
                System.out.println("No one have followed you, yet :)");
            else
            {
                System.out.println("followers:");
                System.out.println(followers);
            }
        }
        else
            System.out.println("You should log in first");
    }
    public static void following()
    {
        if(menuAccess)
        {
            ArrayList<String> folllowings=new ArrayList<>();
            for(String users: follows.keySet())
            {
                if(users.equals(user.getUserName()))
                    folllowings= follows.get(users);
            }
            if(folllowings.isEmpty())
                System.out.println("You didnt follow anyone");
            else
            {
                System.out.println("followings:");
                System.out.println(folllowings);
            }
        }
        else
            System.out.println("You should log in first");
    }
    public static void like(String tID)
    {
        if(menuAccess) {
            int tweetID = Integer.parseInt(tID);
            Boolean tweetExist = true;
            if (tweetID > tweetsID -1 )
                tweetExist = false;
            if (tweetExist)
            {
                ArrayList<String> tweetLikeID = like.get(tweetID);
                if (tweetLikeID == null) {
                tweetLikeID = new ArrayList<>();
                like.put(tweetID, tweetLikeID);
            }
            if (tweetLikeID.contains(user.getUserName()))
                System.out.println("you cant like this tweet more than one time");
            else {
                tweetLikeID.add(user.getUserName());
                for (int i = 0; i < tweets.size(); i++) {
                    if (tweets.get(i).getTweetID() == tweetID) {
                        int likeNumber = tweets.get(i).getLike();
                        likeNumber++;
                        tweets.get(i).setLike(likeNumber);
                        System.out.println("You like this tweet successfully");
                    }
                }
            }
        }
            else
                System.out.println("This tweet doesnt exist!");
        }
        else
            System.out.println("You should log in first");
    }
    public static void myProfile()
    {
        if(menuAccess) {
            int tweetCounter=0;
            for (int i = tweets.size() - 1; i >= 0; i--)
            {
                    System.out.println(getUserName());
                    if (tweets.get(i).getUser().equals(getUserName())) {
                        System.out.println("tweet:" + tweets.get(i).getTweet());
                        System.out.println("tweet ID:" + tweets.get(i).getTweetID());
                        System.out.println("tweet like:" + tweets.get(i).getLike());
                        System.out.println("tweet date:" + tweets.get(i).getDate());
                        System.out.println();
                        tweetCounter++;
                    }
            }
            if(tweetCounter==0)
                System.out.println("You dont have any tweets!");
        }
        else
            System.out.println("You should log in first");
    }
    public static void profile(String user)
    {
        if(menuAccess) {
            if (user.equals(eyd.user.getUserName()))
                System.out.println("If you want to see your profile,please type myprofile");
            else {
                int tweetCounter=0;
                for (int i = tweets.size() - 1; i >= 0; i--) {
                    if (tweets.get(i).getUser().equals(user)) {
                        System.out.println("tweet:" + tweets.get(i).getTweet());
                        System.out.println("tweet ID:" + tweets.get(i).getTweetID());
                        System.out.println("tweet like:" + tweets.get(i).getLike());
                        System.out.println("tweet date:" + tweets.get(i).getDate());
                        System.out.println();
                        tweetCounter++;
                    }
                }
                if(tweetCounter==0)
                    System.out.println(user+" have no tweets");
            }
        }
        else
            System.out.println("You should log in first");
    }
    public static void tweet(String tweet)
    {
        if(menuAccess)
        {
            ArrayList<String> userLikeTweet=new ArrayList<>();
            tweet tweetObj=new tweet();
            Date date=new Date();
            tweetObj.setUser(getUserName());
            tweetObj.setTweetID(tweetsID);
            tweetObj.setTweet(tweet);
            tweetObj.setLike(0);
            tweetObj.setDate(date.toString());
            tweets.add(tweetObj);
            like.put(tweetsID,userLikeTweet);
            tweetsID++;
        }
        else
            System.out.println("You should log in first");
    }
    public static void timeLine()
    {
        if (menuAccess) {
            ArrayList<String> followings = new ArrayList<>();
            for (String userThatFollow : follows.keySet()) {
                if (userThatFollow.equals(user.getUserName()))
                    followings = follows.get(userThatFollow);
            }
            followings.add(user.getUserName());
            for (int j = tweets.size() - 1; j >= 0; j--) {
                for (String following : followings) {
                    if (tweets.get(j).getUser().equals(following)) {
                        System.out.println("username=" + tweets.get(j).getUser());
                        System.out.println("tweet:" + tweets.get(j).getTweet());
                        System.out.println("tweet ID:" + tweets.get(j).getTweetID());
                        System.out.println("tweet like:" + tweets.get(j).getLike());
                        System.out.println("tweet date:" + tweets.get(j).getDate());
                        System.out.println();
                    }
                }
                followings.remove(user.getUserName());
            }
        }
        else
            System.out.println("You should log in first");
    }
    public static void bio(String userBio)
    {
        if(menuAccess) {
            for (String user:bio.keySet())
            {
                if (user.equals(userBio))
                    System.out.print("Bio:"+bio.get(user));
            }
        }
        else
            System.out.println("You should log in first!!");
    }
    public static void logOut()
    {
        String user=null;
        eyd.user.setUserName(user);
        menuAccess =false;
        System.out.println("You loggd out successfully");
    }
    public static void editbio(String newBio)
    {
        if(menuAccess) {
            for (String users:bio.keySet())
            {
                if (users.equals(user.getUserName()))
                {
                    bio.put(user.getUserName(), newBio);
                    System.out.println("Your bio is:" + newBio);
                }
            }
        }
        else
            System.out.println("You should login at first!!");
    }
    public static void help()
    {
        System.out.println("signup    username  password");
        System.out.println("login     username  password");
        System.out.println("follow    username");
        System.out.println("unfollow  username");
        System.out.println("following");
        System.out.println("follower");
        System.out.println("tweet     new tweet");
        System.out.println("myprofile");
        System.out.println("profile   username");
        System.out.println("like      tweetID");
        System.out.println("timeline");
        System.out.println("editbio   bio");
        System.out.println("bio       username");
        System.out.println("logout");
        System.out.println("quit");
    }
}