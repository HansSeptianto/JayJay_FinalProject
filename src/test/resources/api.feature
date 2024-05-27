@api
Feature: Test Automation Rest API

  @valid-get-user-by-id
  Scenario: Test get user by id normal
    Given prepare valid url for "CREATE_USER"
    And hit api post create new user
    Then validation status code is equal to 200
    Then validation response body post create new user
    Then prepare valid url for "GET_USER_BY_ID"
    And hit api get user by id
    Then validation status code is equal to 200
    Then validation response body get user data by id
    Then validation response json with JSONSchema "get_user_by_id_normal.json"

  @valid-get-list-tags
  Scenario: Test get list of tags normal
    Given prepare valid url for "GET_LIST_TAGS"
    And hit api get list of tags
    Then validation status code is equal to 200
    Then validation response body get list of tags
    Then validation response json with JSONSchema "get_list_of_tags_normal.json"

  @valid-create-new-user
  Scenario: Test create new user normal
    Given prepare valid url for "CREATE_USER"
    And hit api post create new user
    Then validation status code is equal to 200
    Then validation response body post create new user
    Then validation response json with JSONSchema "post_create_new_user_normal.json"

  @invalid-create-new-user
  Scenario: Test create new user with invalid email
    Given prepare valid url for "CREATE_USER"
    And hit api post create new user with invalid email
    Then validation status code is equal to 400
    Then validation response body post create new user with invalid email
    Then validation response json with JSONSchema "post_create_new_user_error.json"

  @valid-delete-user
  Scenario: Test delete user normal
    Given prepare valid url for "CREATE_USER"
    And hit api post create new user
    Then validation status code is equal to 200
    Then validation response body post create new user
    Then prepare valid url for "DELETE_USER"
    And hit api delete user
    Then validation status code is equal to 200
    Then validation response body delete user
    Then validation response json with JSONSchema "delete_user_normal.json"

  @invalid-delete-user
  Scenario: Test delete user with invalid id
    Given prepare valid url for "CREATE_USER"
    And hit api post create new user
    Then validation status code is equal to 200
    Then validation response body post create new user
    Then prepare valid url for "DELETE_USER"
    And hit api delete user with invalid id
    Then validation status code is equal to 400
    Then validation response body delete user with invalid id
    Then validation response json with JSONSchema "invalid_id_error.json"

  @valid-update-user
  Scenario: Test update user normal
    Given prepare valid url for "CREATE_USER"
    And hit api post create new user
    Then validation status code is equal to 200
    Then validation response body post create new user
    Then prepare valid url for "UPDATE_USER"
    And hit api update user data
    Then validation status code is equal to 200
    Then validation response body update user data
    Then validation response json with JSONSchema "update_user_normal.json"

  @invalid-update-user
  Scenario: Test update user with invalid id
    Given prepare valid url for "CREATE_USER"
    And hit api post create new user
    Then validation status code is equal to 200
    Then validation response body post create new user
    Then prepare valid url for "UPDATE_USER"
    And hit api update user data with invalid id
    Then validation status code is equal to 400
    Then validation response body update user data with invalid id
    Then validation response json with JSONSchema "invalid_id_error.json"