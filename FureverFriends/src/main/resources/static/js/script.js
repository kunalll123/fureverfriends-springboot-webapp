
// Simulating user authentication
    var isLoggedIn = true; // Assume the user is logged in

    document.addEventListener("DOMContentLoaded", function() {
        if (isLoggedIn) {
            document.getElementById("loginBtn").style.display = "none"; // Hide login button
            document.getElementById("profileBtn").style.display = "block"; // Show profile button
        } else {
            document.getElementById("profileBtn").style.display = "none"; // Hide profile button
        }
    });
