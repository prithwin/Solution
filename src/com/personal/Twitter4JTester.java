package com.personal;

import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.util.Arrays;

/**
 * Created by prajeev on 11/8/16.
 */
public class Twitter4JTester {

    public static void main(String[] args) throws Exception{

        //Your Twitter App's Consumer Key
        String consumerKey = "UlCgkGLcgBDR2sBKCPyd3mxyG";

        //Your Twitter App's Consumer Secret
        String consumerSecret = "phc9EkHW5BwUWEBSwIdxlzKR7KtNdJQDr5Xi6Gqy3oKnHDoFkA";

        //Your Twitter Access Token
        String accessToken = "31375220-VBU0HXsHCnWX7L9tI38kCyoDQPi2JN5mj0ubTv3hG";

        //Your Twitter Access Token Secret
        String accessTokenSecret = "IfQbs5l7ZqCCeZPfbYZW4dXKc0Cz4cLEqS0TiTCpgsBeb";

        //Instantiate a re-usable and thread-safe factory
        TwitterFactory twitterFactory = new TwitterFactory();

        //Instantiate a new Twitter instance
        Twitter twitter = twitterFactory.getInstance();

        //setup OAuth Consumer Credentials
        twitter.setOAuthConsumer(consumerKey, consumerSecret);

        //setup OAuth Access Token
        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));

        //Instantiate and initialize a new twitter status update
        StatusUpdate statusUpdate = new StatusUpdate(
                //your tweet or status message
                "Hello World - Java + Twitter API");
        //attach any media, if you want to
//        statusUpdate.setMedia(
//                //title of media
//                "http://simpledeveloper.com"
//                , new URL("https://si0.twimg.com/profile_images/1733613899/Published_Copy_Book.jpg").openStream());

        //tweet or update status
        Status status = twitter.updateStatus(statusUpdate);

        //response from twitter server
        System.out.println("status.toString() = " + status.toString());
        System.out.println("status.getInReplyToScreenName() = " + status.getInReplyToScreenName());
        System.out.println("status.getSource() = " + status.getSource());
        System.out.println("status.getText() = " + status.getText());

        System.out.println("status.getURLEntities() = " + Arrays.toString(status.getURLEntities()));
        System.out.println("status.getUserMentionEntities() = " + Arrays.toString(status.getUserMentionEntities()));
    }


}
