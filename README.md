# Stock Market Data App

## Overview
This Android application, developed in Java, allows users to access and visualize stock market data retrieved from the Tiingo API. It offers a user-friendly interface where users can search for stock tickers with auto-suggestion features, making it easier to find and select companies of interest. Once a company is selected, users can choose specific time intervals to view the stock information on a custom-designed chart. Additionally, the app displays the latest stock data and detailed company information, providing users with comprehensive insights into their chosen stocks.

## Features

- **Stock Ticker Search with Auto-Suggestion:** Users can easily search for stocks using tickers. The auto-suggestion feature helps in quickly finding the desired company without needing to type the full ticker name.
  
- **Custom Time Interval Selection:** After selecting a stock, users can specify a time range to view the stock's performance. This feature allows for a customized analysis of stock trends over selected periods.
  
- **Custom-Designed Chart:** The app presents stock data on a specially designed chart, enhancing the visualization of stock performance over time.
  
- **Latest Stock Data:** Users receive the most recent stock information, including price, volume, and other relevant data, ensuring they have access to the latest market conditions.
  
- **Company Information:** Detailed information about the company behind the stock ticker is displayed, offering insights into the company's background, financials, and market position.

## Architecture

### Backend
- **Language:** Java
- **Data Source:** Utilizes the Tiingo API to fetch stock market data, including historical and latest stock information.
- **Functionality:** Handles requests from the Android frontend, processes them to fetch the required data from the Tiingo API, and formats this data before sending it back to the frontend.

### Frontend
- **Platform:** Android
- **User Interface:** Provides a sleek and intuitive interface for users to interact with the application. The design focuses on ease of use, with clear navigation and interactive elements to ensure a positive user experience.

## Getting Started

### Prerequisites
- Android Studio or any compatible Android development environment.
- Java Development Kit (JDK).

### Setup
1. **Clone the repository:** First, clone this repository to your local machine using Android Studio or your preferred Git client.
   
2. **API Key:** Obtain an API key from Tiingo by signing up on their website. You'll need this key to fetch data from their service.

3. **Configure the API Key:** Place your Tiingo API key.

4. **Build the Project:** Use Android Studio to build the project and resolve any dependencies.

5. **Run the App:** Finally, run the app on an Android emulator or a real device to start exploring stock market data.

## Usage

- **Search for Stocks:** Start typing the ticker in the search bar, and select your company from the auto-suggestions.
- **Select Time Interval:** Choose your desired time interval for data visualization on the chart.
- **View Stock and Company Information:** Get the latest stock data and read about the company directly within the app.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.

