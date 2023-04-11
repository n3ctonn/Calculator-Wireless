CALCULATOR WIRELESS

This is a code written in Java for an Android application that implements a wireless calculator that sends a request to the server via the HTTP protocol to perform an arithmetic operation and receive the result.

The MainActivity class extends the AppCompatActivity class and is used to define application behavior. In the onCreate method, the layout of the application is set using the activity_main.xml XML file. The EditText objects for the two input numbers, the EditText object for the result, and the RadioButtons to select the operation are then initialized. The button to submit the request is also initialized.

Inside the submit button listener, the values ​​of the two input numbers and the operation selected by the RadioButton are read. These values ​​are then used to construct the HTTP request URL which is sent to the server using the Volley library. The response from the server is then parsed using the XMLPullParser parser to extract the result of the operation. The result is then converted to a string and displayed in the EditText object for the result.

The activity_main.xml XML file defines the user interface of the application. It contains a TextView for the application title, two EditTexts for input numbers, a RadioGroup to select the operation and a Button to send the request.
Socket programming for the wireless feature
The application uses a client-server model for the wireless feature. When a user launches the calculator, they become the server and wait for other users to connect. Other users can then connect to the server and perform calculations on the same instance of the calculator.

License
This project is licensed under the MIT License. You can find more information in the LICENSE file.
