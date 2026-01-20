package linkedlist.singly;
/***************************************************************
 * Social Media Friend Connection System using Singly Linked List
 *
 * Each User Node contains:
 *  - User ID
 *  - Name
 *  - Age
 *  - List of Friend IDs (implemented as another singly linked list)
 *
 * Features:
 * 1. Add a friend connection between two users
 * 2. Remove a friend connection
 * 3. Find mutual friends between two users
 * 4. Display all friends of a user
 * 5. Search user by ID or Name
 * 6. Count number of friends for each user
 ***************************************************************/

// Node representing a Friend ID
class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int id) {
        this.friendId = id;
        this.next = null;
    }
}

// Node representing a User
class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendList;   // Head of friend's linked list
    UserNode next;

    public UserNode(int id, String name, int age) {
        this.userId = id;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}

/*
 * Singly Linked List that manages all users
 */
class SocialMediaList {

    UserNode head;

    // Add a new user
    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Search user by ID
    public UserNode searchById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by Name
    public UserNode searchByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection (both ways)
    public void addFriend(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        addFriendToList(u1, id2);
        addFriendToList(u2, id1);

        System.out.println("Friend connection added between " + u1.name + " and " + u2.name);
    }

    // Helper method to add friend to one user's list
    private void addFriendToList(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friendList;
        user.friendList = newFriend;
    }

    // Remove friend connection (both ways)
    public void removeFriend(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        removeFriendFromList(u1, id2);
        removeFriendFromList(u2, id1);

        System.out.println("Friend connection removed.");
    }

    // Helper method to remove friend from one user's list
    private void removeFriendFromList(UserNode user, int friendId) {
        FriendNode temp = user.friendList, prev = null;

        while (temp != null && temp.friendId != friendId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        if (prev == null)
            user.friendList = temp.next;
        else
            prev.next = temp.next;
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        UserNode user = searchById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friendList;

        if (temp == null) {
            System.out.println("No friends.");
            return;
        }

        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }

    // Count number of friends of a user
    public void countFriends(int userId) {
        UserNode user = searchById(userId);
        if (user == null) return;

        int count = 0;
        FriendNode temp = user.friendList;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println(user.name + " has " + count + " friends.");
    }

    // Find mutual friends between two users
    public void findMutualFriends(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if (u1 == null || u2 == null) return;

        System.out.println("Mutual Friends:");

        FriendNode f1 = u1.friendList;
        while (f1 != null) {
            FriendNode f2 = u2.friendList;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.println("Friend ID: " + f1.friendId);
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }
    }
}

/*
 * Main class to test Social Media Friend System
 */
public class SocialMediaSystem {

    public static void main(String[] args) {

        SocialMediaList list = new SocialMediaList();

        // Add users
        list.addUser(1, "Kushal", 21);
        list.addUser(2, "Amit", 22);
        list.addUser(3, "Ravi", 23);
        list.addUser(4, "Neha", 20);

        // Create friendships
        list.addFriend(1, 2);
        list.addFriend(1, 3);
        list.addFriend(2, 3);
        list.addFriend(3, 4);

        // Display friends
        list.displayFriends(1);

        // Count friends
        list.countFriends(3);

        // Find mutual friends
        list.findMutualFriends(1, 2);

        // Remove friendship
        list.removeFriend(1, 3);

        // Display after removal
        list.displayFriends(1);
    }
}
