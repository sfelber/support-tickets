# support-tickets
Simple Spring/Angular web application to display and manage a list of support tickets.

## Features

* can list all existing tickets
* can create a new ticket with a title, a status (TODO, DOING, DONE), and a description
* can change the title, description and status of a ticket
* can delete a ticket
* after editing a ticket, the date of the last modification is updated automatically

![Screenshot](screenshot.png?raw=true "Title")

# TODO 

* currently is used in-memory database ( = data are not persistent after the server is stopped)
* dashboard with 3 state columns, tickets can be moved between the columns
* paging, sorting and filtering on the ticket table
