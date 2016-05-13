package com.cf.yoda.hackathon;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;

public class FBClientFactory {

	private static final String MY_ACCESS_TOKEN = "CAACEdEose0cBAIQbEp2HqLuaVgvRmvOptkm4qUFNXQg20GayLhnjGOhNnqBuvQSRjXCp6Gjr3n9rx5vJivJCc9eCD9XArrJKttyDfSDqCTWPYXLXxyCupI2vVnBuKbw94JTkZC9rkSqNaeldcGJGjDXEXn0PSJbNZAZAsjxqNUOiZCceVg05ywpfrOn7N9JBfMj3DpdWbNs1EWOwTX9J";

	private static final Version MY_APP_SECRET = null;

	
	// DefaultFacebookClient is the FacebookClient implementation
	// that ships with RestFB. You can customize it by passing in
	// custom JsonMapper and WebRequestor implementations, or simply
	// write your own FacebookClient instead for maximum control.

	
	public static FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);

	// It's also possible to create a client that can only access
	// publicly-visible data - no access token required.
	// Note that many of the examples below will not work unless you supply an access token!

	public static FacebookClient publicOnlyFacebookClient = new DefaultFacebookClient();

	// Get added security by using your app secret:

	public static FacebookClient facebookClientWithApp = new DefaultFacebookClient(MY_ACCESS_TOKEN, MY_APP_SECRET);
}
