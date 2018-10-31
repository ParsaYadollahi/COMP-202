        //Student Name: Parsa Yadollahi
        //Student Number: 260869949

        // do NOT touch these import statements
        import java.time.format.DateTimeFormatter;
        import java.time.LocalDateTime;

        public class CountdownDays {

            // the method returns a String representing the current date in the following format: dd/mm/yyyy
            // you can use it, but do NOT modify it!
            public static String getCurrentDate() {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                return dtf.format(now);
            }

            //========================
            // Enter your code below

            /* A method that takes a String and two integers and display the characters between the two integers */
            public static String getSubstring(String s, int i, int j) {
                //illegal Argument thrown if the second integer is smaller than the first.
                if (i > j) {
                    throw new IllegalArgumentException("The Second input must be larger than the First");
                } else {
                    //Give an empty Srting to build on
                    String result = "";
                    //FOR loop for the characters between the two integers
                    for (int k = i; k <= j; k++) {
                        //Adding characters from the loop to make a String or Character
                        result = result + s.charAt(k);
                    }
                    //return the String or Character
                    return result;
                }
            }
            // A method that inputs a specific date which is dd/mm/yyyy and return only the number of days in that date
            public static int getDay(String s) {
                //Using the getSubstring function, take the two first inputs in the String and returning the answer
                return Integer.parseInt(getSubstring(s, 0, 1));
            }
            // A method that inputs a specific date which is dd/mm/yyyy and return the number of months in that date
            public static int getMonth(String s) {
                //Using the getSubstring function, take the 3rd and 4rth inputs in the String and returning the answer
                return Integer.parseInt(getSubstring(s, 3, 4));
            }
            // A method that takes a specific date which has the format dd/mm/yyyy and return
            // the number of years in that date
            public static int getYear(String s) {
                //Using the getSubstring function taking from the 6th to the 9th inputs in the String and return the answer
                return Integer.parseInt(getSubstring(s, 6, 9));
            }
            // A method that takes an integer input and determines whether or not it is a leap year
            public static boolean isLeapYear(int x) {
                //Condition if the year is not divisible by 4, then the year is not a leap year
                if (x % 4 != 0) {
                    //returning answer
                    return false;
                    //Condition if the year is not divisible by 100, then the year is a leap year
                    //A year is a leap year if and only if it is divisible by 100 and 400
                } else if (x % 100 != 0) {
                    //return answer
                    return true;
                    //check if the year is divisible by 400, if not the it is not a leap year
                } else if (x % 400 != 0) {
                    //return answer
                    return false;
                    //else condition it is a leap year
                } else {
                    //return answer
                    return true;
                }
            }

            // A method that takes two inputs, the months and the years and determing how many days
            // are in that specific month of the year
            public static int getDaysInAMonth(int months, int year) {
                //Condition statement for the months with 30 days
                if (months == 4 || months == 6 || months == 9 || months == 11) {
                    //return answer
                    return 30;
                }
                //Condition statement for the possible leap months
                if (months == 2) {
                    //Condition statement for the leap years, if it is a leap year,
                    //the number of days in the month is 29
                    if (isLeapYear(year)) {
                        //return answer
                        return 29;
                        //Condition statement for the non leap years, if it is not a
                        //leap year, the number of days in the month is 28
                    } else {
                        //return answer
                        return 28;
                    }
                }
                //return the last possibility for number of days in a month, 31 days
                return 31;
            }

            //  A method that compares two date (strings) and tell the user whether or not they have
            //  passed the due date or not
            public static boolean dueDateHasPassed(String currentdate, String duedate) {
                //    Conditional Statement determining which year is bigger
                if (getYear(duedate) < getYear(currentdate)) {
                    return true;
                    //      Conditional Statement enters if the two dates are the same
                }
                if (getYear(duedate) == getYear(currentdate)) {
                    //      Conditional Statement determining which month is bigger
                    if (getMonth(duedate) < getMonth(currentdate)) {
                        return true;
                    }
                    if (getMonth(duedate) > getMonth(currentdate)) {
                        return false;
                    }
                    if (getMonth(duedate) == getMonth(currentdate)) {
                        if (getDay(duedate) <= getDay(currentdate)) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                return false;
            }

            //A program that takes two dates as input in the other dd/mm/yyyy as Strings and returns the number of days between the two
            public static int countDaysLeft(String current, String due) {
                //Initialize variables. Start from 0
                int months = 0;
                int years = 0;
                int addedDaysMonths1 = 0;
                int addedDaysMonths2 = 0;
                int addedDaysYears = 0;
                int nbDaysTot = 0;
                //Condition statement if the date has already passed
                if (dueDateHasPassed(current, due)) {
                    //return answer
                    return 0;
                }

                //Condition Statement if both years are equal
                if (getYear(current) == getYear(due)) {
                    //Condition Statement if both months are equal
                    if (getMonth(current) == getMonth(due)) {
                        //calculate the number of days in that equal month
                        nbDaysTot = getDay(due) - getDay(current);
                    }
                    //Condition Statement if the first month is smaller than the second month
                    if (getMonth(current) < getMonth(due)) {
                        //calculate the number of days left before the next month stars
                        // and add the number of days in the last month to start at the month before the due date
                        //that way we have the number of days in the specified month
                        nbDaysTot = getDaysInAMonth(getMonth(current), getYear(current)) - getDay(current) + getDay(due);
                        //A FOR loop for the number of months
                        for (months = getMonth(current) + 1; months < (getMonth(current) + (getMonth(due) - getMonth(current))); months++) {
                            //Since the years are the same, the difference in months are only the due month - the current month
                            // that way we can calculate the number of days for each month starting from the current month+1
                            //and ending at the last month-1
                            int days = getDaysInAMonth(months, getYear(current));
                            //Increment the number of days in the months
                            addedDaysMonths1 += days;
                        }
                    }
                    //Else condition if the months are not equal
                    //Only other option is if the the due year is > current year
                } else {
                    //Calculate the number of days before the previous month of the due month
                    int nbDaysDue = getDay(due);
                    //Calculate the number of days before the next month of the current month
                    int nbDaysCurrent = getDaysInAMonth(getMonth(current), getYear(current)) - getDay(current);
                    //Calculate the number of day to focus now on the months and years
                    nbDaysTot = nbDaysDue + nbDaysCurrent;

                    //FOR loop for the number of months starting at current month+1
                    for (months = getMonth(current) + 1; months <= 12; months++) {
                        //Calculating the number of days in the months from the current month+1
                        //to the next year
                        int days = getDaysInAMonth(months, getYear(current));
                        //Increment the number of days
                        addedDaysMonths1 += days;
                    }
                    //FOR loop for the number of months starting at the due years first month (01)
                    for (months = getMonth(due) - 1; months >= 1; months--) {
                        //Calculating the number of days from the first month of the due year
                        //to the due month-1 of the due year
                        int days = getDaysInAMonth(months, getYear(due));
                        //Incremeent the number of days
                        addedDaysMonths2 += days;
                    }
                    //FOR loop for the number of years starting from the current year+1 up to the due year-1
                    for (years = getYear(current) + 1; years <= getYear(due) - 1; years++) {
                        //number of days on common year
                        int days = 365;
                        //If statement for the leap years
                        if (isLeapYear(years)) {
                            //Number of days on leap years
                            days = 366;
                        }
                        //incremenet the number of days
                        addedDaysYears += days;
                    }
                }
                //Add all the days from the loops and condition above for the total number of days
                int totalNumberOfDays = addedDaysMonths1 + addedDaysMonths2 + addedDaysYears + nbDaysTot;
                //return the answer
                return totalNumberOfDays;
            }

            //A program that takes an input as a String and displays the current date
            //the due date, and the number of days left before the due date in an ordered way
            public static void displayCountdown(String u) {
                //Condition statement if the current year is larger than the due year

                if (getYear(getCurrentDate()) > getYear(u)) {
                    System.out.println("Today is: " + getCurrentDate());
                    System.out.println("Due date: " + u);
                    //Display a result saying the due date has passed
                    System.out.println("The due date has passed! :( Better luck next time!");
                }
                //Condition statement if the current year and due year are the same, but the
                //current month is larger than the due month
                if ((getYear(getCurrentDate()) == getYear(u)) && (getMonth(getCurrentDate()) > getMonth(u))) {
                    System.out.println ("Today is: " + getCurrentDate());
                    System.out.println ("Due date: " + u);
                    //Display a result saying the due date has passed
                    System.out.println ("The due date has passed! :( Better luck next time!");
                }
                //Condition statement if the current year and month are larger than the due year and month,
                //but the current day is larger than the due day
                if (getYear(getCurrentDate()) == getYear(u) && getMonth(getCurrentDate()) == getMonth(u) && getDay(getCurrentDate())> getDay(u)) {
                    System.out.println ("Today is: " + getCurrentDate());
                    System.out.println ("Due date: " + u);
                    //Display a result saying the due date has passed
                    System.out.println ("The due date has passed! :( Better luck next time!");
                    //Else condition if the due date is after the current date
                } else {
                    //Display results
                    System.out.println ("Today is: " + getCurrentDate());
                    System.out.println ("Due date: " + u);
                    System.out.println ("You have " + countDaysLeft(getCurrentDate(), u) + " days left. You can do it!");
                }
            }

            //A program that displays the number of days left between now (when
            //the program is run) and a given due date provided by the user.
            public static void main(String args[]) {
                String u = "29/10/2018";
                displayCountdown(u);
                System.out.println();
            }
        }

