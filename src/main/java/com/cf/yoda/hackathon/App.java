package com.cf.yoda.hackathon;

import java.util.List;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        FacebookClient fbClient = FBClientFactory.facebookClient;
        
        Page page = fbClient.fetchObject("cocacola", Page.class);

       System. out.println("Page likes: " + page.getLikes());
       
       User user = fbClient.fetchObject("me", User.class);

       System.out.println("User name: " + user);

       Connection<User> myFriends = fbClient.fetchConnection("me/friends", User.class);
       Connection<Post> myFeed = fbClient.fetchConnection("me/feed", Post.class);

       System.out.println("Count of my friends: " + myFriends.getTotalCount());
       System.out.println("First item in my feed: " + myFeed.getData().get(0));

       // Connections support paging and are iterable
       
       for (List<Post> myFeedConnectionPage : myFeed)
           for (Post post : myFeedConnectionPage){
        	   System.out.println("post: " + post.getMessage());
        	   System.out.println("description: " + post.getDescription());
        	   System.out.println("likescount: " + post.getId());
        	   
           }
          	 
  
    
    
       System.out.println("size: "+myFriends.toString());
       for (List<User> myFriendConnectionPage : myFriends){
    	   System.out.println("size: "+myFriendConnectionPage.size());
         for (User friend : myFriendConnectionPage)
        	 System.out.println("Friend: " + friend.getName());
       }
}
}
