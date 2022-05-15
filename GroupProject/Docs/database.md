# Database-Description

The weight related DB is the same but has a different name.

## Declare Function

<pre>
<code>
DB dataBase;
dataBase = new DB(this);
</code>
</pre>


## Fetch Function

<pre>
<code>
//Fetch Data from DB
public Cursor getAllData(String name) //name = MY_JOB_TABLE, JOB_LIST_TABLE or WEIGHT_TABLE 

//example
Cursor list = dataBase.getAllData(table_name); //table_name can be MY_JOB_TABLE, JOB_LIST_TABLE or WEIGHT_TABLE

//check whether list is empty or not
if (list.getCount() == 0) {
    Log.w("tag", "nothing");
} else {
    while ((list.moveToNext())) {
       //if list is not empty, then get info and put 
        Log.w("id",list.getString(0));
        title.setText(list.getString(1));
        company.setText(list.getString(2));
        location.setText(list.getString(3));
        cost.setText(list.getString(4));
        salary.setText(list.getString(5));
        bonus.setText(list.getString(6));
        benefits.setText(list.getString(7));
        stipend.setText(list.getString(8));
        award.setText(list.getString(9));
    }
}
</code>
</pre>

## Insert Function

<pre>
<code>
public boolean insertJobData(String title,
                                 String company,
                                 String location,
                                 String cost,
                                 String salary,
                                 String bonus,
                                 String benefits,
                                 String stipend,
                                 String award,
                                 String table) 

//example 
boolean isInsert = dataBase.insertJobData(title_string,
                    company_string,
                    location_string,
                    cost_string,
                    salary_string,
                    bonus_string,
                    benefits_string,
                    stipend_string,
                    award_string,
                    DB.MY_JOB_TABLE);
                    
            //Check insert data into DB
            if (isInsert == true) {
                Log.e("a", "success");
            } else {
                Log.e("a", "fail");
            }
</code>
</pre>

## Upload Function

<pre>
<code>
public void updateJobData(String id,
                              String title,
                              String company,
                              String location,
                              String cost,
                              String salary,
                              String bonus,
                              String benefits,
                              String stipend,
                              String award,
                              String table)
                              
//example
dataBase.updateJobData("1",
                    title_string,
                    company_string,
                    location_string,
                    cost_string,
                    salary_string,
                    bonus_string,
                    benefits_string,
                    stipend_string,
                    award_string,
                    DB.MY_JOB_TABLE);
<pre>
<code>

