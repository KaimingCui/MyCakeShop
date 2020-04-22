# MyCakeShop

## Introduction

  This is a website for cake shop. It is divided into the front-end product page and the back-end management interface. The product pages is the page customes look through.
  It shows the recommended cake, consumers can click the button to view the cake details. At the top, consumers can see the search category and filter cakes based on the category.
  I did not implement the shopping cart function in this project.  
  
  At the bottom of the homepage, you can click on 'Admin login' to to go to the background management login interface. One account has been added, username is admin, password is admin. Once login, you can manage the cakes and categories, executing  CRUD oprations. Each cake has an attribute 'status', the cakes have status '推荐' and '特卖' will be displayed on the index.jsp. 
  
  
## Environment

* Java JDK 10
* mysql
* Dao layer uses Mybatis
* IU layer uses jsp and servlet
* pageHelper is used
* fileupload

## structure

  One servlet called GlobalController is the dispacher controller. It will analyse the servlet request and decide which controller this request should be forwared. controllers will call service layer, service layer calls Dao layer to do CRUD operations.  
  
  Two filters implemented, one for encoding, another for login filtering.  
  
  visit this url after start the project: {context}/index.do

## Show results

### Product pages

![index page](https://github.com/KaimingCui/MyCakeShop/blob/master/1.png)  
![index page](https://github.com/KaimingCui/MyCakeShop/blob/master/2.png)  
![index page](https://github.com/KaimingCui/MyCakeShop/blob/master/3.png)  

### Manage pages
![index page](https://github.com/KaimingCui/MyCakeShop/blob/master/4.png)  
![index page](https://github.com/KaimingCui/MyCakeShop/blob/master/5.png)  
![index page](https://github.com/KaimingCui/MyCakeShop/blob/master/6.png)  
![index page](https://github.com/KaimingCui/MyCakeShop/blob/master/7.png)  
![index page](https://github.com/KaimingCui/MyCakeShop/blob/master/8.png)  
![index page](https://github.com/KaimingCui/MyCakeShop/blob/master/9.png)  
![index page](https://github.com/KaimingCui/MyCakeShop/blob/master/10.png)  

