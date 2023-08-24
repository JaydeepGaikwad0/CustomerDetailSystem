<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login Page</title>
    <style type="text/css">
    lable{
width:100px;
display:inline-block;
}

    h1{
    color:blue;
    }
   </style>
   
  </head>
  <body>
   <link rel='stylesheet' href='css/bootstrap.css'></link>
   
   <div class='form' style='margin:auto;width:300px;margin-top:100px'>
   
    <h1><div align='center'>login Page</h1>
    <br>
  <form action ="login">
  <div class="conatiner">
   
   <div class="row">
   
   
    <label>Login id</label>
    
    <input width:80%; type="text" name="name">
    
   </div>
   <br>
   <div class="row">
   
      
      <label>Password</label>
    <input width:80%; type="password"  name="pass">
    
   </div>
   
   
    
  
  <br>
  
  <button type="submit" class="btn btn-primary">Login</button>
  
  </div>
  
  
  </form>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  
  </body>
  
</html>