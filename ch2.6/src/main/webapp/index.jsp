<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>File Upload Demo</title>
    <script src="index.js" defer></script>
</head>
<body>
<form id="upload-form" action="upload" method="post" enctype="multipart/form-data">
    <input type="button" id="add_1" value="Add 1">
    <input type="button" id="add_2" value="Add 2">
    <input type="button" id="add_3" value="Add 3">
    <input type="button" id="add_4" value="Add 4">
    <input type="button" id="add_5" value="Add 5">
    <input type="button" id="add_10" value="Add 10">
    <input type="button" id="add_20" value="Add 20">
    <input type="button" id="add_30" value="Add 30">
    <input type="button" id="add_40" value="Add 40">
    <input type="button" id="add_50" value="Add 50">
    <input type="button" id="add_100" value="Add 100">
    <ol id="file-list">
        <li>
            <input type="file" name="file"><br>
            <input type="text" name="description">
            <input type="button" value="➖">
        </li>
        <li>
            <input type="file" name="file"><br>
            <input type="text" name="description">
            <input type="button" value="➖">
        </li>
    </ol>
    <input type="submit" value="Upload">
</form>
</body>
</html>