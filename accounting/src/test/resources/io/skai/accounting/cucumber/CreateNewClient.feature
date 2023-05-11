Feature: addNewClient
  add new client to system

  Scenario: add new client

    Given Client absent in db

    When Call to create new client
      | name      | email                |
      | Brad Pit  |brad.pit@gmail.com    |

    Then Client is stored in database
      | id   | name         |email                |
      |  1   | Brad Pit     |brad.pit@gmail.com   |