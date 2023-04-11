CalculatorWireless App

The CalculatorWireless App is a simple calculator app developed for Android devices using Android Studio. The app is designed to perform basic mathematical operations such as addition, subtraction, multiplication, and division.

Architecture

The app architecture follows the Model-View-Controller (MVC) pattern. The Model is represented by the server-side application that performs the requested mathematical operation and returns the result. The View is the graphical user interface of the app, while the Controller is the activity that mediates communication between the View and the Model.

Functionality

The app allows the user to input two integer numbers and select an operation to perform using RadioButtons. When the "Calculate" button is clicked, the app sends a GET request to the server using the selected operation and the input numbers as parameters. The server performs the calculation and returns the result as an XML response. The app then parses the response using an XmlPullParser to extract the result value and display it in a EditText view.

Technical details

The app uses the Volley library to handle the HTTP request/response communication with the server. The server is hosted at "https://tc.heiz.cc/Calcolatrice/" and provides RESTful services for the four operations using the following URI paths: "add", "sub", "mul", "div". The server returns the result of the requested operation as an XML response containing a "result" element.

The app validates the input values by parsing them as integers using the Integer.parseInt() method. In case of invalid input values, the app displays a toast message notifying the user that the result is not a valid number.

Conclusion

The CalculatorWireless App is a simple and useful app for performing basic mathematical operations on Android devices. The app architecture follows the MVC pattern, and the communication with the server is handled using the Volley library.
