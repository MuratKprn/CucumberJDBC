Feature: UPDATE DELETE INSERT

  Background: Database Connection
    * Database connection is established

  @Update01
  Scenario: In the "users" table,  update the "mobile" number of "usernames" with the second to last letter as 'e'.
   * Create and execute Update01
   * Verify the results of Update1
   * Close the database connection

  @Prepared01
  Scenario: In the "users" table, update the "mobile" number of "usernames" with the second to last letter as 'e'.
    * Create and execute Prepared01
    * Verify the results of Prepared1
    * Close the database connection

  @Prepared02
  Scenario: Insert new data (id, email, token, status, created_at) into the admin_password_resets table.
    * Create and execute Prepared02
    * Verify the results of Prepared2
    * Close the database connection