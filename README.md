# CSX42: Assignment 2
## Name: Tina Sayapogu

### Slack days Used : 0

-----------------------------------------------------------------------
### 1) Compiling and Running Commands:
-----------------------------------------------------------------------
Compilation: ant -buildfile studentRecordsBackupTree/src/build.xml all <br>
Running the code: ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Darg2=errors.txt -Darg3=2 -Darg4=1 

### **NOTE**:

While running the program note that:     <br>
1st argument: -Darg0, must be input file.      <br>
2nd argument: -Darg1, must be outputfile.         <br>
3rd argument: -Darg2, is the file where errors are logged.       <br>
4th argument: -Darg3, is the debug level value.        <br>
5th argument: -Darg4, is the update value.      <br>

There is no need for bstOutput, errorlog files to be present while running. It will be created in the runtime.<br>

-----------------------------------------------------------------------
### 2) Input and Output Format Specification:
-----------------------------------------------------------------------

a.) bstInput.txt 

-  COntains integers that should be used to create the BST.
    Each line will have one integer. Input integers will not contain any duplicates. Input is well formatted.


b.) bstOutput.txt

- This will have the following format,<br>

        Main BST: 1 2 3 4 5 6 
        Backup1: 1 2 3 4 5 6 
        Backup2: 1 2 3 4 5 6 

        Main BST Sum: 21
        Backup1 Sum: 21
        Backup2 Sum: 21

        After Updating:
        Main BST: 11 12 13 14 15 16 
        Backup1: 11 12 13 14 15 16 
        Backup2: 11 12 13 14 15 16 

        Main BST Sum: 81
        Backup1 Sum: 81
        Backup2 Sum: 81

c.) errorlog.txt

- This file contains the error message occured during reading the inputfile.

-----------------------------------------------------------------------
### 3)  Choice of data structures and design explanation:
-----------------------------------------------------------------------

- bst package contains following classes/interfaces:

a.) Subject.java 
    This is the Subject Interface for the Observer Pattern. It has registerTree(), unregisterTree(), notifyTrees() and updateTrees() methods.
b.) Observer.java
    This is the Interface for all the Observers. It has updateAll(), backupTree() methods.
c.) Maintree.java
    This class is implemented from Subject Interface. It registers/unregisters backuptrees. When update is called on main tree, it notifies all other observers.backups and upadtes their value.
### Choice of DataStructure to store Backups:
    I used ArrayList mainly because it seemed as if the backup trees are not created exponentially and thus we dont need much space for the incoming backups. If I used vectors the space is created exponentially and memory is wasted.
d.) Backups.java:
    This class is implemented from Observer Interface.
e.) Node.java:
    This class is used to create a node bNumber with left and right values.
f.) BST.java:
    This class contains all the methods required for performing operations on binary search tree. It has insert(), sum(), inorder() and update() methods.
e.) BSTBuilder.java:
    This class reads a line from the input file, and calls the insert(...) method of the BST.

-driver.java:
    driver class does the following:  
    -Read command line arguments.
    -Use BSTBuilder in the bst package to build the three trees.
    -Call inorder traversal to print the values from the three trees.
    -Call methods to print the sum of all the B-Numbers in each of the three trees.
    -Call a method to increment the nodes in the main BST with UPDATE_VALUE (which will update the backups via the observer pattern).
    -Call methods to print the sum of all the B-Numbers in each of the three trees.
    
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense."

Date: 23-10-2022


