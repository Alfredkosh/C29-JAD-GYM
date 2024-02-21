var friends = [];

function isNumber(str) {
        var pattern = /^\d+\.?\d*$/;
        return pattern.test(str);  // returns a boolean
    }

function addFriend() {
  var friendName = document.getElementById("friend-name").value;

  if (!isNumber(friendName)) {
    alert("The value is not a number");
    return;
  }

  if (friendName.trim() !== "") {
    friends.push(friendName);
    saveFriends();
    renderFriends();

    document.getElementById("friend-name").value = "";

    // Call the Java method with AJAX
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/addFriend?friendName=" + friendName, true);
    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4 && xhr.status === 200) {
        var response = JSON.parse(xhr.responseText);
        var userId = response.userId;
        var username = response.username;

        // Display the userID and username
        alert("User ID: " + userId + "\nUsername: " + username);
      }
    };
    xhr.send();
  }
}

function confirmRemoveFriend(index) {
  var confirmation = confirm("Are you sure you want to remove this friend?");

  if (confirmation) {
    removeFriend(index);
  }
}

function removeFriend(index) {
  friends.splice(index, 1);
  saveFriends();
  renderFriends();
}

function saveFriends() {
  localStorage.setItem("friends", JSON.stringify(friends));
}

function loadFriends() {
  var storedFriends = localStorage.getItem("friends");

  if (storedFriends) {
    friends = JSON.parse(storedFriends);
    renderFriends();
  }
}

function renderFriends() {
  var friendsList = document.getElementById("friends-list");
  friendsList.innerHTML = "";

  for (var i = 0; i < friends.length; i++) {
    var friendItem = document.createElement("li");
    friendItem.classList.add("friend");
    friendItem.textContent = friends[i];

    var removeButton = document.createElement("button");
    removeButton.classList.add("remove-button");
    removeButton.textContent = "Remove";
    removeButton.onclick = (function(index) {
      return function() {
        confirmRemoveFriend(index);
      };
    })(i);

    friendItem.appendChild(removeButton);
    friendsList.appendChild(friendItem);
  }
}

loadFriends();
