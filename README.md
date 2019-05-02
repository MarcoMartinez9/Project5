# Project5

In Project 5, the objective of this programming was to implement a program where grpahics content
will be used to calculate different types of Hamming Distances. While doing this project, I would 
get a better understanding of Java Graphical User Interface (GUI).

The first thing I did was create a HammingDistance class that would get the Hamming Distance of
two specific stations. This class will be used to find the hamming distance and help the graphic
content to split the differences in distance.

The second thing I did implement the HammingDistPanel class that would set up a JFrame and make it 
look like the demo that was given. Many JLabels, JButtons, and etc. were used to set up the JFrame.

The constructor in the HammingDistPanel was used to implement the actual JFrame and its compenents.

The main method was used to called the constructor and ran the JFrame.

The readFile() was used to read in the file from Mesonet.txt and store it into an ArrayList<String> 
  that would be used in the JSlider.
  
 The stateChanged(ChangeEvent arg0) method was used to change the value of the entered Hamming Distance everytime the user moved the JSlider around.
 
 The actionPerformed(ActionEvent e) method is the method that cause an action whenever a button was 
 pressed on the JFrame. This was really important because it gave all the buttons functionalities.
 
 For my own idea, I decided to calculate the Ascii Average of the given station and find simlar stations
 who had the same average.
 
 The MesoAsciiAbstract class was used as the abstract for MesoAscii class that would calculate the
 avereage Ascii Code of the specific station and return it. I used these classes to calculate the average and find the similarity average between stations. The MesoStation class was also used to get
 the specific station ID.
 
