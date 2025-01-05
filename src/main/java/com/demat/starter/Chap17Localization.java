package com.demat.starter;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author TNAJI Khalid
 */
public class Chap17Localization {
    public static void main1(String[] args) {
        double num = 12345.6789;

        /*
to create a pattern, we need to know to formatting characters:
# - omit position if no digit exists for it (e.g. $2.2)
0 - put 0 in position if no digit exists for it (e.g. $002.20)
         */
        NumberFormat f1 = new DecimalFormat("###,###,###.0");
        System.out.println(f1.format(num));
        //12,345.7

        NumberFormat f2 = new DecimalFormat("000,000.000000");
        System.out.println(f2.format(num));
//        012,345.678900
        NumberFormat f3 = new DecimalFormat("My Balance: $#,###,###.##");
        System.out.println(f3.format(num));
//        My Balance: $12,345.68



        var date = LocalDate.now();
        var time = LocalTime.now();
        var dt = LocalDateTime.now();
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        //2023-09-14
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        //09:06:24
        System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        //2023-09-14T09:06:24


        var dd = DateTimeFormatter.ofPattern("MMM-dd-yy HH:mm:ss");// ex: Sep
        var ddd = DateTimeFormatter.ofPattern("MMMM-dd-yy HH:mm:ss");// ex September
        var dddd = DateTimeFormatter.ofPattern("MMMM-dd-yy HH:mm:ss a");// time with AM, PM

        // to insert text values use single quotes
        var f4 = DateTimeFormatter.ofPattern("'Date:' dd.MM.yy. '| Time:' hh:mm:ss a");
        var f5 = DateTimeFormatter.ofPattern("MMM-dd-yyyy 'at' HH'h'm'm'ss's'");
        // NOTE: spaces can be added within or out of the single quotes



        Locale myLocale = Locale.getDefault();
        System.out.println(myLocale);
        //en_US (en language: mandatory, US: country optional)
        System.out.println(Locale.ITALIAN);
        //it
        System.out.println(Locale.ITALY);
        //it_IT
        System.out.println(new Locale("hi", "IN"));
        //hi_IN

        Locale m = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();

        Locale.setDefault(m);


        double myNum = 1234.568;
        var it = NumberFormat.getInstance(Locale.ITALY);
        System.out.println(it.format(myNum));
        // => 1.234,568
        var us = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(us.format(myNum));
        //$12.30


        double discount = 0.151;
        var usss = NumberFormat.getPercentInstance(Locale.US);
        System.out.println(us.format(discount));
        //15%


        String myNumString = "15.72";
        String price = "$12,345.67";
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        try {
            Number parse = us.parse(myNumString);
            System.out.println(parse);
            // 15.72

            double priceValue = (Double) us.parse(price);
            //12345.67
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        int myNum2 = 8_765_432;
        var us1 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(us1.format(myNum2));
        // 9M

        var us122 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        // 9 million


        /*
        FormatStyle.SHORT //14/09/2023
        FormatStyle.LONG //2023 Sep 14
        FormatStyle.FULL
        DateTimeFormatter.ofLocalizedDate(FormatStyle dateStyle);
        DateTimeFormatter.ofLocalizedTime(FormatStyle dateStyle);
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle dateStyle);
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle dateStyle, FormatStyle dateStyle);
         */


        // Resource Bundle?
        //<name_of_the_bundle>_<target_locale>.properties
        //ResourceBundle.getBundle(bundle, locale)

        /*
How to pick resource bundle?
1. Museum_it_IT.properties (requested locale)
2. Museum_it.properties (requested language with no country)
3. Museum_en_US.properties (default locale)
4. Museum_en.properties (default locale with no country)
5. Museum.properties (bundle with no locale - default bundle)
6. MissingResourceException (if non of above were found)
         */

        var enRb = ResourceBundle.getBundle("Museum", new Locale("en", "US"));
        enRb.getString("English");
        MessageFormat.format("hello {0}, hi: {1}", "h","jjskd");
    }

}
