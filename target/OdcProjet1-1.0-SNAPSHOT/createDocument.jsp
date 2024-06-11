<!DOCTYPE html>
<html>
<head>
    <title>Create Document</title>
</head>
<body>
    <h1>Create Document</h1>
    <form action="document" method="post" enctype="multipart/form-data">
        <label for="name">Document Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="content">Document Content:</label>
        <input type="file" id="content" name="content" required><br>

        <button type="submit">Create Document</button>
    </form>
</body>
</html>
