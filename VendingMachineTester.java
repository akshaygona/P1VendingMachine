//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P01 Vending Machine Tester
// Course: CS 300 Fall 2022
//
// Author: (Akshay Gona)
// Email: (gona@wisc.edu)
// Lecturer: (Hobbes LeGault)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: Varun Munagala, my roommate, helped me think about logic for the methods and helped
//////////////// debug at the end, before submission.
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

// Below is a javadoc class header to complete
/**
 * The Vending Machine Tester class contains a series of static tester methods which conduct basic
 * tester operations for the static methods written in the Vending Machine class.
 * 
 * @author Akshay Gona
 *
 */
import java.util.Arrays;

// Javadoc style class header comes here
public class VendingMachineTester {

  // TODO complete the implementation of the following tester methods and add their javadoc style
  // method headers

  // Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetIndexNextItem() {
    // Test scenarios normal and edge cases
    // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
    // its description without removing it.

    // 1. Next item to be dispensed is NOT found: the expected output is -1
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                + "-1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 2. Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 3. Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 4. Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains matches with the provided "
                + "item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of containsItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testContainsItem() {
    // (1) successful search returning true
    String[][] items = new String[][] {{"soda", "15"}, {"milk", "10"}, {"water", "20"},
        {"chocolate", "5"}, {"mangoes", "30"}, {"apples", "15"}, {"chips", "10"}, null, null};
    int itemsCount = 7;
    if (!VendingMachine.containsItem("soda", items, itemsCount)) {
      System.out.println("testContainsItem case 1 fails.");
      return false;
    }
    // (2) unsuccessful search returning false
    if (VendingMachine.containsItem("ritz crackers", items, itemsCount)) {
      System.out.println("testContainsItem case 2 fails.");
      return false;
    }
    return true;
  }

  // Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetItemAtIndex() {
    // (1) the provided index is out of the range
    String[][] items = new String[][] {{"soda", "15"}, {"milk", "10"}, {"water", "20"},
        {"chocolate", "5"}, {"mangoes", "30"}, {"apples", "15"}, {"chips", "10"}, null, null};
    String[][] originalItems = new String[][] {{"soda", "15"}, {"milk", "10"}, {"water", "20"},
        {"chocolate", "5"}, {"mangoes", "30"}, {"apples", "15"}, {"chips", "10"}, null, null};
    int itemsCount = 7;
    if (!VendingMachine.getItemAtIndex(10, items, itemsCount).equals("ERROR INVALID INDEX")
        || !Arrays.deepEquals(items, originalItems)) {
      System.out.println("testGetItematIndex case 1 fails");
      return false;
    }
    // (2) the provided index is in bounds [0..itemsCount-1].
    if (!VendingMachine.getItemAtIndex(3, items, itemsCount).equals("chocolate (5)")
        || !Arrays.deepEquals(items, originalItems)) {
      System.out.println("testGetItematIndex case 2 fails");
      return false;
    }

    // For each test scenario, ensure that the method returned the exact expected string output
    // without making any changes to the contents of the array.
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemOccurrences defined in the VendingMachine class.
  public static boolean testGetItemsOccurrences() {
    // (1) no match found so that the method returns zero
    String[][] items = new String[][] {{"soda", "15"}, {"soda", "10"}, {"water", "20"},
        {"chocolate", "5"}, {"mangoes", "30"}, {"apples", "15"}, {"chips", "10"}, null, null};
    String[][] originalItems = new String[][] {{"soda", "15"}, {"soda", "10"}, {"water", "20"},
        {"chocolate", "5"}, {"mangoes", "30"}, {"apples", "15"}, {"chips", "10"}, null, null};
    int itemsCount = 7;
    if (!(VendingMachine.getItemOccurrences("bananas", items, 7) == 0)
        || !Arrays.deepEquals(items, originalItems)) {
      System.out.println("testgetItemOccurences case 1 fails");
      return false;
    }
    // (2) the items array contains multiple occurrences of the provided item description.
    if (!(VendingMachine.getItemOccurrences("soda", items, 7) == 2)
        || !Arrays.deepEquals(items, originalItems)) {
      System.out.println("testgetItemOccurences case 2 fails");
      return false;
    }
    // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of addItem defined in the VendingMachine class.
  public static boolean testAddItem() {
    String[][] items = new String[][] {null, null, null, null};
    String[][] items2 = new String[][] {{"soda", "0"}, null, null, null};
    int size2 = 1;
    // (1) adding a new item to an empty vending machine whose size is zero (provided itemsCount ==
    // 0)
    int ret = VendingMachine.addItem("soda", "0", items, 0);
    if (ret != 1 || !Arrays.deepEquals(items, items2)) {
      System.out.println("testAddItem case 1 fails");
      return false;
    }
    // (2) adding a new item to a non-empty non-full vending machine
    int ret2 = VendingMachine.addItem("chocolate", "10", items2, 1);
    String items3[][] = new String[][] {{"soda", "0"}, {"chocolate", "10"}, null, null};
    if (ret2 != 2 || !Arrays.deepEquals(items2, items3)) {
      System.out.println("testAddItem case 2 fails");
      return false;
    }
    // (3) adding a new item to a full vending machine where the provided itemsCount equals the
    // length of the provided items array.
    String items4[][] =
        new String[][] {{"soda", "0"}, {"chocolate", "10"}, {"booze", "900"}, {"cigs", "1000"}};
    String items5[][] =
        new String[][] {{"soda", "0"}, {"chocolate", "10"}, {"booze", "900"}, {"cigs", "1000"}};
    int ret3 = VendingMachine.addItem("beer", "200", items4, 4);
    if (ret3 != 4 || !Arrays.deepEquals(items4, items5)) {
      System.out.println("testAddItem case 3 fails");
      return false;
    }
    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of removeNextItem defined in the VendingMachine class.
  public static boolean testRemoveNextItem() {
    String items[][] =
        new String[][] {{"soda", "0"}, {"chocolate", "10"}, {"booze", "900"}, {"cigs", "1000"}};
    String items2[][] =
        new String[][] {{"soda", "0"}, {"chocolate", "10"}, {"booze", "900"}, {"cigs", "1000"}};
    String items3[][] =
        new String[][] {{"chocolate", "10"}, {"booze", "900"}, {"cigs", "1000"}, null};
    int itemsCount = 4;
    // int itemsCount2 = 4;
    // int itemsCount3 = 3;
    // (1) trying to remove a non-existing item from a vending machine (the vending machine can be
    // empty or not)
    if (VendingMachine.removeNextItem("milk", items, itemsCount) != 4
        || !Arrays.deepEquals(items, items2)) {
      System.out.println("testRemoveNextItem case 1 fails");
      return false;
    }
    // (2) the next item to be removed matching the provided description is at index 0 of the array
    int temp = VendingMachine.removeNextItem("soda", items, itemsCount);
    if (temp != 3 || !Arrays.deepEquals(items, items3)) {
      System.out.println("testRemoveNextItem case 2 fails");
      return false;
    }
    // (3) the next item to be removed is at index itemsCount of the array (at the end of the array)
    String items4[][] =
        new String[][] {{"soda", "0"}, {"chocolate", "10"}, {"booze", "900"}, {"cigs", "1000"}};
    int itemsCount4 = 4;
    String items5[][] = new String[][] {{"soda", "0"}, {"chocolate", "10"}, {"booze", "900"}, null};
    int temp2 = VendingMachine.removeNextItem("cigs", items4, itemsCount4);
    if (temp2 != 3 || !Arrays.deepEquals(items4, items5)) {
      System.out.println("testRemoveNextItem case 3 fails");
      return false;
    }
    // (4) the next item to be removed is at a middle index of the provided items array.
    String items6[][] =
        new String[][] {{"soda", "0"}, {"chocolate", "10"}, {"booze", "900"}, {"cigs", "1000"}};
    int itemsCount6 = 4;
    String items7[][] = new String[][] {{"soda", "0"}, {"booze", "900"}, {"cigs", "1000"}, null};
    // int itemsCount7 = 3;
    int temp3 = VendingMachine.removeNextItem("chocolate", items6, itemsCount6);
    if (temp3 != 3 || !Arrays.deepEquals(items6, items7)) {
      System.out.println("testRemoveNextItem case 4 fails");
      return false;
    }
    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemsSummary defined in the VendingMachine class.
  public static boolean testGetItemsSummary() {
    String items[][] = new String[][] {null, null, null, null};
    int itemsCount = 0;
    String items2[][] = new String[][] {{"soda", "0"}, {"chocolate", "10"}, {"booze", "900"},
        {"cigs", "1000"}, null, null, null};
    int itemsCount2 = 4;
    String items3[][] = new String[][] {{"soda", "0"}, {"chocolate", "10"}, {"booze", "900"},
        {"soda", "1000"}, {"chocolate", "10"}, {"chocolate", "10"}, null};
    int itemsCount3 = 6;
    // (1) the vending machine is empty
    if (!VendingMachine.getItemsSummary(items, itemsCount).equals("")) {
      System.out.println("testGetItemsSummary case 1 fails");
      return false;
    }
    // (2) the vending machine contains non duplicate items (no multiple items with the same
    // description)
    if (!VendingMachine.getItemsSummary(items2, itemsCount2)
        .equals("soda (1)/nchocolate (1)/nbooze (1)/ncigs (1)/n")) {
      System.out.println("testGetItemsSummary case 2 fails");
      return false;
    }
    // (3) the vending machine contains multiple items with the same description at various index
    // locations.
    if (!VendingMachine.getItemsSummary(items3, itemsCount3)
        .equals("soda (2)/nchocolate (3)/nbooze (1)/n")) {
      System.out.println("testGetItemsSummary case 3 fails");
      return false;
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
    if (testGetIndexNextItem() != true || testContainsItem() != true || testGetItemAtIndex() != true
        || testGetItemsOccurrences() != true || testAddItem() != true
        || testRemoveNextItem() != true || testGetItemsSummary() != true) {
      System.out.println("one of the tester methods fails");
      return false;
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // main method to call the tester methods defined in this class
  public static void main(String[] args) {
    // System.out.println("testGetIndexNextItem(): " + testGetIndexNextItem());
    System.out.println("runAllTests(): " + runAllTests());
  }

}
