# Design description

1. The user can enter or edit current job details, enter job offers, adjust the comparison settings and rank job offers. 

 - To fulfil this requirement, the **userSystem** must have functionalities including `addJob`, `rankJob`, `adjustWeighting` and `compareJobs`.

2. The user can have multiple job offers (including the current job)

- To fulfil this requirement, I use a array to store job offers and current jobs in the **userSystem**.
- Therefore, the **userSystem** can add job into the **ArrayList<Job>** to make the storage.

3. Current job has title, company, location, cost of living in the location, yearl salary,Yearly bonus, retirement benefits, relocation stipend, and restricted stock unit award.
`
- To fulfil this requirement, I add `Title: String`, `CompanyName: String`, `City: String`, `State: String`, `livingIndex: int`, `yearlySalary: double`, `bonus: double`, `retirementBenefits: double`, `relocationStipend: double`, `RSU: double` into the **Job** class.

4. The user can add a new job offer or compare offers with current job details and also take two jobs to compare and trigger the comparison.

- To fulfil this requirement, I add **compareJobs** to user class, which takes two job as input.

5. A job entered can be either canceled or saved.

- To fulfil this requirement, I add **saveJob** and **cancelJob** function into job class.

6. **comparisonSettings** have yearly salary, yearly bonus, retirement benefits, relocation stipend, and restricted stock unit award.

- To fulfil this requirement, I add a new class comparison setting with the variables defined above.

7. The user can adjust the weight to attributes in **comparisonSettings**. Moreover, I initialize the weight as 1 for each attributes.

To fulfil this requirement, I add **weightAdjusting** funtion into the user class.

8. The user can rank the job offers based on the score calculated for each job.

To fulfil this requirement, I add a new class represents score. Since there are multiple jobs. We need a hashmap to represent job and the corresponding score. 

9. The score is calculated based on the specific job and comparison weighting.

To fulfil this requirement, I add a function to calculate score in score class.

10. The score is calculated based on AYS,  AYB, RS, RPB, RSUA. 

To fulfil this requirement, I add these variables into score class.
