
// Edit button pressed
function showEditForm(){

    var editForm = document.getElementById('editForm');

    if(editForm != null){

        // Show form
        editForm.style.display = "block";

        // Hide blog post
        var blogPost = document.getElementById("blog-post");
        blogPost.style.display = "none";
    }
}

// Cancel button pressed
function hideForm(){

    // Hide form
    var editForm = document.getElementById('editForm');
    editForm.style.display = "none";

    // Show blog post
    var blogPost = document.getElementById("blog-post");
    blogPost.style.display = "block";
}

function confirmDelete(event) {
    var result = confirm("Are you sure you want to delete this post? This cannot be undone.")
    return result;
}