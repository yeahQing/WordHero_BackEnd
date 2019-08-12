//切换题库
function onSubmit_forChangeLib(index){
	var degree = document.getElementsByName("degree");
	for (i = 0; i < degree.length; i++) {
           if(index == i+1){
        	   var str = degree[i].value.split(".");
        	   
        	   var level_id = str[0];
        	   
        	   var url = "http://localhost:8080/Word_Hero/ChangeLevel?level_id="+level_id;
        	   var xmlhttp = new XMLHttpRequest();
        	   
        	    xmlhttp.onreadystatechange=function()
        	    {
        	        if (xmlhttp.readyState==4)
        	        {	
        	        	if(xmlhttp.status == 200){
        	        		getUserData();
        	        	}
        	        }
        	    }
        	    
        	    xmlhttp.open("GET",url,true);
        	    xmlhttp.send(null);
           }
    }
}


//点击选项事件
function clickOptions(index){
        var answer = document.getElementsByName("answer");
        var question_word = document.getElementById("question_word").innerText;
        var score = document.getElementById("score").innerHTML;
        
        for (i = 0; i < answer.length; i++) {
            if(index == i+1){
                var str = answer[i].innerText;
                var opt = str.split(":");
                checkCorrectOption(question_word,opt[1],answer[i],index);
            }
        }
}

//检查是否正确
function checkCorrectOption(question,answer,current_option,index){
    var url = "http://localhost:8080/Word_Hero/CheckCorrectOption?question="+question+"&answer="+answer;
    var xmlhttp = new XMLHttpRequest();
   
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4)
        {	
        	if(xmlhttp.status == 200){
        		getUserScore();
        		current_option.setAttribute("style","background-color: #C9F4EC;");
        		disable_options(index)
        		setTimeout(restart_Animation,2000);
        		
        	}else if(xmlhttp.status == 201){
        		current_option.setAttribute("style","background-color: #FFCCCC;");
        		disable_options(index)
        		setTimeout(restart_Animation,2000);
        	}

        }
    }
    
    xmlhttp.open("GET",url,true);
    xmlhttp.send(null);
}

//禁用其他按钮
function disable_options(index){
	var options = document.getElementsByName("answer");
	for (i = 0; i < options.length; i++) {
		if(index != i+1){
			options[i].setAttribute("style","pointer-events: none");
        }
    }
}

//重启动画
function restart_Animation(index){
	location.reload();
}

//登录验证
function onSubmit_forLogin(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var url = "http://localhost:8080/Word_Hero/Login";
    var data = "username="+username+"&"+"password="+password;
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4)
        {
        	if(xmlhttp.status == 200){
        		window.location.href="index.html";
        	} else if(xmlhttp.status == 201){
        		var welcome = document.getElementById("welcome");
        		welcome.setAttribute("style","color:#EF5350");
                welcome.innerHTML =  xmlhttp.responseText;
        	}

        }
    }
    
    xmlhttp.open("POST",url,true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send(data);
}

//注册验证
function onSubmit_forRegister(){
	 	var username = document.getElementById("r_username").value;
	    var password = document.getElementById("r_password").value;

	    var url = "http://localhost:8080/Word_Hero/Register";
	    var data = "username="+username+"&"+"password="+password;
	    var xmlhttp = new XMLHttpRequest();

	    xmlhttp.onreadystatechange=function()
	    {
	        if (xmlhttp.readyState==4)
	        {
	        	if(xmlhttp.status == 200){
	        		window.location.href="login.html";
	        	} else if(xmlhttp.status == 201){
	        		var welcome = document.getElementById("welcome");
	        		welcome.setAttribute("style","color:#EF5350");
	                welcome.innerHTML =  xmlhttp.responseText;
	        	}

	        }
	    }
	    
	    xmlhttp.open("POST",url,true);
	    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp.send(data);
}

//修改
function onSubmit_forUpdate(){
 	var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var mobile = document.getElementById("mobile").value;
    
    var url = "http://localhost:8080/Word_Hero/UpdateUser?action=updateUserData";
    var data = "username="+username+"&"+"password="+password+"&"+"mobile="+mobile;
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4)
        {
        	if(xmlhttp.status == 200){
        		window.location.href="index.html";
        	} else if(xmlhttp.status == 201){
        		var welcome = document.getElementById("welcome");
        		welcome.setAttribute("style","color:#EF5350");
                welcome.innerHTML =  xmlhttp.responseText;
        	}

        }
    }
    
    xmlhttp.open("POST",url,true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send(data);
}

//加载用户数据
function loadUserData(){
	  var url = "http://localhost:8080/Word_Hero/UpdateUser?action=getUserData";
	    var xmlhttp = new XMLHttpRequest();

	    xmlhttp.onreadystatechange=function()
	    {
	        if (xmlhttp.readyState==4)
	        {
	        	if(xmlhttp.status == 200){
	        		var responseText = xmlhttp.responseText.split(";");
	        		document.getElementById("username").value = responseText[0];
	        		document.getElementById("password").value = responseText[1];
	        		document.getElementById("mobile").value = responseText[2];
	        	} 
	        }
	    }
	    
	    xmlhttp.open("GET",url,true);
	    xmlhttp.send(null);
}

//获取用户数据
function getUserData(){
    var url = "http://localhost:8080/Word_Hero/GetUserData";
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4)
        {
        	if(xmlhttp.status == 200){
        		var responseText = xmlhttp.responseText.split(";");
        		document.getElementById("username").innerHTML = responseText[0];
        		document.getElementById("score").innerHTML = responseText[1];
        		document.getElementById("word_level").innerHTML = responseText[2];
        	} 
        }
    }
    
    xmlhttp.open("GET",url,true);
    xmlhttp.send(null);
}

//获取用户积分
function getUserScore(){
	var url = "http://localhost:8080/Word_Hero/GetUserData";
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4)
        {
        	if(xmlhttp.status == 200){
        		var responseText = xmlhttp.responseText.split(";");
        		document.getElementById("score").innerHTML = responseText[1];
        	} 
        }
    }
    
    xmlhttp.open("GET",url,true);
    xmlhttp.send(null);
}

//获取题库题目
function getQuestionLib(){
    var url = "http://localhost:8080/Word_Hero/GetQuestionLibs";
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4)
        {
        	if(xmlhttp.status == 200){
        		var responseText = xmlhttp.responseText.split(";");
        		document.getElementById("question_word").innerHTML = responseText[0];
        		for(var i = 1;i < responseText.length;i++){
        			var option = "option_"+i;
        			document.getElementById(option).innerHTML = responseText[i];
        		}
        		
        	} 

        }
    }
    
    xmlhttp.open("GET",url,true);
    xmlhttp.send(null);
}

//获取排行榜
function getRankList(){
	var url = "http://localhost:8080/Word_Hero/GetRankList";
    var xmlhttp = new XMLHttpRequest();
    var table_content = "";
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4)
        {
        	if(xmlhttp.status == 200){
        			console.log(xmlhttp.responseText);
        			var tr = xmlhttp.responseText.split(";");
        			console.log(tr.length);
        			for(var i = 0;i < tr.length-1;i++){
        				var td = tr[i].split(",");
    					table_content += "<tr  id='rank_row'><td>"+(i+1)+"</td>";
        				for(var j = 0;j < td.length;j++){
        					table_content += "<td>"+td[j]+"</td>";
        				}
        					table_content += "</tr>";
        			}
        			
        			console.log(table_content);
        			document.getElementById("table_content").innerHTML = table_content;
        	} 

        }
    }
    
    xmlhttp.open("GET",url,true);
    xmlhttp.send(null);
}
