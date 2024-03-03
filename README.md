# JP (Java Programming)
Java programming is a robust and versatile programming language known for its portability and ability to build scalable applications. Being an object-oriented language, Java provides programmers with a clear and modular structure for developing applications. It is used in a wide variety of areas, from web and mobile application development to enterprise applications and embedded systems. The labs will provide an opportunity to familiarize yourself with the basic concepts of the Java language and develop your programming skills through hands-on exercises and application projects.

## Laboratory 1 - Basic Concepts of Object-Oriented Programming
1. It is required to write a Java program that calculates and displays the perimeter and area of a rectangle. The values for length and width are read from the keyboard. Add a break point on the first line that reads the value of one side and from that point run the program line by line following the values of the variables in memory.

2. Write a program that reads a set of numbers from the input file in.txt. The program will determine their sum, arithmetic mean, minimum value, maximum value, display these values on the screen and write them to the output file out.txt. The arithmetic mean will be displayed as a real number.

3. Write a program that reads a natural number n from the keyboard and displays all its divisors on the screen. If the number is prime, a corresponding message will be displayed.

4. To determine the cmmdc of two natural numbers, whose maximum value is 30. The numbers will be randomly generated using an object of type Random and the method nextInt();

5. Write a program that randomly generates an integer between 0 and 20. The program will determine whether the number belongs to the Fobonacci sequence.

## Laboratory 2 - Component of a Class. Creation and Initialization of Objects. Arrays
1. The function ![picture alt](https://github.com/victorcb0/JP/blob/main/Imagini/1.png) has as a graph a parabola with the coordinate vertex ![picture alt](https://github.com/victorcb0/JP/blob/main/Imagini/2.png).
It is required to define a Parabola class whose members will be:
- 3 double variables that represent the coefficients a, b and c
- a constructor with 3 double parameters
- a constructor with a Parabola type parameter
- a method of displaying the function in the form: ![picture alt](https://github.com/victorcb0/JP/blob/main/Imagini/3.png)
- a method for calculating the coordinates of the vertex
- a static method that receives as parameters two parabolas and calculates the coordinates of the middle of the right segment that joins the vertices of the two parabolas as follows: ![picture alt](https://github.com/victorcb0/JP/blob/main/Imagini/4.png), where ![picture alt](https://github.com/victorcb0/JP/blob/main/Imagini/5.png) are the coordinates of the vertex of the first parabola, and ![picture alt](https://github.com/victorcb0/JP/blob/main/Imagini/6.png) describe the vertex of the second parabola. In addition to the Parabola class, a MainApp class will be defined that will exemplify the use of the methods of the Parabola class.

2. Write a program that reads from a text file information about the products in a store. On each line there is: the name of the product, the price (real number) and the quantity (real number). The three elements are separated by the character ";" (sugar; 1.5; 50). The program will display, in the form of a table, the content of the file and will determine the name, price and quantity of the product with the minimum and maximum price that it will write in a destination file. The program will display on the screen the products for which the quantity is lower than a value read from the keyboard. A Product class will be defined that contains as member data the three elements that describe a product. To print the required information, a toString() method will be provided in the Product class. The member variables of the Product class will be private and the class will be provided with at least one constructor. For each product in the file, a Product type object will be created.

## Laboratory 3 - Strings of Characters. Comparing Objects. Wrapping Classes
1. The cantec_in.txt file contains the lyrics of a song of your choice. Write a program that creates the cantec_out.txt file, which contains the lyrics of the original song, but in addition, the number of words per line and the number of vowels per line are displayed next to each line. An asterisk (*) will be placed next to the lines that end with a chosen group of letters. The rows for which a randomly generated number is lower than 0.1 will be written in capital letters (random numbers between 0 and 1 will be generated). We will define a Verse class, which has a private member variable a string representing the verse, and develop an operator for each of the above requirements (a method that returns the number of words, a method that returns the number of vowels, etc.).

2. To insert into a specific position of a character string, another string. The data will be taken from the keyboard or from the file. Delete a portion of a string that starts at a given position and has a given number of characters. It is recommended to use the StringBuilder class.

3. The file judete_in.txt contains the unordered list of counties in the country. Load the data from the file into an array of Strings and sort this array using the sort() method of the Arrays class. To return at which position in the oronated vector a county entered from the keyboard is located. The binary search method from the Arrays class will be used.

4. The in.txt file contains a list of a student's favorite songs. For each song, remember: song_name; artist_name; an_release; number_of_youtube_views. To create a program that:

a) load the information about the songs in the program, in a vector of objects. The Melody class will be created with private member variables, constructor with parameters, getters for member variable access

b) displays the information of the uploaded songs

c) displays the ranking of the songs in descending order of the number of views on youtube

