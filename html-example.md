
# Use this link for preview

```link
https://codepen.io/akshay117/pen/xxjgedL

```

```html

Petstore html


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Store</title>
    <style>
        h1{
            text-align: center;
            background-color: antiquewhite;
            

        }
.grid-container {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-gap: 5px;
} 
    </style>
</head>
<body>

    <h1 style= text-align:center;  >Pet Store</h1>

<div class="grid-container">
  <div class="grid-child purple">
    <img src="cat.jpg" alt="Seems this images does not exist" height="300px" width="200">
    <h3>Cats</h3>
    <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Unde animi nemo ipsam eos itaque, assumenda magnam quod perferendis qui facere facilis minus ducimus hic perspiciatis minima quidem architecto maxime suscipit.</p>
    <a href="dogs.com">know more</a>
    <br>

  </div>
 
    <div class="grid-child purple">

        <img src="dog.jpg" alt="Seems this images does not exist" height="300px" width="200">
        <h3>Dogs</h3>    
        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Assumenda fuga ab maiores expedita est tenetur nihil fugiat rerum perspiciatis pariatur eum impedit, ipsum adipisci eligendi, a nemo minus, magnam facere?</p>
        <a href="dogs.com">know more</a>
        <br>
    </div>
    
    <div class="grid-child purple">
        <img src="bird.jpg" alt="Seems this images does not exist" height="300px" width="200">
        <h3>Birds</h3>
        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fugit tempore, recusandae nam deleniti nobis in velit asperiores, qui modi, cupiditate quaerat rem totam repellat. Perspiciatis unde ipsa sed exercitationem accusamus?</p>
        <a href="dogs.com">know more</a>
        <br>
        <br>

    </div>
   

</div>


    <center>
        <form title="User Registration">
            
            <div>
                <h3>User Registration</h3>
                <label for="Name" >        Name:  </label>
                <input type="text" placeholder="Enter your  Name" id="Name">
                 <br>
                 
                <label for="address" >Address</label>
                <br>
                <textarea name="address" id="address" cols="25" rows="5"></textarea>
                <br>
                <label for="email">Email</label>
                <input type="email" placeholder="Enter your email" id="email" > 
                <br>
                <label for="pets">Recently owned any pet</label>
                <input type="radio" value="Yes" name="pets"> Yes
                <input type="radio" value="No" name="pets"> No
                <br>
                <br>
                <input type="submit">
    
            </div>
    
        </form>
    </center>
   
   
</body>
</html>

```
