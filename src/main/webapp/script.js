/**
 * 
 */

 let xht = new XMLHttpRequest();
 let meaning = document.getElementById("meaning");
 function apiCall(){
	 meaning.innerHTML = "";
	 let Words = document.getElementById("Words").value;
	 console.log(Words);
	 xht.onreadystatechange = function(){
		 if(xht.readyState == 4 && xht.status == 200){
			 let jsonObj = JSON.parse(xht.responseText);
			 console.log(jsonObj);
			 console.log(jsonObj.length);
			 let jsonArr = (jsonObj.definition).split(".");
			 if(jsonObj.definition != ""){
			 meaning.innerHTML += "<p>"+jsonObj.definition+"</p>";
			 }
			 else{
				 alert("Word can't found");
			 }
		 }
	 }
	 
	 xht.open("POST","http://localhost:8080/APIProject/Dictionary");
	 xht.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	 xht.send("word="+Words);
 }