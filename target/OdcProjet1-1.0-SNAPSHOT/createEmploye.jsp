<!DOCTYPE html>
<html>
<head>
    <title>Create Employee</title>
</head>
<body>
    <h1>Create Employee</h1>
    <form action="employee" method="post">
        <label for="nom">Name:</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="departement">Department:</label>
        <input type="text" id="departement" name="departement" required><br>

        <label for="employeeEmail">Email:</label>
        <input type="email" id="employeeEmail" name="employeeEmail" required><br>

        <label for="departmentId">Department ID:</label>
        <input type="text" id="departmentId" name="departmentId" required><br>

        <label for="employeeNumber">Employee Number:</label>
        <input type="text" id="employeeNumber" name="employeeNumber" required><br>

        <label for="employeeType">Employee Type:</label>
        <select id="employeeType" name="employeeType">
            <option value="FULL_TIME">Full Time</option>
            <option value="PART_TIME">Part Time</option>
            <option value="CONTRACT">Contract</option>
        </select><br>

        <h2>Address</h2>
        <label for="street">Street:</label>
        <input type="text" id="street" name="street" required><br>
        
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br>
        
        <label for="state">State:</label>
        <input type="text" id="state" name="state" required><br>
        
        <label for="zipCode">Zip Code:</label>
        <input type="text" id="zipCode" name="zipCode" required><br>

        <button type="submit">Create Employee</button>
    </form>
</body>
</html>
