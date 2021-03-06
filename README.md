# secondactivityassignment-ToastyKrabstix

This assignment illustrates the linking and passing data between activities using the Intent object.

## Problem:

Design and implement an Android application that determines the day of the week (Sunday through Saturday) given any date entered by the user. You could use this program, for example, to determine what day of the week you were born or what day of the week an upcoming exam is. Use Zeller's congruence algorithm to calculate the day of the week. The output day should be printed in a second Android activity.

## Formula:

```Java
day_out = (day + (int)(26 *(month + 1)/10.0) + year + (int)(year/4.0) + (int)(century/4.0) + 5 * century ) % 7;
```

where:

day_out - is the calculated day of the week (0..6) 

day     - is the day entered by the user.

month   - is the adjusted month (January and February are 13 and 14, not 1 and 2)

year    - is the last two digits of the adjusted year (January and February are in the previous year). For example: if year is 2003, then year would be 03

century - is the century of the adjusted year (January and February are in the previous year). For example, if year is 2003, then century is 20


## Keypoint:

In the MainActivity.java:

```Java
       // Intent to go to the second activity
        Intent i = new Intent(this, SecondActivity.class);

        // Put attachment data along with the intent
        i.putExtra("message", day_text);

        startActivity(i);
```

In the SecondActivity.java

```Java
 private void handleIntent(){
        Intent i = getIntent();
        String day_out = i.getStringExtra("message");
        TextView tv_out = (TextView) findViewById(R.id.textViewOut);
        tv_out.setText(day_out);
    }
```


## Screenshots:

![alt tag](https://github.com/DeLaSalleUniversity-Manila/secondactivityassignment-ToastyKrabstix/blob/master/device-2015-10-05-213154.png)

![alt tag](https://github.com/DeLaSalleUniversity-Manila/secondactivityassignment-ToastyKrabstix/blob/master/device-2015-10-05-213228.png)
