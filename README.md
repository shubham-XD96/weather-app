# weather-app
# 🌦 Weather App (Java Web Project)

A simple and interactive *Weather Application* built using *HTML, CSS, JavaScript (frontend)* and *Java JSP & Servlet (backend)*.  
It fetches real-time weather data (via API) and displays it in a clean, user-friendly interface.  

---

## 🚀 Features

- ✅ Search weather by *city name*  
- ✅ Real-time weather data (temperature, humidity, wind speed, etc.)  
- ✅ Modern UI with *HTML, CSS & JavaScript*  
- ✅ Backend handled using *JSP & Servlets*  
- ✅ API integration for live weather updates  
- ✅ Responsive and simple design  

---

## 📂 Project Structure

WeatherApp/
├── src/
│ └── com.weatherapp/
│ ├── WeatherServlet.java
│ └── WeatherUtils.java
├── WebContent/
│ ├── index.jsp
│ ├── result.jsp
│ ├── css/
│ │ └── style.css
│ ├── js/
│ │ └── script.js
│ └── WEB-INF/
│ └── web.xml
└── README.md

yaml
Copy
Edit

---

## ⚡ Installation & Setup

### 1️⃣ Clone the repository
```bash
git clone https://github.com/shubham-XD96/weather-app-java.git
cd weather-app-java
2️⃣ Import into IDE
Open Eclipse / IntelliJ

Import as a Dynamic Web Project

3️⃣ Configure Server
Add project to Apache Tomcat (or any Java EE server).

Make sure web.xml is properly configured with the servlet mapping.

4️⃣ Run Project
Start the server

Open in browser:
👉 http://localhost:8080/weather-app

🛠 Usage
Enter the city name in the search box.

Submit → Backend servlet fetches weather data via API.

JSP page displays the formatted weather results.

💡 Example
Input: London

Output:

🌡 Temperature: 15°C

💧 Humidity: 72%

🌬 Wind Speed: 5.2 km/h

🔧 Built With
Frontend: HTML5, CSS3, JavaScript

Backend: Java, JSP, Servlet

Server: Apache Tomcat

Weather API: OpenWeatherMap (or any other)

👨‍💻 Author
Shubham prakash ✨
Feel free to fork, contribute, and enhance this project 🚀
