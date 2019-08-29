package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet(name = "ImageServlet", urlPatterns = "/images")

public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Gson GSON = new Gson();
	
	private static final JsonArray imageArray = new JsonArray();
	
	private static final String[] imageUrls = {"https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg?format=tiny",
			"https://images.pexels.com/photos/2607544/pexels-photo-2607544.jpeg?format=tiny",
			"https://images.pexels.com/photos/1851164/pexels-photo-1851164.jpeg?format=tiny",
			"https://images.pexels.com/photos/1741205/pexels-photo-1741205.jpeg?format=tiny",
			"https://images.pexels.com/photos/290204/pexels-photo-290204.jpeg?format=tiny",
			"https://images.pexels.com/photos/895259/pexels-photo-895259.jpeg?format=tiny",
			"https://images.pexels.com/photos/220938/pexels-photo-220938.jpeg?format=tiny",
			"https://images.pexels.com/photos/53966/rabbit-palm-hand-snatch-53966.jpeg?format=tiny",
			"https://images.pexels.com/photos/485294/pexels-photo-485294.jpeg?format=tiny",
			"https://images.pexels.com/photos/1619690/pexels-photo-1619690.jpeg?format=tiny",
			"https://images.pexels.com/photos/2664417/pexels-photo-2664417.jpeg?format=tiny",
			"https://images.pexels.com/photos/126407/pexels-photo-126407.jpeg?format=tiny",
			"https://images.pexels.com/photos/1591939/pexels-photo-1591939.jpeg?format=tiny",
			"https://images.pexels.com/photos/1390784/pexels-photo-1390784.jpeg?format=tiny",
			"https://images.pexels.com/photos/1383397/pexels-photo-1383397.jpeg?format=tiny",
			"https://images.pexels.com/photos/1521304/pexels-photo-1521304.jpeg?format=tiny",
			"https://images.pexels.com/photos/37337/cat-silhouette-cats-silhouette-cat-s-eyes.jpg?format=tiny",
			"https://images.pexels.com/photos/326012/pexels-photo-326012.jpeg?format=tiny",
			"https://images.pexels.com/photos/407037/gecko-reptile-terrarium-lizard-407037.jpeg?format=tiny",
			"https://images.pexels.com/photos/886210/pexels-photo-886210.jpeg?format=tiny",
			"https://images.pexels.com/photos/56733/pexels-photo-56733.jpeg?format=tiny"};
	
	private static final String[] imageTitles = {"Tim & Jim",
			"Barky Spears",
			"Pickles",
			"Woody",
			"Mathis",
			"Bucky",
			"Montana",
			"Smol",
			"Frito",
			"Benny",
			"Len",
			"Sasha",
			"Dottie",
			"Moose",
			"Duchess",
			"Hagrid",
			"Midnight",
			"Marten",
			"Sandy",
			"Rupert",
			"Polly"};
	
	private static final String [] imageDescriptions = {"The best buds that anyone could have",
			"Woof! I did it again",
			"Judging you for dropping the ball",
			"Lost the laser pointer a while ago but still trying to play along",
			"Beautiful, but not easily fooled by your ploys to distract her from her upcoming meal.",
			"Here to remind you that not all heros wear caps...some are just Dachshunds",
			"Got her eyes on that prize...peanut butter",
			"His name is Smol because he is just that...smol",
			"Bathtime isn't his favprote but he's tolerant.",
			"Strong genetic predispositon for mailmen suspicion.",
			"Strengths: sitting on command for treats. Weaknesses: Fear of thunder.",
			"She's beauty... she's grace... she might attack your face...",
			"Just always having too good a time...you can take her anywhere...wags her tail with unparalleled force.",
			"Loves: walks down the street and belly rubs. Hates: whenever the door bell rings.",
			"Tolerates being held. Consistently gets the zooms between 2 to 3 am.",
			"Don't let his size intimidate you. The sweetest bug around.",
			"Talented at Hide & Seek. Excellent hunter.",
			"Senior Bun. Loves Cilantro.",
			"Often found on warm rocks.",
			"Endurance athlete with occasional sprints to the retrieve the daily feed.",
			"Excellent imitator. Dislikes being patronized with crackers."};
	
	static{
		for(int i = 0; i < imageUrls.length; i++){
			JsonObject imageObject = new JsonObject();
			imageObject.addProperty("title", imageTitles[i]);
			imageObject.addProperty("description", imageDescriptions[i]);
			imageObject.addProperty("url", imageUrls[i]);
			imageObject.addProperty("created", new Date().toString());
			imageArray.add(imageObject);
		}
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(GSON.toJson(imageArray));
	}
}