d) displays all the songs of an artist

## Laboratory 4 - Strings of Characters. Comparing Objects. Wrapping Classes
1. The proposed problem tries to give a hand in the product management of a company that sells electronic equipment. Each piece of equipment is registered with a name, an inventory number nr_inv, has a price and is placed in a specific area of the mag_zone warehouse. Any equipment can be in one of the following situations:
- purchased (entered the warehouse);
- displayed (displayed in the store);
- sold (transported and installed to the customer).

The company sells several types of equipment. All equipment that uses paper as a consumable is characterized by the number of pages written per minute ppm. Printers are characterized by resolution (number of dots per inch dpi) and number of pages/cartridge p_car. A printer can be set to write mode:
- printColor (selection of color printing mode);
- printing Black and White (selecting the black and white printing mode).

Copiers are characterized by the number of pages/toner p_ton. The format can be set copy:
- setFormatA4 (setting the A4 format);
- setFormatA3 (setting the A3 format).

Computer systems have a monitor of a certain type type_mon, a processor of a certain speed vit_proc, a capacity of HDD c_hdd and can be installed one of the following operating systems:
- instalWin (installation of a version of Windows);
- installLinux (installation of a Linux variant).

The methods above will set the appropriate parameters.

To realize the hierarchy of classes corresponding to the presented model; To create ONE VECTOR OF OBJECTS in which the data from the electronice.txt input file will be retrieved. A menu will be developed that will offer the following facilities:
- Display of printers
- Display of copiers
- Display of calculation systems
- Changing the state in which a piece of equipment is located
- Setting a specific write mode for a printer
- Setting a copy format for copiers
- Installing a particular operating system on a computer system
- Display of sold equipment
- Make two static methods for serializing / deserializing the collection of objects in the equipment.bin file

## Laboratory 5 - Strings of Characters. Comparing Objects. Wrapping Classes
1. It is requested to model the activity of several bank counters. The system consists of the following entities, with the corresponding attributes:

- The bank
  - bank_name (String)
  - clients (collection of objects of type List<Client>)

- Customer
  - name (String)
  - address (String)
  - accounts (collection of objects of type Set<BankAccount>; a customer must have at least one account, but no more than five accounts)

- Bank account
  - numberAccount (String)
  - sum(float)
  - currency (String)
  - opening_date (Calendar)
  - last_operation_date (Calendar)

Bank accounts can be in RON and EUR. For accounts in RON, the interest is calculated as follows: 0.3 RON per day for amounts below 500 RON and 0.8 RON per day for larger amounts.

Accounts in EUR have an interest of 0.1 EUR per day.

All accounts implement an Operations interface that has the methods:
- public float calculate_interest() – calculates the number of days elapsed from the date of the last operation on the account to the current date. The number of days obtained is used for interest calculation as mentioned above
- public float update_amount() – adds to the amount in the account the interest corresponding to the number of days that have passed, updates the date of the last operation and returns the amount
- public void deposit(float amount) – updates the amount, the date of the last operation and adds the deposited amount to the existing amount
- public void extract (float amount) – updates the amount, the date of the last operation and subtracts the deposited amount from the existing amount

All classes will have constructors and methods for processing and displaying member data. We will redefine the toString() method in each class so that it returns a String that represents the values of the member variables in that class.

Also, a Bank Customers class will be created, which contains the main program that offers the following menu:
1. Add banks, customers, accounts. The banks will be inserted into a collection of Vector<Bank> type objects (the Vector class will be used).
2. Display entered data
3. Depositing an amount into an account
4. Withdrawal of an amount from an account
5. Money transfer between two accounts

Data can be retrieved from the keyboard or from the file.

## Laboratory 8 - Development of GUI Applications in Java – The Swing Library
1. Make a desktop GUI application. Exceptions that may occur will be handled by displaying appropriate messages (eg: Divide by 0, missing value, invalid value - if letters are entered instead of numbers). After completing the application, the runnable jar file will be created, using the command File > Export > Java > Runnable jar file. Choose the main class for the Launch configuration option and specify the location and name of the jar file that will be created through Export destination. The created jar file is run by double clicking.

