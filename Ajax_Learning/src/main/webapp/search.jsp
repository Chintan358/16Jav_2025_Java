<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			$.get('countries',{},function(rt){
				$("#country").html(rt)
			})
			
		})
	
		const search = (value)=>{	
			$.get('search',{value},function(rt){
				$("#result").html(rt)
			})	
		}
		
		const getState = (cid)=>{
			$.get('states',{cid},function(rt){
				$("#state").html(rt)
			})
		}
		
		const getCity = (sid)=>{
			$.get('cities',{sid},function(rt){
				$("#city").html(rt)
			})
		}
	
	</script>
</head>
<body>
			
			<input type="text"  placeholder="search here..." onkeyup="search(value)">
			<div id="result"></div>
			
			
			<br>
			<br>
			<select id="country" name="country" onchange="getState(value)">
			<option>---Select country---</option>
			</select>
			
			<select id="state" name="state" onchange="getCity(value)">
			<option>---Select State---</option>
			</select>
			
			<select id="city" name="city">
			<option>---Select city---</option>
			</select>
			
			
			
			
			
			
</body>
</html>