package controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

public class ExtractURLsController {
	private static final Pattern urlPattern = Pattern.compile("(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)" + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*" + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	private String domain;
	private ArrayList<String> visited;
	
	public ExtractURLsController(String domain) {
		this.domain = domain;
		this.visited = new ArrayList<String>();
	}
	
	private String page(String url) throws IOException, InterruptedException {
		System.out.println("[DOWNLOAD >>] " + url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	
	public void links(String url) throws IOException, InterruptedException {
		if (this.visited.contains(url) || url.indexOf(this.domain) < 0) {
			return;
		}
		this.visited.add(url);
		String body = page(url);
		
		Matcher matcher = urlPattern.matcher(body);
		while (matcher.find()) {
			int matchStart = matcher.start(1);
			int matchEnd = matcher.end();
			String sub_url = body.substring(matchStart, matchEnd);
			if (sub_url.endsWith(".html") || sub_url.endsWith(".htm") || sub_url.endsWith("/")) {
				System.out.println("[+] " + sub_url);
				links(sub_url);
			}
		}
	}
}