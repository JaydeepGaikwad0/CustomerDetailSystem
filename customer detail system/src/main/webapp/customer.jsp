<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Customer details</title>
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
  
     <h1><div align ="center">Customer Details</h1>
     <br> 
<form action="CustomerServlet" method="get">
<div style='margin:auto;width:700px;margin-top:50px;'>
 

		


  <div class="row">
    <div class="col">
    <lable>Firstname</lable>
    
      <input type="text" name="Firstname">
    </div>
    
    <div class="col">
    <lable>Lastname</lable>
      <input type="text" name="Lastname">
    </div>
  </div>
    <div class="row">
    <div class="col">
    <br>
    <lable>Street</lable>
      <input type="text" name="Street">
    </div>
    <div class="col">
    <br>
    <lable>Address</lable>
      <input type="text" name="Address">
    </div>
  </div>
    <div class="row">
    <div class="col">
    <br>
    <lable>City</lable>
      <input type="text" name="City">
    </div>
    <div class="col">
    <br>
    <lable>State</lable>
      <input type="text" name="State">
    </div>
  </div>
    <div class="row">
    <div class="col">
    <br>
    <lable>Email</lable>
      <input type="text" name="Email">
    </div>
    <div class="col">
    <br>
    <lable>Phone</lable>
      <input type="text" name="Phone">
    
  

    
</div>
</div> 


</div>
<br>

<div align="center">
<button align='center' type="submit" class="btn btn-primary">ADD CUSTOMER</button>


</div>




</form>
<br>
      
     <a href = "showdata"><div align='center'><button type='button'>Show Customer</button></a></button><br>


</div>


  
   


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  </body>
</html>