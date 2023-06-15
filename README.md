# Lead QA Assessment
Welcome to your QA Lead Assessment!

To validate your test cases for the REST API, follow these steps:

1. Install Node.js. You can download Node.js from https://nodejs.org.<br>
2. Open your command prompt or terminal.<br>
3. Run the following command to install json-server:<br>
```npm install -g json-server```<br>
4. Run the following command to start the REST API server:<br> 
```json-server --watch db.json```<br>
5. Edit the db.json file to include this data:<br>
```
{
  "tasks": [
    {
      "id": "1",
      "name": "OpenNewTab",
      "description": "Create a test that opens a new tab in Chrome and navigates to it",
      "completed": true
    },
    {
      "id": "2",
      "name": "CheckDropDownOptions",
      "description": "Create a test that checks all the options of a dropdown menu",
      "completed": false
    }
  ]
}
```
6. Run the tests in the src/tests<br>

Please note that the sample code assumes that the REST API is running on http://localhost:3000. 
If your REST API is running on a different port or URL, you will need to update the BASE_URI variable in the sample code accordingly.
