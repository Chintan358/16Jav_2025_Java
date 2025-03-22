<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

<script type="text/javascript">

		$(document).ready(function(){
			
			$("#upbtn").hide()
			loadData()
			
		})

		const loadData = ()=>{
				
			$.get("display",{},(rt)=>{
				
				data = JSON.parse(rt)
				var rows=""
				data.map(ele=>{
					
					rows+="<tr><td>"+ele.id+"</td><td>"+ele.uname+"</td><td>"+ele.email+"</td><td>"+ele.phone+"</td><td><button onclick='deleteuser("+ele.id+")' class='btn btn-danger'>Delete</button></td><td><button onclick='edituser("+ele.id+")' class='btn btn-primary'>Update</button></td></tr>"
					
				})
				
				$("#tdata").html(rows)
			})
		}

		const addUser = ()=>{
			
			var uname = $("#uname").val()	
			var email = $("#email").val()	
			var phone = $("#phone").val()	
			var pass = $("#pass").val()	
			
			$.post('adduser',{uname,email,phone,pass},(rt)=>{
				alert(rt)
				loadData()
				
				$("#uname").val("")	
				$("#email").val("")
				$("#phone").val("")
				$("#pass").val("")	
			})
			
			}
		
			const updateUser = ()=>{
			
				var id = $("#id").val()
			var uname = $("#uname").val()	
			var email = $("#email").val()	
			var phone = $("#phone").val()	
			var pass = $("#pass").val()	
			
			$.post('updateuser',{id,uname,email,phone,pass},(rt)=>{
				alert(rt)
				loadData()
				
				$("#uname").val("")	
				$("#email").val("")
				$("#phone").val("")
				$("#pass").val("")	
				
				$("#upbtn").hide()
				$("#smbtn").show()
			})
			
			}
		
		
		const deleteuser = (did)=>{
			
			$.get("update",{"did":did,"action":"delete"},(rt)=>{
					alert(rt)
					loadData()
			})
			
		}
		
	const edituser = (did)=>{
			
			$.get("update",{"did":did,"action":"update"},(rt)=>{
					
				data = JSON.parse(rt)
				$("#id").val(data.id)
				$("#uname").val(data.uname)	
				$("#email").val(data.email)
				$("#phone").val(data.phone)
				$("#pass").val(data.pass)	
				
				$("#upbtn").show()
				$("#smbtn").hide()
			})
			
		}
	
		const emailCheck = (value)=>{
			
			$.get("emailcheck",{value},(rt)=>{
				var email = document.getElementById("email")
				var emailErr = document.getElementById("emailErr")
				if(rt=="true")
				{
					email.style.border="1px solid red"
					emailErr.innerHTML="Email already exist !!!"
					$("#smbtn").prop('disabled', true);
				}
				else
				{
					email.style.border=""
					emailErr.innerHTML=""
					$("#smbtn").prop('disabled', false);
				}
			})
		}
		
		const search = (value)=>{
			
			$.get("search",{value},(rt)=>{
				
				data = JSON.parse(rt)
				var rows=""
				data.map(ele=>{
					
					rows+="<tr><td>"+ele.id+"</td><td>"+ele.uname+"</td><td>"+ele.email+"</td><td>"+ele.phone+"</td><td><button onclick='deleteuser("+ele.id+")' class='btn btn-danger'>Delete</button></td><td><button onclick='edituser("+ele.id+")' class='btn btn-primary'>Update</button></td></tr>"
					
				})
				
				$("#tdata").html(rows)
			})
			
			
		}

</script>

</head>
<body>
			<div class="container">
			<div class="row">
			<div class="col-4 card p-3 mt-5">
			<h2>User Registration</h2>
			<hr>
			<input type="hidden" id="id">
			<div class="form-group">
			
			<label>Username</label>
			<input type="text" id="uname" placeholder="Enter username" class="form-control">
			</div>
			
			<div class="form-group">
			<label>Email</label>
			<input type="text" id="email" placeholder="Enter Email" onblur="emailCheck(value)" class="form-control">
			<span id="emailErr" class="text-danger"></span>
			</div>
			
			<div class="form-group">
			<label>Phone</label>
			<input type="text" id="phone" placeholder="Enter Phone" class="form-control">
			</div>
			
			<div class="form-group">
			<label>PAssword</label>
			<input type="text" id="pass" placeholder="Enter Password" class="form-control">
			</div>
			<br>
			<div class="form-group">
			
			<input type="submit" value="Submit" id="smbtn" onclick="addUser()"  class="btn btn-success">
			<input type="submit" value="Update" id="upbtn" onclick="updateUser()"  class="btn btn-success">
		
			</div>
			</div>
			<div class="col-1"></div>
			<div class="col-7 card p-3 mt-5">
			<h2 align="center">User Details</h2>
			<hr>
				<input type="text" onkeyup="search(value)" placeholder="Search..." class="form-control">
				<br>
				<table class="table">
				<thead>
				<tr>
				<th>Id</th>
				<th>Username</th>
				<th>Email</th>
				<th>Phone</th>
				<th colspan="2">Action</th>
				
				</tr>
				</thead>
				<tbody id="tdata">
				
				</tbody>
				</table>
			</div>
			</div>
			</div>
			
</body>
</html>