<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
<form onsubmit="validateInfo()">
id<input type="text" name="id"><br>
pwd<input type="password" name="pwd"><br>
pwdChk<input type="password" name="pwdChk"><br>
age<input type="number" name="age"><br>
email<input type="text" name="email"><br>
<button>join</button>
</form>
</body>
<script>
function validateInfo(){
	var id = document.querySelector('input[name=id]').value;
	var pwd = document.querySelector('input[name=pwd]').value;
	var pwdChk = document.querySelector('input[name=pwdChk]').value;
	var age = document.querySelector('input[name=age]').value;
	var email = document.querySelector('input[name=email]').value;
	var emailChk = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if(id==""){
		alert('id를 입력해 주세요');
		id.focus();
		return false;
	}
	if(id.length<4){
		alert('id는 5글자 이상입니다');
		id.focus();
		return false;
	}
	if(pwd==''){
		alert('password를 입력해주세요');
		pwd.focus();
		return false;
	}
	if(pwd.length<=7){
		alert('password는 8글자 이상입니다');
		pwd.focus();
		return false;
	}
	if(pwd!=pwdChk){
		alert('password를 확인해주세요');
		pwdChk.focus();
		return false;
	}
	if(age=="") {
        alert("age을 입력해 주세요");
        age.focus();
        return false;
    }
	if(age<=0){
		alert('나이는 1~129까지 가능합니다');
		age.focus();
		return false;
	}
	if(age>=130){
		alert('나이는 1~129까지 가능합니다');
		age.focus();
		return false;
	}
	if(email=="") {
        alert("이메일을 입력해 주세요");
        email.focus();
        return false;
    }
    if(!check(emailChk, email, "적합하지 않은 이메일 형식입니다.")) {
    	email.focus();
        return false;
    }

}
</script>
</html>
