package eyd;

import java.util.Scanner;
import static eyd.menu.*;

public class Twitter
{
    static Scanner in = new Scanner(System.in);
    static Boolean menuAccess = false;
    public static void main(String[] args)
    {
        while(true)
        {
            String[] arg = in.nextLine().split(" ");
            String input = arg[0].toLowerCase();
            switch (input)
            {
                case "signup":
                    if(arg.length==3)
                        signUp(arg[1], arg[2]);
                    else
                        System.out.println("if you need help,type help");
                    break;

                case "login":
                    if(arg.length==3)
                        logIn(arg[1], arg[2]);
                    else
                        System.out.println("if you need help,type help");
                    break;

                case "quit":
                    if (arg.length==1)
                        System.exit(0);
                    else
                        System.out.println("if you need help,type help");
                    return;

                case "follow":
                    if(arg.length==2)
                        follow(arg[1]);
                    else
                        System.out.println("if you need help,type help");
                    break;

                case "unfollow":
                    if(arg.length==2)
                        unfollow(arg[1]);
                    else
                        System.out.println("if you need help,type help");
                    break;

                case "follower":
                    if (arg.length==1)
                        follower();
                    else
                        System.out.println("if you need help,type help");
                    break;

                case "following":
                    if (arg.length==1)
                        following();
                    else
                        System.out.println("if you need help,type help");
                    break;

                case "myprofile":
                    if(arg.length==1)
                        myProfile();
                    else
                        System.out.println("if you need help,type help");
                    break;

                case "timeline":
                    if (arg.length==1)
                        timeLine();
                    else
                        System.out.println("if you need help,type help");
                    break;

                case "profile":
                    if(arg.length==2)
                        profile(arg[1]);
                    else
                        System.out.println("if you need help,type help");
                    break;

                case "tweet":
                    Boolean repeat=true;
                    while(repeat) {
                        String s = "";
                        for (int i = 1; i < arg.length; i++)
                            s = s + arg[i] + " ";
                        if (s.length() > 141)
                            System.out.println("Your Tweet has more than 140 characters. \n Re-enter your Tweet");
                        else
                        {
                            tweet(s);
                            repeat=false;
                        }
                    }

                    break;

                case "like":
                    if(arg.length==2)
                    {
                        like(arg[1]);
                    }
                    else
                        System.out.println("if you need help,type help");
                    break;

                case"editbio":
                    boolean reepeat=true;
                    while(reepeat) {
                        String biog = "";
                        for (int i = 1; i < arg.length; i++)
                            biog = biog + arg[i] + " ";
                        if (biog.length() > 41)
                            System.out.println("Your bio has more than 40 characters. \n Re-enter your bio");
                        else {
                            editbio(biog);
                            reepeat=false;
                        }
                    }
                    break;

                case"bio":
                    if(arg.length==2) {
                        bio(arg[1]);
                    }
                    else
                        System.out.println("if you need help,type help");
                    break;

                case"help":
                    if (arg.length==1)
                        help();
                    else
                        System.out.println("if you need help,type help");
                    break;

                case "logout":
                    if (arg.length==1)
                        logOut();
                    else
                        System.out.println("if you need help,type help");
                    break;

                    default:
                        System.out.println("if you need help,type help");
                        break;
            }
        }
    }
}