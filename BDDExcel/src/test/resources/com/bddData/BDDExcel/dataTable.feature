
Feature: I want to read excel

  @tag1
  Scenario: Convert table to user defined1
    Given Excel filename and Location is given as
    |Excel|Location|Sheet|
    |TestUserData.xlsx|C:\Users\2172261\git\BDDExcelMar2024\BDDExcel\src\test\resources\files\TestUserData.xlsx|BaseDetail|
    
   @tag2
  Scenario: Convert table to user defined2
    Given Excel filename and Location is given for second as
    |Excel|Location|Sheet|Index|
    |TestUserData.xlsx|C:\Users\2172261\git\BDDExcelMar2024\BDDExcel\src\test\resources\files\TestUserData.xlsx|BaseDetail|3|
    
  @tag3
  Scenario: Convert table to user defined3
    Given Excel filename and Location is given for third as
    |Excel|Location|Sheet|
    |TestUserData.xlsx|C:\Users\2172261\git\BDDExcelMar2024\BDDExcel\src\test\resources\files\TestUserData.xlsx|FullDetails|
    
  @tag4
  Scenario: Convert table to user defined4
    Given Excel filename and Location is given for fourth as
    |Excel|Location|Sheet|Index|
    |TestUserData.xlsx|C:\Users\2172261\git\BDDExcelMar2024\BDDExcel\src\test\resources\files\TestUserData.xlsx|FullDetails|5|
