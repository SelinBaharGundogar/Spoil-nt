Group Number : G1B
Title : Spoil’nt
Group Name : Entrepreneurs
Project’s Current Status : Working


Description:
The desktop application Spoil’nt aims to decrease food waste by creating a platform for markets to offer items with close expiration dates to their customers for free. The application will work as a system to limit ‘purchases’ per day for each user to prevent any misuse of obtaining a surplus of items. The application will accomplish this by assigning an ID to each one of its customer users. Each customer will only be able to add a certain quantity of food offered on the application per day to their online baskets. The customers will be able to obtain these items by going to the market in person and having their IDs checked by the market through the application. 

What has  been done so far?

Admin Side:

Registration and logging are complete and work perfectly. Admin users can change their name and/or passwords. The brief statistics about the user count and market count in the program are written. Admins can search markets or customers by writing their ID, and they can see markets’ past items and customers’ basket items. Also, admins can delete a customer or a market from the system, if they want. All of the implemented parts on the admin side are working. We have not implemented running maintenance on the system and sending notifications to customers and markets in the program.

Customer Side:

Registration and logging are complete and work perfectly. Customers can change their name,surname,username,address. They can also change their passwords. The most discounted items are listed on the main page. Users can go to four different categorization pages and can add the items to their basket from there. They can go to categorization pages by using the search textfield. On the main page, the most helpful markets are visible too according to the item count in the markets. The items in the basket of the customer are also listed on the main page. In the profile page, users can see the past items that they have bought so far from the application. If they want, they can evaluate the items by giving points out of 5. Last but not least, we added information pages to explain why we have created this program,food waste and climate change and poverty, and the tips to not to waste food.  All of the implemented parts in the customer side are working. We have not implemented commenting items in the program, we have thought that rating the items was enough for evaluation.

Market Side:

Registration and logging are complete and work perfectly. Markets can change their name,email,address. They can also change their passwords. They can change their market logo if they want. They can also deactivate their account by clicking the radio button. In the add item page, they can add items by item name, category, expiration date, quantity and amount, price and brand.Market users can remove items from their market, if they wish. In the ID page, they can search the customer's ID and sell the items in that customer’s basket. In the profile page, the past items of that market are listed.All of the implemented parts in the market side are working. We have not implemented the see reviews section since we have not implemented commenting in the program, as explained with the reasons at the last sentence in the Customer Side section.

Group Members and Their Contributions

Emre Karataş-
Designing GUI with Aslı. Working with other group members to connect GUI with model and data classes.Debugging the code with the whole team.

Selin Bahar Gündoğar-
Coding model classes with Parsa. Working with other group members to connect model classes with GUI. Debugging the code with the whole team.

Aslı Karaman-
Designing GUI with Emre. Working with other group members to connect GUI with model and data classes.Debugging the code with the whole team.

Parsa Keihan-
Coding model classes with Selin. Working with other group members to connect model classes with GUI. Debugging the code with the whole team.

Ahmet Arda Ceylan-
Coding data classes. Working with other group members to connect data classes and model classes with the controller classes. Debugging the code with the whole team.



Technology Details

We coded our project only in Java on IntelliJ and used Scene Builder for our GUI. We used the Scene Builder version 16.0.0 and integrated it inside IntelliJ. We downloaded the javafx-sdk-16 to work on our Scene Builder which is why we also had to use Java SDK version 16 to work the application. We did not use any API for our project but we had to add the javafx-sdk-16 as a lib to our project. Some of us used the MacOS operating system and some of us used the Windows version of the javafx-sdk-16 but as long as the version number was the same, there were no problems. 

 How to set up the project?

After downloading the code for our application, the person will have to check if they have javafx-sdk-16 and Java jdk 16 downloaded on their computers to run the program. As we used IntelliJ to code our application and our GUI is supported by JavaFX, the person will have to open Project Structure, click on libraries, click on the plus sign, click on java sign, add the lib folder of the javafx-sdk-16, click on apply, and click on OK. The person will then have to click on the edit configurations button, click on Modify Options, click on Add VM Options, the copy paste   “ --module-path “path file” --add-modules Javafx.controls,javafx.fxml “
to the space given where the “path file” needs to be the path of the javafx-sdk-16-lib folder inside the computer written without the quotation marks. We have not tried to run this program without integrating Scene Builder to IntelliJ so the person may also need to download Scene Builder from Gluon website, the version that fits their operating system. When the person clicks on the run button, the application should open up.
