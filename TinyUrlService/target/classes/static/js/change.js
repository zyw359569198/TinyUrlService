function urlChange(){
	var url=document.getElementsByName('url')[0].value;
	url=base64encode(utf16to8(url));
	$.ajax({
		type: 'GET',
		url: "/tinyUrlConvert/"+url,
		contentType: "application/json;cherset=utf-8",
		dataType: "json",
		asynchronous: true,
		success: function(data){
			document.getElementById("result").innerHTML="<a target='about:blank' href='http://localhost:8080/s/"+data.data.url+"'>http://localhost:8080/s/"+data.data.url+" </a>";	
		}
	});
}