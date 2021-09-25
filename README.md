Expense Reimbursement App

Project Description:
The Expense Reimbursement App is created to give employees the ability to a request reimbursement for a payment they have made, view their pending requests, or past requests. 
From there the financial managers will use their judgement to see if the reimbursement request should be approved or denied. The managers will also be able to view all of the
employee reimbursement requests that have been sent, or they can filter them by their condition. 

Technologies Used:
Java
PostgreSQL
Javascript
CSS
AWS RDS

Features of the project:
- User can login as employee or financial manager.
- Employees can make a new reimbursement request.
- Employees can view all their current pending requests or past requests.
- Financial managers can view all reimbursement requests.
- Financial Managers can view reimburse requests through the condition of the requests.

To-do list:
- Improve the CSS.
- Add Encryption.
- Add Email Response.
- Add Receipt for User.
- Allow Financial Manager to add new account.

Getting Started:
* Make sure you have IntelliJ, Visual Studio Code, and DBeaver.
* Copy the the GitHub link url and paste it on the address bar.
* Next, click on the clone on the top right corner, and copy the HTTPS link.
* Once you have done this, then select the folder in your computer where you want the repository to be.
* Use Git Bash and put this command: git clone https://github.com/Leger123/Expense-Reimbursement-App.git.
* Open your IntelliJ and open up the "Project_1_ERS_Kevin_Dian" project folder.
* Inside the IntelliJ, make sure you set up the SmartTomcat configuration int as shown in PNG file named "Project_1_Instructions_1".

![Project_1_Instructions_1](https://user-images.githubusercontent.com/90068310/134623844-4e0f2f5f-877e-489b-a2d5-7b39a61c52d1.PNG)

* Make sure you set up the environment variables (DATABASE_USERNAME, DATABASE_PASSWORD, DATABASE_URI) up in IntelliJ and put the appropriated values. The images below will give you an example.

![Project_1_Instructions_4](https://user-images.githubusercontent.com/90068310/134749119-3b6073bf-cfa7-4c94-a101-13a291304d1e.PNG)

![Project_1_Instructions_5](https://user-images.githubusercontent.com/90068310/134749175-214c0093-d604-48e9-80a2-dbf57f004f6d.PNG)

* Open up DBeaver and create a new database for the project
* Make a new SQL Script and be sure to have the following code to set up the tables for the project:

CREATE TABLE ers_user_roles(
	ers_role_id SERIAL PRIMARY KEY NOT NULL,
	ers_role varchar(20) NOT NULL
);
CREATE TABLE ers_users(
	ers_users_id SERIAL PRIMARY KEY NOT NULL,
	ers_username varchar(50) UNIQUE NOT NULL,
	ers_password varchar(50) NOT NULL,
	user_first_name varchar(100) NOT NULL,
	user_last_name varchar(100) NOT NULL,
	user_email varchar(100) UNIQUE NOT NULL,
	ers_role_id_fk int REFERENCES ers_user_roles(ers_role_id) NOT NULL
);
CREATE TABLE ers_reimbursement(
	reimb_id SERIAL PRIMARY KEY NOT NULL,
	reimb_amount NUMERIC(13,2) NOT NULL,
	reimb_submitted TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	reimb_resolved TIMESTAMP DEFAULT NULL,
	reimb_description varchar(250),
	reimb_receipt BYTEA DEFAULT NULL,
	ers_users_fk_auth int REFERENCES ers_users(ers_users_id) NOT NULL,
	ers_users_fk_reslvr int DEFAULT NULL REFERENCES ers_users(ers_users_id),
	ers_reimbursement_status_fk int DEFAULT 1 REFERENCES ers_reimbursement_status(reimb_status_id) NOT NULL,
	ers_reimbursement_type_fk int REFERENCES ers_reimbursement_type(reimb_type_id) NOT NULL
);
CREATE TABLE ers_reimbursement_type(
	reimb_type_id SERIAL PRIMARY KEY NOT NULL,
	reim_type varchar(20) NOT NULL
);
CREATE TABLE ers_reimbursement_status(
	reimb_status_id SERIAL PRIMARY KEY NOT NULL,
	reimb_status varchar(20) NOT NULL
);

* Your Schema should look like the following:

![Project_1_Instructions_6](https://user-images.githubusercontent.com/90068310/134751595-d0faa8dd-a30c-45d7-bb72-c0f098180d26.PNG)

* Create some dummy accounts, in order to test the project. The image below will give you an example.

INSERT INTO ers_users VALUES (DEFAULT, 'username', 'password', 'John', 'Doe', 'johndoe@hotmail.com', 1);
INSERT INTO ers_users VALUES (DEFAULT, 'money', 'stock', 'King', 'Solomon', 'proverbsforlife@yahoo.com', 2);

* Run the SmartTomcat on IntelliJ
* Click on this link to access the website, once you activated the SmartTomcat: http://localhost:9000/Project_1_ERS_Kevin_Dian/

![Project_1_Instructions_7](https://user-images.githubusercontent.com/90068310/134752586-4b2008db-8619-4587-91c2-0e6671dcd14b.PNG)

Usage
* You will first need to login, as either an employee or a financial manager
![Project_1_Instructions_8](https://user-images.githubusercontent.com/90068310/134752692-521c6947-4c5b-4f7b-bd7b-e4ac2719f836.PNG)

* For the employee page you can view all pending requests on the main screen, view all past requests, and create a reimbursement request. The following images will show the employee ID and employee dashboard page.

![Project_1_Instructions_9](https://user-images.githubusercontent.com/90068310/134753748-5f1c1926-895e-4a56-a75f-b4bb236f7063.PNG)
![Project_1_Instructions_10](https://user-images.githubusercontent.com/90068310/134753750-3433df92-02e6-4302-8fa5-801af7e56ab2.PNG)

* For the financial manager page you can view all reimbursement requests on the main screen, view all pending, approved, and denied requests through a filter. Finally, you can also approve or deny a reimbursement request on the main page or through viewing all pending requests. The following images will show the finanacial manager ID and manager dashboard page.

![Project_1_Instructions_11](https://user-images.githubusercontent.com/90068310/134753819-cb5619bf-b386-499f-83ff-6f5b41d663a5.PNG)
![Project_1_Instructions_12](https://user-images.githubusercontent.com/90068310/134753821-17804031-c0da-4813-883a-d1ce8f2f5be2.PNG)
![Project_1_Instructions_13](https://user-images.githubusercontent.com/90068310/134753824-29476019-39d0-4031-8e43-cdca30a3fb26.PNG)
![Project_1_Instructions_14](https://user-images.githubusercontent.com/90068310/134753825-1327d9ad-9040-41f0-857e-84af795c1667.PNG)
![Project_1_Instructions_15](https://user-images.githubusercontent.com/90068310/134753827-51394fed-4470-4748-922d-c55eda2f290a.PNG)

* Any user can logout by clicking the "Logout button on the top right corner"
![Project_1_Instructions_16](https://user-images.githubusercontent.com/90068310/134753857-250264b3-d9c2-4dae-8661-c56691693ea3.PNG)

* Further note: Sessions are used to check whether the user is logged in. If this is the case, then any attempt to go back to the login page will fail and the program will redirect them bcak to the dashboard pages of their respective roles.





