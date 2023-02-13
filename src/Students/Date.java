package Students;
import java.util.Calendar;

/**
 * This date class serves to reference the invalid date functionality provided in the command list.
 * It will allow for a reliable set of valid or accurate dates in order to prove roster credibility.
 * @author Maanini Kantem, Shreeya Karanam
 */

public class Date implements Comparable<Date>
{
    private int year;
    private int month;
    private int day;

    /**
     * This Date() utilizes the Calendar library and validates dates according to the corresponding month, year, and date.
     */
    public Date()
    {
        Calendar calendar = Calendar.getInstance();
        this.month  = calendar.get(Calendar.MONTH);
        this.year = calendar.get(Calendar.YEAR);
        this.day = calendar.get(Calendar.DATE);
    }

    /**
     * Below constructor utilizes parsing in order to generate an alternate date instance.
     * @param date A specific date format is presented as per the standard month, date, and year.
     */
    public Date(String date)
    {
        String[] dateElements = date.split("/");
        month = Integer.parseInt(dateElements[0]);
        day = Integer.parseInt(dateElements[1]);
        year = Integer.parseInt(dateElements[2]);
    }

    /**
     * The purpose of the below function is to create an additional instance of the date to compare.
     * @param d Duplicate
     */
    public Date(Date d)
    {
        this.month = d.getMonth();
        this.day = d.getDay();
        this.year = d.getYear();
    }

    /**
     * Using the given three parameters consistent throughout, (month, day and year), instance created
     * @param m m symbolizes month
     * @param d d symbolizes day
     * @param y y symbolizes year
     */
    public Date(int m, int d, int y)
    {
        this.month = m;
        this.day = d;
        this.year = y;
    }

    /**
     * D, (day) of the specified month is the final return call
     * @return Day of specified month
     */
    public int getDay()
    {
        int d = this.day;
        return d;
    }

    /**
     * M, (month) of the specified year is the final return call
     * @return Month of the specified year
     */
    public int getMonth()
    {
        int m = this.month;
        return m;
    }

    /**
     * Y, (year) of the specified year is the final return call
     * @return Year
     */
    public int getYear()
    {
        int y = this.year;
        return y;
    }

    /**
     * Sets specific day to matched month
     * @param d Specific day of month
     */
    public void setDay(int d)
    {
        this.day = d;
    }

    /**
     * Specifies specific month within year
     * @param m Symbolizes month of year
     */
    public void setMonth(int m)
    {
        this.month = m;
    }

    /**
     * Same method, specific to year
     * @param y Year
     */
    public void setYear(int y)
    {
        this.year = y;
    }

    /**
     *
     * isValid(), as name specifies makes sure that the entered date is existent and a possible input
     * Is able to process the possibility of leap years and year restrictions
     * @return On the basis of a date following isValid(), returns yes (true) or no (false)
     *
     */
    public boolean isValid()
    {
        final int TOTAL_MONTH = 12;
        final int MIN_MONTH = 1;
        final int TOTAL_FEB_DAYS = 28;
        final int TOTAL_FEB_LEAP_DAYS = 29;
        final int TOTAL_AJSN_DAYS = 30; //AJSN = April, June, September, and November
        final int TOTAL_MONTH_DAYS = 31;
        boolean leapYear = isLeapYear(year);
        Calendar today = Calendar.getInstance();

        if(year < 1900 || year > today.get(Calendar.YEAR)) return false;

        if(month > TOTAL_MONTH || month < MIN_MONTH) return false;

        if(day < 1) return false;
        if(month == Month.FEB)
        {
            if(leapYear)
            {
                if(day > TOTAL_FEB_LEAP_DAYS) return false;
            } else
            {
                if(day > TOTAL_FEB_DAYS) return false;
            }
        } else if(month == Month.APR || month  == Month.JUN || month == Month.SEP || month == Month.NOV) //MONTHS WITH 30 DAYS
        {
            if(day > TOTAL_AJSN_DAYS) return false;
        } else  //MONTHS WITH 31 DAYS
        {
            if(this.day > TOTAL_MONTH_DAYS) return false;
        }

        return true;
    }

    /**
     * As mentioned above, used to determine if it is a leap year
     * @param y Year in question.
     * @return true if the year is a leap year, false if not.
     */
    private boolean isLeapYear(int y)
    {
        final int QUADRENNIAL = 4;
        final int CENTENNIAL = 100;
        final int QUATERCENTENNIAL = 400;
        if(y % QUADRENNIAL == 0)
        {
            if(y % CENTENNIAL == 0)
            {
                if(y % QUATERCENTENNIAL == 0)
                {
                    return true;
                }else
                {
                    return false;
                }
            }else
            {
                return true;
            }
        }else
        {
            return false;
        }
    }

    /**
     * Determine whether two dates are equal.
     * @param date The date to compare against.
     * @return true if the dates are equal, false if not.
     */
    public boolean equals(Date date)
    {
        return compareTo(date) == 0;
    }

    /**
     * Compares two dates.
     * @param date The date to compare the current one to.
     * @return 1 if the current date occurs after the given one, -1 if the current date occurs before, and 0 if the the dates are the same.
     */
    @Override
    public int compareTo(Date date)
    {
        if(year > date.getYear()) return 1;
        else if(year < date.getYear()) return -1;
        if(month > date.getMonth()) return 1;
        else if(month < date.getMonth()) return -1;
        if(day > date.getDay()) return 1;
        else if(day < date.getDay()) return -1;
        return 0;
    }

    /**
     * Converts the date into a string
     * @return A string representation of the date in mm/dd/yyyy format.
     */
    public String toString()
    {
        return month + "/" + day + "/" + year;
    }

    /**
     * Tries a series of tests to make sure if isValid() function works.
     * All the tests should return false except for the last one.
     * @param args
     */
    public static void main(String[] args)
    {
        Date d;

        //test case 1
        d = new Date("5/22/1883");
        System.out.println(d.isValid());

        //test case 2
        d = new Date("16/3/1984");
        System.out.println(d.isValid());

        //test case 3
        d = new Date("0/15/2002");
        System.out.println(d.isValid());

        //test case 4
        d = new Date("2/29/1993");
        System.out.println(d.isValid());

        //test case 5
        d = new Date("2/-1/1993");
        System.out.println(d.isValid());

        //test case 6
        d = new Date("2/31/1984");
        System.out.println(d.isValid());

        //test case 7
        d = new Date("6/31/2000");
        System.out.println(d.isValid());

        //test case 8
        d = new Date("6/0/2000");
        System.out.println(d.isValid());

        //test case 9
        d = new Date("12/500/1994");
        System.out.println(d.isValid());

        //test case 10
        d = new Date("12/0/1994");
        System.out.println(d.isValid());

        //test case 11
        d = new Date("3/3/2019");
        System.out.println(d.isValid());
    }
}