

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class ExtractTweets {

	public void retrieve(HttpServletResponse response) {
		// TODO Auto-generated method stub
		try
		{
			PrintWriter out = response.getWriter();
			GeoLocation geo = new GeoLocation(20.545024, 79.980469);
			Query query1 = new Query().geoCode(geo, 40, "mi");
			Twitter twitter = new TwitterFactory().getInstance();
			QueryResult result1 = twitter.search(query1);
			//int i = 1;
			List<Status> s = result1.getTweets();
			for(Status tweet : s) {
				out.println(tweet.getText());
				out.println("<br>");
			}
			/*for (Tweet tweet3 : result1.getTweets()) {
			out.println("<img src='" + tweet3.getProfileImageUrl() + "'>"
			+ "<b>(" + i + ") " + tweet3.getFromUser() + "("
			+ tweet3.getCreatedAt() + ")" + "</b>" + " : "
			+ tweet3.getText() + "<br/>");
			i++;
			}*/
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(TwitterException t)
		{
			t.printStackTrace();
		}
		
	}

}
