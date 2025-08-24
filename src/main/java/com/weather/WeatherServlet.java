package com.weather;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//API Setup
		String apiKey = "f9f9c8c743514f2307fa1db9029fd9d1";
		// Get the city from the form input
        String city = request.getParameter("city"); 
        city = URLEncoder.encode(city, "UTF-8"); // ✅ This encodes spaces and special characters

        // Create the URL for the OpenWeatherMap API request
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        
        
        //API Integration
        URL url = new URL(apiUrl);
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        //Reading the data from network
        InputStream inputStream = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        
        //Want to store in string
        
        StringBuilder responseContent = new StringBuilder();
        
        //input lene ke liye from the reader, will create scanner object
            Scanner scanner = new Scanner(reader);
            
            while (scanner.hasNext()) {
                responseContent.append(scanner.nextLine());
            }
            
           scanner.close();
           
           //Typecasting = parsing the data into JSON
        // Parse the JSON response to extract temperature, date, and humidity
           Gson gson = new Gson();
           JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);
           
           //Date & Time
           long dateTimestamp = jsonObject.get("dt").getAsLong() * 1000;
           String date = new Date(dateTimestamp).toString();
           
           //Temperature
           double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
           int temperatureCelsius = (int) (temperatureKelvin - 273.15);
          
           //Humidity
           int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
           
           //Wind Speed
           double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
           
           //Weather Condition
           String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
           
           
           // Set the data as request attributes (for sending to the jsp page)
           request.setAttribute("date", date);
           request.setAttribute("city", city);
           request.setAttribute("temperature", temperatureCelsius);
           request.setAttribute("weatherCondition", weatherCondition); 
           request.setAttribute("humidity", humidity);    
           request.setAttribute("windSpeed", windSpeed);
           request.setAttribute("weatherData", responseContent.toString());
           
           
           connection.disconnect();
           
           // Forward the request to the weather.jsp page for rendering
           request.getRequestDispatcher("index.jsp").forward(request, response);



	}

}
