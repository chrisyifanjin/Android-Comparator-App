
# User Manual

## Initial Screen

<img src="https://github.gatech.edu/gt-omscs-se-2022spring/6300Spring22Team007/blob/master/GroupProject/Screen-Shots/initial_screen.png" width="300" height="600"/>

When user opens the application, the initial screen will pop up and show four buttons:

- Current Job -- which contains the current job information, allow user to view / update
- Job Offer -- which allows the user to enter a new job details
- Comparison Setting -- which allows user to adjust weighting for each category
- Job Comparison -- which allows user to select and compare two jobs

## Current Job Page

<img src="https://github.gatech.edu/gt-omscs-se-2022spring/6300Spring22Team007/blob/master/GroupProject/Screen-Shots/current_job.png" width="300" height="600"/>

**Current job** page contains a form with all the attributes that specified in documentation. Among those attributes, user can input characters for the first three field, but only input integers for the rest fields.

If user currently has a job, then the current job information will be shown in the corresponding field, waiting for user to edit and save them.

When **Save** button is clicked, current information will be saved in a database and there is a dialog popped out showing the success message.

<img src="https://github.gatech.edu/gt-omscs-se-2022spring/6300Spring22Team007/blob/master/GroupProject/Screen-Shots/success_dialog.png" width="300" height="600"/>

When **Reset** button is clicked, all the field values are set to empty string.

## Job Offer Page

<img src="https://github.gatech.edu/gt-omscs-se-2022spring/6300Spring22Team007/blob/master/GroupProject/Screen-Shots/job_offer.png" width="300" height="600"/>

**Job Offer** page is very similar to current job pages. Except there is a **Compare** button. If the user add already user's current job into the database and the user put the information of offer job on this page, then the user can see two job information by the table on the bottom of this page by clicking the button.


<img src="https://github.gatech.edu/gt-omscs-se-2022spring/6300Spring22Team007/blob/master/GroupProject/Screen-Shots/job_offer_comparison.png" width="300" height="600"/>


## Comparison Setting Page

<img src="https://github.gatech.edu/gt-omscs-se-2022spring/6300Spring22Team007/blob/master/GroupProject/Screen-Shots/comparison_setting.png" width="300" height="600"/>

When user enters the comparison setting page, all the values are equally weighted and set to 1 initially. User can change the value of each field and give them different weights.

- Save button will save current weights to database
- Reset button will reset all the weights to 1

## Job Comparison Page

<img src="https://github.gatech.edu/gt-omscs-se-2022spring/6300Spring22Team007/blob/master/GroupProject/Screen-Shots/job_comparison.png" width="300" height="600"/>

Job comparison page will display a list of job offers that user currently has. Use can select any two jobs and click "compare" button. When the button is clicked, a table with specified columns will display at the bottom of the page.

<img src="https://github.gatech.edu/gt-omscs-se-2022spring/6300Spring22Team007/blob/master/GroupProject/Screen-Shots/comparison_detail.png" width="300" height="600"/>
