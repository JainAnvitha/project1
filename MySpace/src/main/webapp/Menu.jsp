<%@page import="com.database.FileInfoFromDB"%>
<%@page import="com.pojo.DBPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>MyFileSpaceMenu</title>
<body background="https://www.wallpaperup.com/uploads/wallpapers/2015/10/30/826741/6a0e364fbe723ec85b32f1a68c85b4f9-1400.jpg">
	 <header><h1>Login successful....WELCOME &nbsp;&nbsp;<%=session.getAttribute("username")%></h1>
            <%
            	String s = session.getAttribute("username").toString();
                            session.setAttribute("username", s);
            %>

            
        </header>
	
	<style>
table {
    width:100%;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 15px;
    text-align: left;
}
table tr:nth-child(even) {
    background-color: #eee;
}
table tr:nth-child(odd) {
   background-color: #fff;
}
table th {
    background-color: black;
    color: white;
}
</style>

	<table width="59%" border="1">
		<tr>
			<td>User</td>
			<td>File name</td>
			<td>Description</td>
			<td>Date created</td>
			<td>Download</td>
			<td>Delete</td>
			<td>Update</td>
		</tr>
		<%
			String username = session.getAttribute("username").toString();

			System.out.println("username  " + username);
			ArrayList<DBPojo> pojo = new ArrayList<DBPojo>();
			FileInfoFromDB info = new FileInfoFromDB();
			pojo = info.fetchData(username);

			for (int i = 0; i < pojo.size(); i++) {
				DBPojo object = new DBPojo();
				object = pojo.get(i);
				String fn = object.getFileName();
				System.out.println("objectoffile  " + object.getFileName());
				request.setAttribute("filenameuploaded", fn);
		%>
		<tr>
			<td><%=object.getUserName()%></td>

			<td><%=object.getFileName()%></td>

			<td><%=object.getFileDescription()%></td>

			<td><%=object.getFileUploadTime()%></td>
			<!--<td><button>Download</button>-->
			<td>
				<form action="DownloadServlet" method="post">
					<input type="submit" value="Download"> <input
						type="hidden" name="myObject" value=<%=object.getFileName()%> />
				</form>
			</td>
			<td>
				<form action="DeleteServlet" method="post">
					<input type="submit" value="Delete"> <input type="hidden"
						name="myObject" value=<%=object.getFileName()%> />
				</form>
			</td>
			<td>
				<form action="MenuServlet" method="post"
					enctype="multipart/form-data">
					<input type="file" id="file" name="file" multiple> <input
						type="submit" value="Submit" id="btnSubmit" />
				</form>
			</td>
		</tr>

		<%
			}
		%>
	</table>


	<form id="myform" action="MainMenuServlet"
		onsubmit="return myFunction();" method="post"
		enctype="multipart/form-data">

		<label for="file">Choose file to upload</label> <input type="file"
			id="file" name="file" multiple="true"> <input type="submit"
			value="Submit" id="btnSubmit" /></br></br></br>
			<button><a href="Login.jsp">logout</a></button>
	
	</form>
	
	
	<script>
		function myFunction() {

			var fileUpload = document.getElementById(file);
			var flag = false;

			if (typeof (fileUpload.files) !== "undefined") {
				System.out.println("Inside MainMenu.jsp line99");
			
				var maxsize = 10 * 1024;

				var size = fileUpload.files[i].size / 1024;

				if (size > maxsize) {
					alert("filesize larger than 10MB");
					document.getElementById("myform").reset();
					flag = false;

				} else {
					flag = true;

				}

				
			} else {

				alert("error.... html5 unsupportable.");
			}
			return flag;
		}
	</script>


</body>

</html>
