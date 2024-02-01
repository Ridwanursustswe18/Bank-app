# Introduction
- It is a banking JAVA console application. It consists of 8 functionalities.
  - Create Account
  - Show accounts
  - search acccount by account no
  - Deposit into an account
  - Withdraw from an account
  - Update details(only account_type,but can be further extended)
  - Delete account
  - exit from application
# Code Structure
- I tried to implement single responsibility principle for all the functionalities.
- I used aggregation to use one object in other class and avoided close coupling.
- Tried to handle nullException efficiently

# how the application works
- First the operator has to create accounts otherwise he cannot use any other functions.
- Then he can use all other functions.
- When creating account operator has to deposit an certain amount of money for different type of account. For example : saving 500 is minimum and so on.
- When Withdrawing he has to keep certain amount of money for specific accounts