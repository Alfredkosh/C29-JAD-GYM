//var friends = [];
//
//function isNumber(str) {
//        var pattern = /^\d+\.?\d*$/;
//        return pattern.test(str);  // returns a boolean
//    }
//
//async function addFriend() {
//  let friendName = document.getElementById("friend-name").value;
//
//  if (!isNumber(friendName)) {
//    alert("The value is not a number");
//    return;
//  }
//  const token = localStorage.getItem("token")
//  if (!token) {
//    window.location.href = "/login"
//  }
//
//  const res = await fetch("/friends/friend", {
//    method: "POST",
//    headers: {
//      "Content-Type": "application/json",
//      Authorization: `Bearer ${token}`
//    },
//    body: JSON.stringify({
//      userId: friendName
//    })
//  })
//  const data = await res.json();
//  if (res.ok) {
//    console.log(data)
//  }
//}
//
//function confirmRemoveFriend(index) {
//  var confirmation = confirm("Are you sure you want to remove this friend?");
//
//  if (confirmation) {
//    removeFriend(index);
//  }
//}
//
//function removeFriend(index) {
//  friends.splice(index, 1);
//  saveFriends();
//  renderFriends();
//}
//
//function saveFriends() {
//  localStorage.setItem("friends", JSON.stringify(friends));
//}
//
//function loadFriends() {
//  var storedFriends = localStorage.getItem("friends");
//
//  if (storedFriends) {
//    friends = JSON.parse(storedFriends);
//    renderFriends();
//  }
//}
//
// // Load friends from localStorage on page load
// loadFriends();
//
//function renderFriends() {
//  var friendsList = document.getElementById("friends-list");
//  friendsList.innerHTML = "";
//
//  for (var i = 0; i < friends.length; i++) {
//    var friendItem = document.createElement("li");
//    friendItem.classList.add("friend");
//    friendItem.textContent = friends[i];
//
//    var removeButton = document.createElement("button");
//    removeButton.classList.add("remove-button");
//    removeButton.textContent = "Remove";
//    removeButton.onclick = (function (index) {
//      return function () {
//        confirmRemoveFriend(index);
//      };
//    })(i);
//
//    friendItem.appendChild(removeButton);
//
//    var userDetail = document.createElement("span");
//    userDetail.classList.add("user-detail");
//    userDetail.textContent = "Loading..."; // Placeholder text while loading user details
//
//    // Append the user detail element to the friend item
//    friendItem.appendChild(userDetail);
//
//    // Append the friend item to the friends list
//    friendsList.appendChild(friendItem);
//
//    // Call the Java method with AJAX to retrieve user details
//    var friendName = friends[i];
//    var xhr = new XMLHttpRequest();
//    xhr.open("GET", "/getUserDetails?friendName=" + friendName, true);
//    xhr.onreadystatechange = function () {
//      if (xhr.readyState === 4 && xhr.status === 200) {
//        var response = JSON.parse(xhr.responseText);
//        var userId = response.userId;
//        var username = response.username;
//
//        // Update the user detail element with the retrieved data
//        userDetail.textContent = "User ID: " + userId + " Username: " + username;
//      }
//    };
//    xhr.send();
//  }
//}