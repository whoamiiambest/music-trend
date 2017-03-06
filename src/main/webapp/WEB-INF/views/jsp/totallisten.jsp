<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 style="margin: 0 auto;">Update total listen</h1>

	<script type="application/javascript"
		src="http://code.jquery.com/jquery-latest.min.js"></script>
	 

	 <%-- <script type="application/javascript"
		src="${pageContext.request.contextPath}/resources/core/js/jquery.ajax-cross-origin.min.js"></script> --%>
	<script type="application/javascript">
		


    var listSongId = ${listSongId};
    var listTotalListener = [];
    var id;
    var total;
    var dataString = "";   
    for (var i = 0; i < 1; i++) {
        /* id =  listSongId[15];
        $.ajax({
        	   url : 'http://mp3.zing.vn/json/song/listen',
               type : 'GET',
               crossDomain : true,
               dataType: "json",
               async : false,
               cache : false,
               data : {
                   "id" : id
               },
               success : function(data) {
                   console.log(listSongId[i] + " --  " + data.total)
                   total = data.total;
               },
               error : function() {
                   console.log("error")
               }
        });
       
           */
			
     
          $.ajax({
            url : '${pageContext.request.contextPath}/Service/UpdateTotal',
            async : false,
            method: 'POST',
            data: {
                'id': "123",
                'total': "abc"
            }, success : function() {
                console.log("success")
            } ,
            error : function() {
                console.log("error")
            }
         }); 
    }
	
   
	</script>
	 $(document).ready(function () {
    	 console.log("success"),
    	 alert("aaa");
    });


</body>
</html>