# Offer Comparator App
## An Application that helps you decide which offer to choose

People in technology industry often switch their jobs in their career, usually two or three years. It is common that one job seeker get multiple offers from different companies. It is sometimes difficult to decide which one to choose. This offer comparator app provides a quantitative judgement on different job offers. User can adjust their weighting on salary, stock and working life balance based on their own preference. This app provide a quantitative and also customized way to compare different job offers. 

**Technologies:** Java, SQLite, Android Studio, XML 

## Interface
<p>
<img src="https://user-images.githubusercontent.com/53075473/168497663-c1f6d5d3-598c-40ad-b23b-67bba6e47185.png" alt="drawing" style="width:180px;"/>
<img src="https://user-images.githubusercontent.com/53075473/168497751-036de6ad-0665-4226-a8ca-154ad1bde556.png" alt="drawing" style="width:180px;"/>
<img src="https://user-images.githubusercontent.com/53075473/168497942-e9287813-2d14-4096-b7f6-e4cbb39ee3b3.png" alt="drawing" style="width:180px;"/>
<img src="https://user-images.githubusercontent.com/53075473/168497996-0ee340c4-7e81-467b-a7d7-6d583c45f18d.png" alt="drawing" style="width:180px;"/>
<img src="https://user-images.githubusercontent.com/53075473/168498034-c7a7c107-0286-44ff-8e98-e49fc9232260.png" alt="drawing" style="width:180px;"/>
</p>

## Design: 

![image](https://user-images.githubusercontent.com/53075473/168498280-2724df93-91a6-4ca8-b625-fa1ec26e49e9.png)


# User Manual

## Initial Screen

<img src="https://user-images.githubusercontent.com/53075473/168497663-c1f6d5d3-598c-40ad-b23b-67bba6e47185.png" width="300" height="600"/>

When user opens the application, the initial screen will pop up and show four buttons:

- Current Job -- which contains the current job information, allow user to view / update
- Job Offer -- which allows the user to enter a new job details
- Comparison Setting -- which allows user to adjust weighting for each category
- Job Comparison -- which allows user to select and compare two jobs

## Current Job Page

<img src="https://user-images.githubusercontent.com/53075473/168498915-b8de91d1-2c3c-45e5-bdd7-3f8c1ff191f4.png" width="300" height="600"/>

**Current job** page contains a form with all the attributes that specified in documentation. Among those attributes, user can input characters for the first three field, but only input integers for the rest fields.

If user currently has a job, then the current job information will be shown in the corresponding field, waiting for user to edit and save them.

When **Save** button is clicked, current information will be saved in a database and there is a dialog popped out showing the success message.

<img src="https://user-images.githubusercontent.com/53075473/168498951-cc17c9aa-51b6-46bb-aecd-6a6224b14b7c.png" width="300" height="600"/>

When **Reset** button is clicked, all the field values are set to empty string.

## Job Offer Page

<img src="https://user-images.githubusercontent.com/53075473/168499050-468053c8-5009-42d4-8f67-8f1bdd3dd724.png" width="300" height="600"/>

**Job Offer** page is very similar to current job pages. Except there is a **Compare** button. If the user add already user's current job into the database and the user put the information of offer job on this page, then the user can see two job information by the table on the bottom of this page by clicking the button.


<img src="https://user-images.githubusercontent.com/53075473/168499065-fdded6cf-06a6-42e7-b43b-f2ee79fda61d.png" width="300" height="600"/>


## Comparison Setting Page

<img src="https://user-images.githubusercontent.com/53075473/168499086-7a2660a6-21b4-4f99-b200-6ffe9104c505.png" width="300" height="600"/>

When user enters the comparison setting page, all the values are equally weighted and set to 1 initially. User can change the value of each field and give them different weights.

- Save button will save current weights to database
- Reset button will reset all the weights to 1

## Job Comparison Page

<img src="https://user-images.githubusercontent.com/53075473/168499124-816ee07d-0bdb-4117-8791-d4198b099ff9.png" width="300" height="600"/>

Job comparison page will display a list of job offers that user currently has. Use can select any two jobs and click "compare" button. When the button is clicked, a table with specified columns will display at the bottom of the page.

<img src="https://user-images.githubusercontent.com/53075473/168499109-a69a7982-88f8-4952-933a-889844fb794c.png" width="300" height="600"/>
