# Design Description

## Requirements

### Requirement #1
When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet). 

+ `Job`, `User` and `ComparisonSetting` are nouns, and it's better to model them as classes.
+ Use can enter or edit current job details, so I added a `saveJobDetails()` function inside the `User` class, which takes all the job attributes as paramenters and returns the newly created/updated `Job` object;
+ User can enter job offers, which means user can create new Job object, so I added `createJobOffer()` function inside the `User` class. And it takes all the job attributes as parameters, returns the newly created `Job` object;
+ User can adjust comparison settings, and this setting can have many attributes, it's better to model it as a seperate class. `User` class will need to have a `adjustComparisonSetting()` function to update it;
+ `User` class needs to have a `compareJobOffer()` function to compare two jobs;
  
### Requirement #2
When choosing to enter current job details, a user will:
1. Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of: Title, Company, Location (entered as city and state), ....

+ All the attributes is reflected in the UML diagram as private fields.

1. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

+ When user choose to save the jobs details, the system will call `saveJobDetails()` function; When user choose to cancel, there is nothing the backend needs to do. This is a GUI requirement, and we only need to show a `cancel` button in the frontend;

### Requirement #3
When choosing to enter job offers, a user will:
1. Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.
   
+ `Job` class has all the attributes specified in the documentation;

2. Be able to either save the job offer details or cancel.

+ `User` class has a `createJobOffer()` function, and it will be called when user saves the job offer. Nothing happens when user cancels;

3. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

+ *(1)* and *(2)* are GUI related functionalities, and they are not reflected in the UML diagram. In order for user to perform operation *(3)*, `User` class need to have a `compareJobs()` function;

### Requirement #4
When adjusting the comparison settings, the user can assign integer weights to: Yearly salary, Yearly bonus, Retirement benefits, Relocation stipend, Restricted stock unit award.

If no weights are assigned, all factors are considered equal.

+ All the attributes are modeled as private attributes inside `ComparisonSetting` class, and all initlized to 1.

### Requirement #5
When choosing to compare job offers, a user will:
1. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
   
+ `User` class will need to have a `rankJobs()` function to fulfill this functionality;
  
2. Select two jobs to compare and trigger the comparison.

+ `User` class has a `compareJobs()` function;

3. Be shown a table comparing the two jobs, displaying, for each job: Title, Company, Location, Yearly salary adjusted for cost of living, Yearly bonus adjusted for cost of living, Retirement benefits, Relocation stipend, Restricted stock unit award

+ Since the cost of living is expressed as an **living index**, it's better to store this information inside the `Job` class. `livingIndex` is a *hashmap* that maps the location to the actual living cost.

4. Be offered to perform another comparison or go back to the main menu.

+ This is a GUI related functionality, and it's not shown in the UML diagram;

### Requirement #6
When ranking jobs, a job’s score is computed as the weighted sum of:

AYS + AYB + RS + (RPB * AYS / 100) + (RSUA / 4)

+ This is the implementation detail, and it should not shown in the UML diagram;

### Requirement #7
The user interface must be intuitive and responsive.

+ This is a GUI related functionality, and it's not shown in the UML diagram;

### Requirement #8
For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

+ This is an assumption and shoud not shown in the UML diagram;