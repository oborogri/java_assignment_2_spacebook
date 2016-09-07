# java_assignment_2_spacebook

The following tasks have to be completed as part of the assignment:

Task 1: User Friendship

Presently the befriend method in User ensures a user cannot befriend itself.
Modify the befriend method to ensure that, additionally, the same user cannot be befriended more than once.
Refer to the skeleton code immediately below: you are required to write the method boolean friendshipsContains(User friend)
The method should traverse and check the instance variable friendships and return true if the argument friend is present in the list (as a targetUser), else false.

Task 2: User class

Note that an enum exists that defines Status: enum Status {ONLINE, OFFLINE, BUSY, AWAY}
Set the default status field to "ONLINE" at User instantiation
Write a method to set the status field's value
Signature: public void setStatus(...)
Write a method to display a list of friends filtered based on status. Signature: public void displayFriends(Status status)
Test by invoking displayFriends(Status status) on a User object with various Status values
Test by invoking displayFriends() on a TestSpacebook object.

Task 3: User class
Write a method in User to send a message. Signature: public void sendMessage(Message message)

Task 4 Message class
A subject field is present in the Message class: enum Subject {PERSONAL, FAMILY, WORK, GENERAL}
Modify Message constructor to initialize the Subject field.
Initialise Subject field with the actual Subject parameter.

Task 5 Group class
Develop a class named Group to implement the concept of a group of friends such as family, friends, clients and so on.

Task 6: Message class
Complete the displayMessage method in Message. 

Task 7 User class
Write a method in User class to display an array list of messages. Signature public void displayMessages(ArrayList<Message> messages);

Task 8 User class
Write a method to display an array list of messages filtered by subject:
Signature public void displayMessages(Subject subject, ArrayList<Message> messages);

Task 9 MessageSort class
Write a method in MessageSort to sort an array of messages.
Signature: public static void sortMessages(Message[] messages);

Task 10 MessageSort class
Write a method in MessageSort to sort an ArrayList of messages.

Signature: public void sortMessages(ArrayList<Message> messages).
