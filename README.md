# Programming II Application
## About
This repository includes a java Social Media Application which constitutes the semester project for the *Programming II* class 
## Building

Run `mvn clean compile assembly:single`

## Running

Run `java -jar "../target/our-social-media-app-1.0-jar-with-dependencies.jar"`.

## Usage
1. A Welcome Message and the Main Menu is printed in the command line after running
2. The user makes a selection from the menu (Sign-up, Login, or Exit). All selections are made inputting the corresponding selections number in the terminal
3. If his selection is Sign-up, the sign-up process initiates and he inputs his personal information following the on-screen instructions
4. If his selection is Login, the login process initiates and he is asked to input his credentials. _For steps 3 and 4, there is a validation process for inputs which must match specifics_
5. If his Selection is Exit, then the Application prints a goodbye message and terminates after 30 seconds.
6. When the user has signed-up or logged-in, the home menu is displayed and he is asked to make a selection in order to proceed. The screen differs depending on the declaration of the type of user

## Contributing
- Feel free to contribute your ideas or suggestions by opening an issue
- Make sure to keep in mind what is stated in [CONTRIBUTING.md](https://github.com/AnnaMariaDimareli/Java2/blob/main/CONTRIBUTING.md)