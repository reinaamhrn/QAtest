Feature: JSONPlaceholder API Testing

Scenario: Create New Post
  Given user prepares request body for new post
  When user sends POST request to create post
  Then response status code should be 201
  And response should contain title "Learn API Testing"
  And response should contain body "Practicing API testing with JSONPlaceholder"
  And response should contain userId 101
  And response should match post JSON schema

Scenario: Retrieve all posts
  Given user is ready to retrieve all posts
  When user sends GET request to retrieve posts
  Then response status code should be 200
  And each post id should not be null
  And response should match get JSON schema
  
Scenario: Delete a post successfully
  When user sends DELETE request to delete post with id 1
  Then response status code should be 200
  And response body should indicate successful deletion
  And response should match delete post JSON schema

Scenario: Update a post successfully
  Given user prepares update request body
  When user sends PUT request to update post with id 1
  Then response status code should be 200
  And response should contain title "Updated Post Title"
  And response should contain body "This is the updated body content."
  And response should contain userId 99
  And response should match post JSON schema