(https://github.com/victorcb0/JP/blob/main/Imagini/7.png)

2. Create an application with a similar graphical interface.
The name of a formation is entered in the text box and then the enter key is pressed, an action that causes the name of the formation to be added to the JList box below. Pressing the delete button causes the deletion of the formations selected in the JList box (multiple deletion).

(https://github.com/victorcb0/JP/blob/main/Imagini/8.png)

3. To create an application that allows the introduction of films released in the last 5 years and their display in tabular format. The application will have a similar graphical interface.

(https://github.com/victorcb0/JP/blob/main/Imagini/9.png)

## Laboratory 9 - Java Database Connectivity (JDBC) and MySQL
1. To create in the "test" MySQL database a table "people" with the fields id (integer primary key), name (varchar), age (integer). A Java application will be created, which will connect to the MySQL database using JDBC technology (theoretical support is in progress) and will perform the primary operations on the people table: query, insert, search, delete and update.

(https://github.com/victorcb0/JP/blob/main/Imagini/10.png)

- The arrows will allow navigation among the records in the people table (positioning on the first record, on the previous record, on the next record, respectively on the last record). If we are on the first record, the left navigation buttons will be disabled. Symmetrically, the navigation buttons to the right will be used.
- The text box in the JToolBar, will display the number of the current record and the total number of records
- Add, edit, delete, search, save and quit commands will be implemented
- Two states will be implemented:
  - State 1 – in which you can navigate among the elements and give the add, edit, delete commands
  - State 2 - reached if the user chooses add or edit, where the only active options are save or quit (see figure 8.2).

(https://github.com/victorcb0/JP/blob/main/Imagini/11.png)

- The deletion will be carried out only after an additional confirmation message

(https://github.com/victorcb0/JP/blob/main/Imagini/12.png)

- The name of the person being searched for will be entered in a window of type showInputDialog()

(https://github.com/victorcb0/JP/blob/main/Imagini/13.png)

## Laboratory 10 - Processing of XML Documents
1. To develop an application with a graphical interface that allows connecting to XML documents and displaying them in tree form, in a JTree control. Only the tags and the texts between the tags will be displayed, without attributes. Document Object Model (DOM) technology will be used to exploit XML. Processing XML documents in the course.

(https://github.com/victorcb0/JP/blob/main/Imagini/14.png)

Pressing the Open XML button will cause a JFileChooser window to be displayed. The window will be configured so that it only allows the opening of XML documents and when the Open XML button is pressed, the contents of the project folder will be displayed by default. The optional.xml and studenti.xml files will be used as test files.

(https://github.com/victorcb0/JP/blob/main/Imagini/15.png)

In the main window, in the upper right corner, the time read from the system will be displayed in a JLabel type box in the format oo:mm:ss. The display will be like a clock, you will see the seconds change, then the minutes change, etc. For this, a Timer configured to generate an interrupt every second will be used. In the interrupt handling routine, the time is read from the system and updated in the JLabel box.

A recursive approach is recommended for xml mining. Nodes in JTree are of type DefaultMutableTreeNode.

## Laboratory 11 - Java 8
1. Create an employees table in the test database using MySQL Workbench.
The table will have the columns:
- id - primary key and autoincrement of type int
- name of type varchar(20)
- position of type varchar(20)
- data_employment data type
- the float type salary

Using MySQL Workbench, enter the data of 5 people into the employees table.

In Java, the Employee class will be constructed with the following member variables:
- id (int)
- name (String)
- post (String)
- date of employment (LocalDate)
- salary (float).

The class will have a constructor with parameters, getters and setters for member variable access and will redefine the toString method from the Object class so that it returns a String with the values of the member variables separated by commas.

Make a program that implements the requirements below using Java 8 facilities (streams, lambda expressions, method references, etc.). The program will achieve the following:
1. Read the employee data from the MySQL table employees and create a List employees collection.
2. Display the created collection (using streams, etc.).
3. Displays employees whose salary is over 2500 RON. The solution will use streams and lambda expressions.
4. Create a list of employees from April, of the current year, who have a management position (the position contains one of the words chief or director). To create a list from a stream, the terminal operation collect (Collectors.toList()) will be used. Strings and lambda expressions will be used. The new list will then be displayed.
5. Display non-management employees (their job title does not contain the words director or boss), in descending order of salary, using streams and lambda expressions.
6. Extract from the list of employees a list of Strings containing the names of the employees written in capital letters (using streams, method references, etc.). The list of Strings will be displayed.
7. Display salaries less than 3000 RON (only salaries, no other information) using lambda expression streams, method references.
