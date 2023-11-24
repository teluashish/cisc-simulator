# cisc-simulator

# Instruction Manual (Single Person Group)

The project contains a .jar file which when executed opens a panel to enter Instructions load and store values at a specific address in Main Memory and perform Load and Store operations through Common Bus.

## Use the following command to display the front panel (CISC_Simulator):

![image_page_1_5 (1)](https://github.com/teluashish/cisc-simulator/assets/66863362/40533a70-ad8f-44d5-802e-d39f72eaf51a)

### CISC Simulator Front Panel:

All the values are entered and displayed in the binary format.

![image_page_1_6](https://github.com/teluashish/cisc-simulator/assets/66863362/01ba83f8-8c67-4409-87b4-023b29b5b14f)


### To execute an Instruction:

- Click on IPL to load the initial program into Main Memory and enter the instruction in binary format then click Run button.

![image_page_2_9](https://github.com/teluashish/cisc-simulator/assets/66863362/ee40d777-af23-43c2-9b5c-34998816ca42)

- The above example instruction loads into register R3 the value stored in the main memory at address (1111)base2 or 15.
- Clicking on load button next to the register loads the corresponding register with the value entered in the common bus.

![image_page_2_10](https://github.com/teluashish/cisc-simulator/assets/66863362/38221b21-684b-48a6-8967-577a238fa89e)


#### Example of executing the instruction: “0000011100001111”

![image_page_2_11](https://github.com/teluashish/cisc-simulator/assets/66863362/4be4f206-b8f4-45ac-b8c1-cc68e6666e1c)

Main Memory Interface allows us to interact directly with the memory and perform Memory load and store operations.

![image_page_3_14](https://github.com/teluashish/cisc-simulator/assets/66863362/9f25c01a-8390-45e1-ab63-a9f9033ea58b)


#### Input and Output Text Field Boxes:
Allow users to interact with the command line interface.

![image_page_3_138](https://github.com/teluashish/cisc-simulator/assets/66863362/01e5a86f-af60-487b-bd45-e09209ee73a4)


#### Cache Scroll Pane:
Shows the representation of FIFO(queue) storing the data which follows Most Recently Used Policy. If the data to be accessed is not present in the cache we read it from the main memory and store it in the cache. Each "Tag" points to a block of memory "m" and "Data" stores values at "m" locations.

![image_page_4_98](https://github.com/teluashish/cisc-simulator/assets/66863362/d1f0beb0-9f9b-45aa-a17a-0f9450eaa146)


## Program 1: (Click on IPL before starting the program)

### Input:
a) Enter 20 numbers in the console Input each followed by a comma "" and a number. Last number is also followed by a comma ""
b) Enter a single number followed by a comma ""

### Output:
A number contained in the input which is closest to the number entered from Input b).

![image_page_4_100](https://github.com/teluashish/cisc-simulator/assets/66863362/f52146d2-4122-478f-b878-a317d6354d9e)

![image_page_4_99](https://github.com/teluashish/cisc-simulator/assets/66863362/d4c1e293-2c9c-4e05-a8e4-ecbc12119760)


- After entering 20 numbers click on Read(nums: 20) button to read the entered numbers.

![image_page_5_57](https://github.com/teluashish/cisc-simulator/assets/66863362/4dacf3bf-baac-4433-8faf-45f5b26f71ee)

- Enter a single number in the Input console then press Find Closest button to execute the program 1 and find the closest number number.

![image_page_5_58](https://github.com/teluashish/cisc-simulator/assets/66863362/aa13ebed-4e1e-40cb-b226-2247ab9e3cfe)


## Project Part - 3

New buttons and functionality added for program 2 which reads sentences and finds the input word in those sentences

![image_page_6_272](https://github.com/teluashish/cisc-simulator/assets/66863362/91d059b4-7e0b-455b-813e-880719b7482e)


## Program 2: (Click on IPL before starting the program)

### Input:
Click on "Load Sentences" button. After that enter a word into Console Input and press Find Word Button.

### Output:
Word Number and Sentence number is printed on the console output.

![image_page_7_246](https://github.com/teluashish/cisc-simulator/assets/66863362/09dea247-9eb8-4847-b808-1ffe3b9dcfba)

![image_page_7_245](https://github.com/teluashish/cisc-simulator/assets/66863362/ee9b2c77-e795-4c4a-ba77-be34a77cc2e9)


- Click on Load Sentences button to load the sentences into main memory

![image_page_8_214](https://github.com/teluashish/cisc-simulator/assets/66863362/bbac9a24-82b6-4986-b1f3-151e5fbef6f4)
  
- Enter a single word into the Console 

![image_page_8_215](https://github.com/teluashish/cisc-simulator/assets/66863362/df3222bb-2734-4503-9967-80df3a673585)

- Press Find Word Button

![image_page_9_200](https://github.com/teluashish/cisc-simulator/assets/66863362/fbce1eaa-86e0-4d88-995d-b51228fd658b)

As you can see in the console output the word unknown in the current example is 15th word in the 2nd sentence.


