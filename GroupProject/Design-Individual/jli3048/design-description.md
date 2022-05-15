


****Design description****

	1. 
       
       To realize this requirement, I added main class ‘App’ that represents the entry point to the system. Added class 'Job' to represents the current job or job offers as they have the same detail fields, method 'New' used for (2) and method 'Update' used for (1). Added class 'ComparisonSettings' to represents the job conparison setting. Added class 'JobRankList' and 'ComparisonDisplay' both used for (4).

	2. a
        
        To realize this requirement, added all the details as attributes of class 'Job'
	
	2. b

		This is not represented in my design, as it will be handled entirely within the GUI implementation. only need to decide whether to call method 'Update' of class 'Job'.
	
	3. a, b, c(1), c(2)

		Same as 2.a and 2.b

	3. c(3)

		To realize this requirement, the method 'New' for class 'Job' will return boolean to indicate whether to compare the new job offer with current job.

	4.
		To realize this requirement, the method 'New' of class 'ComparisonSettings' will initialize the settings(weights) and method 'Adjust' is used to update the weights.

	5. a

		To realize this requirement, the class 'JobRankList' is used to show the list of ranked job offers with current job(if presents).

	5. b,c,d

		To realize this requirement, only need GUI impelentation to get the selected data from backend.

	6.

		 To realize this requirement, method 'GetRankList' of class 'JobRankList' will using the formula to calculate the weighted sum of each job offers and current job(if present) and rank them according to their weighted sum, and store the sorted list as class attribute 'RankList'.

	7,8.

		This is not represented in my design, as it will be handled entirely within the GUI implementation.
