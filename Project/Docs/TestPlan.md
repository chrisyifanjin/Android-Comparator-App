# Test Plan

*This is the template for your test plan. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: 6300Spring22Team007

## 1 Testing Strategy

### 1.1 Overall strategy

*This section should provide details about your unit-, integration-, system-, and regression-testing strategies. In particular, it should discuss which activities you will perform as part of your testing process, and who will perform such activities.*

unit-: after complete each individual component implementation, add related unit tests to test against that component.

integration-: after 2 or more related components competed, add integration tests to make sure the components interact with each other as expected.

system-: black-box testing with test cases prepared prior to the development, identify each independent functional features and design test cases for it.

regression-: after any code change(bug fix or improvement) added after the development has done, add more related uint/integration/system tests if needed, and re-run all the tests before to make sure everything is still fundtioning as expected.

### 1.2 Test Selection

*Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

unit-: white-box. (control flow based)

integration-: black-box.

system-: black-box.

regression-: white-box and black-box

### 1.3 Adequacy Criterion

*Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

unit-: control flow based, covers every execution path

integration-: covers all interaction between different components.

system-: covers all funtional features of the software.

regression-: make sure old tests are run after each new code change.

### 1.4 Bug Tracking

*Describe how bugs and enhancement requests will be tracked.*

Record them done in github `Issues`

### 1.5 Technology

*Describe any testing technology you intend to use or build (e.g., JUnit, Selenium).*

JUnit

## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*

|Test case #|purpose|steps|expected result|actual result|pass/fail|remark|
|---|---|---|---|---|---|---|
|1.1  |test enter/edit current job details successful flow|<ol><li>enter/edit job detail button clicked</li><li>enter/edit job details</li><li>save button clicked</li></ol>|the job detail entered/edited saved to database and pop up success msg| O |  / | /|
| 1.2  | test enter/edit current job details failed flow  |  <ol><li>enter/edit job detail button clicked</li><li>enter/edit job details with some invalid field values</li><li>save button clicked</li></ol> |  pop up error msg showing which field(s) invalid | O |  / |  / |
|  1.3 | test enter/edit current job details back flow  |  <ol><li>enter/edit job detail button clicked</li><li>enter/edit job details</li><li>cancel and exit without saving button clicked</li></ol> |  back to main menu and the entered/edited job detail not saved to database | O | /  |  / | 
|  2.1 | test enter job offers successful flow |  <ol><li>enter job offers button clicked</li><li>enter job offers</li><li>save button clicked</li></ol> |the job offer entered saved to database and pop up success msg| O  | /  |  / | 
| 2.2  | test enter job offers failed flow  |  <ol><li>enter job offers button clicked</li><li>enter job offer with some invalid field values</li><li>save button clicked</li></ol> |  pop up error msg showing which field(s) invalid |  O |  / |  / | 
|  2.3 | test enter job offers back flow |  <ol><li>enter job offers button clicked</li><li>enter job details</li><li>cancel and exit without saving button clicked</li></ol> |  back to main menu and the new job offer not saved to database | O  | /  |  / | 
|  2.4 | test enter job offers successful and continue add job offer flow |  <ol><li>enter job offers button clicked</li><li>enter job offers</li><li>save button clicked</li><li>enter another offer button clicked</li></ol> |  the job offer entered saved to database and the page refreshed to enter new offer | O  | /  |  / |
|  2.5 | test enter job offers successful and compare with current job(present) flow |  <ol><li>enter job offers button clicked</li><li>enter job offers</li><li>save button clicked</li><li>comapre with current job button clicked</li></ol> |  the job offer entered saved to database and the comparison page will be shown | O | /  |  / |
|  2.6 | test enter job offers successful and compare with current job(not present) flow |  <ol><li>enter job offers button clicked</li><li>enter job offers</li><li>save button clicked</li><li>comapre with current job button clicked</li></ol> |  the job offer entered saved to database and the comapre with current job button click will trigger error msg no current job | O  | /  |  / |
|  3 | test adjust comparison settings flow |  <ol><li>adjust comparison settings button clicked</li><li>assign integer weights to settings</li><li>save button clicked</li></ol> |  comparison settings adjusted saved to database | O | /  |  / |
|  4.1 | test compare job offers normal flow |  <ol><li>compare job offers button clicked</li><li>be shown ranked job list and choose 2 to trigger comparison</li><li>after compare page showed, back to main menu button clicked </li></ol> |  be shown a table comparing the 2 job details, then go back to main menu | O  | /  |  / |
|  4.2 | test compare job offers and continue comparing flow |  <ol><li>compare job offers button clicked</li><li>be shown ranked job list page and choose 2 to trigger comparison</li><li>after compare page showed, perform another compare clicked </li></ol> |  be shown a table comparing the 2 job details, then go to ranked job list page again | O  | /  |  / |


Weekly 3
- Success in 1.1, 1.2, 1.3, 3
