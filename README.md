# News Website - Full Stack Application

This is a full-stack news website that fetches top headlines from the NewsAPI and displays them to users. The frontend is built using React, and the backend is powered by Spring Boot. Users can view news articles by category or search for specific news topics.

* Link to the live website: http://newsheadlinesapplication.s3-website.ap-south-1.amazonaws.com/
* Link to the frontend repository: https://github.com/arora-kapil/News-Headlines-Website-Frontend

## Features

- Browse top news headlines by category: Trending, Business, Entertainment, Health, Science, Sports, and Technology.
- Search for news articles based on a user-provided query.
- Displays the news articles with titles, descriptions, and links to the full article.
- Responsive design for both mobile and desktop screens.
- Error handling and loading states to improve user experience.

## Tech Stack

### Frontend
- **React**: A JavaScript library for building user interfaces.
- **Bootstrap**: For responsive design and prebuilt components.
- **CSS**: For additional styling.

### Backend
- **Spring Boot**: Java-based framework for building robust backend services.
- **REST APIs**: Fetch news data by category or search query using the NewsAPI.
- **NewsAPI**: External API that provides news articles based on categories or search terms.

### Hosting & Deployment
- **Frontend**: Hosted on [AWS S3](https://aws.amazon.com/s3/).
- **Backend**: Deployed on [AWS EC2](https://aws.amazon.com/ec2/).

## How It Works

### Frontend
- **Navbar Component**: Allows users to switch between different news categories and perform searches.
- **News Component**: Fetches and displays a list of news articles based on the current category or search query.
- **Search**: Users can search for specific news articles using a search bar in the navbar.
- **Loading & Error States**: Displays loading spinners while fetching data, and error messages in case of failure.

### Backend
- **Spring Boot Controller**: Provides two main endpoints:
  - `/api/news/category?category={category}`: Fetches top headlines for the specified category.
  - `/api/news/search?query={query}`: Searches for news articles based on the query string.
- **Service Layer**: Makes HTTP requests to the NewsAPI and caches the results for better performance.
- **DTOs**: Data Transfer Objects are used to model the API responses.

## Running the Project Locally

### Prerequisites

- **Node.js** and **npm** installed on your machine for the frontend.
- **Java 8+** and **Maven** installed for the backend.
- An API key from [NewsAPI](https://newsapi.org/).

# Backend Setup:
### Navigate to the backend folder:
cd backend

### Add your NewsAPI key to the application.properties file:
news.api.key=YOUR_NEWSAPI_KEY

### Run the Spring Boot application:
mvn spring-boot:run

The backend will be available at http://localhost:8080/api/news.

# API Endpoints
* GET /api/news/category?category={category}: Fetches top headlines for a specific category.
* GET /api/news/search?query={query}: Searches for news articles based on the search query.
