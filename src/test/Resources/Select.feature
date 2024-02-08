Feature: Select Query Execute

  Background: Database Connection
    * Database connection is established

  @Query01
  Scenario: In the "deposits" table in the database, verify the user_ids whose "amount" value is between $100 and $500.
    * Query01 is prepared and executed
    * ResultSet01 are processed
    * Close the database connection

  @Query02
  Scenario: Verify the "name" information of the first 2 records in the "cron_schedules" table in the database
    * Query02 is prepared and executed
    * ResultSet02 results are processed
    * Close the database connection

  @Query03
  Scenario: In the "Users" table in the database, the data that does not have "country_code=TR" and
            has "id=11" Verify "firstname" and "lastname" information.
    * Query03 is prepared and executed
    * ResultSet03 results are processed
    * Close the database connection

  @Query04
  Scenario: logged into the system according to user_ids in the user_logins table group browsers
            and os's and write them on the screen
    * Query04 is prepared and executed
    * ResultSet04 results are processed
    * Close the database connection







