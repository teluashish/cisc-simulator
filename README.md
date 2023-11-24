# cisc-simulator

# Instruction Manual (Team 6 - Single Person Team)

The project contains a .jar file which when executed opens a panel to enter Instructions load and store values at a specific address in Main Memory and perform Load and Store operations through Common Bus.

## Use the following command to display the front panel (CISC_Simulator):

![image_page_1_5 (1)](https://github.com/teluashish/cisc-simulator/assets/66863362/40533a70-ad8f-44d5-802e-d39f72eaf51a)

### CISC Simulator Front Panel:

All the values are entered and displayed in the binary format.

### To execute an Instruction:

- Click on IPL to load the initial program into Main Memory and enter the instruction in binary format then click Run button.
- The above example instruction loads into register R3 the value stored in the main memory at address (1111)base2 or 15.
- Clicking on load button next to the register loads the corresponding register with the value entered in the common bus.

#### Example of executing the instruction: “0000011100001111”

Main Memory Interface allows us to interact directly with the memory and perform Memory load and store operations.

#### Input and Output Text Field Boxes:
Allow users to interact with the command line interface.

#### Cache Scroll Pane:
Shows the representation of FIFO(queue) storing the data which follows Most Recently Used Policy. If the data to be accessed is not present in the cache we read it from the main memory and store it in the cache. Each "Tag" points to a block of memory "m" and "Data" stores values at "m" locations.

## Program 1: (Click on IPL before starting the program)

### Input:
a) Enter 20 numbers in the console Input each followed by a comma "" and a number. Last number is also followed by a comma ""
b) Enter a single number followed by a comma ""

### Output:
A number contained in the input which is closest to the number entered from Input b).

- After entering 20 numbers click on Read(nums: 20) button to read the entered numbers.
- Enter a single number in the Input console then press Find Closest button to execute the program 1 and find the closest number number.

## Project Part - 3

New buttons and functionality added for program 2 which reads sentences and finds the input word in those sentences

## Program 2: (Click on IPL before starting the program)

### Input:
Click on "Load Sentences" button. After that enter a word into Console Input and press Find Word Button.

### Output:
Word Number and Sentence number is printed on the console output.

- Click on Load Sentences button to load the sentences into main memory
- Enter a single word into the Console Input
- Press Find Word Button

As you can see in the console output the word unknown in the current example is 15th word in the 2nd sentence.


