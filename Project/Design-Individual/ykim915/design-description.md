# Design-Description

Purpose for the Software Design :

1 Enter and edit job details
2 Enter a job offer
3 Adjust recruitment comparison settings
4 Job offer comparison available on screen

==================================================
[Main Class (Top Class in hierarchy)]

*Function*
CurrentJob Function:  Go to the Current Job Class 
JobOffer Function: Go to the Job Offer Class
Comparison Setting Function: Go to the Comparision Setting Class
Comparision Function: Go to the Comparision Class (Notice: disabled if no job offers are available)

==================================================

[Current Job Class] 
Purpose: To enter/edit details of the current job

*Function*
RequestJobInfo Function: If there is information about the current Job, it is requested from the database
SaveJobInfo Function: Save Job Information to the database
EditJobInfo Function:  Edit Job Information to the database
NavigateMain Function: Go back to the Main Class

[Job Offer Class]
Purpose: To enter/edit details of the Offer job

*Function*
SaveOfferInfo Function: Save Job Offer Information to the database
CancelOfferInfo Function: Cancel to write Job Information to the database
EditOfferInfo Function:  Edit Job Information to the database
CompareOffer Function:  Compare Current Job and Job Offer Information
NavigateMain Function: Go back to the Main Class

[Comparison Setting Class]
Purpose: To set weight value for Comparison
Notice: no weights are assigned, all factors are considered equal.

*Function*
SaveWeight Function: Save weight value to the database
EditWeight Function: Edit weight value to the database
NavigateMain Function: Go back to the Main Class

[Comparison Class]
Purpose: To Show the difference between current job and offer jobs

*Function*
RequestJobList Function: Request JobList from the database, if there is job list
SelectTwoJob Function: Select two jobs for comparison
Cancel Function:  Cancel to select two Job in the job list 
CompareTwoJobs Function: Call CompareTwoJobs Class
NavigateMain Function: Go back to the Main Class


==================================================

CompareTwoJobs Class
*Function*
ShowComparison Function: To show the difference between information of current job and offer job

Compare Class
*Function*
ShowComparison Function: To show the difference between two information of selected jobs 

==================================================

JobList Class
A class that defines job rank-related property values for comparision

*Function*
CalculateRank Function: To use the rank equation in the utility to determine the rank of Job lists.

AdjustedJob Class
A class that defines and calculate job-related property values by Cost of living in the location(Index - https://www.expatistan.com/cost-of-living/index/north-america)

*Function*
Adjust Function: To determine yearly salary and yearly bonus by index of living cost 

==================================================

Job Class
A class that defines job-related property values

Weight Class
A class that defines weight-related property values for calculating job information

==================================================

Utility
Rank equation : AYS + AYB + RS + (RPB * AYS / 100) + (RSUA / 4)


