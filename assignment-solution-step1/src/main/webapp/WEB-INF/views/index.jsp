<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send 
		 button. Handle errors like empty fields -->
	<form action="saveNote" method="post" modelAttribute="noteUI">
		<table>
			<tr>
				<td>Note Id :</td>
				<td><input type="text" name="noteId"></td>
			</tr>
			<tr>
				<td>Note Title :</td>
				<td><input type="text" name="noteTitle"></td>
			</tr>
			<tr>
				<td>Note Content :</td>
				<td><input type="text" name="noteContent"></td>
			</tr>
			<tr>
				<td>Note Status :</td>
				<td><input type="text" name="noteStatus"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Save Note" /></td>
			</tr>
		</table>
	</form>

	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
	<h1>Notes List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Note Id</th>
			<th>Note Title</th>
			<th>Note Content</th>
			<th>Note Status</th>
			<th>Note Created Date</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="note" items="${notesListUI}">
			<tr>
				<td>${note.noteId}</td>
				<td>${note.noteTitle}</td>
				<td>${note.noteContent}</td>
				<td>${note.noteStatus}</td>
				<td>${note.createdAt}</td>
				<td><a href="deleteNote?noteId=${note.noteId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>